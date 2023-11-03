package br.com.barbearia.braddock.service.agenda;

import br.com.barbearia.braddock.controller.request.AgendarRequest;
import br.com.barbearia.braddock.domain.Agenda;
import br.com.barbearia.braddock.mapper.AgendaMapper;
import br.com.barbearia.braddock.repository.AgendaRepository;
import br.com.barbearia.braddock.repository.ClienteRepository;
import br.com.barbearia.braddock.repository.FuncionarioRepository;
import br.com.barbearia.braddock.repository.ServicoRepository;
import br.com.barbearia.braddock.validator.AgendaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class AgendarService {

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private AgendaValidator agendaValidator;

    public enum ServicoEnum {
        CORTE(30),
        BARBA(30),
        COMBO(45);

        public final int label;

        private ServicoEnum(int label) {
            this.label = label;
        }
    }

    public void agendar(AgendarRequest request) {

        agendaValidator.diaValido(request.getHorarioInicio());

        LocalDateTime horarioAbertura = LocalDateTime.of(request.getHorarioInicio().getYear(), request.getHorarioInicio().getMonth(), request.getHorarioInicio().getDayOfMonth(), 8, 0);
        LocalDateTime horarioFechamento = LocalDateTime.of(request.getHorarioInicio().getYear(), request.getHorarioInicio().getMonth(), request.getHorarioInicio().getDayOfMonth(), 20, 0);

        agendaValidator.horarioDeTrabalho(request.getHorarioInicio());

        List<Agenda> agendamentosDoDia = agendaRepository.findAllByHorarioInicioBetweenAndNomeFuncionarioIgnoreCaseOrderByHorarioInicio(horarioAbertura, horarioFechamento, request.getNomeFuncionario());

        agendamentosDoDia.forEach(agenda -> agendaValidator.validaHorarioConflitante(request.getHorarioInicio(), request.getHorarioInicio().plusMinutes(getTempoMedio(request.getServico())), agenda));

        Agenda agenda = AgendaMapper.toEntity(request, getTempoMedio(request.getServico()));

        agendaRepository.save(agenda);

    }

    private int getTempoMedio(String nomeServico){
        return switch (nomeServico.toUpperCase()) {
            case "CORTE" -> ServicoEnum.CORTE.label;
            case "BARBA" -> ServicoEnum.BARBA.label;
            case "COMBO" -> ServicoEnum.COMBO.label;
            default -> throw new ResponseStatusException(BAD_REQUEST, "Serviço não encontrado");
        };
    }
}

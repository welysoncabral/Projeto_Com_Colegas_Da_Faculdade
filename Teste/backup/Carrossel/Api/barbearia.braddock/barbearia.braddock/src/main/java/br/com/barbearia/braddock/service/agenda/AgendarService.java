package br.com.barbearia.braddock.service.agenda;

import br.com.barbearia.braddock.controller.request.AgendarRequest;
import br.com.barbearia.braddock.domain.Agenda;
import br.com.barbearia.braddock.domain.Cliente;
import br.com.barbearia.braddock.domain.Funcionario;
import br.com.barbearia.braddock.domain.Servico;
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

    public void agendar(AgendarRequest request) {

        Cliente cliente = clienteRepository.findById(request.getClienteId()).orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "Cliente não encontrado"));

        Funcionario funcionario = funcionarioRepository.findById(request.getFuncionarioId()).orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "Funcionário não encontrado"));

        Servico servico = servicoRepository.findById(request.getServicoId()).orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "Serviço não encontrado"));

        agendaValidator.horarioDeTrabalho(request.getHorarioInicio());

        LocalDateTime horarioAbertura = LocalDateTime.of(request.getHorarioInicio().getYear(), request.getHorarioInicio().getMonth(), request.getHorarioInicio().getDayOfMonth(), 8, 0);
        LocalDateTime horarioFechamento = LocalDateTime.of(request.getHorarioInicio().getYear(), request.getHorarioInicio().getMonth(), request.getHorarioInicio().getDayOfMonth(), 20, 0);

        List<Agenda> agendamentosDoDia = agendaRepository.findAllByHorarioInicioBetweenAndFuncionarioOrderByHorarioInicio(horarioAbertura, horarioFechamento, funcionario);

        agendamentosDoDia.forEach(agenda -> agendaValidator.validaHorarioConflitante(request.getHorarioInicio(), request.getHorarioInicio().plusMinutes(servico.getTempoMedio()), agenda));

        Agenda agenda = AgendaMapper.toEntity(request, cliente, servico, funcionario);

        agendaRepository.save(agenda);

    }
}

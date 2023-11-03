package br.com.barbearia.braddock.service.agenda;

import br.com.barbearia.braddock.controller.response.AgendaResponse;
import br.com.barbearia.braddock.domain.Agenda;
import br.com.barbearia.braddock.mapper.AgendaMapper;
import br.com.barbearia.braddock.repository.AgendaRepository;
import br.com.barbearia.braddock.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ListarAgendamentosService {

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<AgendaResponse> listarPorFuncionarioEDia(String nomeFuncionario, int dia, int mes, int ano) {

        LocalDateTime horarioAbertura = LocalDateTime.of(ano, mes, dia, 8, 0);
        LocalDateTime horarioFechamento = LocalDateTime.of(ano, mes, dia, 20, 0);

        List<Agenda> agendaDoDia = agendaRepository.findAllByHorarioInicioBetweenAndNomeFuncionarioIgnoreCaseOrderByHorarioInicio(horarioAbertura, horarioFechamento, nomeFuncionario);

        return agendaDoDia.stream().map(AgendaMapper::toResponse).toList();

    }

    public List<AgendaResponse> listarPorFuncionario(String nomeFuncionario) {


        List<Agenda> agendaDoFuncionario = agendaRepository.findAllByNomeFuncionarioIgnoreCaseOrderByHorarioInicio(nomeFuncionario);

        return agendaDoFuncionario.stream().map(AgendaMapper::toResponse).toList();
    }
}

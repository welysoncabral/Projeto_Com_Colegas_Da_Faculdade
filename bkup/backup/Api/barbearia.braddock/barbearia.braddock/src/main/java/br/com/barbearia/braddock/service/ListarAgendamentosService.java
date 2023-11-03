package br.com.barbearia.braddock.service;

import br.com.barbearia.braddock.controller.response.AgendaResponse;
import br.com.barbearia.braddock.domain.Agenda;
import br.com.barbearia.braddock.domain.Funcionario;
import br.com.barbearia.braddock.mapper.AgendaMapper;
import br.com.barbearia.braddock.repository.AgendaRepository;
import br.com.barbearia.braddock.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ListarAgendamentosService {

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<AgendaResponse> listarPorFuncionarioEDia(Long id, int dia, int mes, int ano) {

        Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "Funcionário não encontrado"));


        LocalDateTime horarioAbertura = LocalDateTime.of(ano, mes, dia, 8, 0);
        LocalDateTime horarioFechamento = LocalDateTime.of(ano, mes, dia, 20, 0);

        List<Agenda> agendaDoDia = agendaRepository.findAllByHorarioInicioBetweenAndFuncionarioOrderByHorarioInicio(horarioAbertura, horarioFechamento, funcionario);

        return agendaDoDia.stream().map(AgendaMapper::toResponse).toList();

    }

    public List<AgendaResponse> listarPorFuncionario(Long id) {

        Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "Funcionário não encontrado"));

        List<Agenda> agendaDoFuncionario = agendaRepository.findAllByFuncionarioOrderByHorarioInicio(funcionario);

        return agendaDoFuncionario.stream().map(AgendaMapper::toResponse).toList();
    }
}

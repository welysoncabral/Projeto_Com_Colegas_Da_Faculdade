package br.com.barbearia.braddock.repository;

import br.com.barbearia.braddock.domain.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {

    List<Agenda> findAllByNomeFuncionarioIgnoreCaseOrderByHorarioInicio(String funcionario);

    List<Agenda> findAllByHorarioInicioBetweenAndNomeFuncionarioIgnoreCaseOrderByHorarioInicio(LocalDateTime horarioAbertura, LocalDateTime horarioFechamento, String nomeFuncionario);
}

package br.com.barbearia.braddock.repository;

import br.com.barbearia.braddock.domain.Agenda;
import br.com.barbearia.braddock.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {

    List<Agenda> findAllByHorarioInicioBetweenAndFuncionarioOrderByHorarioInicio(LocalDateTime horarioAbertura, LocalDateTime horarioFechamento, Funcionario funcionario);

    List<Agenda> findAllByFuncionarioOrderByHorarioInicio(Funcionario funcionario);
}

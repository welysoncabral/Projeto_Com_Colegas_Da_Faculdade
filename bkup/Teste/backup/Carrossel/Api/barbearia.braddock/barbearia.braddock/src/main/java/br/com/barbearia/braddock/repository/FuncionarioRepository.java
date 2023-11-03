package br.com.barbearia.braddock.repository;

import br.com.barbearia.braddock.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}

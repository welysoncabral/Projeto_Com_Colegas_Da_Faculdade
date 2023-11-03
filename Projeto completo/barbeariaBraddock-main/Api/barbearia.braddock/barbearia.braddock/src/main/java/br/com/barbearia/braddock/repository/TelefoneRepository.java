package br.com.barbearia.braddock.repository;

import br.com.barbearia.braddock.domain.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

    boolean existsByDddAndNumero(String ddd, String numero);
}

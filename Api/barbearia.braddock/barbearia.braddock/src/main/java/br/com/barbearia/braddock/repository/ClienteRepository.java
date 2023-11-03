package br.com.barbearia.braddock.repository;

import br.com.barbearia.braddock.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    boolean existsByEmailIgnoreCaseAndSenhaIgnoreCase(String email, String senha);

    Cliente findByEmailIgnoreCase(String emailCliente);
}

package br.com.barbearia.braddock.repository;

import br.com.barbearia.braddock.domain.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {

}

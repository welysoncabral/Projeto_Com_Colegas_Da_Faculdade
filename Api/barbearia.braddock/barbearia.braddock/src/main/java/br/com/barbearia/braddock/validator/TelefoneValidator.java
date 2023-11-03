package br.com.barbearia.braddock.validator;

import br.com.barbearia.braddock.domain.Cliente;
import br.com.barbearia.braddock.domain.Telefone;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Component
public class TelefoneValidator {

    public void valida(String telefone) {
        if(telefone.length() != 11){
            throw new ResponseStatusException(BAD_REQUEST, "Um ou mais telefones cadastrados não são válidos");
        }
    }

    public void validaClienteJaComTelefone(Cliente cliente, String telefone) {
        if(cliente.getTelefones().stream().map(Telefone::getNumero).toList().contains(telefone)){
            throw new ResponseStatusException(BAD_REQUEST, "Esse cliente já possui o número: " + telefone + " cadastrado");
        }
    }
}

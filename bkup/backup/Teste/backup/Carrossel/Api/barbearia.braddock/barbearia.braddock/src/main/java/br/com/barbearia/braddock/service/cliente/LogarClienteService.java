package br.com.barbearia.braddock.service.cliente;

import br.com.barbearia.braddock.controller.request.LogarClienteRequest;
import br.com.barbearia.braddock.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.FORBIDDEN;

@Service
public class LogarClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public boolean logar(LogarClienteRequest request) {

        boolean isCliente = clienteRepository.existsByEmailIgnoreCaseAndSenhaIgnoreCase(request.getEmail(), request.getSenha());

        if(!isCliente){
            throw new ResponseStatusException(FORBIDDEN, "Usuário não encontrado");
        }

        return isCliente;
    }
}

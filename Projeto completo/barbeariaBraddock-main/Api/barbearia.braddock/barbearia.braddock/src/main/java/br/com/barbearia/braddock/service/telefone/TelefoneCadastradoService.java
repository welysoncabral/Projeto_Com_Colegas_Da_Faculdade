package br.com.barbearia.braddock.service.telefone;

import br.com.barbearia.braddock.controller.request.AdicionarTelefoneRequest;
import br.com.barbearia.braddock.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class TelefoneCadastradoService {

    @Autowired
    private TelefoneRepository telefoneRepository;

    public void valida(AdicionarTelefoneRequest request) {

        if(telefoneRepository.existsByDddAndNumero(request.getDdd(), request.getNumero())){
            throw new ResponseStatusException(BAD_REQUEST, "Número de telefone já cadastrado");
        }
    }
}

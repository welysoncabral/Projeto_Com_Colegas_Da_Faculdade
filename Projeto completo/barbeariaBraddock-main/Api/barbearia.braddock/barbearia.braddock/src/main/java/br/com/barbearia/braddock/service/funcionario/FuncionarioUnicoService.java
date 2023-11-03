package br.com.barbearia.braddock.service.funcionario;

import br.com.barbearia.braddock.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class FuncionarioUnicoService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public void valida(String nome) {
        boolean funcionarioExiste = funcionarioRepository.existsByNome(nome);
        if (funcionarioExiste){
            throw new ResponseStatusException(BAD_REQUEST, "Funcionário já cadastrado");
        }
    }
}

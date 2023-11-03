package br.com.barbearia.braddock.service.funcionario;

import br.com.barbearia.braddock.controller.response.FuncionarioResponse;
import br.com.barbearia.braddock.domain.Funcionario;
import br.com.barbearia.braddock.mapper.FuncionarioMapper;
import br.com.barbearia.braddock.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarFuncionariosService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<FuncionarioResponse> listar() {

        List<Funcionario> listaFuncionarios = funcionarioRepository.findAll();

        return listaFuncionarios.stream().map(FuncionarioMapper::toResponse).toList();
    }
}

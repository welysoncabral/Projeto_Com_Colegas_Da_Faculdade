package br.com.barbearia.braddock.service.funcionario;

import br.com.barbearia.braddock.controller.request.CriarFuncionarioRequest;
import br.com.barbearia.braddock.controller.response.FuncionarioResponse;
import br.com.barbearia.braddock.domain.Funcionario;
import br.com.barbearia.braddock.mapper.FuncionarioMapper;
import br.com.barbearia.braddock.repository.FuncionarioRepository;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.barbearia.braddock.mapper.FuncionarioMapper.toEntity;
import static br.com.barbearia.braddock.mapper.FuncionarioMapper.toResponse;

@Service
public class CriarFuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private FuncionarioUnicoService funcionarioUnicoService;



    public FuncionarioResponse criar(CriarFuncionarioRequest request) {

        funcionarioUnicoService.valida(request.getNome());

        Funcionario funcionario = toEntity(request);

        funcionarioRepository.save(funcionario);

        return toResponse(funcionario);
    }
}

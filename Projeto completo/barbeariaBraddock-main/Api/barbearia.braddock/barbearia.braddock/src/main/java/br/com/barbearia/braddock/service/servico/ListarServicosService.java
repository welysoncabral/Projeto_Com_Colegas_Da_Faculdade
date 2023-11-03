package br.com.barbearia.braddock.service.servico;

import br.com.barbearia.braddock.controller.response.ServicoResponse;
import br.com.barbearia.braddock.domain.Servico;
import br.com.barbearia.braddock.mapper.ServicoMapper;
import br.com.barbearia.braddock.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarServicosService {

    @Autowired
    private ServicoRepository servicoRepository;

    public List<ServicoResponse> listar() {

        List<Servico> servicos = servicoRepository.findAll();

        return servicos.stream().map(ServicoMapper::toResponse).toList();
    }
}

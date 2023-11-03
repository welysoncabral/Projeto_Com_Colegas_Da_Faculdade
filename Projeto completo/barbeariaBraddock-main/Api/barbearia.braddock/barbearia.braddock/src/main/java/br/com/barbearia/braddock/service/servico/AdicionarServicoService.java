package br.com.barbearia.braddock.service.servico;

import br.com.barbearia.braddock.controller.request.CriarServicoRequest;
import br.com.barbearia.braddock.controller.response.ServicoResponse;
import br.com.barbearia.braddock.domain.Servico;
import br.com.barbearia.braddock.mapper.ServicoMapper;
import br.com.barbearia.braddock.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdicionarServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public ServicoResponse criar(CriarServicoRequest request) {

        Servico servico = ServicoMapper.toEntity(request);

        servicoRepository.save(servico);

        return ServicoMapper.toResponse(servico);

    }
}

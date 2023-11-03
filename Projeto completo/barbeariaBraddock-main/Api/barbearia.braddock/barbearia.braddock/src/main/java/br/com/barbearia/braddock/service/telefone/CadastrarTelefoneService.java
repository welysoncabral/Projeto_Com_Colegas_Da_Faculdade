package br.com.barbearia.braddock.service.telefone;

import br.com.barbearia.braddock.controller.request.AdicionarTelefoneRequest;
import br.com.barbearia.braddock.mapper.TelefoneMapper;
import br.com.barbearia.braddock.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastrarTelefoneService {


    @Autowired
    private TelefoneCadastradoService telefoneCadastradoService;

    @Autowired
    private TelefoneRepository telefoneRepository;

    public void adicionar(AdicionarTelefoneRequest request) {

        telefoneCadastradoService.valida(request);

        telefoneRepository.save(TelefoneMapper.toEntity(request));

    }
}

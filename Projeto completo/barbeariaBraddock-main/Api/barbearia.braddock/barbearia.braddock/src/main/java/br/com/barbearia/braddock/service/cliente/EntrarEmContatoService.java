package br.com.barbearia.braddock.service.cliente;

import br.com.barbearia.braddock.controller.request.EntrarEmContatoRequest;
import br.com.barbearia.braddock.domain.Mensagem;
import br.com.barbearia.braddock.mapper.MensagemMapper;
import br.com.barbearia.braddock.repository.MensagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntrarEmContatoService {

    @Autowired
    private MensagemRepository mensagemRepository;

    public void enviar(EntrarEmContatoRequest request) {

        Mensagem mensagem = MensagemMapper.toEntity(request);

        mensagemRepository.save(mensagem);
    }
}

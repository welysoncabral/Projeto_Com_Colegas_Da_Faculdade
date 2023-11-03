package br.com.barbearia.braddock.service.cliente;

import br.com.barbearia.braddock.controller.request.CriarClienteRequest;
import br.com.barbearia.braddock.domain.Cliente;
import br.com.barbearia.braddock.mapper.ClienteMapper;
import br.com.barbearia.braddock.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.barbearia.braddock.mapper.ClienteMapper.toEntity;

@Service
public class CriarClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public void criar(CriarClienteRequest request) {

        Cliente cliente = toEntity(request);

        clienteRepository.save(cliente);
    }
}

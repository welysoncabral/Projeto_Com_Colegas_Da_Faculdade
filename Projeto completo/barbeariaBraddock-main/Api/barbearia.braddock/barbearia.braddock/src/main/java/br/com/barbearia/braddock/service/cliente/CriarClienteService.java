package br.com.barbearia.braddock.service.cliente;

import br.com.barbearia.braddock.controller.request.CriarClienteRequest;
import br.com.barbearia.braddock.domain.Cliente;
import br.com.barbearia.braddock.domain.Telefone;
import br.com.barbearia.braddock.repository.ClienteRepository;
import br.com.barbearia.braddock.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.barbearia.braddock.mapper.ClienteMapper.toEntity;

@Service
public class CriarClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TelefoneRepository telefoneRepository;

    public void criar(CriarClienteRequest request) {

        Cliente cliente = toEntity(request);

        if(!request.getIdTelefones().isEmpty()){
            List<Telefone> listaTelefones = new java.util.ArrayList<>(List.of());
            request.getIdTelefones().forEach(telefoneAtual -> {
                Telefone telefone = telefoneRepository.findById(telefoneAtual).orElseThrow();
                listaTelefones.add(telefone);
            });
            cliente.setTelefones(listaTelefones);
        }

        clienteRepository.save(cliente);
    }
}

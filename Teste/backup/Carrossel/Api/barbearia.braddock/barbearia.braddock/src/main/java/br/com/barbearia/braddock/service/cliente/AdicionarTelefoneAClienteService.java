package br.com.barbearia.braddock.service.cliente;

import br.com.barbearia.braddock.controller.request.AdcicionarTelefoneRequest;
import br.com.barbearia.braddock.domain.Cliente;
import br.com.barbearia.braddock.domain.Telefone;
import br.com.barbearia.braddock.mapper.ClienteMapper;
import br.com.barbearia.braddock.mapper.TelefoneMapper;
import br.com.barbearia.braddock.repository.ClienteRepository;
import br.com.barbearia.braddock.repository.TelefoneRepository;
import br.com.barbearia.braddock.validator.TelefoneValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static br.com.barbearia.braddock.mapper.ClienteMapper.*;
import static br.com.barbearia.braddock.mapper.TelefoneMapper.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class AdicionarTelefoneAClienteService {


    @Autowired
    private TelefoneValidator telefoneValidator;

    @Autowired
    private TelefoneRepository telefoneRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public void adicionar(AdcicionarTelefoneRequest request) {

        if(request.getListaTelefones().isEmpty()){
            throw new ResponseStatusException(BAD_REQUEST, "Lista de telefones vazia");
        }

        request.getListaTelefones().forEach((telefone) -> telefoneValidator.valida(telefone.getNumero()));

        Cliente cliente = clienteRepository.findByEmailIgnoreCase(request.getEmailCliente());



        request.getListaTelefones().forEach(telefone -> {

            telefoneValidator.validaClienteJaComTelefone(cliente, telefone.getNumero());

            boolean isTelefoneCadastrado = telefoneRepository.existsByNumero(telefone.getNumero());

            if(!isTelefoneCadastrado){

                telefoneRepository.save(TelefoneMapper.toEntity(telefone.getNumero()));
            }

            Telefone telefoneJaSalvo = telefoneRepository.findByNumero(telefone.getNumero());

            Cliente clienteComTelefone = toEntityComTelefone(cliente, telefoneJaSalvo);

            clienteRepository.save(clienteComTelefone);
        });




    }
}

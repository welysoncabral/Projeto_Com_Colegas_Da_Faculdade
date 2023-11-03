package br.com.barbearia.braddock.mapper;

import br.com.barbearia.braddock.controller.request.CriarClienteRequest;
import br.com.barbearia.braddock.controller.response.ClienteResponse;
import br.com.barbearia.braddock.domain.Cliente;
import br.com.barbearia.braddock.domain.Telefone;

import java.util.List;

public class ClienteMapper {

    public static Cliente toEntity(CriarClienteRequest request) {
        Cliente entity = new Cliente();
        entity.setNome(request.getNome().toLowerCase());
        entity.setEmail(request.getEmail().toLowerCase());
        entity.setSenha(request.getSenha().toLowerCase());
        return entity;
    }

    public static Cliente toEntityComTelefone(Cliente cliente, Telefone telefone) {
        cliente.addTelefones(telefone);
        return cliente;
    }

    public static ClienteResponse toResponse(Cliente cliente) {
        return ClienteResponse.builder()
                .id(cliente.getId())
                .nome(cliente.getNome())
                .email(cliente.getEmail())
                .build();
    }
}

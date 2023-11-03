package br.com.barbearia.braddock.mapper;

import br.com.barbearia.braddock.controller.request.EntrarEmContatoRequest;
import br.com.barbearia.braddock.domain.Mensagem;

public class MensagemMapper {

    public static Mensagem toEntity(EntrarEmContatoRequest request) {
    Mensagem entity = new Mensagem();
    entity.setNome(request.getNome());
    entity.setEmail(request.getEmail());
    entity.setNumero((request.getNumero()));
    entity.setMensagem(request.getMensagem());

    return entity;

    }
}

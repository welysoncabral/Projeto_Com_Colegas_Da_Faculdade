package br.com.barbearia.braddock.mapper;

import br.com.barbearia.braddock.controller.request.AdicionarTelefoneRequest;
import br.com.barbearia.braddock.domain.Telefone;

public class TelefoneMapper {


    public static Telefone toEntity(AdicionarTelefoneRequest request) {
        Telefone entity = new Telefone();
        entity.setDdd(request.getDdd());
        entity.setNumero(request.getNumero());
        return entity;
    }

}

package br.com.barbearia.braddock.mapper;

import br.com.barbearia.braddock.domain.Telefone;

import java.util.ArrayList;
import java.util.List;

public class TelefoneMapper {


    public static Telefone toEntity(String telefone) {
        Telefone entity = new Telefone();
        entity.setNumero(telefone);
        return entity;
    }

    public static List<Telefone> listToEntity(List<Telefone> listaTelefones) {
        List<Telefone> entityList;
        entityList = listaTelefones.stream().map((telefone) -> {
            Telefone entity = new Telefone();
            entity.setNumero(telefone.getNumero());
            return entity;
        }).toList();
        return  entityList;
    }
}

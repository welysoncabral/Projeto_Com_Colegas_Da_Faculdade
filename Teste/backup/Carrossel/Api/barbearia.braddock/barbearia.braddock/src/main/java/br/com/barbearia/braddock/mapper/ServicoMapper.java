package br.com.barbearia.braddock.mapper;

import br.com.barbearia.braddock.controller.request.CriarServicoRequest;
import br.com.barbearia.braddock.controller.response.ServicoResponse;
import br.com.barbearia.braddock.domain.Servico;

public class ServicoMapper {

    public static Servico toEntity(CriarServicoRequest request) {
        Servico entity = new Servico();
        entity.setNome(request.getNome());
        entity.setTempoMedio((request.getTempoMedio()));
        entity.setValor(request.getValor());
        return entity;
    }

    public static ServicoResponse toResponse(Servico servico) {
        return ServicoResponse.builder()
                .id(servico.getId())
                .nome(servico.getNome())
                .valor(servico.getValor())
                .tempoMedio(servico.getTempoMedio())
                .build();
    }
}

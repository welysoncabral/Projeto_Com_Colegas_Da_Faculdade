package br.com.barbearia.braddock.mapper;

import br.com.barbearia.braddock.controller.request.AgendarRequest;
import br.com.barbearia.braddock.controller.response.AgendaResponse;
import br.com.barbearia.braddock.domain.Agenda;

public class AgendaMapper {

    public static Agenda toEntity(AgendarRequest request, int tempoMedio) {
        Agenda entity = new Agenda();
        entity.setNomeCliente(request.getNomeCliente());
        entity.setNomeFuncionario(request.getNomeFuncionario());
        entity.setServico(request.getServico());
        entity.setHorarioInicio(request.getHorarioInicio());
        entity.setHorarioFim(request.getHorarioInicio().plusMinutes(tempoMedio));
        return entity;
    }

    public static AgendaResponse toResponse(Agenda agenda) {
        return AgendaResponse.builder()
                .id(agenda.getId())
                .cliente(agenda.getNomeCliente())
                .funcionario(agenda.getNomeFuncionario())
                .servico(agenda.getServico())
                .horarioInicio(agenda.getHorarioInicio())
                .horarioFim(agenda.getHorarioFim())
                .build();
    }
}

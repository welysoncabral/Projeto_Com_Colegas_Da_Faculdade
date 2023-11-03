package br.com.barbearia.braddock.mapper;

import br.com.barbearia.braddock.controller.request.AgendarRequest;
import br.com.barbearia.braddock.controller.response.AgendaResponse;
import br.com.barbearia.braddock.domain.Agenda;
import br.com.barbearia.braddock.domain.Cliente;
import br.com.barbearia.braddock.domain.Funcionario;
import br.com.barbearia.braddock.domain.Servico;

public class AgendaMapper {

    public static Agenda toEntity(AgendarRequest request, Cliente cliente, Servico servico, Funcionario funcionario) {
        Agenda entity = new Agenda();
        entity.setCliente(cliente);
        entity.setFuncionario(funcionario);
        entity.setServico(servico);
        entity.setHorarioInicio(request.getHorarioInicio());
        entity.setHorarioFim(request.getHorarioInicio().plusMinutes(servico.getTempoMedio()));
        return entity;
    }

    public static AgendaResponse toResponse(Agenda agenda) {
        return AgendaResponse.builder()
                .id(agenda.getId())
                .cliente(ClienteMapper.toResponse(agenda.getCliente()))
                .funcionario(FuncionarioMapper.toResponse(agenda.getFuncionario()))
                .servico(ServicoMapper.toResponse(agenda.getServico()))
                .horarioInicio(agenda.getHorarioInicio())
                .horarioFim(agenda.getHorarioFim())
                .build();
    }
}

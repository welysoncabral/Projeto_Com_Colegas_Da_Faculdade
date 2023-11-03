package br.com.barbearia.braddock.mapper;

import br.com.barbearia.braddock.controller.request.CriarFuncionarioRequest;
import br.com.barbearia.braddock.controller.response.FuncionarioResponse;
import br.com.barbearia.braddock.domain.Funcionario;

public class FuncionarioMapper {

    public static Funcionario toEntity(CriarFuncionarioRequest request) {
        Funcionario entity = new Funcionario();
        entity.setNome(request.getNome());
        return entity;
    }

    public static FuncionarioResponse toResponse(Funcionario funcionario) {
        return FuncionarioResponse.builder()
                                  .id(funcionario.getId())
                                  .nome(funcionario.getNome())
                                  .build();
    }
}

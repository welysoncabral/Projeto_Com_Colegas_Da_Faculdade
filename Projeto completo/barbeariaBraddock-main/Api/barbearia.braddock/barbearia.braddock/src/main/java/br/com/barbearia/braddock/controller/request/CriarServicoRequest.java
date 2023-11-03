package br.com.barbearia.braddock.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CriarServicoRequest {

    @NotBlank
    private String nome;

    @NotNull
    private String valor;

    @NotNull
    private Long tempoMedio;

}

package br.com.barbearia.braddock.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CriarFuncionarioRequest {

    @NotBlank
    @Size(min = 10, max = 255)
    private String nome;

}

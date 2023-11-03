package br.com.barbearia.braddock.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AdicionarTelefoneRequest {

    @NotBlank
    @Size(min = 9, max = 9)
    private String numero;

    @NotBlank
    @Size(min = 2, max = 2)
    private String ddd;
}

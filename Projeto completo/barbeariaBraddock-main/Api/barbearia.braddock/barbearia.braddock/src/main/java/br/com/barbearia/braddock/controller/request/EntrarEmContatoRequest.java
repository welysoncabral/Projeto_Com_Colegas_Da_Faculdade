package br.com.barbearia.braddock.controller.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class EntrarEmContatoRequest {

    @NotBlank
    @Size(min = 10, max = 255)
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String numero;

    @NotBlank
    @Size(min = 10, max = 1000)
    private String mensagem;
}

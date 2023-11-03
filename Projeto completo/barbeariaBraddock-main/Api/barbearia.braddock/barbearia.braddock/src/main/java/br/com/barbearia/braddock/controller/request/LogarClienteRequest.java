package br.com.barbearia.braddock.controller.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LogarClienteRequest {

    @NotBlank
    @Email
    @Size(min = 10, max = 255)
    private String email;

    @NotBlank
    @Size(min = 8, max = 255)
    private String senha;
}

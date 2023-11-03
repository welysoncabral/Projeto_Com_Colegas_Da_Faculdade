package br.com.barbearia.braddock.controller.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class CriarClienteRequest {

    @NotBlank
    @Size(min = 10, max = 255)
    private String nome;

    @NotBlank
    @Email
    @Size(min = 10, max = 255)
    private String email;

    @NotBlank
    @Size(min = 8, max = 255)
    private String senha;

    private List<Long> idTelefones;

}

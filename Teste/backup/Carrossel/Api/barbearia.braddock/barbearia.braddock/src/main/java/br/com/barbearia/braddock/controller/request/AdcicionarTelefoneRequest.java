package br.com.barbearia.braddock.controller.request;

import br.com.barbearia.braddock.domain.Telefone;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class AdcicionarTelefoneRequest {

    private List<Telefone> listaTelefones;

    @NotBlank
    private String emailCliente;
}

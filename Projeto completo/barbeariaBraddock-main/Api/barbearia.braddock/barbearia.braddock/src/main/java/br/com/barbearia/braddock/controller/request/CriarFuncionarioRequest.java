package br.com.barbearia.braddock.controller.request;

import br.com.barbearia.braddock.domain.TurnoEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Builder
@Getter
public class CriarFuncionarioRequest {

    @NotBlank
    @Size(min = 10, max = 255)
    private String nome;

    @NonNull
    private TurnoEnum turno;

}

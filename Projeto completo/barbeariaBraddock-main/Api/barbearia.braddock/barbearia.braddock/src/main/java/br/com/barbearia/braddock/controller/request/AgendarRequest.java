package br.com.barbearia.braddock.controller.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class AgendarRequest {

    @NotNull
    @Size(min = 10, max = 255)
    private String nomeCliente;

    @NotNull
    private String nomeFuncionario;

    @NotNull
    private String telefone;

    @NotNull
    private String servico;

    @NotNull
    private LocalDateTime horarioInicio;

}

package br.com.barbearia.braddock.controller.request;

import br.com.barbearia.braddock.domain.Cliente;
import br.com.barbearia.braddock.domain.Funcionario;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

@Builder
@Getter
public class AgendarRequest {

    @NotNull
    private Long clienteId;

    @NotNull
    private Long funcionarioId;

    @NotNull
    private Long servicoId;

    @NotNull
    private LocalDateTime horarioInicio;

}

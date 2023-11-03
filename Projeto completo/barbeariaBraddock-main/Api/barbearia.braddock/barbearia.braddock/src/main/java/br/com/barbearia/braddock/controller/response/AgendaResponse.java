package br.com.barbearia.braddock.controller.response;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AgendaResponse {

    private Long id;
    private String cliente;
    private String funcionario;
    private String servico;
    private LocalDateTime horarioInicio;
    private LocalDateTime horarioFim;

}

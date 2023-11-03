package br.com.barbearia.braddock.controller.response;

import br.com.barbearia.braddock.domain.TurnoEnum;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FuncionarioResponse {

    private Long id;
    private String nome;
    private TurnoEnum turno;
}

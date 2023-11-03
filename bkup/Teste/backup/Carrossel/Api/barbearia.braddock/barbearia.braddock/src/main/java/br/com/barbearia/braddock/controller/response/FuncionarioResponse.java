package br.com.barbearia.braddock.controller.response;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FuncionarioResponse {

    private Long id;
    private String nome;
}

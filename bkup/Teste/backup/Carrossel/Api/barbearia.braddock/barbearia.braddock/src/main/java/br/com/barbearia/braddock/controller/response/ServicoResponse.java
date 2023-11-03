package br.com.barbearia.braddock.controller.response;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ServicoResponse {

    private Long id;
    private String nome;
    private String valor;
    private Long tempoMedio;

}

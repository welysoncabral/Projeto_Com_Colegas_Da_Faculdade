package br.com.barbearia.braddock.controller.response;

import br.com.barbearia.braddock.domain.Telefone;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClienteResponse {

    private Long id;
    private String nome;
    private String email;
    private List<Telefone> telefones;
}

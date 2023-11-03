package br.com.barbearia.braddock.controller.response;

import br.com.barbearia.braddock.domain.Cliente;
import br.com.barbearia.braddock.domain.Funcionario;
import br.com.barbearia.braddock.domain.Servico;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AgendaResponse {

    private Long id;
    private ClienteResponse cliente;
    private FuncionarioResponse funcionario;
    private ServicoResponse servico;
    private LocalDateTime horarioInicio;
    private LocalDateTime horarioFim;

}

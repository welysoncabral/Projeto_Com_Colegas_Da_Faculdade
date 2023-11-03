package br.com.barbearia.braddock.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(of = "id")
public class Agenda {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column
    private String nomeCliente;

    @Column
    private String nomeFuncionario;

    @Column
    private String servico;

    @Column(nullable = false)
    private LocalDateTime horarioInicio;

    @Column(nullable = false)
    private LocalDateTime horarioFim;
}

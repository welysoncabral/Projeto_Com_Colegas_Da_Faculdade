package br.com.barbearia.braddock.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;
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

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "servico_id")
    private Servico servico;

    @Column(nullable = false)
    private LocalDateTime horarioInicio;

    @Column(nullable = false)
    private LocalDateTime horarioFim;
}

package br.com.barbearia.braddock.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(of = "id")
public class Telefone {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numero;

    @ManyToMany(mappedBy = "telefones")
    private List<Cliente> clientes = new ArrayList<>();
}

package br.com.barbearia.braddock.domain;

import jakarta.persistence.*;
import lombok.*;

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
public class Cliente {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    @OneToMany
    @JoinTable(name = "cliente_telefone",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "telefone_id"))
    private List<Telefone> telefones;

    public void addTelefones(Telefone telefone) {
        this.telefones.add(telefone);
    }
}
package com.orangetalents.cadastrodeveiculos.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false,unique = true)
    private String cpf;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")

    private List<Veiculo> veiculos;
}

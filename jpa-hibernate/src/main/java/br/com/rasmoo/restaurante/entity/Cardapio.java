package br.com.rasmoo.restaurante.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "cardapio")

public class Cardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private Boolean disponivel;
    private BigDecimal valor;

    @ManyToOne
    private Categoria categoria;

    @Column(name = "data_de_registro")
    private LocalDateTime dataRegistro = LocalDateTime.now();

}

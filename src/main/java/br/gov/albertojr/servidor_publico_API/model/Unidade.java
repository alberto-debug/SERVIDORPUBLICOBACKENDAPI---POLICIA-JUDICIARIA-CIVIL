package br.gov.albertojr.servidor_publico_API.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "unidade")
public class Unidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unid_id")
    private int id;

    @Column(name = "unid_nome")
    private String nome;


    @Column(name = "unid_sigla")
    private String sigla;

    @ManyToMany
    @JoinTable(name = "unidade_endereco",
            joinColumns = @JoinColumn(name = "unid_id") ,
            inverseJoinColumns = @JoinColumn(name = "end_id")
    )
    private List<Endereco> enderecoList;


}

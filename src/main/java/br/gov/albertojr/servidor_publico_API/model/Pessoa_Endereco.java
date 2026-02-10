package br.gov.albertojr.servidor_publico_API.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pessoa_endereco")
public class Pessoa_Endereco {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(name = "pes_id", nullable = false)
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "end_id", nullable = false)
    private Endereco endereco;


}

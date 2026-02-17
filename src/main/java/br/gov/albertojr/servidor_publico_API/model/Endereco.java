package br.gov.albertojr.servidor_publico_API.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "endereco")
@ToString
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "end_id")
    private int id;

    @Column(name = "end_tipo_logradouro")
    private String tipoLogradouro;

    @Column(name = "end_logradouro")
    private String logradouro;

    @Column(name = "end_numero")
    private int numero;

    @Column(name = "end_bairro")
    private String bairro;

    @ManyToOne
    @JoinColumn(name = "cid_id", nullable = false)
    private Cidade cidade;


}

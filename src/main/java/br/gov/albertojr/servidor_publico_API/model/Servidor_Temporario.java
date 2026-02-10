package br.gov.albertojr.servidor_publico_API.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "servidor_temporario")
public class Servidor_Temporario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "pes_id", nullable = false, referencedColumnName = "pes_id")
    private Pessoa pessoa;

    @Column(name = "st_data-admissao")
    private LocalDate stDataAdmissao;

    @Column(name = "st_data_demissao")
    private LocalDate seDataDemissao;


}

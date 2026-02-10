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
@Table(name = "lotacao")
public class Lotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lot_id")
    private int id;


    @ManyToOne
    @JoinColumn(name = "pes_id", nullable = false)
    private Pessoa pessoa;


    @ManyToOne
    @JoinColumn(name = "unid_id", nullable = false)
    private Unidade unidade;

    @Column(name = "lot_data_lotacao")
    private LocalDate data_lotacao;

    @Column(name = "lot)data_remocao")
    private LocalDate data_remocao;


    @Column(name = "lot_portaria")
    private String portaria;




}

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
@Table(name = "foto_pessoa")
public class Foto_Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fp_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "pes_id", nullable = false)
    private Pessoa pessoa;

    @Column(name = "fp_data")
    private LocalDate data;

    @Column(name = "fp_bucket")
    private String bucket;

    @Column(name = "fp_hash")
    private String hash;
}

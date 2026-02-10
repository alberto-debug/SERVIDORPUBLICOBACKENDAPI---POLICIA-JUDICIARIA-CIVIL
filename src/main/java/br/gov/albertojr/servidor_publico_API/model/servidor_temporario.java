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
@Table(name = "servidor_temporario")
public class servidor_temporario {

    @Id
    @ManyToOne
    @JoinColumn(name = "pes_id", nullable = false, referencedColumnName = "pes_id")
    private pessoa pessoa;
}

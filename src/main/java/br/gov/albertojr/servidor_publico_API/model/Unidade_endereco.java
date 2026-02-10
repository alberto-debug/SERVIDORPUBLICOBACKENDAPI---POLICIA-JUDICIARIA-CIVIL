package br.gov.albertojr.servidor_publico_API.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "unidade_endereco")
public class Unidade_endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "unid_id", nullable = false)
    private Unidade unidade;

    @ManyToOne
    @JoinColumn(name = "end_id", nullable = false)
    private Endereco endereco;
}

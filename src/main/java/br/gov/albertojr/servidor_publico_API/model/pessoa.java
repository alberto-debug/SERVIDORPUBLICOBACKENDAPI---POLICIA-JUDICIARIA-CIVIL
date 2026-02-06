package br.gov.albertojr.servidor_publico_API.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Setter
@Getter
public class pessoa {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pes_id;
    private String pes_nome;
    private LocalDate pes_data_nascimento;
    private String pes_sexo;
    private String pes_mae;
    private String pes_pai;


}

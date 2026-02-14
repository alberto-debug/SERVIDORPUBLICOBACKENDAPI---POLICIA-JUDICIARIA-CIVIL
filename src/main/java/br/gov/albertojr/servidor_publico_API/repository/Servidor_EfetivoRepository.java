package br.gov.albertojr.servidor_publico_API.repository;

import br.gov.albertojr.servidor_publico_API.model.Servidor_Efetivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Servidor_EfetivoRepository  extends JpaRepository<Servidor_Efetivo, Integer> {



}

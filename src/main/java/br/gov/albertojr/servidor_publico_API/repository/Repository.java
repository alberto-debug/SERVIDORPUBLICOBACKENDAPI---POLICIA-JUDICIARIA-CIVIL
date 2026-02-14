package br.gov.albertojr.servidor_publico_API.repository;


import br.gov.albertojr.servidor_publico_API.model.Lotacao;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Lotacao, Integer> {
}

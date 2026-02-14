package br.gov.albertojr.servidor_publico_API.repository;

import br.gov.albertojr.servidor_publico_API.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

    List<Cidade> findById(int id);
}

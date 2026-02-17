package br.gov.albertojr.servidor_publico_API.repository;

import br.gov.albertojr.servidor_publico_API.model.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Integer> {

    Optional<Unidade> findById(int id);

    public Unidade findByNome(String nome);
}

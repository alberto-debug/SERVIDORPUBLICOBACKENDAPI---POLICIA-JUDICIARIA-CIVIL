package br.gov.albertojr.servidor_publico_API.repository;

import br.gov.albertojr.servidor_publico_API.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    Optional<Pessoa> findByNome(String nome);

}

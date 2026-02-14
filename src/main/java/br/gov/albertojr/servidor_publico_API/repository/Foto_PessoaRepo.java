package br.gov.albertojr.servidor_publico_API.repository;

import br.gov.albertojr.servidor_publico_API.model.Foto_Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Foto_PessoaRepo extends JpaRepository<Foto_Pessoa, Integer> {
}

package br.gov.albertojr.servidor_publico_API.repository;


import br.gov.albertojr.servidor_publico_API.model.Unidade_endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeEnderecoRepository extends JpaRepository<Unidade_endereco, Integer> {
}

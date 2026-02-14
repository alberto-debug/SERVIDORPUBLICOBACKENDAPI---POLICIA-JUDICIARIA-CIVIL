package br.gov.albertojr.servidor_publico_API.repository;


import br.gov.albertojr.servidor_publico_API.model.PessoaEndereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaEnderecoRepository extends JpaRepository<PessoaEndereco, Integer> {
}

package br.gov.albertojr.servidor_publico_API.repository;


import br.gov.albertojr.servidor_publico_API.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

    Optional<Endereco> findByLogradouro(String nome);

    Optional<Endereco> findById(int id);
}


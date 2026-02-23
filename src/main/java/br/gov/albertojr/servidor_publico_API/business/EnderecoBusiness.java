package br.gov.albertojr.servidor_publico_API.business;

import br.gov.albertojr.servidor_publico_API.exception.EntityAlreadyExistsException;

import br.gov.albertojr.servidor_publico_API.exception.EntityDoesNotExistsException;
import br.gov.albertojr.servidor_publico_API.model.Cidade;
import br.gov.albertojr.servidor_publico_API.model.Endereco;
import br.gov.albertojr.servidor_publico_API.repository.EnderecoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EnderecoBusiness {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco add(Endereco endereco){

        if (enderecoRepository.existsById(endereco.getId())){
            throw new EntityAlreadyExistsException(endereco.getId()+ " " + endereco.getLogradouro());

        }

        return enderecoRepository.save(endereco);
    }

    public Page<Endereco> findAll(Pageable pageable){

        return enderecoRepository.findAll(pageable);
    }

    public Endereco findById(int id){

       return enderecoRepository.findById(id)
              .orElseThrow(()-> new EntityDoesNotExistsException(id));
    }

    public Endereco update(int id, Endereco endereco){

        if (!enderecoRepository.existsById(id)){

            throw new EntityDoesNotExistsException(id);
        }

        endereco.setId(id);

        return enderecoRepository.save(endereco);

    }

}
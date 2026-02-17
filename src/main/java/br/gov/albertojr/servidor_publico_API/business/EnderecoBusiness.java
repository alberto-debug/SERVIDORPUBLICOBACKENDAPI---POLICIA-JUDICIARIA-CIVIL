package br.gov.albertojr.servidor_publico_API.business;

import br.gov.albertojr.servidor_publico_API.exceptoion.EntityAlreadyExistsException;
import br.gov.albertojr.servidor_publico_API.exceptoion.EntityDoesNotExistsException;

import br.gov.albertojr.servidor_publico_API.model.Endereco;
import br.gov.albertojr.servidor_publico_API.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EnderecoBusiness {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco add(Endereco endereco) throws EntityAlreadyExistsException {
        if (enderecoRepository.findByLogradouro(endereco.getLogradouro()).isPresent()) {
            throw new EntityAlreadyExistsException(endereco.getLogradouro());
        }
        return enderecoRepository.save(endereco);
    }

    public Page<Endereco> findAll(Pageable pageable) {
        return enderecoRepository.findAll(pageable);
    }

    public Endereco update(Endereco endereco) throws EntityDoesNotExistsException {
        if (enderecoRepository.findById(endereco.getId()).isEmpty()) {
            throw new EntityDoesNotExistsException(endereco.getId());
        }
        return enderecoRepository.save(endereco);
    }

    public void delete(int id) throws EntityDoesNotExistsException {
        if (enderecoRepository.findById(id).isEmpty()) {
            throw new EntityDoesNotExistsException(id);
        }
        enderecoRepository.deleteById(id);
    }

}
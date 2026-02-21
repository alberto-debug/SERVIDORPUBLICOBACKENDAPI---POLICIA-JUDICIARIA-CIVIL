package br.gov.albertojr.servidor_publico_API.business;

import br.gov.albertojr.servidor_publico_API.exceptoion.EntityAlreadyExistsException;
import br.gov.albertojr.servidor_publico_API.exceptoion.EntityDoesNotExistsException;

import br.gov.albertojr.servidor_publico_API.model.Endereco;
import br.gov.albertojr.servidor_publico_API.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

public Page<Endereco> findAll(Pageable pageable){

        return enderecoRepository.findAll(pageable);
}

public Endereco update(int id, Endereco endereco) throws EntityDoesNotExistsException{

        Endereco update = enderecoRepository.findById(id)
                .orElseThrow(()-> new EntityDoesNotExistsException(id));


        update.setLogradouro(endereco.getLogradouro());
        update.setNumero(endereco.getNumero());
        update.setBairro(endereco.getBairro());

        return  enderecoRepository.save(update);
}

}
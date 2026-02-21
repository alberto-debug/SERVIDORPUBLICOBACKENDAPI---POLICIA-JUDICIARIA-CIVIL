package br.gov.albertojr.servidor_publico_API.business;


import br.gov.albertojr.servidor_publico_API.exception.EntityAlreadyExistsException;
import br.gov.albertojr.servidor_publico_API.exception.EntityDoesNotExistsException;
import br.gov.albertojr.servidor_publico_API.model.Cidade;
import br.gov.albertojr.servidor_publico_API.repository.CidadeRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CidadeBusiness {

    @Autowired
    private CidadeRepository cidadeRepository;


    public Cidade add(Cidade cidade){

        if (cidadeRepository.existsById(cidade.getId())){
            throw new EntityAlreadyExistsException(cidade.getUf() + " " +cidade.getNome());
        }

        return cidadeRepository.save(cidade);
    }

    public Page<Cidade> findAll(Pageable pageable){

        return cidadeRepository.findAll(pageable);

    }

    public Cidade findById(int id){

        return cidadeRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(String.valueOf(id)));
    }


    public Cidade update(int id, Cidade cidade){

        if (!cidadeRepository.existsById(id)){
            throw new EntityDoesNotExistsException(id);
        }

        cidade.setId(id);

        return cidadeRepository.save(cidade);
    }



}

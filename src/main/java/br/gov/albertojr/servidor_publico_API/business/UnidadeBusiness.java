package br.gov.albertojr.servidor_publico_API.business;

import br.gov.albertojr.servidor_publico_API.exception.EntityAlreadyExistsException;
import br.gov.albertojr.servidor_publico_API.exception.EntityDoesNotExistsException;
import br.gov.albertojr.servidor_publico_API.model.Cidade;
import br.gov.albertojr.servidor_publico_API.model.Endereco;
import br.gov.albertojr.servidor_publico_API.model.Unidade;
import br.gov.albertojr.servidor_publico_API.repository.EnderecoRepository;
import br.gov.albertojr.servidor_publico_API.repository.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UnidadeBusiness {

    @Autowired
    private UnidadeRepository unidadeRepository;

    public Unidade add(Unidade unidade){

        if (unidadeRepository.existsById(unidade.getId())){
            throw  new EntityAlreadyExistsException(unidade.getId()+ " " + unidade.getNome());
        }

        return unidadeRepository.save(unidade);
    }

    public Page<Unidade> findAll(Pageable pageable){

        return unidadeRepository.findAll(pageable);
    }

    public Unidade findById(int id){

        return unidadeRepository.findById(id)
                .orElseThrow(()-> new EntityDoesNotExistsException(id));
    }

    public Unidade update(int id, Unidade unidade){
        if (!unidadeRepository.existsById(id)){
            throw new EntityDoesNotExistsException(id);
        }

        unidade.setId(id);
        return unidadeRepository.save(unidade);
    }






}

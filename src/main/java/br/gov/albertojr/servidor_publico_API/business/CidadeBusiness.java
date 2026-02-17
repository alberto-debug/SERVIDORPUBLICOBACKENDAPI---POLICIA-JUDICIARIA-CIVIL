package br.gov.albertojr.servidor_publico_API.business;


import br.gov.albertojr.servidor_publico_API.exceptoion.EntityAlreadyExistsException;
import br.gov.albertojr.servidor_publico_API.exceptoion.EntityDoesNotExistsException;
import br.gov.albertojr.servidor_publico_API.model.Cidade;
import br.gov.albertojr.servidor_publico_API.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CidadeBusiness {

    @Autowired
    private CidadeRepository cidadeRepository;

    public Cidade add(Cidade cidade) throws EntityAlreadyExistsException {
        if (cidadeRepository.findById(cidade.getId()).isPresent()){
            throw new EntityAlreadyExistsException(cidade.getUf()+ " "+ cidade.getNome() );
        } 
        return cidadeRepository.save(cidade);
    }

    public Page<Cidade> findAll(Pageable pageable){
        return cidadeRepository.findAll(pageable);
    }

    public Cidade update(Cidade cidade) throws EntityDoesNotExistsException {
        if (!cidadeRepository.findById(cidade.getId()).isPresent()) {
            throw new EntityDoesNotExistsException(cidade.getId());
        }

        return cidadeRepository.save(cidade);
    }


}

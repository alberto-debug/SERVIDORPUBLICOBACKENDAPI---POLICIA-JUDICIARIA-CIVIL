package br.gov.albertojr.servidor_publico_API.business;

import br.gov.albertojr.servidor_publico_API.exceptoion.EntityAlreadyExistsException;
import br.gov.albertojr.servidor_publico_API.exceptoion.EntityDoesNotExistsException;
import br.gov.albertojr.servidor_publico_API.model.Endereco;
import br.gov.albertojr.servidor_publico_API.model.Unidade;
import br.gov.albertojr.servidor_publico_API.repository.EnderecoRepository;
import br.gov.albertojr.servidor_publico_API.repository.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UnidadeBusiness {

    @Autowired
    private UnidadeRepository unidadeRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;


    public Unidade add(Unidade unidade) throws EntityAlreadyExistsException{

        if (unidadeRepository.findById(unidade.getId()).isPresent()){

            throw new EntityAlreadyExistsException(unidade.getNome());
        }

        verificarSeTodosOsEnderecosExistem(unidade);

        return unidadeRepository.save(unidade);
    }

    public Page<Unidade> findAll(Pageable pageable){
        return unidadeRepository.findAll(pageable);
    }

    public void verificarSeTodosOsEnderecosExistem(Unidade unidade) throws EntityDoesNotExistsException {
        for (Endereco endereco : unidade.getEnderecoList()) {
            if (enderecoRepository.findById(endereco.getId()).isEmpty()) {
                throw new EntityDoesNotExistsException(endereco.getId());
            }
        }
    }
}

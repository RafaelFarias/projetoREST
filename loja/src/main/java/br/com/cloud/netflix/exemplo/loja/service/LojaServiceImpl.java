package br.com.cloud.netflix.exemplo.loja.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.com.cloud.netflix.exemplo.loja.domain.Loja;
import br.com.cloud.netflix.exemplo.loja.domain.LojaComCarros;
import br.com.cloud.netflix.exemplo.loja.repository.LojaRepository;

@Service
@Validated
public class LojaServiceImpl implements LojaService {

    private final LojaRepository repository;

    @Autowired
    public LojaServiceImpl(final LojaRepository repository) {
        this.repository = repository;
    }
    
    public Loja getById(String id) {    
    	return repository.findOne(id);
    }
    
	public List<Loja> listAllLojas() {
		return repository.findAll();
	}
	
    @Transactional
    public Loja save(@NotNull @Valid final Loja participant) {
    	
        Loja existing = repository.findOne(participant.getId());
/*        
        if (existing != null) {
            throw new LojaAlreadyExistsException(String.format("There already exists a participant with email=%s", participant.getName()));
        }
 */
        
        return repository.save(participant);
    }
    
    public void deleteById(String id) {    
    	repository.delete(id);
    }

	public LojaRepository getRepository() {
		return repository;
	}

}

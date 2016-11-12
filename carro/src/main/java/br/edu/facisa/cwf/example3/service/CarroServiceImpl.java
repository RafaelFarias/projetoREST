package br.edu.facisa.cwf.example3.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.edu.facisa.cwf.example3.domain.Carro;
import br.edu.facisa.cwf.example3.repository.CarroRepository;

@Service
@Validated
public class CarroServiceImpl implements CarroService {

    private final CarroRepository repository;

    @Autowired
    public CarroServiceImpl(final CarroRepository repository) {
        this.repository = repository;
    }
    
    public Carro getById(String id) {    
    	return repository.findOne(id);
    }
    
	public List<Carro> listAllCarros() {
		return repository.findAll();
	}
	
    @Transactional
    public Carro save(@NotNull @Valid final Carro participant) {
    	
        Carro existing = repository.findOne(participant.getId());
/*        
        if (existing != null) {
            throw new CarroAlreadyExistsException(String.format("There already exists a participant with email=%s", participant.getName()));
        }
 */
        
        return repository.save(participant);
    }
    
    public void deleteById(String id) {    
    	repository.delete(id);
    }

	public CarroRepository getRepository() {
		return repository;
	}
}

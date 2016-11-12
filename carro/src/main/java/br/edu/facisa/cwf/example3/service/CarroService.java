package br.edu.facisa.cwf.example3.service;

import java.util.List;

import br.edu.facisa.cwf.example3.domain.Carro;

public interface CarroService {

	Carro save(Carro carro);

	Carro getById(String id);
	
	List<Carro> listAllCarros();
	
	void deleteById(String id);
}

package br.edu.facisa.cwf.example3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.facisa.cwf.example3.domain.Carro;

public interface CarroRepository extends JpaRepository<Carro, String> {

	public Carro findByModelo(String modelo);
	
}

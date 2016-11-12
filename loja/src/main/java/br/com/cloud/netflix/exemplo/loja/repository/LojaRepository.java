package br.com.cloud.netflix.exemplo.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cloud.netflix.exemplo.loja.domain.Loja;

public interface LojaRepository extends JpaRepository<Loja, String> {

	public Loja findByName(String name);
	
}

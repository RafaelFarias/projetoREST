package br.com.cloud.netflix.exemplo.loja.service;

import java.util.List;

import br.com.cloud.netflix.exemplo.loja.domain.Loja;
import br.com.cloud.netflix.exemplo.loja.domain.LojaComCarros;

public interface LojaService {

	Loja save(Loja loja);

	Loja getById(String id);
	
	List<Loja> listAllLojas();
	
	void deleteById(String id);

}

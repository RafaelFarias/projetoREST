package br.com.cloud.netflix.exemplo.loja.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cloud.netflix.exemplo.loja.domain.Carro;
import br.com.cloud.netflix.exemplo.loja.domain.Loja;
import br.com.cloud.netflix.exemplo.loja.domain.LojaComCarros;
import br.com.cloud.netflix.exemplo.loja.hystrix.CarrosBean;
import br.com.cloud.netflix.exemplo.loja.service.LojaService;

@RestController
public class LojaController {

	@Autowired
	private CarrosBean carrosBean;

	private static List<Loja> lojas = new ArrayList<Loja>();
	
	private final LojaService lojaService;

	@Autowired
	public LojaController(final LojaService lojaService) {
		this.lojaService = lojaService;
	}
	
	@RequestMapping("/")
	public ResponseEntity<List<LojaComCarros>> getLojas() {
		List<LojaComCarros> returnLojas = new ArrayList<LojaComCarros>();

		lojas = lojaService.listAllLojas();
		
		for (Loja loja : lojas) {
			returnLojas.add(new LojaComCarros(loja, carrosBean.getCarros(loja.getId())));
		}

		return new ResponseEntity<List<LojaComCarros>>(returnLojas, HttpStatus.OK);
	}
	
	@RequestMapping("/lojas")
	public ResponseEntity<List<LojaComCarros>> getAllLojas() {
		return getLojas();
	}

	@RequestMapping("/carros")
	public ResponseEntity<List<LojaComCarros>> getLojasComCarros() {
		List<LojaComCarros> returnLojas = new ArrayList<LojaComCarros>();

		lojas = lojaService.listAllLojas();
		
		for (Loja loja : lojas) {
			returnLojas.add(new LojaComCarros(loja, carrosBean.getCarros(loja.getId())));
		}

		return new ResponseEntity<List<LojaComCarros>>(returnLojas, HttpStatus.OK);
	}
	
	@RequestMapping("/lojasComCarros")
	public ResponseEntity<List<LojaComCarros>> getMergeLojasComCarros() {
		List<LojaComCarros> returnLojas = new ArrayList<LojaComCarros>();

		lojas = lojaService.listAllLojas();
		
		for (Loja loja : lojas) {
			returnLojas.add(new LojaComCarros(loja, carrosBean.getCarros(loja.getId())));
		}

		return new ResponseEntity<List<LojaComCarros>>(returnLojas, HttpStatus.OK);
	}

	@RequestMapping(value = "/lojas/{id}",method = RequestMethod.GET)
	public ResponseEntity<Loja> getLoja(@PathVariable String id) {
		
		Loja loja = lojaService.getById(id);
		
		return loja == null ? 
				new ResponseEntity<Loja>(HttpStatus.NOT_FOUND) : 
					new ResponseEntity<Loja>(loja, HttpStatus.OK);
	}
	
	@RequestMapping(value="/lojas", method = RequestMethod.POST)
	public ResponseEntity<String> createLoja(@RequestBody Loja loja) {

		try {
			lojaService.save(loja);
			return new ResponseEntity<String>(HttpStatus.CREATED);

		 } catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/lojas", method = RequestMethod.PUT)
	public ResponseEntity<String> updateLoja(@RequestBody Loja loja) {

		try {
			lojaService.save(loja);
			return new ResponseEntity<String>(HttpStatus.OK);

		 } catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/lojas/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteLoja(@PathVariable String id) {
		
		lojaService.deleteById(id);
		
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	public LojaService getLojaService() {
		return lojaService;
	}
}


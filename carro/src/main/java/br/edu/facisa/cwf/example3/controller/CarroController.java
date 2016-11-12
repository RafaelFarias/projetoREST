package br.edu.facisa.cwf.example3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.facisa.cwf.example3.domain.Carro;
import br.edu.facisa.cwf.example3.service.CarroService;

@RestController
public class CarroController {

	private final CarroService carroService;

	@Autowired
	public CarroController(final CarroService carroService) {
		this.carroService = carroService;
	}

	@RequestMapping(value="/carro", method = RequestMethod.GET)
	public ResponseEntity< List<Carro> > listAllCarros() {
		return new ResponseEntity< List<Carro> >
		(carroService.listAllCarros(), HttpStatus.OK);
	}

	@RequestMapping(value = "/carro/{id}",method = RequestMethod.GET)
	public ResponseEntity<Carro> getCarro(@PathVariable String id) {
		
		Carro carro = carroService.getById(id);
		
		return carro == null ? 
				new ResponseEntity<Carro>(HttpStatus.NOT_FOUND) : 
					new ResponseEntity<Carro>(carro, HttpStatus.OK);
	}
	
	@RequestMapping(value="/carro", method = RequestMethod.POST)
	public ResponseEntity<String> createCarro(@RequestBody Carro carro) {

		try {
			carroService.save(carro);
			return new ResponseEntity<String>(HttpStatus.CREATED);

		 } catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/carro", method = RequestMethod.PUT)
	public ResponseEntity<String> updateCarro(@RequestBody Carro carro) {

		try {
			carroService.save(carro);
			return new ResponseEntity<String>(HttpStatus.OK);

		 } catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/carro/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteCarro(@PathVariable String id) {
		
		carroService.deleteById(id);
		
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	public CarroService getCarroService() {
		return carroService;
	}
}

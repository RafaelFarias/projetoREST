package br.edu.facisa.cwf.example3;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarroController {

	@RequestMapping(value="/carro", method = RequestMethod.GET)
	public ResponseEntity< List<Carro> > listAllCarros() {
		
		//dados fake
		List<Carro> listaCarrosFake = new ArrayList<Carro>();
		listaCarrosFake.add(new Carro(1,"Fiat","Palio"));
		listaCarrosFake.add(new Carro(2,"Chevrolet","Onix"));
		listaCarrosFake.add(new Carro(3,"Nissan","Sentra"));
		
		return new ResponseEntity< List<Carro> >(listaCarrosFake, HttpStatus.OK);
	}

	@RequestMapping(value = "/carro/{id}",method = RequestMethod.GET)
	public ResponseEntity<Carro> getCarro(@PathVariable String id) {
		
		Carro carroFake = new Carro(1,"Fiat","Palio");
		
		return carroFake == null ? 
				new ResponseEntity<Carro>(HttpStatus.NOT_FOUND) : 
					new ResponseEntity<Carro>(carroFake, HttpStatus.OK);
	}
	
	@RequestMapping(value="/carro", method = RequestMethod.POST)
	public ResponseEntity<Carro> createCarro(@RequestBody Carro carro) {

		try {
			//salvar
			return new ResponseEntity<Carro>(carro, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<Carro>(carro, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/carro", method = RequestMethod.PUT)
	public ResponseEntity<Carro> updateCarro(@RequestBody Carro carro) {
		
		return new ResponseEntity<Carro>(carro, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/carro/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteCarro(@PathVariable String id) {
		
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}

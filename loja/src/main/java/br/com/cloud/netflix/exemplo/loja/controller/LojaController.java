package br.com.cloud.netflix.exemplo.loja.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cloud.netflix.exemplo.loja.domain.Loja;
import br.com.cloud.netflix.exemplo.loja.domain.LojaComCarros;
import br.com.cloud.netflix.exemplo.loja.hystrix.CarrosBean;

@RestController
public class LojaController {

	@Autowired
	private CarrosBean carrosBean;

	private static List<Loja> lojas = new ArrayList<Loja>();

	public LojaController() {
		lojas.add(new Loja("123", "Loja A"));
		lojas.add(new Loja("456", "Loja B"));
		lojas.add(new Loja("789", "Loja C"));
	}

	@RequestMapping("/")
	public List<Loja> getLojas() {
		return lojas;
	}

	@RequestMapping("/carros")
	public List<LojaComCarros> getLojasComCarros() {
		List<LojaComCarros> returnLojas = new ArrayList<LojaComCarros>();

		for (Loja loja : lojas) {
			returnLojas.add(new LojaComCarros(loja, carrosBean.getCarros(loja.getId())));
		}

		return returnLojas;
	}
}

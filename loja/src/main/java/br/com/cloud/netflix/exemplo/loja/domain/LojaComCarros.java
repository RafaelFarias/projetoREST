package br.com.cloud.netflix.exemplo.loja.domain;

import java.util.List;

public class LojaComCarros extends Loja {

	private List<Carro> carros;

	public LojaComCarros(Loja loja, List<Carro> carros) {
		super(loja.getId(), loja.getName());
		this.carros = carros;
	}

	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}
}

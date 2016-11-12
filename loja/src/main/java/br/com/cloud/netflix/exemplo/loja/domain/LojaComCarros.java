package br.com.cloud.netflix.exemplo.loja.domain;

import java.util.List;

public class LojaComCarros extends Loja {

	private List<Carro> clientes;

	public LojaComCarros(Loja loja, List<Carro> clientes) {
		super(loja.getId(), loja.getName());
		this.clientes = clientes;
	}

	public List<Carro> getClientes() {
		return clientes;
	}

	public void setClientes(List<Carro> clientes) {
		this.clientes = clientes;
	}
}

package br.com.cloud.netflix.exemplo.loja.domain;

import java.util.List;

public class Carro {

	private String marca;
	private String modelo;
	private List<String> lojas;

	public Carro() {

	}
	
	public Carro(String marca, String modelo, List<String> lojas) {
		this.marca = marca;
		this.modelo = modelo;
		this.lojas = lojas;
	}
	
	public List<String> getLojas() {
		return lojas;
	}

	public void setLojas(List<String> lojas) {
		this.lojas = lojas;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
}

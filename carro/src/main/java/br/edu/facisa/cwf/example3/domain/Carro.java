package br.edu.facisa.cwf.example3.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Carro implements Serializable {

	private static final long serialVersionUID = -7799369695818057571L;
	
	@Id
	private String id;
	private String marca;
	private String modelo;
	
	@Column
    @ElementCollection(targetClass=String.class)
	private List<String> lojas;
	
	public Carro() {
	}


	public Carro(String id, String marca, String modelo, List<String> lojas) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.lojas = lojas;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
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


	public List<String> getLojas() {
		return lojas;
	}


	public void setLojas(List<String> lojas) {
		this.lojas = lojas;
	}


	@Override
	public String toString() {
		return "Carro [id=" + id + ", marca=" + marca + ", modelo=" + modelo + "]";
	}

}

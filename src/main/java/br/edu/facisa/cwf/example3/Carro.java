package br.edu.facisa.cwf.example3;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Carro implements Serializable {

	private static final long serialVersionUID = -7799369695818057571L;
	
	@Id
	private int id;
	private String marca;
	private String modelo;
	
	public Carro() {
	}


	public Carro(int id, String marca, String modelo) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String name) {
		this.marca = name;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	@Override
	public String toString() {
		return "Carro [id=" + id + ", marca=" + marca + ", modelo=" + modelo + "]";
	}

}

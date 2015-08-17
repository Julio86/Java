package com.example.captamyp;

public class Articulos {
	

	private String articulos;
	private Long codart;
	private int bultos;
	private Long unidades;
	private String serie;
	private int numero;
	private String etiquetas;
	private int codvendedor;
	private long id;
	
	
	public int getId() {
		return (int) id;
	}
	public void setId(long l) {
		this.id = l;
	}
	public int getBultos() {
		return bultos;
	}
	public void setBultos(int bultos) {
		this.bultos = bultos;
	}
	public Long getUnidades() {
		return unidades;
	}
	public void setUnidades(Long unidades) {
		this.unidades = unidades;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getEtiquetas() {
		return etiquetas;
	}
	public void setEtiquetas(String etiquetas) {
		this.etiquetas = etiquetas;
	}
	public int getCodvendedor() {
		return codvendedor;
	}
	public void setCodvendedor(int codvendedor) {
		this.codvendedor = codvendedor;
	}
	public Long getCodart() {
		return codart;
	}
	public void setCodart(Long codart) {
		this.codart = codart;
	}
	
	public String getArticulos() {
		return articulos;
	}
	public void setArticulos(String articulos) {
		this.articulos = articulos;
	}
	

}

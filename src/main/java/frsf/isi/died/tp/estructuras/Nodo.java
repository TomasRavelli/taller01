package frsf.isi.died.tp.estructuras;

import java.util.List;

public class Nodo {
	
	private List <Nodo> nodosHijos;
	
	private String valor;
	public TipoNodo tipoNodo;
	
	
	public Nodo () {
		
	}
	
	public void setValor (String titulo) {
		this.valor = titulo;
	}
	
	public String getValor () {
		return valor;
	}
	
	public void setTipoNodo (TipoNodo valor) {
		this.tipoNodo = valor;
	}
	
	public List<Nodo> getHijos () {
		return nodosHijos;
	}
	
	public void addHijo(Nodo hijo) {
		nodosHijos.add(hijo);
	}
	
	

}

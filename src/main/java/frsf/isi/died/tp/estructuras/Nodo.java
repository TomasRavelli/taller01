package frsf.isi.died.tp.estructuras;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

public class Nodo extends DefaultMutableTreeNode {
	
	private String valor;
	public TipoNodo tipoNodo;
	private List <Nodo> nodosHijos;
	
	
	public Nodo (TipoNodo tn, String val) {
		super(tn + ": " + val);
		nodosHijos = new ArrayList<Nodo>();
		tipoNodo = tn;
		valor = val;
		
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
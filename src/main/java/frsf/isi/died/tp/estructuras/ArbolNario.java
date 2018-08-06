package frsf.isi.died.tp.estructuras;

import java.util.List;

public class ArbolNario {
	
	Nodo raiz;
	
	public ArbolNario () {
		raiz = new Nodo();
	}
	
	public void setValor (String titulo) {
		raiz.setValor (titulo);
	}
	
	public Nodo getValor () {
		return raiz;
	}
	
	public void setTipoNodo (TipoNodo valor) {
		this.raiz.setTipoNodo(valor);
	}

}

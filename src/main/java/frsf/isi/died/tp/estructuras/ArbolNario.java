package frsf.isi.died.tp.estructuras;

public class ArbolNario {
		
	Nodo raiz;
	
	public ArbolNario (String titulo, TipoNodo valor) {
		raiz = new Nodo(valor, titulo);
	}
	
	public Nodo getRaiz () {
		return raiz;
	}	
}

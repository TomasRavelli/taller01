/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frsf.isi.died.tp.estructuras;

/**
 *
 * @author mdominguez
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;

public class Grafo<T> {

	protected List<Arista<T>> aristas;
	protected List<Vertice<T>> vertices;

	/**
	 * 
	 */
	public Grafo(){
		this.aristas = new ArrayList<Arista<T>>();
		this.vertices = new ArrayList<Vertice<T>>();
	}

	/**
	 * @param nodo
	 */
	public void addNodo(T nodo){
		this.addNodo(new Vertice<T>(nodo));
	}
	/**
	 * @param nodo
	 */
	public void addNodo(Vertice<T> nodo){
		this.vertices.add(nodo);
	}
	
	public void deleteNodo(T nodo) {
		Vertice<T> x = new Vertice<>(nodo);
		vertices.remove(x);
		List<Arista<T>> aux= new ArrayList<>();
		for(Arista<T> a: aristas) {
			if(a.getInicio().equals(x) || a.getFin().equals(x)) {
				aux.add(a);
			}
		}
		aristas.removeAll(aux);
	}
	
	public void updateNodo(T viejo, T nuevo) {
		Vertice<T> v = new Vertice<>(viejo);
		Vertice<T> n = new Vertice<>(nuevo);
		vertices.remove(v);
		vertices.add(n);
	}
	
	/**
	 * @param n1
	 * @param n2
	 */
	public void conectar(T n1,T n2){
		this.conectar(getNodo(n1), getNodo(n2), 0.0);
	}

        /**
	 * @param nodo1
	 * @param nodo2
	 */
	public Arista<T> conectar(Vertice<T> nodo1,Vertice<T> nodo2){
            Arista<T> arista = new Arista<T>(nodo1,nodo2,0.0);
            this.aristas.add(arista);
            return arista;
	}
    public List<Arista<T>> getAristas(){
    	return this.aristas;
    }    
	/**
	 * @param n1
	 * @param n2
	 * @param valor
	 */
	public void conectar(T n1,T n2,Number valor){
		this.conectar(getNodo(n1), getNodo(n2), valor);
	}

	/**
	 * @param nodo1
	 * @param nodo2
	 * @param valor
	 */
	public void conectar(Vertice<T> nodo1,Vertice<T> nodo2,Number valor){
		this.aristas.add(new Arista<T>(nodo1,nodo2,valor));
	}
	
	/**
	 * @param valor
	 * @return
	 */
	public Vertice<T> getNodo(T valor){
		return this.vertices.get(this.vertices.indexOf(new Vertice<T>(valor)));
	}

	/**
	 * @param valor
	 * @return
	 */
	public List<T> getAdyacentes(T valor){ 
		Vertice<T> unNodo = this.getNodo(valor);
		List<T> salida = new ArrayList<T>();
		for(Arista<T> enlace : this.aristas){
			if( enlace.getInicio().equals(unNodo)){
				salida.add(enlace.getFin().getValor());
			}
		}
		return salida;
	}
	

	/**
	 * @param unNodo
	 * @return
	 */
	protected List<Vertice<T>> getAdyacentes(Vertice<T> unNodo){ 
		List<Vertice<T>> salida = new ArrayList<Vertice<T>>();
		for(Arista<T> enlace : this.aristas){
			if( enlace.getInicio().equals(unNodo)){
				salida.add(enlace.getFin());
			}
		}
		return salida;
	}
                
	/**
	 * 
	 */
	public void imprimirAristas(){
		System.out.println(this.aristas.toString());
	}


        
	/**
	 * @param v1
	 * @param v2
	 * @return
	 */
	protected boolean esAdyacente(Vertice<T> v1,Vertice<T> v2){
            List<Vertice<T>> ady = this.getAdyacentes(v1);
            for(Vertice<T> unAdy : ady){
                if(unAdy.equals(v2)) return true;
            }
            return false;
    }
        
    public Boolean esVacio(){
    	if(this.vertices!= null && !this.vertices.isEmpty()) return false;
    	return true;
    }
    
    public List<T> listaVertices(){
    	List<T> lista = new ArrayList<>();
    	this.vertices.forEach(v -> lista.add(v.getValor()));
    	return lista;
    }

		/**
	 * @param vertice
	 * @return
	 */
	public Integer gradoEntrada(T v){
		Vertice<T> vertice = this.getNodo(v);
		Integer res =0;
		//TODO
		for(int i=0;i<this.aristas.size();i++) {
			if(this.aristas.get(i).getFin().equals(vertice)) {
				res++;
			}
		}
		return res;
	}

	/**
	 * @param vertice
	 * @return
	 */
	public Integer gradoSalida(T v){
		Vertice<T> vertice = this.getNodo(v);
		Integer res =0;
		//TODO
		res=this.getAdyacentes(v).size();
		return res;
	}

    public T primerVerticeGradoK(T v,Integer gradoK) {
    	HashSet<Vertice> visitados= new HashSet<>();
    	HashSet<Vertice> enTratamiento= new HashSet<>();
    	//TODO
    	Vertice<T> vertice = this.getNodo(v);
    	enTratamiento.addAll(this.getAdyacentes(vertice));
    	visitados.add(vertice);
    	return primerVerticeGradoK(gradoK, visitados,enTratamiento);
    			
    }
    
    private T primerVerticeGradoK(Integer gradoK, HashSet<Vertice> visitados, HashSet<Vertice> enTratamiento) {
    	HashSet<Vertice> aux= new HashSet<>();
    	for(Vertice<T> vertice : enTratamiento) {
    		if(!visitados.contains(vertice) && this.gradoSalida(vertice.getValor())==gradoK) {
    			return vertice.getValor();
    		}
    		visitados.add(vertice);
    		aux.addAll(this.getAdyacentes(vertice));
    	}
    	
    	return primerVerticeGradoK(gradoK, visitados, aux);
    }

    
    public boolean existeCamino(T v) {
		Vertice<T> vertice = this.getNodo(v);
    	return true;
    }
    
    
    /**
     * @param n1
     * @param n2
     * @param valor
     */
    public List<T> buscarCaminoNSaltos(T n1,T n2,Integer saltos){
		Vertice<T> origen = this.getNodo(n1);
		Vertice<T> destino= this.getNodo(n2);
		System.out.println(this.buscarCaminoNSaltos(origen, destino, saltos, new HashSet<Vertice>()).toString());
        return this.buscarCaminoNSaltos(origen, destino, saltos, new HashSet<Vertice>());
         
    }
    
    private List<T> buscarCaminoNSaltos(Vertice<T> n1,Vertice<T> n2,Integer saltos,HashSet<Vertice> visitados){
        ArrayList<T> resultado = new ArrayList<>();
        ArrayList<T> auxiliar = new ArrayList<>();
       //TODO
        visitados.add(n1);
        if(saltos!=0) {
        	for(int i=0;i<this.getAdyacentes(n1.getValor()).size();i++) {
            	if(!visitados.contains(this.getAdyacentes(n1.getValor()).get(i))) {
	        		auxiliar.addAll(buscarCaminoNSaltos(this.getNodo(this.getAdyacentes(n1.getValor()).get(i)), n2, saltos-1, visitados));
	            	if(auxiliar.size()!=0) {
	            		auxiliar.add(0, n1.getValor());
	            		return auxiliar;
	            	}
            	}
            }
        }else {
        	if(n1.getValor()==n2.getValor()) {
        		resultado.add(n2.getValor());
        	}
        }
        return resultado;
    }
    
    public List<T> buscarCamino(T n1,T n2){
		Vertice<T> origen = this.getNodo(n1);
		Vertice<T> destino= this.getNodo(n2);
        return this.buscarCamino(origen, destino);
    }
    private List<T> buscarCamino(Vertice<T> n1,Vertice<T> n2){
      List<T> resultado = new ArrayList<>();
      for(int i=1;i<this.vertices.size();i++) {
    	 resultado = buscarCaminoNSaltos(n1, n2, i, new HashSet<Vertice>());
    	 if(!resultado.isEmpty()) {
    		 System.out.println(resultado.toString());
    		 return resultado;
    	 }
      }
      return new ArrayList<T>();
    }
   

    public void actualizarPR() {
    	for(Vertice<T> m: this.vertices) {
    		((MaterialCapacitacion)m.getValor()).setPR(1.0);;
    	}
    }
}
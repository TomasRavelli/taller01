/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frsf.isi.died.tp.modelo.productos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import frsf.isi.died.tp.estructuras.ArbolNario;
import frsf.isi.died.tp.estructuras.TipoNodo;
import frsf.isi.died.tp.modelo.Biblioteca;
import frsf.isi.died.tp.util.Ordenable;

/**
 * Representa de manera abstracta los materiales de capacitación
 * 
 * @author mdominguez
 * @author Perussini, Martin
 * @author Ravelli, Tomas
 * https://github.com/TomasRavelli/taller01.git
 */
public abstract class MaterialCapacitacion implements Ordenable, Comparable<MaterialCapacitacion>{
	protected Integer id;
	
	protected String titulo;

	protected Integer votantes;
	
	protected Double costo;
	
	protected Double calificacion;
	
	protected Date fecha_publicacion;
	
	protected Relevancia relevancia; 
	
	protected String tema;
	
	protected Double pageRank;
	
	protected ArbolNario arbol;
	
	
	public MaterialCapacitacion() {
		this(0,"en desarrollo",0.0);
		this.pageRank = 1.0;
		arbol = new ArbolNario();
		this.arbol.setValor (this.titulo);
		this.arbol.setTipoNodo(TipoNodo.TITULO);
	}
	

	public MaterialCapacitacion(Integer id, String titulo) {
		this(id,titulo,0.0);
		this.pageRank = 1.0;
		arbol = new ArbolNario();
		this.arbol.setValor (this.titulo);
		this.arbol.setTipoNodo(TipoNodo.TITULO);
	}

	
	public MaterialCapacitacion(Integer id,String titulo, Double costo) {
		this.id =id;
		this.titulo = titulo;
		this.costo = costo;
		this.pageRank = 1.0;
		arbol = new ArbolNario();
		this.arbol.setValor (this.titulo);
		this.arbol.setTipoNodo(TipoNodo.TITULO);

	}
	
	public MaterialCapacitacion(Integer id,String titulo, Double costo, Relevancia r,String tema2) {
		this.id =id;
		this.titulo = titulo;
		this.costo = costo;
		this.tema = tema2;
		this.relevancia = r;
		this.pageRank = 1.0;
		arbol = new ArbolNario();
		this.arbol.setValor (this.titulo);
		this.arbol.setTipoNodo(TipoNodo.TITULO);
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTema() {
		return tema;
	}

	public void setTema(String tema2) {
		this.tema = tema2;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}
	
	public void setRelevancia (Relevancia r) {
		this.relevancia = r;
	}
	

	public Relevancia getRelevancia () {
		return relevancia;
	}
	
	public void setPR (Double r) {
		this.pageRank = r;
	}
	
	public Double getPR() {
		return this.pageRank;
	}
	
	public void setCalificacion (Double c) {
		this.calificacion = c;
	}
	

	public	Double getCalificacion () {
		return calificacion;
	}
	
	
	public void setFechaPublicacion (Date date) {
		this.fecha_publicacion = date;
	}
	
	
	public Date getFechaPublicacion () {
		return fecha_publicacion;
	}
	
	
	public abstract Double precio();
	
	
	public abstract Boolean esLibro();

	
	public abstract Boolean esVideo();
	
	
	public ArbolNario getArbol () {
		return arbol;
	}


	
	//TODO 02: sobrescribir el metodo toString de la clase "Object"
	//	el método toString retorna un string que representa el material actual
	//  retornando el titulo, y el precio 	 * usando el formato : 
	// [Titulo: <titulo> ; Precio: <precio> ]
	public String toString() {
		String s=new String();
		s="[Titulo: "+this.getTitulo()+"; Precio: "+this.precio()+"]";
		return s;
	}
	
	// TODO 10: implementar Ordenable
	public final int valor() {
		return this.precio().intValue();
		//funciona porque el metodo es abstracto en esta clase, la cual es abstracta,
		//pero esta implementado en las clases hijas
	}
	
	

	/*@Override
	public boolean equals(Object obj) {
		//if (this == obj)
			//return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MaterialCapacitacion other = (MaterialCapacitacion) obj;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!(titulo.toLowerCase()).equals(other.titulo.toLowerCase()))
			return false;
		return true;
	}*/
	
	@Override
	public int compareTo(MaterialCapacitacion mat) {
		if(this.equals(mat)) {
			return (int) (this.precio()-mat.precio());
		}else {
			return titulo.compareTo(mat.titulo);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MaterialCapacitacion other = (MaterialCapacitacion) obj;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
	public abstract List<String> asCsvRow();
	public abstract void loadFromStringRow(List<String> datos);	
}
/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frsf.isi.died.tp.modelo.productos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import frsf.isi.died.tp.estructuras.ArbolNario;
import frsf.isi.died.tp.estructuras.TipoNodo;

/**
 * Representa un libro en el sistema de biblioteca digital
 * @author mdominguez
 */
public class Libro extends MaterialCapacitacion {
	
	private Double precioCompra;
	private Integer paginas;
	
	public Libro() {
	}

	
	public Libro(Integer id, String titulo) {
		this(id, titulo,0.0,0.0,0);
	}

	
	public Libro(Integer id, String titulo, Double costo, Double precioCompra, Integer paginas) {
		super(id, titulo, costo);
		this.precioCompra = precioCompra;
		this.paginas = paginas;
	}
	
	
	public Libro(Integer id, String titulo, Double costo, Double precioCompra, Integer paginas,Relevancia r, Date date, String tema2) {
		super(id, titulo, costo, r,tema2);
		this.precioCompra = precioCompra;
		this.paginas = paginas;
		this.calificacion = 0.0;
		this.votantes = 0;
		this.fecha_publicacion = date;
		this.tema = tema2;
	}

	
	public Double getPrecioCompra() {
		return precioCompra;
	}
	
	
	public void setPrecioCompra(Double precioCompra) {
		this.precioCompra = precioCompra;
	}


	public Integer getPaginas() {
		return paginas;
	}

	
	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}

	
	@Override
	public Boolean esLibro() {
		return true;
	}

	@Override
	public Boolean esVideo() {
		return false;
	}

	/**
	 * El precio de un libro se calcula segun la siguiente formula
	 * PRECIO = costo + (precio de compra * FACTOR_PAGINAS)
	 * FACTOR_PAGINAS es un 3% cada 150 paginas.
	 * 
	 * Por ejemplo, para un libro cuyo costo de publicacion es de $50 y cuyo precio de compra
	 * es de $100 si tiene 460 paginas se calculará su precio final como
	 * 
	 * PRECIO = 50.0 + (100.0 * (1.0+ (0.03 * 460/150))); 
	 * PRECIO = 50.0 + (100.0 * (1.0 + 0.09)) = 50.0 + 109.0 = 159.0
	 */
	@Override
	public Double precio() {
		return (this.costo+(this.precioCompra*(1.0+(0.03*this.paginas.doubleValue()/150.0))));
	}
	
	public static void main (String [] args) {
		Libro L1=new Libro();
		System.out.println("L1: "+L1.esLibro());
	}

	
	@Override
	public List<String> asCsvRow() {
		List<String> lista = new ArrayList<String>();
		lista.add(this.id+"");
		lista.add("\""+this.titulo.toString()+"\"");
		lista.add(this.costo.toString());
		lista.add(this.paginas.toString());
		lista.add(this.precioCompra.toString());
		lista.add(this.calificacion.toString());
		lista.add(this.relevancia.toString());
		lista.add((new SimpleDateFormat("dd/MM/yyyy")).format(this.fecha_publicacion));
		lista.add(this.tema.toString());
		return lista;
	}

	
	@Override
	public void loadFromStringRow(List<String> datos) {
		this.id =Integer.valueOf(datos.get(0));
		this.titulo = datos.get(1).substring(1, datos.get(1).length()-1);
		this.costo =Double.valueOf(datos.get(2));
		this.paginas =Integer.valueOf(datos.get(3));
		this.precioCompra =Double.valueOf(datos.get(4));
		this.calificacion = Double.valueOf(datos.get(5));
		this.relevancia = Relevancia.valueOf(datos.get(6));
		this.tema = String.valueOf(datos.get(8));
		
		this.arbol=new ArbolNario(this.titulo, TipoNodo.TITULO);
		
	    Date fechaDate = new Date();
	    try {
	         fechaDate = (new SimpleDateFormat("dd/MM/yyy")).parse(datos.get(7));
	    } 
	    catch (ParseException ex) 
	    {
	       System.out.println(ex);
	    }
	    fecha_publicacion = fechaDate;
	}
}
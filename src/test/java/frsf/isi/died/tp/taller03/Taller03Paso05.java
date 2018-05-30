package frsf.isi.died.tp.taller03;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import frsf.isi.died.tp.estructuras.Arbol;
import frsf.isi.died.tp.estructuras.ArbolBinarioBusqueda;
//import frsf.isi.died.tp.modelo.biblioteca;
//import frsf.isi.died.tp.modelo.bibliotecaABB;
import frsf.isi.died.tp.modelo.productos.Libro;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;
import frsf.isi.died.tp.modelo.productos.Video;

public class Taller03Paso05 {
	private ArbolBinarioBusqueda arbol1;
	private Libro l1;
	private Libro l2;
	private Libro l3;
	private Libro l4;
	private Libro l5;
	private Libro l6;
	private Video v1;
	private Video v2;
	private Video v3;
	private Video v4;
	private Video v5;
	
	@Before
	public void init() {
		
		arbol1 = new ArbolBinarioBusqueda((mc1,mc2)-> mc1.precio().intValue()- mc2.precio().intValue());	
		//this.costo+(this.precioCompra*(1.0+(0.03*this.paginas.doubleValue()/150.0))) precio libro
		//public Libro(Integer id, String titulo, Double costo, Double precioCompra, Integer paginas) constructor de libro
		l1= new Libro(1, "Libro1", 10.0, 20.0, 154);//30.616
		l2= new Libro(2, "Libro2", 20.0, 24.0, 361);//
		l3= new Libro(3, "Libro3", 15.0, 18.0, 108);//33.3888
		l4= new Libro(4, "Libro4", 30.0, 16.0, 250);
		l5= new Libro(5, "Libro5", 24.0, 32.0, 545);
		l6= new Libro(6, "Libro6", 28.0, 54.0, 302);
		v1= new Video(7, "Video7", 28.0, 360);
		v2= new Video(8, "Video8", 15.0, 625);
		v3= new Video(9, "Video9", 30.0, 145);
		v4= new Video(10, "Video10", 45.0, 38);
		v5= new Video(11, "Video11", 12.0, 60);
		arbol1.add(l1);
		arbol1.add(l2);
		arbol1.add(l3);
		arbol1.add(l4);
		arbol1.add(l5);
		arbol1.add(l6);
		arbol1.add(v1);
		arbol1.add(v2);
		arbol1.add(v3);
		arbol1.add(v4);
		arbol1.add(v5);
		
	}
	
	@Test
	public void test1() {
		double min=0.0;
		double max=100.0;
		List<MaterialCapacitacion> lista1 = new ArrayList<>();
		lista1=arbol1.rango(min, max);
		List<MaterialCapacitacion> lista2 = new ArrayList<>();
		lista2=arbol1.inOrden();
		List<MaterialCapacitacion> lista3 = new ArrayList<>();
		for(int i =0;i<lista2.size();i++) {
			if(lista2.get(i).precio()>min && lista2.get(i).precio()<max) {
				lista3.add(lista2.get(i));
			}
		}
		assertTrue(lista3.containsAll(lista1) && lista1.size()==lista3.size());
	}
	@Test
	public void test2() {
		double min=100.0;
		double max=200.0;
		List<MaterialCapacitacion> lista1 = new ArrayList<>();
		lista1=arbol1.rango(min, max);
		List<MaterialCapacitacion> lista2 = new ArrayList<>();
		lista2=arbol1.inOrden();
		List<MaterialCapacitacion> lista3 = new ArrayList<>();
		for(int i =0;i<lista2.size();i++) {
			if(lista2.get(i).precio()>min && lista2.get(i).precio()<max) {
				lista3.add(lista2.get(i));
			}
		}
		assertTrue(lista3.containsAll(lista1) && lista1.size()==lista3.size());
	}
	@Test
	public void test3() {
		double min=0.0;
		double max=0.0;
		List<MaterialCapacitacion> lista1 = new ArrayList<>();
		lista1=arbol1.rango(min, max);
		List<MaterialCapacitacion> lista2 = new ArrayList<>();
		lista2=arbol1.inOrden();
		List<MaterialCapacitacion> lista3 = new ArrayList<>();
		for(int i =0;i<lista2.size();i++) {
			if(lista2.get(i).precio()>min && lista2.get(i).precio()<max) {
				lista3.add(lista2.get(i));
			}
		}
		assertTrue(lista3.containsAll(lista1) && lista1.size()==lista3.size());
	}
	@Test
	public void test4() {
		double min=1000.0;
		double max=100.0;
		List<MaterialCapacitacion> lista1 = new ArrayList<>();
		lista1=arbol1.rango(min, max);
		List<MaterialCapacitacion> lista2 = new ArrayList<>();
		lista2=arbol1.inOrden();
		List<MaterialCapacitacion> lista3 = new ArrayList<>();
		for(int i =0;i<lista2.size();i++) {
			if(lista2.get(i).precio()>min && lista2.get(i).precio()<max) {
				lista3.add(lista2.get(i));
			}
		}
		assertTrue(lista3.containsAll(lista1) && lista1.size()==lista3.size());
	}
	@Test
	public void test5() {
		double min=100.0;
		double max=1000.0;
		List<MaterialCapacitacion> lista1 = new ArrayList<>();
		lista1=arbol1.rango(min, max);
		List<MaterialCapacitacion> lista2 = new ArrayList<>();
		lista2=arbol1.inOrden();
		List<MaterialCapacitacion> lista3 = new ArrayList<>();
		for(int i =0;i<lista2.size();i++) {
			if(lista2.get(i).precio()>min && lista2.get(i).precio()<max) {
				lista3.add(lista2.get(i));
			}
		}
		lista3.add(l1); 
		assertFalse(lista3.containsAll(lista1) && lista1.size()==lista3.size());
	}
}

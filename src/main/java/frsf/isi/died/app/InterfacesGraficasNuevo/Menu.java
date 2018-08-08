package frsf.isi.died.app.InterfacesGraficasNuevo;

import java.util.PriorityQueue;
import  javax.swing.*;
import frsf.isi.died.app.dao.MaterialCapacitacionDaoDefault;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;

public class Menu extends JFrame{
	
	private MaterialCapacitacionDaoDefault materiales = new MaterialCapacitacionDaoDefault();
	private PriorityQueue<MaterialCapacitacion> wishlist = new PriorityQueue<>((m1,m2)->comparar(m1,m2));
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Menu();
			}
		}); 
	}
	
	
	public Menu() {
		this.setTitle("Aplicacion");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setSize(800,600);
		this.setVisible(true);
		this.setContentPane(new Inicio(this));
		this.pack();
	}
	
	
	public MaterialCapacitacionDaoDefault getMateriales(){
		return materiales;
	}
	
	
	public void RecargarMateriales() {
		this.materiales = new MaterialCapacitacionDaoDefault();
	}
	
	
	public PriorityQueue<MaterialCapacitacion> getWishlist(){
		return wishlist;
	}
	
	
	private int comparar(MaterialCapacitacion m1, MaterialCapacitacion m2) {
		if(m1.getRelevancia().compareTo(m2.getRelevancia()) != 0) {
			return m1.getRelevancia().compareTo(m2.getRelevancia());}
		else {
			if(m1.getCalificacion().compareTo(m2.getCalificacion()) != 0) {	
				return m1.getCalificacion().compareTo(m2.getCalificacion());}
			else {
				return m1.precio().compareTo(m2.precio());
			} 
		}
	}	
}
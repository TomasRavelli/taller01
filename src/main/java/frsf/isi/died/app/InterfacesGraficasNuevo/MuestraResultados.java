package frsf.isi.died.app.InterfacesGraficasNuevo;

import java.awt.Dimension;
import java.awt.GridBagConstraints;

import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import frsf.isi.died.app.dao.MaterialCapacitacionDaoDefault;
import frsf.isi.died.tp.modelo.productos.Libro;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;
import frsf.isi.died.tp.modelo.productos.Video;
import frsf.isi.died.app.dao.*;

public class MuestraResultados extends JPanel{
	
	public MuestraResultados() {
		
	}
	public MuestraResultados (Menu ventana, List<MaterialCapacitacion> encontrados){
	
		this.setPreferredSize(new Dimension(800,600));
		this.setVisible(true);
		this.setLayout(null);
		
	
		String[] columnasLibro = {"Titulo","Costo","Precio","Paginas","Calificacion","Relevancia","ID","Fecha Publicacion"};
		DefaultTableModel modeloTablaLibro = new DefaultTableModel(null,columnasLibro);
		JTable tablaLibro = new JTable(modeloTablaLibro);
		JScrollPane scrollTablaLibro = new JScrollPane(tablaLibro);	
		scrollTablaLibro.setBounds(20, 20, 750, 235);
		this.add(scrollTablaLibro);
				

		String[] columnasVideo = {"Titulo","Duracion","Costo","Calificacion","Relevancia","ID","Fecha Publicacion"};		
		DefaultTableModel modeloTablaVideo = new DefaultTableModel(null,columnasVideo);
		JTable tablaVideo = new JTable(modeloTablaVideo);
		JScrollPane scrollTablaVideo = new JScrollPane(tablaVideo);	
		scrollTablaVideo.setBounds(20, 255, 750, 245);
		this.add(scrollTablaVideo);
		
		JButton atras = new JButton("Atras");
		atras.setBounds(650, 505, 120, 50);
		this.add(atras);
		
		JButton agregarWish = new JButton("Agregar a Wishlist");
		agregarWish.setBounds(450, 505, 150, 50);
		this.add(agregarWish);
		
		atras.addActionListener(e->volverAtras(ventana));
		
		for(MaterialCapacitacion m: encontrados) {
			
			if(m.esLibro()) {
				agregarLibroATabla(modeloTablaLibro,(Libro) m);				
			}
			else {
				agregarVideoATabla(modeloTablaVideo,(Video) m);	
			}
		}		
				
		agregarWish.addActionListener(e->agregarAWish(ventana,(Vector)modeloTablaLibro.getDataVector(), (Vector)modeloTablaVideo.getDataVector(), tablaLibro.getSelectedRow(), tablaVideo.getSelectedRow()));
	
	}
	
	
	

	private void agregarAWish(Menu ventana, Vector libro, Vector video, int filaLibro, int filaVideo) {

		if(filaLibro!=-1 && filaVideo!=-1) {
		agregarAWish(ventana, (Vector) libro.get(filaLibro), (Vector) video.get(filaVideo));
		} else {
			if (filaLibro != -1 && filaVideo == -1) {
				agregarAWish(ventana, (Vector) libro.get(filaLibro), new Vector());		
			}
			else {
				if(filaVideo != -1 && filaLibro == -1) {
				agregarAWish(ventana,new Vector(), (Vector) video.get(filaVideo));
				}
			}
		}
	}
		
		
		
	private void agregarAWish(Menu ventana, Vector<Object> libro, Vector<Object> video) {	
		if(!libro.isEmpty()) {
		for(Libro m: ventana.getMateriales().listaLibros()) {
				if(m.getId() == libro.get(6)){
				if(!ventana.getWishlist().contains(m)) {
				ventana.getWishlist().add(m);
				}
			}
		}	
	}	
		if(!video.isEmpty()) {
			for(Video v2: ventana.getMateriales().listaVideos()) {
				if(v2.getId() == video.get(5)){
					if(!ventana.getWishlist().contains(v2)) {
						ventana.getWishlist().add(v2);
					}
				}	
			}			
		}
		
	}
	
	public void agregarLibroATabla(DefaultTableModel modelo, Libro libro) {
		Object[] obj = {libro.getTitulo(),libro.getCosto(),libro.precio(),libro.getPaginas(),libro.getCalificacion(),libro.getRelevancia(),libro.getId(),libro.getFechaPublicacion()};
		modelo.addRow(obj);
	}
	
	
	public void agregarVideoATabla(DefaultTableModel modelo, Video video) {
		Object[] obj = {video.getTitulo(),video.getDuracion(),video.getCosto(),video.getCalificacion(),video.getRelevancia(),video.getId(),video.getFechaPublicacion()};
		modelo.addRow(obj);
	}
	public void volverAtras(Menu ventana) {
		ventana.setContentPane(new BuscarMaterial(ventana));
		ventana.pack();
	}
	
}
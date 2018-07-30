package frsf.isi.died.app.interfacesGraficas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import frsf.isi.died.tp.modelo.productos.Libro;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;
import frsf.isi.died.tp.modelo.productos.Video;

public class MuestraResultados extends JFrame{
	List<List<String>> libros;
	List<List<String>> videos;
	
	public static void main(String[] args) {
	javax.swing.SwingUtilities.invokeLater(new Runnable() {
		public void run() {
			MuestraResultados prueba  = new MuestraResultados(new ArrayList<>());
			}
		});

	}
	
	public MuestraResultados() {
		
	}
	public MuestraResultados(List<MaterialCapacitacion> materiales){
		
		this.setTitle("Resultados de busqueda");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.pack();
		this.setSize(800,600);
		this.setVisible(true);
		JPanel panel = new JPanel();
		this.setContentPane(panel);
		panel.setLayout(null);
		

	
		String[] columnasLibro = {"Titulo","Costo","Precio","Paginas","Calificacion","Relevancia","ID","Fecha Publicacion"};
		DefaultTableModel modeloTablaLibro = new DefaultTableModel(null,columnasLibro);
		JTable tablaLibro = new JTable(modeloTablaLibro);
		JScrollPane scrollTablaLibro = new JScrollPane(tablaLibro);	
		scrollTablaLibro.setBounds(20, 20, 750, 235);
		panel.add(scrollTablaLibro);
				

		String[] columnasVideo = {"Titulo","Duracion","Costo","Calificacion","Relevancia","ID","Fecha Publicacion"};		
		DefaultTableModel modeloTablaVideo = new DefaultTableModel(null,columnasVideo);
		JTable tablaVideo = new JTable(modeloTablaVideo);
		JScrollPane scrollTablaVideo = new JScrollPane(tablaVideo);	
		scrollTablaVideo.setBounds(20, 255, 750, 245);
		panel.add(scrollTablaVideo);
		
		JButton atras = new JButton("Atras");
		atras.setBounds(650, 505, 120, 50);
		panel.add(atras);
		
		atras.addActionListener(e->volverAtras());
		
		for(MaterialCapacitacion m: materiales) {
			
			if(m.esLibro()) {
				agregarLibroATabla(modeloTablaLibro,(Libro) m);				
			}
			else {
				agregarVideoATabla(modeloTablaVideo,(Video) m);	
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
	public void volverAtras() {
		BuscarMaterial m = new BuscarMaterial();
		this.dispose();
	}
}
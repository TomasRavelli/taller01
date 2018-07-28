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
	public MuestraResultados(List<List<String>> materiales){
		
		libros = new ArrayList<>();
		videos = new ArrayList<>();
		clasificarMateriales(libros,videos,materiales);
		this.setTitle("Resultados de busqueda");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.pack();
		this.setSize(800,600);
		this.setVisible(true);
		JPanel panel = new JPanel();
		this.setContentPane(panel);
		panel.setLayout(null);
		

	
		String[] columnasLibro = {"Titulo","Costo","Precio Compra","Paginas","Calificacion","Relevancia","ID"};
		DefaultTableModel modeloTablaLibro = new DefaultTableModel(null,columnasLibro);
		JTable tablaLibro = new JTable(modeloTablaLibro);
		JScrollPane scrollTablaLibro = new JScrollPane(tablaLibro);	
		scrollTablaLibro.setBounds(20, 20, 750, 235);
		panel.add(scrollTablaLibro);
				

		String[] columnasVideo = {"Titulo","Duracion","Costo por Seg","Costo","Relevancia","ID"};		
		DefaultTableModel modeloTablaVideo = new DefaultTableModel(null,columnasVideo);
		JTable tablaVideo = new JTable(modeloTablaVideo);
		JScrollPane scrollTablaVideo = new JScrollPane(tablaVideo);	
		scrollTablaVideo.setBounds(20, 255, 750, 245);
		panel.add(scrollTablaVideo);
		
		JButton atras = new JButton("Atras");
		atras.setBounds(650, 505, 120, 50);
		panel.add(atras);
		
		atras.addActionListener(e->volverAtras());
		
		agregarLibrosATabla(modeloTablaLibro,libros);
		agregarVideosATabla(modeloTablaVideo, videos);

	}
	
	public void clasificarMateriales(List<List<String>> libros,List<List<String>> videos,List<List<String>> materiales){
		
		for(int i=0; i < materiales.size();i++) {
			if(materiales.get(i).get(0).equals("0")) {
				videos.add(materiales.get(i));
			}
			else{
				libros.add(materiales.get(i));
			}
		}
		
	}
	
	
	public void agregarLibroATabla(DefaultTableModel modelo, Libro libro) {
		Object[] obj = {libro.getTitulo(),libro.getCosto(),libro.getPrecioCompra(),libro.getPaginas(),libro.getCalificacion(),libro.getRelevancia(),libro.getId()};
		modelo.addRow(obj);
	}
	
	public void agregarLibrosATabla(DefaultTableModel modelo, List<List<String>> libros) {
		
		for(int i = 0; i<libros.size();i++) {
			Libro l = new Libro();
			l.loadFromStringRow(libros.get(i));
			agregarLibroATabla(modelo, l);
	
		}
		
	}
	
	public void agregarVideoATabla(DefaultTableModel modelo, Video video) {
		Object[] obj = {video.getTitulo(),video.getDuracion(),video.getCostoxSeg(),video.getCosto(),video.getRelevancia(),video.getId()};
		modelo.addRow(obj);
	}

	public void agregarVideosATabla(DefaultTableModel modelo, List<List<String>> videos) {
		
		for(int i = 0; i<videos.size();i++) {
			Video video = new Video();
			video.loadFromStringRow(videos.get(i));
			agregarVideoATabla(modelo, video);

		}
		
	}
	public void volverAtras() {
		BuscarMaterial m = new BuscarMaterial();
		this.dispose();
	}
}
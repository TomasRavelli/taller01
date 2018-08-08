package frsf.isi.died.app.InterfacesGraficasNuevo;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import frsf.isi.died.tp.modelo.productos.Libro;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;
import frsf.isi.died.tp.modelo.productos.Video;

public class MuestraWish extends JPanel {
	
	public MuestraWish() {
		
	}
	
	public MuestraWish(Menu ventana){
		
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
		
		
		atras.addActionListener(e->volverAtras(ventana));
		
		for(MaterialCapacitacion m: ventana.getWishlist()) {
			if(m.esLibro()) {
				agregarLibroATabla(modeloTablaLibro,(Libro) m);				
			}
			else {
				agregarVideoATabla(modeloTablaVideo,(Video) m);	
			}
		}
	}
	
	
	public void volverAtras(Menu ventana) {
		ventana.setContentPane(new BuscarMaterial(ventana));
		ventana.pack();
	}
	
	public void agregarLibroATabla(DefaultTableModel modelo, Libro libro) {
		Object[] obj = {libro.getTitulo(),libro.getCosto(),libro.precio(),libro.getPaginas(),libro.getCalificacion(),libro.getRelevancia(),libro.getId(),libro.getFechaPublicacion()};
		modelo.addRow(obj);
	}
	
	public void agregarVideoATabla(DefaultTableModel modelo, Video video) {
		Object[] obj = {video.getTitulo(),video.getDuracion(),video.getCosto(),video.getCalificacion(),video.getRelevancia(),video.getId(),video.getFechaPublicacion()};
		modelo.addRow(obj);
	}	
}
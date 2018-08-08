package frsf.isi.died.app.InterfacesGraficasNuevo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Inicio extends JPanel {
	
	public Inicio (Menu menu) {
		
		this.setPreferredSize(new Dimension(800,600));
		this.setVisible(true);
		this.setLayout(new GridLayout(0,2));
		
		menu.RecargarMateriales();
		
		JButton crearLibro = new JButton ("Crear Libro");
		this.add(crearLibro);
		JButton crearVideo = new JButton ("Crear Video");
		this.add(crearVideo);
		JButton actualizarLibro = new JButton ("Actualizar Libro");
		this.add(actualizarLibro);
		JButton actualizarVideo = new JButton ("Actualizar Video");
		this.add(actualizarVideo);
		JButton borrarLibro = new JButton ("Borrar Libro");
		this.add(borrarLibro);
		JButton borrarVideo = new JButton ("Borrar Video");
		this.add(borrarVideo);
		JButton buscarMaterial = new JButton ("Buscar Material Capacitacion");
		this.add(buscarMaterial);
		JButton salir = new JButton ("Salir");
		salir.setForeground(Color.RED);
		this.add(salir);
		
		
		buscarMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				menu.setContentPane(new  BuscarMaterial(menu));
				menu.pack();
			}
		});
		
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		crearLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				menu.setContentPane(new CrearLibro(menu));
				menu.pack();
			}
		});
		
		crearVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				menu.setContentPane(new CrearVideo(menu));
				menu.pack();
			}
		});
		
		actualizarLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				menu.setContentPane(new ActualizarLibro(menu));
				menu.pack();
			}
		});
		
		actualizarVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				menu.setContentPane(new ActualizarVideo(menu));
				menu.pack();
			}
		});
		
		borrarLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				menu.setContentPane(new BorrarLibro(menu));
				menu.pack();
			}
		});
		
		borrarVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				menu.setContentPane(new BorrarVideo(menu));
				menu.pack();
			}
		});
	}
}
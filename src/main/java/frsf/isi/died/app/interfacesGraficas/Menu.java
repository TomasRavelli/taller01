package frsf.isi.died.app.interfacesGraficas;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import  javax.swing.*;

public class Menu extends JFrame{
	
	public static void main(String[] args) {
	javax.swing.SwingUtilities.invokeLater(new Runnable() {
	public void run() {
		Menu m = new Menu();
	}
	}); 
	
	
	}
	public  Menu() {
		JFrame principal = new JFrame("Menu");
		principal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		principal.pack();
		principal.setSize(800,600);
		principal.setVisible(true);
		JPanel inicio = new JPanel();
		principal.setContentPane(inicio);
		inicio.setLayout(new GridLayout(0,2));
		
		JButton crearLibro = new JButton ("Crear Libro");
		inicio.add(crearLibro);
		JButton crearVideo = new JButton ("Crear Video");
		inicio.add(crearVideo);
		JButton actualizarLibro = new JButton ("Actualizar Libro");
		inicio.add(actualizarLibro);
		JButton actualizarVideo = new JButton ("Actualizar Video");
		inicio.add(actualizarVideo);
		JButton borrarLibro = new JButton ("Borrar Libro");
		inicio.add(borrarLibro);
		JButton borrarVideo = new JButton ("Borrar Video");
		inicio.add(borrarVideo);
		JButton buscarLibro = new JButton ("Buscar Libro");
		inicio.add(buscarLibro);
		JButton buscarVideo = new JButton ("Buscar Video");
		inicio.add(buscarVideo);
		
	
		buscarLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				BuscarMaterial b1 = new BuscarMaterial();
				principal.dispose();
			}
		});
		
		buscarVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				BuscarMaterial b1 = new BuscarMaterial();
				principal.dispose();
			}
		});
		
		crearLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				CrearLibro l1 = new CrearLibro();
				principal.dispose();
			}
		});
		
		crearVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				CrearVideo v1 = new CrearVideo();
				principal.dispose();
			}
		});
		
		actualizarLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				ActualizarLibro l1 = new ActualizarLibro();
				principal.dispose();
			}
		});
		
		actualizarVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				ActualizarVideo v1 = new ActualizarVideo();
				principal.dispose();
			}
		});
		
		borrarLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				BorrarLibro l1 = new BorrarLibro();
				principal.dispose();
			}
		});
		
		borrarVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				BorrarVideo v1 = new BorrarVideo();
				principal.dispose();
			}
		});
	}
	}
		

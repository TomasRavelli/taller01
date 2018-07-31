package frsf.isi.died.app.interfacesGraficas;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import  javax.swing.*;

import frsf.isi.died.app.dao.MaterialCapacitacionDao;
import frsf.isi.died.app.dao.MaterialCapacitacionDaoDefault;
import frsf.isi.died.tp.modelo.BibliotecaABB;

public class Menu extends JFrame{
	
	public static void main(String[] args) {
	javax.swing.SwingUtilities.invokeLater(new Runnable() {
	public void run() {
		new Menu();
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
		JButton buscarMaterial = new JButton ("Buscar Material Capacitacion");
		inicio.add(buscarMaterial);
		JButton salir = new JButton ("Salir");
		salir.setForeground(Color.RED);
		inicio.add(salir);
		
		MaterialCapacitacionDaoDefault materiales = new MaterialCapacitacionDaoDefault();
		
		buscarMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				new BuscarMaterial(materiales);
				principal.dispose();
			}
		});
		//TODO agregar lo de tema en todos lados
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
			System.exit(0);
			}
		});
		
		crearLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				new CrearLibro(materiales);
				principal.dispose();
			}
		});
		
		crearVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				new CrearVideo(materiales);
				principal.dispose();
			}
		});
		
		actualizarLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				new ActualizarLibro(materiales);
				principal.dispose();
			}
		});
		
		actualizarVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				new ActualizarVideo(materiales);
				principal.dispose();
			}
		});
		
		borrarLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				new BorrarLibro(materiales);
				principal.dispose();
			}
		});
		
		borrarVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				new BorrarVideo(materiales);
				principal.dispose();
			}
		});
	}
	}
		

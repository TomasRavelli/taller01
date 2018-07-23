package frsf.isi.died.app.interfacesGraficas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  javax.swing.*;

public class BuscarMaterial extends JFrame{
	
	public static void main(String[] args) {
	javax.swing.SwingUtilities.invokeLater(new Runnable() {
	public void run() {
		BuscarMaterial b1 = new BuscarMaterial();
		
	}
	}); 
	}
	
	public BuscarMaterial() {
	JFrame buscarM = new JFrame("Buscar Material de Capacitacion");
	buscarM.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	buscarM.pack();
	buscarM.setSize(800,600);
	buscarM.setVisible(true);
	JPanel panel = new JPanel();
	buscarM.setContentPane(panel);
	panel.setLayout(null);
	
	JLabel j = new JLabel("Criterio de Busqueda");
	j.setFont(new Font("Segoe UI Sybol",Font.BOLD,15));
	j.setBounds(40,100,200,20);
	panel.add(j);
	
	JButton titulo = new JButton("Titulo");
	titulo.setBounds(40, 150, 200, 20);
	panel.add(titulo);
	
	JButton calificacion = new JButton("Calificacion");
	calificacion.setBounds(40, 200, 200, 20);
	panel.add(calificacion);

	JButton tema = new JButton("Tema");
	tema.setBounds(40, 250, 200, 20);
	panel.add(tema);
	

	JButton rangoFecha = new JButton("Rango Fecha Publicacion");
	rangoFecha.setBounds(40, 300, 200, 20);
	panel.add(rangoFecha);
	
	}

	}

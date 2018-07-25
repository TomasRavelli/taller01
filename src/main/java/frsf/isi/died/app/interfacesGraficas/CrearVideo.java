package frsf.isi.died.app.interfacesGraficas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  javax.swing.*;

public class CrearVideo extends JFrame {

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				CrearVideo v1 = new CrearVideo();
				}
			});

	}
	
	
	public CrearVideo() {
		JFrame crearV = new JFrame("Crear Video");
		crearV.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		crearV.pack();
		crearV.setSize(800,600);
		crearV.setVisible(true);
		JPanel panel = new JPanel();
		crearV.setContentPane(panel);
		panel.setLayout(null);
	}

}

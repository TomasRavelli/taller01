package frsf.isi.died.app.interfacesGraficas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  javax.swing.*;

public class ActualizarLibro extends JFrame {

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ActualizarLibro l1 = new ActualizarLibro();
				}
			});

	}
	
	
	public ActualizarLibro() {
		JFrame actualizarL = new JFrame("Actualizar Libro");
		actualizarL.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		actualizarL.pack();
		actualizarL.setSize(800,600);
		actualizarL.setVisible(true);
		JPanel panel = new JPanel();
		actualizarL.setContentPane(panel);
		panel.setLayout(null);
	}

}

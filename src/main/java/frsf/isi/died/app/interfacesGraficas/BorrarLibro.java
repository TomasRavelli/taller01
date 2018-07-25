package frsf.isi.died.app.interfacesGraficas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  javax.swing.*;

public class BorrarLibro extends JFrame {

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				BorrarLibro l1 = new BorrarLibro();
				}
			});

	}
	
	
	public BorrarLibro() {
		JFrame borrarL = new JFrame("Borrar Libro");
		borrarL.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		borrarL.pack();
		borrarL.setSize(800,600);
		borrarL.setVisible(true);
		JPanel panel = new JPanel();
		borrarL.setContentPane(panel);
		panel.setLayout(null);
	}

}

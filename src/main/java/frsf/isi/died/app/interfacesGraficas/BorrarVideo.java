package frsf.isi.died.app.interfacesGraficas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  javax.swing.*;

public class BorrarVideo extends JFrame {

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				BorrarVideo v1 = new BorrarVideo();
				}
			});

	}
	
	
	public BorrarVideo() {
		JFrame borrarV = new JFrame("Borrar Video");
		borrarV.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		borrarV.pack();
		borrarV.setSize(800,600);
		borrarV.setVisible(true);
		JPanel panel = new JPanel();
		borrarV.setContentPane(panel);
		panel.setLayout(null);
	}

}

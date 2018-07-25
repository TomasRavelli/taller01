package frsf.isi.died.app.interfacesGraficas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  javax.swing.*;

public class ActualizarVideo extends JFrame {

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ActualizarVideo v1 = new ActualizarVideo();
				}
			});

	}
	
	
	public ActualizarVideo() {
		JFrame actualizarV = new JFrame("Actualizar Video");
		actualizarV.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		actualizarV.pack();
		actualizarV.setSize(800,600);
		actualizarV.setVisible(true);
		JPanel panel = new JPanel();
		actualizarV.setContentPane(panel);
		panel.setLayout(null);
	}

}

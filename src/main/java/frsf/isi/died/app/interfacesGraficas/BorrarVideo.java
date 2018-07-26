package frsf.isi.died.app.interfacesGraficas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
		panel.setLayout(new GridBagLayout());
		
		
		
		JLabel lblID;
		JTextField txtID;
		JButton btnIr;
		JButton btnCancelar;
		
		GridBagConstraints gridConst= new GridBagConstraints();
		
			
		lblID = new JLabel("Ingrese ID Video: ");
		gridConst.gridx=0;
		gridConst.gridy=0;
		panel.add(lblID, gridConst);
		
		txtID = new JTextField();
		txtID.setColumns(20);
		gridConst.gridx=1;
		gridConst.gridwidth=5;
		panel.add(txtID, gridConst);
		
		btnIr = new JButton("Ir");
		gridConst.gridx=0;
		gridConst.gridy=6;
		panel.add(btnIr, gridConst);
		
		btnCancelar = new JButton("Cancelar");
		gridConst.gridx=1;
		gridConst.gridy=6;
		panel.add(btnCancelar, gridConst);
		
<<<<<<< HEAD
		btnIr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				BorrarVideo2 v1 = new BorrarVideo2();
				borrarV.dispose();
			}
		});
		
=======
<<<<<<< HEAD
>>>>>>> e085bbc5f1093b620ad3fcbbe4f53a7e5d9de277
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				Menu v1 = new Menu();
				borrarV.dispose();
			}
		});
		
<<<<<<< HEAD
=======
=======
>>>>>>> 4a4a416762e2ca5d6bb6ee551059fee37b6eddf9
>>>>>>> e085bbc5f1093b620ad3fcbbe4f53a7e5d9de277
	}
}


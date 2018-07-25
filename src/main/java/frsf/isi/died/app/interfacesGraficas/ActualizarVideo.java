package frsf.isi.died.app.interfacesGraficas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				Menu v1 = new Menu();
				actualizarV.dispose();
			}
		});
	}
}

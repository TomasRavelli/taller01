package frsf.isi.died.app.interfacesGraficas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
		panel.setLayout(new GridBagLayout());
		ventanaActualizarLibro(actualizarL, panel);
	}
	
	public void ventanaActualizarLibro(JFrame actualizarL, JPanel panel) {
		GridBagConstraints gridConst = new GridBagConstraints();
		
		JLabel ID = new JLabel("Ingrese ID libro: ");
		gridConst.gridx=0;
		gridConst.gridy=0;
		panel.add(ID, gridConst);
		
		JTextField ID2 = new JTextField();
		ID2.setColumns(10);
		gridConst.gridx=1;
		gridConst.gridwidth=2;
		panel.add(ID2, gridConst);
		
		JButton btnIr = new JButton("Ir");
		gridConst.gridx=0;
		gridConst.gridy=1;
		panel.add(btnIr, gridConst);
		
		JButton btnCancelar = new JButton("Cancelar");
		gridConst.gridx=1;
		gridConst.gridy=1;
		panel.add(btnCancelar, gridConst);		
				
		btnIr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				ActualizarLibro2 b1 = new ActualizarLibro2();
				actualizarL.dispose();
			}
		});
	
	btnCancelar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e){
			Menu v1 = new Menu();
			actualizarL.dispose();
		}
	});
	

}
	}

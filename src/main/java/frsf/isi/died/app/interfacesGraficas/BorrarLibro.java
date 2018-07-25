package frsf.isi.died.app.interfacesGraficas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
		panel.setLayout(new GridBagLayout());
		ventanaBorrar(borrarL, panel);
		
	}
	
	private void ventanaBorrar(JFrame borrarL, JPanel panel) {
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
				BorrarLibro2 b1 = new BorrarLibro2();
				borrarL.dispose();
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				Menu v1 = new Menu();
				borrarL.dispose();
			}
		});
	}

}

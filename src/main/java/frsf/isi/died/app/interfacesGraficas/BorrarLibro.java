package frsf.isi.died.app.interfacesGraficas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  javax.swing.*;

import frsf.isi.died.app.dao.MaterialCapacitacionDaoDefault;
import frsf.isi.died.tp.modelo.*;
import frsf.isi.died.tp.modelo.productos.*;

public class BorrarLibro extends JFrame {


	
	public BorrarLibro(MaterialCapacitacionDaoDefault materiales) {
		JFrame borrarL = new JFrame("Borrar Libro");
		borrarL.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		borrarL.pack();
		borrarL.setSize(800,600);
		borrarL.setVisible(true);
		JPanel panel = new JPanel();
		borrarL.setContentPane(panel);
		panel.setLayout(new GridBagLayout());
		ventanaBorrar(borrarL, panel,materiales);
		
	}
	
	private void ventanaBorrar(JFrame borrarL, JPanel panel,MaterialCapacitacionDaoDefault materiales) {
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
				boolean b=false;
				Libro estelibro = new Libro();
				for(Libro ellibro : materiales.listaLibros()) {
					if(ellibro.getId()==Integer.valueOf(ID2.getText())) {
						estelibro=ellibro;
						b=true;
					}
				}
				if(b) {
				new BorrarLibro2(materiales,estelibro);
				borrarL.dispose();
				}else {
					//TODO ventana de error: no hay video/libro con ese id
				}
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				new Menu();
				borrarL.dispose();
			}
		});
	}

}

package frsf.isi.died.app.InterfacesGraficasNuevo;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  javax.swing.*;

import frsf.isi.died.app.InterfacesGraficasNuevo.Menu;
import frsf.isi.died.app.dao.MaterialCapacitacionDaoDefault;
import frsf.isi.died.tp.modelo.productos.*;

public class ActualizarLibro extends JPanel {
	
	
	public ActualizarLibro(Menu ventana) {
		
		this.setPreferredSize(new Dimension(800,600));
		this.setVisible(true);
		this.setLayout(new GridBagLayout());
		ventanaActualizarLibro(ventana);
	}
	
	
	public void ventanaActualizarLibro(Menu actualizarL) {
		GridBagConstraints gridConst = new GridBagConstraints();
		
		JLabel ID = new JLabel("Ingrese ID libro: ");
		gridConst.gridx=0;
		gridConst.gridy=0;
		this.add(ID, gridConst);
		
		JTextField ID2 = new JTextField();
		ID2.setColumns(10);
		gridConst.gridx=1;
		gridConst.gridwidth=2;
		this.add(ID2, gridConst);
		
		JButton btnIr = new JButton("Ir");
		gridConst.gridx=0;
		gridConst.gridy=1;
		this.add(btnIr, gridConst);
		
		JButton btnCancelar = new JButton("Cancelar");
		gridConst.gridx=1;
		gridConst.gridy=1;
		this.add(btnCancelar, gridConst);		
				
		
		btnIr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				boolean b=false;
				Libro estelibro = new Libro();
				for(Libro ellibro : actualizarL.getMateriales().listaLibros()) {
					if(ellibro.getId()==Integer.valueOf(ID2.getText())) {
						estelibro=ellibro;
						b=true;
					}
				}
				if(!b || ID2.getText().isEmpty()) {
					//TODO ventana de error: no hay video/libro con ese id
					JOptionPane noEncontrado = new JOptionPane();
					noEncontrado.showConfirmDialog(actualizarL, "No existe libro con ese ID", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
					}
				else {
						actualizarL.setContentPane(new ActualizarLibro2(actualizarL,estelibro));
						actualizarL.pack();
				}
			}
		});
		
		
		btnIr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(ID2.getText().isEmpty()) {
					//TODO Poner esto para que salga en una ventanita,ver que vengan solo enteros y que coincida con algun ID existente
					System.out.println("Campo ID vacio");
				}
			}
		});
	
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				actualizarL.setContentPane(new Inicio(actualizarL));
				actualizarL.pack();
			}
		});
	}
}
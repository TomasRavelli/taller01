package frsf.isi.died.app.interfacesGraficas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  javax.swing.*;

import frsf.isi.died.app.dao.MaterialCapacitacionDaoDefault;
import frsf.isi.died.tp.modelo.productos.Libro;
import frsf.isi.died.tp.modelo.productos.*;

public class ActualizarVideo extends JFrame {


	public ActualizarVideo(MaterialCapacitacionDaoDefault materiales) {
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
		
		btnIr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(txtID.getText().isEmpty()) {
					//TODO Poner esto para que salga en una ventanita,ver que vengan solo enteros y que coincida con algun ID existente
					System.out.println("Campo ID vacio");
				}
			}
		});
		btnIr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				boolean b=false;
				Video estevideo = new Video();
				for(Video elvideo : materiales.listaVideos()) {
					if(elvideo.getId()==Integer.valueOf(txtID.getText())) {
						estevideo=elvideo;
						b=true;
					}
				}
				if(b) {
					new ActualizarVideo2(materiales,estevideo);
					actualizarV.dispose();
					}else {
						//TODO ventana de error: no hay video/libro con ese id
					}
			}
		});
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				new Menu();
				actualizarV.dispose();
			}
		});
	}
}

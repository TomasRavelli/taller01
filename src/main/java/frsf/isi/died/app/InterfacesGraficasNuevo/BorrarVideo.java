package frsf.isi.died.app.InterfacesGraficasNuevo;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import frsf.isi.died.app.InterfacesGraficasNuevo.Menu;
import frsf.isi.died.tp.modelo.productos.Video;


public class BorrarVideo extends JPanel {

	public BorrarVideo(Menu ventana) {
		
		this.setPreferredSize(new Dimension(800,600));
		this.setVisible(true);
		this.setLayout(new GridBagLayout());		
		
		JLabel lblID;
		JTextField txtID;
		JButton btnIr;
		JButton btnCancelar;
		GridBagConstraints gridConst= new GridBagConstraints();
		
			
		lblID = new JLabel("Ingrese ID Video: ");
		gridConst.gridx=0;
		gridConst.gridy=0;
		this.add(lblID, gridConst);
		
		txtID = new JTextField();
		txtID.setColumns(20);
		gridConst.gridx=1;
		gridConst.gridwidth=5;
		this.add(txtID, gridConst);
		
		btnIr = new JButton("Ir");
		gridConst.gridx=0;
		gridConst.gridy=6;
		this.add(btnIr, gridConst);
		
		btnCancelar = new JButton("Cancelar");
		gridConst.gridx=1;
		gridConst.gridy=6;
		this.add(btnCancelar, gridConst);
		

		btnIr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				boolean b=false;
				Video estevideo = new Video();
				for(Video elvideo : ventana.getMateriales().listaVideos()) {
					if(elvideo.getId()==Integer.valueOf(txtID.getText())) {
						estevideo=elvideo;
						b=true;
					}
				}
				
				if(!b || txtID.getText().isEmpty()) {
					JOptionPane.showConfirmDialog(ventana, "No existe video con ese ID", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
					}
				else {
					ventana.setContentPane(new BorrarVideo2(ventana,estevideo));
					ventana.pack();
				}
			}
		});
		
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				ventana.setContentPane(new Inicio(ventana));
				ventana.pack();
			}
		});
	}
}
package frsf.isi.died.app.interfacesGraficas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CrearVideo extends JFrame {

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				CrearVideo v1 = new CrearVideo();
				}
			});

	}
	
	
	public CrearVideo() {
		JFrame crearV = new JFrame("Crear Video");
		crearV.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		crearV.pack();
		crearV.setSize(800,600);
		crearV.setVisible(true);
		JPanel panel = new JPanel();
		crearV.setContentPane(panel);
		panel.setLayout(new GridBagLayout());
		
		
		JLabel lblTitulo;
		JTextField txtTitulo;
		JLabel lblCostoSeg;
		JLabel lblDuracion;
		JTextField txtCostoSeg;
		JTextField txtDuracion;
		JLabel lblCosto;
		JTextField txtCosto;
		JButton btnAgregar;
		JButton btnCancelar;
		JLabel lblRelevancia;
		JTextField txtRelevancia;
		JLabel lblID;
		JTextField txtID;
		
		
		GridBagConstraints gridConst= new GridBagConstraints();
		
		gridConst.gridx=0;
		gridConst.gridy=0;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		lblTitulo = new JLabel("Titulo");
		panel.add(lblTitulo,gridConst);
		
		gridConst.gridx=1;
		gridConst.gridy=0;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 5;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		txtTitulo = new JTextField();
		panel.add(txtTitulo,gridConst);
		
		gridConst.gridx=0;
		gridConst.gridy=1;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		lblDuracion = new JLabel("Duracion");
		panel.add(lblDuracion, gridConst);
		
		gridConst.gridx=1;
		gridConst.gridy=1;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;

		txtDuracion = new JTextField();
		panel.add(txtDuracion, gridConst);
		
		gridConst.gridx=2;
		gridConst.gridy=1;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		lblCostoSeg = new JLabel("Costo por segundo");
		panel.add(lblCostoSeg,gridConst);
		
		
		gridConst.gridx=3;
		gridConst.gridy=1;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		txtCostoSeg = new JTextField();
		panel.add(txtCostoSeg,gridConst);
		
		gridConst.gridx=4;
		gridConst.gridy=1;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		lblCosto = new JLabel("Costo");
		panel.add(lblCosto,gridConst);
		
		gridConst.gridx=5;
		gridConst.gridy=1;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		txtCosto = new JTextField();
		panel.add(txtCosto, gridConst);
		

		gridConst.gridx=0;
		gridConst.gridy=2;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		lblRelevancia = new JLabel("Relevancia");
		panel.add(lblRelevancia, gridConst);
		

		gridConst.gridx=1;
		gridConst.gridy=2;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		txtRelevancia = new JTextField();
		panel.add(txtRelevancia, gridConst);


		gridConst.gridx=2;
		gridConst.gridy=2;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		lblID = new JLabel("ID");
		panel.add(lblID, gridConst);
		
		gridConst.gridx=3;
		gridConst.gridy=2;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		txtID = new JTextField();
		panel.add(txtID, gridConst);
		

String[] columnas = {"Titulo","Duracion","Costo por Seg","Costo","Relevancia","ID"};

		
		DefaultTableModel modeloTabla = new DefaultTableModel(null,columnas);
		
		JTable tablaLibro = new JTable(modeloTabla);
		JScrollPane scrollTabla = new JScrollPane(tablaLibro);
		gridConst.gridx = 0;
		gridConst.gridy = 3;
		gridConst.gridheight = 5 ;
		gridConst.gridwidth = 6;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		gridConst.anchor = GridBagConstraints.PAGE_START;
	
		panel.add(scrollTabla,gridConst);
		
		gridConst.gridx = 5;
		gridConst.gridy = 8;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		btnCancelar = new JButton("Cancelar");
		panel.add(btnCancelar, gridConst);
		
		gridConst.gridx = 4;
		gridConst.gridy = 8;
		gridConst.gridwidth = 1;
		gridConst.gridheight = 1 ;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		btnAgregar = new JButton("Agregar");
		panel.add(btnAgregar,gridConst);
		
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				Menu v1 = new Menu();
				crearV.dispose();
			}
		});

		
		
	}

}

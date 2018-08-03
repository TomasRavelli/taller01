package frsf.isi.died.app.InterfacesGraficasNuevo;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import frsf.isi.died.app.dao.MaterialCapacitacionDaoDefault;
import frsf.isi.died.tp.modelo.productos.*;

public class BorrarVideo2 extends JPanel {
	
	public BorrarVideo2(Menu ventana, Video paraBorrar){
		
		this.setPreferredSize(new Dimension(800,600));
		this.setVisible(true);
		this.setLayout(new GridBagLayout());
		
		JLabel lblTitulo;
		JTextField txtTitulo;
		JLabel lblCosto;
		JLabel lblPrecioCompra;
		JTextField txtCosto;
		JTextField txtPrecioCompra;
		JButton btnEliminar;
		JButton btnCancelar;
		JLabel lblRelevancia;
		JTextField txtRelevancia;
		JLabel lblID;
		JTextField txtID;
		
		GridBagConstraints gridConst= new GridBagConstraints();
		
		
		lblTitulo = new JLabel("Titulo: ");
		gridConst.gridx=0;
		gridConst.gridy=0;
		this.add(lblTitulo, gridConst);
		
		txtTitulo = new JTextField();
		txtTitulo.setEditable(false);
		txtTitulo.setColumns(20);
		gridConst.gridx=1;
		gridConst.gridwidth=5;
		txtTitulo.setText(paraBorrar.getTitulo());
		this.add(txtTitulo, gridConst);
		
		lblCosto= new JLabel("Costo: ");		
		gridConst.gridx=0;
		gridConst.gridy=1;
		gridConst.weightx=0.0;
		this.add(lblCosto, gridConst);
		
		txtCosto = new JTextField();
		txtCosto.setEditable(false);
		txtCosto.setColumns(5);
		gridConst.gridx=1;
		txtCosto.setText(paraBorrar.getCosto().toString());
		this.add(txtCosto, gridConst);
		
		lblPrecioCompra= new JLabel("Duracion: ");
		gridConst.gridx=0;
		gridConst.gridy=2;
		this.add(lblPrecioCompra, gridConst);
		
		txtPrecioCompra = new JTextField();
		txtPrecioCompra.setEditable(false);
		txtPrecioCompra.setColumns(5);
		gridConst.gridx=3;
		txtPrecioCompra.setText(paraBorrar.getDuracion().toString());
		this.add(txtPrecioCompra, gridConst);
		
		lblRelevancia= new JLabel("Relevancia: ");
		gridConst.gridx=0;
		gridConst.gridy=3;
		this.add(lblRelevancia, gridConst);
		
		txtRelevancia = new JTextField();
		txtRelevancia.setEditable(false);
		txtRelevancia.setColumns(5);
		gridConst.gridx=3;
		txtRelevancia.setText(paraBorrar.getRelevancia().toString());
		this.add(txtRelevancia, gridConst);
				
		lblID= new JLabel("ID: ");
		gridConst.gridx=0;
		gridConst.gridy=5;
		this.add(lblID, gridConst);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setColumns(5);
		gridConst.gridx=3;
		txtID.setText(paraBorrar.getId().toString());
		this.add(txtID, gridConst);
		
		btnEliminar = new JButton("Eliminar");
		gridConst.gridx=0;
		gridConst.gridy=6;
		this.add(btnEliminar, gridConst);
		
		btnCancelar = new JButton("Cancelar");
		gridConst.gridx=1;
		gridConst.gridy=6;
		this.add(btnCancelar, gridConst);
		
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ventana.getMateriales().borrarMaterial(paraBorrar);
				ventana.getMateriales().modificarArchivoVideo(ventana);
				ventana.setContentPane(new BorrarLibro(ventana));
				ventana.pack();
			}
		});
		
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				 ventana.setContentPane(new BorrarVideo(ventana));;
				 ventana.pack();
			}
		});
	}
}

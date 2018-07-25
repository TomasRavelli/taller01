package frsf.isi.died.app.interfacesGraficas;

import java.awt.GridBagConstraints;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  javax.swing.*;

//import frsf.isi.died.app.vista.material.LibroTableModel;


public class CrearLibro extends JFrame {

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				CrearLibro l1 = new CrearLibro();
				}
			});

	}
	
	
	public CrearLibro() {
		JFrame crearL = new JFrame("Crear Libro");
		crearL.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		crearL.pack();
		crearL.setSize(800,600);
		crearL.setVisible(true);
		JPanel panel = new JPanel();
		crearL.setContentPane(panel);
		panel.setLayout(new GridBagLayout());
		
		
		JLabel lblTitulo;
		JTextField txtTitulo;
		JScrollPane scrollPane;
		JTable tabla;
		JLabel lblCosto;
		JLabel lblPrecioCompra;
		JLabel lblPaginas;
		JTextField txtCosto;
		JTextField txtPrecioCompra;
		JTextField txtPaginas;
		JButton btnAgregar;
		JButton btnCancelar;		
		
		TablaLibro tableModel;
		
		GridBagConstraints gridConst= new GridBagConstraints();
		
		lblTitulo = new JLabel("Titulo: ");
		gridConst.gridx=0;
		gridConst.gridy=0;
		panel.add(lblTitulo, gridConst);
		
		txtTitulo = new JTextField();
		txtTitulo.setColumns(20);
		gridConst.gridx=1;
		gridConst.gridwidth=5;
		panel.add(txtTitulo, gridConst);
		
		lblCosto= new JLabel("Costo: ");		
		gridConst.gridx=0;
		gridConst.gridy=1;
		gridConst.weightx=0.0;
		panel.add(lblCosto, gridConst);
		
		txtCosto = new JTextField();
		txtCosto.setColumns(5);
		gridConst.gridx=1;
		panel.add(txtCosto, gridConst);
		
		lblPrecioCompra= new JLabel("Precio Compra: ");
		gridConst.gridx=0;
		gridConst.gridy=2;
		panel.add(lblPrecioCompra, gridConst);
		
		txtPrecioCompra = new JTextField();
		txtPrecioCompra.setColumns(5);
		gridConst.gridx=3;
		panel.add(txtPrecioCompra, gridConst);
		
		lblPaginas= new JLabel("Paginas: ");		
		gridConst.gridx=0;
		gridConst.gridy=3;
		panel.add(lblPaginas, gridConst);
		
		txtPaginas = new JTextField();
		txtPaginas.setColumns(5);
		gridConst.gridx=1;
		panel.add(txtPaginas, gridConst);
				
		
		
		btnAgregar = new JButton("Agregar");
		gridConst.gridx=0;
		gridConst.gridy=5;
		panel.add(btnAgregar, gridConst);
		
		btnCancelar = new JButton("Cancelar");
		gridConst.gridx=1;
		gridConst.gridy=5;
		panel.add(btnCancelar, gridConst);
		
		
		//TablaLibro t = new TablaLibro();
		
		
	}
}
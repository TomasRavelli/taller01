package frsf.isi.died.app.interfacesGraficas;

import java.awt.GridBagConstraints;

import java.awt.GridBagLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  javax.swing.*;
import javax.swing.table.DefaultTableModel;

import frsf.isi.died.tp.modelo.productos.Libro;


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
		JLabel lblCosto;
		JLabel lblPrecioCompra;
		JLabel lblPaginas;
		JTextField txtCosto;
		JTextField txtPrecioCompra;
		JTextField txtPaginas;
		JButton btnAgregar;
		JButton btnCancelar;
		

		
		GridBagConstraints gridConst= new GridBagConstraints();
		gridConst.gridx=0;
		gridConst.gridy=0;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 5;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		lblTitulo = new JLabel("Titulo: ");
		panel.add(lblTitulo, gridConst);
		
		gridConst.gridx=1;
		gridConst.gridy=0;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 5;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		
		txtTitulo = new JTextField();
		panel.add(txtTitulo, gridConst);
		
		gridConst.gridx=0;
		gridConst.gridy=1;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		lblCosto= new JLabel("Costo: ");		
		panel.add(lblCosto, gridConst);
		
		gridConst.gridx=1;
		gridConst.gridy=1;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		txtCosto = new JTextField();
		panel.add(txtCosto, gridConst);
		
		gridConst.gridx=2;
		gridConst.gridy=1;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		lblPrecioCompra= new JLabel("Precio Compra: ");
		panel.add(lblPrecioCompra, gridConst);
		
		gridConst.gridx=3;
		gridConst.gridy=1;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		txtPrecioCompra = new JTextField();
		panel.add(txtPrecioCompra, gridConst);
		
		gridConst.gridx=4;
		gridConst.gridy=1;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		lblPaginas= new JLabel("Paginas: ");		
		panel.add(lblPaginas, gridConst);
		
		gridConst.gridx=5;
		gridConst.gridy=1;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		txtPaginas = new JTextField();
		panel.add(txtPaginas, gridConst);
		
		gridConst.gridx=0;
		gridConst.gridy=2;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		JLabel relevancia = new JLabel("Relevancia:");
		panel.add(relevancia,gridConst);
		
		gridConst.gridx=1;
		gridConst.gridy=2;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		JTextField relevancia2 = new JTextField();
		panel.add(relevancia2,gridConst);

		gridConst.gridx=2;
		gridConst.gridy=2;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
	
		JLabel id = new JLabel("ID:");
		panel.add(id,gridConst);
		
		gridConst.gridx=3;
		gridConst.gridy=2;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		JTextField ID2 = new JTextField();
		panel.add(ID2,gridConst);
		
		String[] columnas = {"Titulo","Costo","Precio Compra","Paginas","Relevancia","ID"};
		
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
				crearL.dispose();
			}
		});
		
		
		
	}
}
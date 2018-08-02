package frsf.isi.died.app.InterfacesGraficasNuevo;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import frsf.isi.died.app.dao.MaterialCapacitacionDaoDefault;
import frsf.isi.died.tp.modelo.productos.Libro;
import frsf.isi.died.tp.modelo.productos.Relevancia;

public class ActualizarLibro2 extends JPanel {

	public ActualizarLibro2(Menu ventana,Libro paraActualizar){
		
		this.setPreferredSize(new Dimension(800,600));
		this.setVisible(true);
		this.setLayout(new GridBagLayout());
		
		JLabel lblTitulo;
		JTextField txtTitulo;
		JLabel lblCosto;
		JLabel lblPrecioCompra;
		JLabel lblPaginas;
		JTextField txtCosto;
		JTextField txtPrecioCompra;
		JTextField txtPaginas;
		JButton btnGuardar;
		JButton btnCancelar;
		
		GridBagConstraints gridConst= new GridBagConstraints();
		
		lblTitulo = new JLabel("Titulo: ");
		gridConst.gridx=0;
		gridConst.gridy=0;
		this.add(lblTitulo, gridConst);
		
		txtTitulo = new JTextField();
		txtTitulo.setColumns(20);
		gridConst.gridx=1;
		gridConst.gridwidth=5;
		txtTitulo.setText(paraActualizar.getTitulo().toString());
		this.add(txtTitulo, gridConst);
		
		lblCosto= new JLabel("Costo: ");		
		gridConst.gridx=0;
		gridConst.gridy=1;
		gridConst.weightx=0.0;
		this.add(lblCosto, gridConst);
		
		txtCosto = new JTextField();
		txtCosto.setColumns(5);
		gridConst.gridx=1;
		txtCosto.setText(paraActualizar.getCosto().toString());
		this.add(txtCosto, gridConst);
		
		lblPrecioCompra= new JLabel("Precio Compra: ");
		gridConst.gridx=0;
		gridConst.gridy=2;
		this.add(lblPrecioCompra, gridConst);
		
		txtPrecioCompra = new JTextField();
		txtPrecioCompra.setColumns(5);
		gridConst.gridx=3;
		txtPrecioCompra.setText(paraActualizar.getPrecioCompra().toString());
		this.add(txtPrecioCompra, gridConst);
		
		lblPaginas= new JLabel("Paginas: ");		
		gridConst.gridx=0;
		gridConst.gridy=3;
		this.add(lblPaginas, gridConst);
		
		txtPaginas = new JTextField();
		txtPaginas.setColumns(5);
		gridConst.gridx=1;
		txtPaginas.setText(paraActualizar.getPaginas().toString());
		this.add(txtPaginas, gridConst);
		
		JLabel relevancia = new JLabel("Relevancia:");
		gridConst.gridx=0;
		gridConst.gridy=5;
		this.add(relevancia,gridConst);
		
		Object[] obj = {"ALTA","MEDIA","BAJA"};
		JComboBox relevancia2 = new JComboBox(obj);
		gridConst.gridx=1;
		gridConst.gridy=5;
		relevancia2.setSelectedItem(paraActualizar.getRelevancia());
		this.add(relevancia2,gridConst);
		
		JLabel id = new JLabel("ID:");
		gridConst.gridx=0;
		gridConst.gridy=6;
		this.add(id,gridConst);
		
		JTextField ID2 = new JTextField();
		gridConst.gridx=1;
		ID2.setColumns(5);
		gridConst.gridy=6;
		ID2.setText(paraActualizar.getId().toString());
		this.add(ID2,gridConst);
		
		//TODO Agregar lo de la fecha
		
		
		btnGuardar = new JButton("Guardar Cambios");
		gridConst.gridx=0;
		gridConst.gridy=7;
		this.add(btnGuardar, gridConst);
		
		btnCancelar = new JButton("Cancelar");
		gridConst.gridx=1;
		gridConst.gridy=7;
		this.add(btnCancelar, gridConst);
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				ventana.setContentPane(new ActualizarLibro(ventana));
				ventana.pack();
			}
		});
		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//if() 
				{
					Libro nuevoLibro = new Libro();
					ventana.getMateriales().agregarLibro(nuevoLibro);
					//TODO cuando tengamos lo de la fecha, hay que crear el libro con sus atrubitos
					//y eliminar el del ID que sacamos en la ventana anterior (IDParaEliminar)
				}
			}
		});
	}
	
}

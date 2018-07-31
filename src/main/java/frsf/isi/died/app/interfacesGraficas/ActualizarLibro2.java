package frsf.isi.died.app.interfacesGraficas;

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

public class ActualizarLibro2 {

	public ActualizarLibro2(MaterialCapacitacionDaoDefault materiales,Libro paraActualizar){
		JFrame crearL = new JFrame("Actualizar Libro");
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
		JButton btnGuardar;
		JButton btnCancelar;
		
		GridBagConstraints gridConst= new GridBagConstraints();
		
		lblTitulo = new JLabel("Titulo: ");
		gridConst.gridx=0;
		gridConst.gridy=0;
		panel.add(lblTitulo, gridConst);
		
		txtTitulo = new JTextField();
		txtTitulo.setColumns(20);
		gridConst.gridx=1;
		gridConst.gridwidth=5;
		txtTitulo.setText(paraActualizar.getTitulo().toString());
		panel.add(txtTitulo, gridConst);
		
		lblCosto= new JLabel("Costo: ");		
		gridConst.gridx=0;
		gridConst.gridy=1;
		gridConst.weightx=0.0;
		panel.add(lblCosto, gridConst);
		
		txtCosto = new JTextField();
		txtCosto.setColumns(5);
		gridConst.gridx=1;
		txtCosto.setText(paraActualizar.getCosto().toString());
		panel.add(txtCosto, gridConst);
		
		lblPrecioCompra= new JLabel("Precio Compra: ");
		gridConst.gridx=0;
		gridConst.gridy=2;
		panel.add(lblPrecioCompra, gridConst);
		
		txtPrecioCompra = new JTextField();
		txtPrecioCompra.setColumns(5);
		gridConst.gridx=3;
		txtPrecioCompra.setText(paraActualizar.getPrecioCompra().toString());
		panel.add(txtPrecioCompra, gridConst);
		
		lblPaginas= new JLabel("Paginas: ");		
		gridConst.gridx=0;
		gridConst.gridy=3;
		panel.add(lblPaginas, gridConst);
		
		txtPaginas = new JTextField();
		txtPaginas.setColumns(5);
		gridConst.gridx=1;
		txtPaginas.setText(paraActualizar.getPaginas().toString());
		panel.add(txtPaginas, gridConst);
		
		JLabel relevancia = new JLabel("Relevancia:");
		gridConst.gridx=0;
		gridConst.gridy=5;
		panel.add(relevancia,gridConst);
		
		Object[] obj = {"ALTA","MEDIA","BAJA"};
		JComboBox relevancia2 = new JComboBox(obj);
		gridConst.gridx=1;
		gridConst.gridy=5;
		relevancia2.setSelectedItem(paraActualizar.getRelevancia());
		panel.add(relevancia2,gridConst);
		
		JLabel id = new JLabel("ID:");
		gridConst.gridx=0;
		gridConst.gridy=6;
		panel.add(id,gridConst);
		
		JTextField ID2 = new JTextField();
		gridConst.gridx=1;
		ID2.setColumns(5);
		gridConst.gridy=6;
		ID2.setText(paraActualizar.getId().toString());
		panel.add(ID2,gridConst);
		
		//TODO Agregar lo de la fecha
		
		
		btnGuardar = new JButton("Guardar Cambios");
		gridConst.gridx=0;
		gridConst.gridy=7;
		panel.add(btnGuardar, gridConst);
		
		btnCancelar = new JButton("Cancelar");
		gridConst.gridx=1;
		gridConst.gridy=7;
		panel.add(btnCancelar, gridConst);
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				new ActualizarLibro(materiales);
				crearL.dispose();
			}
		});
		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//if() 
				{
					Libro nuevoLibro = new Libro();
					materiales.agregarLibro(nuevoLibro);
					//TODO cuando tengamos lo de la fecha, hay que crear el libro con sus atrubitos
					//y eliminar el del ID que sacamos en la ventana anterior (IDParaEliminar)
				}
			}
		});
	}
	
}

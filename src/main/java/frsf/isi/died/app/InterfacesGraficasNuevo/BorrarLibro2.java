package frsf.isi.died.app.InterfacesGraficasNuevo;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import frsf.isi.died.tp.modelo.productos.*;

public class BorrarLibro2 extends JPanel{
	
	public BorrarLibro2(Menu ventana, Libro paraBorrar){
		
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
		JButton btnEliminar;
		JButton btnCancelar;
		
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
		
		lblPrecioCompra= new JLabel("Precio Compra: ");
		gridConst.gridx=0;
		gridConst.gridy=2;
		this.add(lblPrecioCompra, gridConst);
		
		txtPrecioCompra = new JTextField();
		txtPrecioCompra.setEditable(false);
		txtPrecioCompra.setColumns(5);
		gridConst.gridx=3;
		txtPrecioCompra.setText(paraBorrar.getPrecioCompra().toString());
		this.add(txtPrecioCompra, gridConst);
		
		lblPaginas= new JLabel("Paginas: ");		
		gridConst.gridx=0;
		gridConst.gridy=3;
		this.add(lblPaginas, gridConst);
		
		txtPaginas = new JTextField();
		txtPaginas.setEditable(false);
		txtPaginas.setColumns(5);
		gridConst.gridx=1;
		txtPaginas.setText(paraBorrar.getPaginas().toString());
		this.add(txtPaginas, gridConst);
		
		JLabel relevancia = new JLabel("Relevancia:");
		gridConst.gridx=0;
		gridConst.gridy=5;
		this.add(relevancia,gridConst);
		
		JTextField relevancia2 = new JTextField();
		gridConst.gridx=1;
		relevancia2.setColumns(5);
		gridConst.gridy=5;
		relevancia2.setEditable(false);
		relevancia2.setText(paraBorrar.getRelevancia().toString());
		this.add(relevancia2,gridConst);
		
		JLabel id = new JLabel("ID:");
		gridConst.gridx=0;
		gridConst.gridy=6;
		this.add(id,gridConst);
		
		JTextField ID2 = new JTextField();
		ID2.setEditable(false);
		gridConst.gridx=1;
		ID2.setColumns(5);
		gridConst.gridy=6;
		ID2.setText(paraBorrar.getId().toString());
		this.add(ID2,gridConst);
		
		
		btnEliminar = new JButton("Eliminar");
		gridConst.gridx=0;
		gridConst.gridy=7;
		this.add(btnEliminar, gridConst);
		
		btnCancelar = new JButton("Cancelar");
		gridConst.gridx=1;
		gridConst.gridy=7;
		this.add(btnCancelar, gridConst);
		
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.getMateriales().borrarMaterial(paraBorrar);
				ventana.getMateriales().modificarArchivoLibro(ventana);
				ventana.setContentPane(new BorrarLibro(ventana));
				ventana.pack();
			}
		});
		
			
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				ventana.setContentPane(new BorrarLibro(ventana));
				ventana.pack();
			}
		});	
	}	
}
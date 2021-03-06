package frsf.isi.died.app.InterfacesGraficasNuevo;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import frsf.isi.died.tp.modelo.productos.Libro;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;
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
				
				Date fecha = new Date();
				fecha = paraActualizar.getFechaPublicacion();
				String tema = paraActualizar.getTema();
				Integer idAnterior = paraActualizar.getId();
				
				if(!txtTitulo.getText().isEmpty() && !txtCosto.getText().isEmpty() && !txtPrecioCompra.getText().isEmpty() && !txtPaginas.getText().isEmpty() && !ID2.getText().isEmpty()) {
					boolean b=false;
					for(MaterialCapacitacion m : ventana.getMateriales().listaMateriales()) {
						if(m.getId().equals(Integer.valueOf(ID2.getText())) && !(m.getId().equals(idAnterior))) {
							b=true;
						}
					}
					if(b) {
						JOptionPane.showConfirmDialog(ventana, "Ese ID no esta libre", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
					}
					else {
						Double costo = new Double(txtCosto.getText());
						Double precioCompra = new Double(txtPrecioCompra.getText());
						Integer id = new Integer(ID2.getText());
						Integer paginas = new Integer(txtPaginas.getText());
						
						Relevancia aux;
						if(relevancia2.getSelectedIndex()==0){
							aux=Relevancia.ALTA;
						}
						else {
							if(relevancia2.getSelectedIndex()==1){
								aux=Relevancia.MEDIA;
							}
							else {
								 aux=Relevancia.BAJA;
							}
						}
						
						Libro nuevoLibro = new Libro(id, txtTitulo.getText(), costo, precioCompra, paginas, aux, fecha, tema);
						ventana.getMateriales().actualizarMaterial(paraActualizar, nuevoLibro);
						ventana.getMateriales().modificarArchivoLibro(ventana);
						ventana.setContentPane(new Inicio(ventana));
						ventana.pack();
					}
				}
				else {
					JOptionPane.showConfirmDialog(ventana, "Faltan campos por completar", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}	
}
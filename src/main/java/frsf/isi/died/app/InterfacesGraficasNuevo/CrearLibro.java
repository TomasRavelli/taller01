package frsf.isi.died.app.InterfacesGraficasNuevo;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import frsf.isi.died.app.InterfacesGraficasNuevo.Menu;
import frsf.isi.died.app.dao.MaterialCapacitacionDaoDefault;
import frsf.isi.died.tp.modelo.productos.Libro;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;
import frsf.isi.died.tp.modelo.productos.Relevancia;


public class CrearLibro extends JPanel {

	public CrearLibro(Menu ventana) {
		
		this.setPreferredSize(new Dimension(800,600));
		this.setVisible(true);
		this.setLayout(new GridBagLayout());
		
		JLabel lblTitulo;
		JTextField txtTitulo;
		JLabel lblTema;
		JTextField txtTema;
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
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		lblTitulo = new JLabel("Titulo");
		this.add(lblTitulo, gridConst);
		
		gridConst.gridx=1;
		gridConst.gridy=0;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 3;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		txtTitulo = new JTextField();
		this.add(txtTitulo, gridConst);
		
		gridConst.gridx=4;
		gridConst.gridy=0;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		lblTema = new JLabel("Tema");
		this.add(lblTema, gridConst);
		
		gridConst.gridx=5;
		gridConst.gridy=0;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		txtTema = new JTextField();
		this.add(txtTema, gridConst);
		
		gridConst.gridx=0;
		gridConst.gridy=1;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		lblCosto= new JLabel("Costo: ");		
		this.add(lblCosto, gridConst);
		
		gridConst.gridx=1;
		gridConst.gridy=1;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		txtCosto = new JTextField();
		this.add(txtCosto, gridConst);
		
		gridConst.gridx=2;
		gridConst.gridy=1;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		lblPrecioCompra= new JLabel("Precio Compra: ");
		this.add(lblPrecioCompra, gridConst);
		
		gridConst.gridx=3;
		gridConst.gridy=1;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		txtPrecioCompra = new JTextField();
		this.add(txtPrecioCompra, gridConst);
		
		gridConst.gridx=4;
		gridConst.gridy=1;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		lblPaginas= new JLabel("Paginas: ");		
		this.add(lblPaginas, gridConst);
		
		gridConst.gridx=5;
		gridConst.gridy=1;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		txtPaginas = new JTextField();
		this.add(txtPaginas, gridConst);
		
		gridConst.gridx=4;
		gridConst.gridy=2;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		JLabel lblFechaPublicacion = new JLabel("Fecha publicacion: ");		
		this.add(lblFechaPublicacion, gridConst);
		
		gridConst.gridx=5;
		gridConst.gridy=2;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		JTextField txtFechaPublicacion = new JTextField();
		this.add(txtFechaPublicacion, gridConst);
		
		gridConst.gridx=0;
		gridConst.gridy=2;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		JLabel relevancia = new JLabel("Relevancia:");
		
		btnAgregar = new JButton("Agregar");
		this.add(relevancia,gridConst);
		
		gridConst.gridx=1;
		gridConst.gridy=2;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		Object[] obj = {"ALTA","MEDIA","BAJA"};
		JComboBox relevancia2 = new JComboBox(obj);
		this.add(relevancia2,gridConst);

		gridConst.gridx=2;
		gridConst.gridy=2;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
	
		JLabel id = new JLabel("ID:");
		this.add(id,gridConst);
		
		gridConst.gridx=3;
		gridConst.gridy=2;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		JTextField ID2 = new JTextField();
		this.add(ID2,gridConst);
		
		String[] columnas = {"Titulo","Costo","Precio","Paginas","Calificacion","Relevancia","ID","Fecha Publicacion"};
		
		DefaultTableModel modeloTabla = new DefaultTableModel(null,columnas);
		
		JTable tablaLibro = new JTable(modeloTabla);
		JScrollPane scrollTabla = new JScrollPane(tablaLibro);
		gridConst.gridx = 0;
		gridConst.gridy = 3;
		gridConst.gridheight = 5;
		gridConst.gridwidth = 6;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		gridConst.anchor = GridBagConstraints.PAGE_START;
	
		this.add(scrollTabla,gridConst);
		
		gridConst.gridx = 5;
		gridConst.gridy = 8;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		btnCancelar = new JButton("Cancelar");
		
		this.add(btnCancelar, gridConst);
		
		gridConst.gridx = 4;
		gridConst.gridy = 8;
		gridConst.gridwidth = 1;
		gridConst.gridheight = 1 ;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		btnAgregar = new JButton("Agregar");
		this.add(btnAgregar,gridConst);
		
		agregarLibrosATabla(modeloTabla,ventana.getMateriales());	
		
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				ventana.setContentPane(new Inicio(ventana));
				ventana.pack();				
			}
		});
		
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(!txtTitulo.getText().isEmpty() && !txtCosto.getText().isEmpty() && !txtPrecioCompra.getText().isEmpty() && !txtPaginas.getText().isEmpty()  && !ID2.getText().isEmpty() && !txtFechaPublicacion.getText().isEmpty() && !txtTema.getText().isEmpty()){
					boolean IDlibre=true;
					for(MaterialCapacitacion m: ventana.getMateriales().listaMateriales()) {
						if(m.getId()==Integer.valueOf(ID2.getText())) {
							IDlibre=false;
						}
					}
					if(IDlibre) {
					Integer id = new Integer(ID2.getText());
					Double costo = new Double(txtCosto.getText());
					Double precioCompra = new Double(txtPrecioCompra.getText());
					Integer paginas = new Integer(txtPaginas.getText());
				
				
					//Formato fecha de publicacion
					Date fecha_publicacion = new Date();
					SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
					try {
						fecha_publicacion = d.parse(txtFechaPublicacion.getText());
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
				
				
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
					
					Libro libro=new Libro(id,(String) txtTitulo.getText(), costo,precioCompra,paginas,aux,fecha_publicacion,txtTema.getText().toString());
					agregarATabla(modeloTabla,libro);
					JOptionPane.showConfirmDialog(ventana, "El libro se creo exitosamente.", "Agregar Libro", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
					ventana.getMateriales().agregarLibro(libro);	
					ventana.RecargarMateriales();
					}
					else {
						JOptionPane.showConfirmDialog(ventana, "Ese ID no esta libre", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showConfirmDialog(ventana, "Faltan campos por llenar", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
				}
			}
		});		
	}
	
	
	public void agregarATabla(DefaultTableModel modelo, Libro libro) {
		Object[] obj = {libro.getTitulo(),libro.getCosto(),libro.precio(),libro.getPaginas(),libro.getCalificacion(),libro.getRelevancia(),libro.getId(),libro.getFechaPublicacion()};
		modelo.addRow(obj);
	}
	
	public void agregarLibrosATabla(DefaultTableModel modelo, MaterialCapacitacionDaoDefault materiales) {
		for(Libro e: materiales.listaLibros()) {
			agregarATabla(modelo, e);
		}
	}
}
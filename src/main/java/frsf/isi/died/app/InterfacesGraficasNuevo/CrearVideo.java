package frsf.isi.died.app.InterfacesGraficasNuevo;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import  javax.swing.*;
import javax.swing.table.DefaultTableModel;

import frsf.isi.died.app.InterfacesGraficasNuevo.Menu;
import frsf.isi.died.app.dao.MaterialCapacitacionDaoDefault;
import frsf.isi.died.tp.modelo.productos.Libro;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;
import frsf.isi.died.tp.modelo.productos.Relevancia;
import frsf.isi.died.tp.modelo.productos.Video;

public class CrearVideo extends JPanel {

	
	
	public CrearVideo(Menu ventana) {
		this.setPreferredSize(new Dimension(800,600));
		this.setVisible(true);
		this.setLayout(new GridBagLayout());
		
		
		JLabel lblTitulo;
		JTextField txtTitulo;
		JLabel lblDuracion;
		JTextField txtDuracion;
		JLabel lblCosto;
		JTextField txtCosto;
		JButton btnAgregar;
		JButton btnCancelar;
		JLabel lblRelevancia;
		JLabel lblID;
		JTextField txtID;
		JLabel lblTema;
		JTextField txtTema;
		
		
		GridBagConstraints gridConst= new GridBagConstraints();
		
		gridConst.gridx=0;
		gridConst.gridy=0;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		lblTitulo = new JLabel("Titulo");
		this.add(lblTitulo,gridConst);
		
		gridConst.gridx=1;
		gridConst.gridy=0;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 5;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		txtTitulo = new JTextField();
		this.add(txtTitulo,gridConst);
		
		gridConst.gridx=0;
		gridConst.gridy=1;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		lblDuracion = new JLabel("Duracion");
		this.add(lblDuracion, gridConst);
		
		gridConst.gridx=1;
		gridConst.gridy=1;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;

		txtDuracion = new JTextField();
		this.add(txtDuracion, gridConst);
		
		gridConst.gridx=2;
		gridConst.gridy=1;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		lblCosto = new JLabel("Costo");
		this.add(lblCosto,gridConst);
		
		
		gridConst.gridx=3;
		gridConst.gridy=1;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		txtCosto = new JTextField();
		this.add(txtCosto, gridConst);
		
		
		gridConst.gridx=4;
		gridConst.gridy=1;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		JLabel lblFechaPublicacion = new JLabel("Fecha publicacion: ");		
		this.add(lblFechaPublicacion, gridConst);
		
		
		gridConst.gridx=5;
		gridConst.gridy=1;
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
		
		lblRelevancia = new JLabel("Relevancia");
		this.add(lblRelevancia, gridConst);
		

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
		
		lblID = new JLabel("ID");
		this.add(lblID, gridConst);
		
		gridConst.gridx=3;
		gridConst.gridy=2;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		txtID = new JTextField();
		this.add(txtID, gridConst);
	
		gridConst.gridx=4;
		gridConst.gridy=2;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		lblTema = new JLabel("Tema");
		this.add(lblTema, gridConst);
		
		gridConst.gridx=5;
		gridConst.gridy=2;
		gridConst.gridheight = 1 ;
		gridConst.gridwidth = 1;
		gridConst.weightx = 1.0;
		gridConst.weighty = 1.0;
		gridConst.fill = GridBagConstraints.BOTH;
		
		txtTema = new JTextField();
		this.add(txtTema,gridConst);
		

		String[] columnas = {"Titulo","Duracion","Costo","Calificacion", "Relevancia","ID","Fecha Publicacion"};

		DefaultTableModel modeloTabla = new DefaultTableModel(null,columnas);
		
		JTable tablaVideo = new JTable(modeloTabla);
		JScrollPane scrollTabla = new JScrollPane(tablaVideo);
		gridConst.gridx = 0;
		gridConst.gridy = 3;
		gridConst.gridheight = 5 ;
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
		

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				ventana.setContentPane(new Inicio(ventana));
				ventana.pack();
			}
		});

		agregarVideosATabla(modeloTabla,ventana.getMateriales());

		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(!txtTitulo.getText().isEmpty() && !txtCosto.getText().isEmpty() &&
					!txtDuracion.getText().isEmpty()  && !txtID.getText().isEmpty() && !txtFechaPublicacion.getText().isEmpty() && !txtTema.getText().isEmpty()){
					boolean IDlibre=true;
					for(MaterialCapacitacion m: ventana.getMateriales().listaMateriales()) {
						if(m.getId()==Integer.valueOf(txtID.getText())) {
							IDlibre=false;
						}
					}
					
					if(IDlibre) {
						Integer id = new Integer(txtID.getText());
						Double costo = new Double(txtCosto.getText());
						String titulo = new String(txtTitulo.getText());
						Integer duracion = new Integer(txtDuracion.getText());
						
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
						}else {
							if(relevancia2.getSelectedIndex()==1){
								aux=Relevancia.MEDIA;
							}else {
								 aux=Relevancia.BAJA;
							}
						}
						Video video = new Video(id,titulo, costo,duracion,aux,fecha_publicacion, txtTema.getText().toString());
						JOptionPane nuevoLibro = new JOptionPane();
						agregarATabla(modeloTabla, video);
						nuevoLibro.showConfirmDialog(ventana, "El video se creo exitosamente.", "Agregar Video", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
						ventana.getMateriales().agregarVideo(video);
						ventana.RecargarMateriales();
					}else {
						//ID ocupado
						JOptionPane noEligio = new JOptionPane();
						noEligio.showConfirmDialog(ventana, "Ese ID no esta libre", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
					}
				}else {
					//campos vacios
					JOptionPane noEligio = new JOptionPane();
					noEligio.showConfirmDialog(ventana, "Faltan campos por llenar", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
				}
			
			}
		});		
	}

	public void agregarATabla(DefaultTableModel modelo, Video video) {
		Object[] obj = {video.getTitulo(),video.getDuracion(),video.getCosto(),video.getCalificacion(), video.getRelevancia(),video.getId(),video.getFechaPublicacion()};
		modelo.addRow(obj);
	}
	
	public void agregarVideosATabla(DefaultTableModel modelo,MaterialCapacitacionDaoDefault materiales) {
		for(Video e: materiales.listaVideos()) {
			agregarATabla(modelo, e);
		}
	}
}
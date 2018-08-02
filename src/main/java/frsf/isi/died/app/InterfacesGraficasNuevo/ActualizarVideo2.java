package frsf.isi.died.app.InterfacesGraficasNuevo;

import java.awt.Dimension;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import frsf.isi.died.app.dao.MaterialCapacitacionDaoDefault;
import frsf.isi.died.tp.modelo.productos.Libro;
import frsf.isi.died.tp.modelo.productos.Relevancia;
import frsf.isi.died.tp.modelo.productos.Video;

public class ActualizarVideo2 extends JPanel{
	
	
	public ActualizarVideo2(Menu ventana, Video paraActualizar){
		this.setPreferredSize(new Dimension(800,600));
		this.setVisible(true);
		this.setLayout(new GridBagLayout());
		
		
		JLabel lblTitulo;
		JTextField txtTitulo;
		JLabel lblCosto;
		JLabel lblDuracion;
		JTextField txtCosto;
		JTextField txtDuracion;
		JButton btnGuardarCambios;
		JButton btnCancelar;
		JLabel lblRelevancia;
		JLabel lblID;
		JTextField txtID;
		
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
		
		lblDuracion= new JLabel("Duracion: ");
		gridConst.gridx=0;
		gridConst.gridy=2;
		this.add(lblDuracion, gridConst);
		
		txtDuracion = new JTextField();
		txtDuracion.setColumns(5);
		gridConst.gridx=3;
		txtDuracion.setText(paraActualizar.precio().toString());
		this.add(txtDuracion, gridConst);
		
		lblRelevancia= new JLabel("Relevancia: ");
		gridConst.gridx=0;
		gridConst.gridy=3;
		this.add(lblRelevancia, gridConst);
		
		
		Object[] obj = {"ALTA","MEDIA","BAJA"};
		JComboBox relevancia2 = new JComboBox(obj);
		gridConst.gridx=1;
		gridConst.gridy=3;
		relevancia2.setSelectedItem(paraActualizar.getRelevancia());
		this.add(relevancia2,gridConst);
				
		lblID= new JLabel("ID: ");
		gridConst.gridx=0;
		gridConst.gridy=5;
		this.add(lblID, gridConst);
		
		txtID = new JTextField();
		txtID.setColumns(5);
		gridConst.gridx=3;
		txtID.setText(paraActualizar.getId().toString());
		this.add(txtID, gridConst);
		
		
		//TODO Agregar lo de la fecha
		
		btnGuardarCambios = new JButton("Guardar Cambios");
		gridConst.gridx=0;
		gridConst.gridy=6;
		this.add(btnGuardarCambios, gridConst);
		
		btnCancelar = new JButton("Cancelar");
		gridConst.gridx=1;
		gridConst.gridy=6;
		this.add(btnCancelar, gridConst);
		
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				ventana.setContentPane(new ActualizarVideo(ventana));
				ventana.pack();;
			}
		});
		
		
		btnGuardarCambios.addActionListener(new ActionListener() {
			
			//List<List<String>> nuevoContenido = new ArrayList<>();
		
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Date fecha = new Date();
				fecha = paraActualizar.getFechaPublicacion();
				
				String tema = paraActualizar.getTema();
				
				Integer idAnterior = paraActualizar.getId();
				
				
				if(!txtTitulo.getText().isEmpty() && !txtCosto.getText().isEmpty() && !txtDuracion.getText().isEmpty() && !txtID.getText().isEmpty()) {
					
					Double costo = new Double(txtCosto.getText());
					Integer duracion = new Integer(txtDuracion.getText());
					Integer id = new Integer(txtID.getText());
					
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
					
					Video nuevoVideo = new Video(id, txtTitulo.getText(), costo, duracion, aux, fecha, tema);
					ventana.getMateriales().actualizarMaterial(paraActualizar, nuevoVideo);
					ventana.setContentPane(new Inicio(ventana));
					ventana.pack();
					
					
					
					
					
				}
			}
		});
	}
}
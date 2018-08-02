package frsf.isi.died.app.InterfacesGraficasNuevo;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import frsf.isi.died.tp.modelo.productos.Video;

public class ActualizarVideo2 extends JPanel{
	
	
	public ActualizarVideo2(Menu ventana, Video video){
		this.setPreferredSize(new Dimension(800,600));
		this.setVisible(true);
		this.setLayout(new GridBagLayout());
		
		
		JLabel lblTitulo;
		JTextField txtTitulo;
		JLabel lblCosto;
		JLabel lblPrecioCompra;
		JTextField txtCosto;
		JTextField txtPrecioCompra;
		JButton btnGuardarCambios;
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
		txtTitulo.setColumns(20);
		gridConst.gridx=1;
		gridConst.gridwidth=5;
		//txtTitulo.setText(paraActualizar.getTitulo().toString());
		this.add(txtTitulo, gridConst);
		
		lblCosto= new JLabel("Costo: ");		
		gridConst.gridx=0;
		gridConst.gridy=1;
		gridConst.weightx=0.0;
		this.add(lblCosto, gridConst);
		
		txtCosto = new JTextField();
		txtCosto.setColumns(5);
		gridConst.gridx=1;
		//txtCosto.setText(paraActualizar.getCosto().toString());
		this.add(txtCosto, gridConst);
		
		lblPrecioCompra= new JLabel("Duracion: ");
		gridConst.gridx=0;
		gridConst.gridy=2;
		this.add(lblPrecioCompra, gridConst);
		
		txtPrecioCompra = new JTextField();
		txtPrecioCompra.setColumns(5);
		gridConst.gridx=3;
		//txtPrecioCompra.setText(paraActualizar.precio().toString());
		//TODO no se bien que es este precio VER
		this.add(txtPrecioCompra, gridConst);
		
		lblRelevancia= new JLabel("Relevancia: ");
		gridConst.gridx=0;
		gridConst.gridy=3;
		this.add(lblRelevancia, gridConst);
		
		/*txtRelevancia = new JTextField();
		txtRelevancia.setColumns(5);
		gridConst.gridx=3;
		this.add(txtRelevancia, gridConst);*/
		Object[] obj = {"ALTA","MEDIA","BAJA"};
		JComboBox relevancia2 = new JComboBox(obj);
		gridConst.gridx=1;
		gridConst.gridy=5;
		//relevancia2.setSelectedItem(paraActualizar.getRelevancia());
		this.add(relevancia2,gridConst);
				
		lblID= new JLabel("ID: ");
		gridConst.gridx=0;
		gridConst.gridy=5;
		this.add(lblID, gridConst);
		
		txtID = new JTextField();
		txtID.setColumns(5);
		gridConst.gridx=3;
		//txtID.setText(paraActualizar.getId().toString());
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
			@Override
			public void actionPerformed(ActionEvent e) {
				//if() 
				{
					Video nuevoVideo = new Video();
					//TODO cuando tengamos lo de la fecha, hay que crear el video con sus atrubitos
					//tambien hay que agregarlo a la lista de materialesCapacitacion
					//y eliminar el del ID que sacamos en la ventana anterior (IDParaEliminar)
				}
			}
		});
	}
}
package frsf.isi.died.app.interfacesGraficas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class ActualizarVideo2 {
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ActualizarVideo2 a = new ActualizarVideo2();
				}
			});
	}
	
	
	public ActualizarVideo2(){
		JFrame crearV = new JFrame("Actualizar Video");
		crearV.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		crearV.pack();
		crearV.setSize(800,600);
		crearV.setVisible(true);
		JPanel panel = new JPanel();
		crearV.setContentPane(panel);
		panel.setLayout(new GridBagLayout());
		
		
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
		
		lblPrecioCompra= new JLabel("Duracion: ");
		gridConst.gridx=0;
		gridConst.gridy=2;
		panel.add(lblPrecioCompra, gridConst);
		
		txtPrecioCompra = new JTextField();
		txtPrecioCompra.setColumns(5);
		gridConst.gridx=3;
		panel.add(txtPrecioCompra, gridConst);
		
		lblRelevancia= new JLabel("Relevancia: ");
		gridConst.gridx=0;
		gridConst.gridy=3;
		panel.add(lblRelevancia, gridConst);
		
		txtRelevancia = new JTextField();
		txtRelevancia.setColumns(5);
		gridConst.gridx=3;
		panel.add(txtRelevancia, gridConst);
				
		lblID= new JLabel("ID: ");
		gridConst.gridx=0;
		gridConst.gridy=5;
		panel.add(lblID, gridConst);
		
		txtID = new JTextField();
		txtID.setColumns(5);
		gridConst.gridx=3;
		panel.add(txtID, gridConst);
		
		btnGuardarCambios = new JButton("Guardar Cambios");
		gridConst.gridx=0;
		gridConst.gridy=6;
		panel.add(btnGuardarCambios, gridConst);
		
		btnCancelar = new JButton("Cancelar");
		gridConst.gridx=1;
		gridConst.gridy=6;
		panel.add(btnCancelar, gridConst);
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				ActualizarVideo v1 = new ActualizarVideo();
				crearV.dispose();
			}
		});
	}
}
package frsf.isi.died.app.InterfacesGraficasNuevo;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;

public class BuscarArbolN extends JPanel{
	
	public BuscarArbolN() {
		
	}
	
	public BuscarArbolN(Menu ventana, MaterialCapacitacion material) {
		
		this.setPreferredSize(new Dimension(800,600));
		this.setVisible(true);
		this.setLayout(null);
				
		
		JButton atras = new JButton("Atras");
		JButton modificar = new JButton("Modificar material");
				
		
		atras.setBounds(620, 510, 150, 40);
		modificar.setBounds(450, 510, 150, 40);
				
		
		this.add(modificar);
		this.add(atras);
		
		
		atras.addActionListener(e->volverAtras(ventana));
		modificar.addActionListener(e->modificarMaterial(ventana,material));
		
		
	}
	
	public void volverAtras(Menu ventana) {
		ventana.setContentPane(new BuscarMaterial(ventana));
		ventana.pack();
	}
	
	public void modificarMaterial(Menu ventana, MaterialCapacitacion material) {
		ventana.setContentPane(new ModificarMaterialArbolN(ventana,material));
		ventana.pack();
	}

}

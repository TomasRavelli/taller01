package frsf.isi.died.app.InterfacesGraficasNuevo;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import frsf.isi.died.tp.estructuras.TipoNodo;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;

public class ModificarMaterialArbolN extends JPanel{

	public ModificarMaterialArbolN() {
		
	}
	
	public ModificarMaterialArbolN(Menu ventana, MaterialCapacitacion material) {
		
		this.setPreferredSize(new Dimension(800,600));
		this.setVisible(true);
		this.setLayout(null);
		
		
		JLabel nodoPadre = new JLabel("Seleccionar Nodo Padre:");
		JLabel tipoNodo = new JLabel("Tipo Nodo:");
		Object[] obj = {TipoNodo.TITULO, TipoNodo.METADATO, TipoNodo.AUTOR, TipoNodo.SECCION, TipoNodo.PARRAFO, TipoNodo.CAPITULO, TipoNodo.EDITORIAL, TipoNodo.RESUMEN, TipoNodo.PALABRA_CLAVE};
		JComboBox enumeration = new JComboBox(obj);
		JTree arbolNario;
		JButton atras = new JButton("Atras");
		JButton buscar = new JButton("Buscar");
			
		
		nodoPadre.setBounds(10,40,200,20);
		tipoNodo.setBounds(10,10,200,20);
		enumeration.setBounds(200,10,200,20);
		atras.setBounds(620, 510, 150, 40);
		buscar.setBounds(450, 510, 150, 40);
		
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(material.getArbol().getValor().tipoNodo + ": " + material.getArbol().getValor().getValor()); 
	
		arbolNario = new JTree(node);
		arbolNario.setBounds(10,70,500,300);
		this.add(arbolNario);
		
		
		this.add(nodoPadre);
		this.add(tipoNodo);
		this.add(enumeration);
		this.add(atras);
		this.add(buscar);
		

		buscar.addActionListener(e->buscarArbolN(ventana,material));
		atras.addActionListener(e->volverAtras(ventana));
		arbolNario.addTreeSelectionListener(e->agregarHijo(ventana,(DefaultMutableTreeNode)arbolNario.getLastSelectedPathComponent()));
		
	}
	
	
	public void volverAtras(Menu ventana) {
		ventana.setContentPane(new BuscarMaterial(ventana));
		ventana.pack();
	}
	
	
	public void buscarArbolN (Menu ventana,MaterialCapacitacion material) {
		ventana.setContentPane(new BuscarArbolN(ventana,material));
		ventana.pack();
	}
	
	private	void agregarHijo(Menu ventana, DefaultMutableTreeNode nodoSeleccionado)	{
		
	}
	
}
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

import frsf.isi.died.tp.estructuras.ArbolNario;
import frsf.isi.died.tp.estructuras.Nodo;
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
		JButton agregar = new JButton("Agregar");
		
		nodoPadre.setBounds(10,40,200,20);
		tipoNodo.setBounds(10,10,200,20);
		enumeration.setBounds(200,10,200,20);
		atras.setBounds(620, 510, 150, 40);
		buscar.setBounds(450, 510, 150, 40);
		agregar.setBounds(280,510,150,40);
			
		
		//MOSTRAR ARBOL
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(material.getArbol().getValor().tipoNodo + ": " + material.getArbol().getValor().getValor()); 
		arbolNario = new JTree(node);
		arbolNario.setBounds(10,70,500,300);
		this.add(arbolNario);
		
		
		this.add(nodoPadre);
		this.add(tipoNodo);
		this.add(enumeration);
		this.add(atras);
		this.add(buscar);
		this.add(agregar);
		

		buscar.addActionListener(e->buscarArbolN(ventana,material));
		atras.addActionListener(e->volverAtras(ventana));
		agregar.addActionListener(e->agregarHijo(ventana,(DefaultMutableTreeNode)arbolNario.getLastSelectedPathComponent(),enumeration.getSelectedItem()));
		
	}
	
	
	public void volverAtras(Menu ventana) {
		ventana.setContentPane(new BuscarMaterial(ventana));
		ventana.pack();
	}
	
	
	public void buscarArbolN (Menu ventana,MaterialCapacitacion material) {
		ventana.setContentPane(new BuscarArbolN(ventana,material));
		ventana.pack();
	}
	
	private	void agregarHijo(Menu ventana, DefaultMutableTreeNode nodoSeleccionado, Object tipoNodo){
		
		Nodo paraAgregar = new Nodo();
		paraAgregar.setTipoNodo((TipoNodo)tipoNodo);
		ArbolNario arbol;
		
		for (MaterialCapacitacion m : ventana.getMateriales().listaMateriales()) {
			arbol = m.getArbol();
			buscarEnArbol(arbol,nodoSeleccionado,paraAgregar);
		}
		
	}
	
	
	private void buscarEnArbol (ArbolNario arbol, DefaultMutableTreeNode nodoSeleccionado, Nodo paraAgregar) {
		
		//VER ESTO
		if (arbol.getValor().getValor().equals(nodoSeleccionado)) {
			//TERMINA
		}
		else {
			//BUSCA EN LAS LISTAS DE NODOS
		}
		
	}
	
}
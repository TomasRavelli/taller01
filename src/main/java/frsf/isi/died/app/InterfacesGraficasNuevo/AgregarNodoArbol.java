package frsf.isi.died.app.InterfacesGraficasNuevo;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import frsf.isi.died.tp.estructuras.ArbolNario;
import frsf.isi.died.tp.estructuras.Nodo;
import frsf.isi.died.tp.estructuras.TipoNodo;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;

public class AgregarNodoArbol extends JPanel{

	MaterialCapacitacion mat;
	
	public AgregarNodoArbol() {
		
	}
	
	public AgregarNodoArbol(Menu ventana, MaterialCapacitacion material) {
		
		this.setPreferredSize(new Dimension(800,600));
		this.setVisible(true);
		this.setLayout(null);
		
		mat = material;
		
		JScrollPane scroll;
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
		
		 
		//arbolNario = new JTree(dibujarArbol(mat.getArbol().getRaiz(), mat.getArbol().getRaiz()));
		arbolNario = new JTree(mat.getArbol().getRaiz());
		//arbolNario.setBounds(10,70,700,400);
		//Fuente: https://code.i-harness.com/es/q/e819e3
		for (int i = 0; i < arbolNario.getRowCount(); i++) {
		    arbolNario.expandRow(i);
		}
		scroll = new JScrollPane(arbolNario);
		scroll.setBounds(10,70,700,400);
		this.add(scroll);
		
		this.add(nodoPadre);
		this.add(tipoNodo);
		this.add(enumeration);
		this.add(atras);
		this.add(buscar);
		this.add(agregar);
		

		buscar.addActionListener(e->buscarArbolN(ventana,material));
		atras.addActionListener(e->volverAtras(ventana));
		agregar.addActionListener(e->agregarHijo(ventana,(Nodo)arbolNario.getLastSelectedPathComponent(),enumeration.getSelectedItem(),arbolNario));
		
	}
	
	public void volverAtras(Menu ventana) {
		ventana.setContentPane(new BuscarMaterial(ventana));
		ventana.pack();
	}
	
	
	public void buscarArbolN (Menu ventana,MaterialCapacitacion material) {
		ventana.setContentPane(new BuscarArbolN(ventana,material));
		ventana.pack();
	}
	
	private	void agregarHijo(Menu ventana, Nodo nodoSeleccionado, Object tipoNodo, JTree arbolNario){
		JOptionPane escribirValor = new JOptionPane();
		String valorTN = escribirValor.showInputDialog("Ingrese valor:");
		Nodo paraAgregar = new Nodo((TipoNodo)tipoNodo,valorTN);
		nodoSeleccionado.add(paraAgregar);
		nodoSeleccionado.addHijo(paraAgregar);
		arbolNario.updateUI();

		//Fuente: https://code.i-harness.com/es/q/e819e3
		for (int i = 0; i < arbolNario.getRowCount(); i++) {
		    arbolNario.expandRow(i);
		}
	
		
		/*ArbolNario arbol;
		arbol = mat.getArbol();
		agregarAArbol(arbol,nodoSeleccionado,paraAgregar);*/
		
	}
	
	
	private void agregarAArbol (ArbolNario arbol, Nodo nodoSeleccionado, Nodo paraAgregar) {
		
		//VER ESTO
		if (arbol.getRaiz().getValor().equals(nodoSeleccionado)) {
			//TERMINA
		}
		else {
			//BUSCA EN LAS LISTAS DE NODOS
		}
		
	}
	
/*	private Nodo dibujarArbol(Nodo padre) {
		for(Nodo aux: padre.getHijos()) {
			Nodo aux2 = new Nodo(padre.tipoNodo+": "+padre.getValor());
			padre.add(aux2);
			dibujarArbol(aux2);
		}
		
		return padre;
	}*/
}
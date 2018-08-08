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
		
		mat = material;
		
		this.setPreferredSize(new Dimension(800,600));
		this.setVisible(true);
		this.setLayout(null);

		
		JScrollPane scroll;
		JLabel nodoPadre = new JLabel("Seleccionar Nodo Padre:");
		JLabel tipoNodo = new JLabel("Tipo Nodo:");
		Object[] obj = {TipoNodo.TITULO, TipoNodo.METADATO, TipoNodo.AUTOR, TipoNodo.SECCION, TipoNodo.PARRAFO, TipoNodo.CAPITULO, TipoNodo.EDITORIAL, TipoNodo.RESUMEN, TipoNodo.PALABRA_CLAVE};
		JComboBox enumeration = new JComboBox(obj);
		JTree arbolNario;
		JButton atras = new JButton("Atras");
		JButton buscar = new JButton("Ir a Buscar");
		JButton agregar = new JButton("Agregar");
		JLabel lblValor = new JLabel("Ingrese valor del nodo: ");
		JTextField txtValor = new JTextField();
		nodoPadre.setBounds(10,70,200,20);
		tipoNodo.setBounds(10,10,200,20);
		enumeration.setBounds(200,10,200,20);
		atras.setBounds(620, 510, 150, 40);
		buscar.setBounds(450, 510, 150, 40);
		agregar.setBounds(280,510,150,40);
		lblValor.setBounds(10, 40, 200, 20);
		txtValor.setBounds(200,40,200,20);
		
		//MOSTRAR ARBOL
		
		 
		//arbolNario = new JTree(dibujarArbol(mat.getArbol().getRaiz(), mat.getArbol().getRaiz()));
		arbolNario = new JTree(mat.getArbol().getRaiz());
		//arbolNario.setBounds(10,70,700,400);
		//Fuente: https://code.i-harness.com/es/q/e819e3
		for (int i = 0; i < arbolNario.getRowCount(); i++) {
		    arbolNario.expandRow(i);
		}
		
		scroll = new JScrollPane(arbolNario);
		scroll.setBounds(10,100,700,400);
		this.add(scroll);
		this.add(lblValor);
		this.add(txtValor);
		this.add(nodoPadre);
		this.add(tipoNodo);
		this.add(enumeration);
		this.add(atras);
		this.add(buscar);
		this.add(agregar);
		

		buscar.addActionListener(e->buscarArbolN(ventana,material));
		atras.addActionListener(e->volverAtras(ventana));
		agregar.addActionListener(e->agregarHijo(ventana,txtValor.getText(),(Nodo)arbolNario.getLastSelectedPathComponent(), enumeration.getSelectedItem(),arbolNario));
		
	}
	
	public void volverAtras(Menu ventana) {
		ventana.setContentPane(new BuscarMaterial(ventana));
		ventana.pack();
	}
	
	
	public void buscarArbolN (Menu ventana,MaterialCapacitacion material) {
		ventana.setContentPane(new BuscarArbolN(ventana,material));
		ventana.pack();
	}
	

	private	void agregarHijo(Menu ventana, String valor, Nodo nodoSeleccionado, Object tipoNodo, JTree arbolNario){
		Boolean tipoNValido;
		TipoNodo tipoSeleccionado = (TipoNodo) tipoNodo;
		JOptionPane msgVentana = new JOptionPane();
		if(!tipoSeleccionado.name().equals("TITULO")) {
	
			switch(nodoSeleccionado.tipoNodo) {
			
			case TITULO:{
				if(hacerValidacionesTitulo(tipoSeleccionado, nodoSeleccionado)){
				tipoNValido = true;
				}
				else {
				tipoNValido = false;
				}
				break;
			}
			case METADATO:{
				if(hacerValidacionesMetadato(tipoSeleccionado, nodoSeleccionado)){
					tipoNValido = true;
				}
				else {
					tipoNValido = false;
				}
				break;
			}
			case AUTOR:{
			
				tipoNValido = false;
			
				break;
			}
			case SECCION:{
				if(hacerValidacionesSeccion(tipoSeleccionado)) {
					tipoNValido = true;
				}
				else {
				tipoNValido = false;
				}
				break;
			}
			case PARRAFO:{
				tipoNValido = false;			
				break;
			}
			case CAPITULO:{
				if(hacerValidacionesCapitulo(tipoSeleccionado, nodoSeleccionado)){
					tipoNValido = true;
				}
				else {
					tipoNValido = false;
				}
				break;
			}
			case EDITORIAL:{
				tipoNValido = false;
				break;
			}
			case RESUMEN:{
				if(hacerValidacionesResumen(tipoSeleccionado)) {
					tipoNValido=true;
				}
				else {
					tipoNValido = false;
				}
				break;
			}
			case PALABRA_CLAVE:{
				tipoNValido = false;
				break;
			}
			default:{
				tipoNValido = false;
				break;
			}
		}	
	}
		else{
			tipoNValido = false;
		}
		
		if(tipoNValido) {
				
				if(valor.isEmpty()) {
					valor = null;
				}
				Nodo paraAgregar = new Nodo((TipoNodo)tipoNodo,valor);
				nodoSeleccionado.add(paraAgregar);
				nodoSeleccionado.addHijo(paraAgregar);
				arbolNario.updateUI();

				//Fuente: https://code.i-harness.com/es/q/e819e3
				for (int i = 0; i < arbolNario.getRowCount(); i++) {
				arbolNario.expandRow(i);
				}
		}	
						
				
		else {
			JOptionPane.showMessageDialog(this,"TipoNodo no valido", "Error", msgVentana.ERROR_MESSAGE);	
		}
	
}
		
	
	private Boolean hacerValidacionesTitulo(TipoNodo tipoSeleccionado, Nodo nPadre) {
		Boolean valido = true;
		switch(tipoSeleccionado) {
		case METADATO:{
			for(Nodo n: nPadre.getHijos()) {
				if(n.tipoNodo.name().equals("METADATO")) {
					valido = false;
				}
			}
			break;
			}
		case RESUMEN:{
			for(Nodo n: nPadre.getHijos()) {
				if(n.tipoNodo.name().equals("RESUMEN")) {
					valido = false;
				}
			
			
			}
			break;
			}
		case CAPITULO:{
			/*for(Nodo n: nPadre.getHijos()) {
				if(n.tipoNodo.name().equals("CAPITULO")) {
					valido = false;
				}
				else {
					valido = true;
				}
				
			}*/
			valido = true;	
			break;
		}
		
		default:{
			valido = false;
			break;
		}
	}
	
	return valido;
	}
	
	
	private Boolean hacerValidacionesMetadato(TipoNodo tipoSeleccionado, Nodo nPadre){
		Boolean valido = true;
		System.out.println(valido);
		//switch(nPadreMetadato.tipoNodo) {
		//case TITULO:{
			switch(tipoSeleccionado) {
			case AUTOR:{
				valido = true;
				System.out.println(valido);
				break;
			}
			case EDITORIAL:{
				for(Nodo n: nPadre.getHijos()) {
					if(n.tipoNodo.name().equals("EDITORIAL")) {
						valido = false;
					}
				}
				System.out.println(valido);
				break;
			}
			case PALABRA_CLAVE:{
				for(Nodo n: nPadre.getHijos()) {
					if(n.tipoNodo.name().equals("PALABRA_CLAVE")) {
						valido = false;
					}
				}
				System.out.println(valido);
				break;
			}
			default:{
				valido = false;
				System.out.println(valido);
				break;
			}
		}
	
	
		System.out.println(valido);
		return valido;
	}	
	
	/*private Boolean hacerValidacionesAutor(TipoNodo tipoSeleccionado, Nodo nPadre) {
		Boolean valido = false;
		return valido;
	}*/
	private Boolean hacerValidacionesSeccion(TipoNodo tipoSeleccionado){
		Boolean valido = true;
		
		switch(tipoSeleccionado) {
		case PARRAFO:{
			valido = true;
			break;
		}
		default:{
			valido = false;
			break;
		}
	}
		return valido;
}
	/*private Boolean hacerValidacionesParrafo(TipoNodo tipoSeleccionado){
		Boolean valido = false;
		return valido;
	}*/
	private Boolean hacerValidacionesCapitulo(TipoNodo tipoSeleccionado, Nodo nPadre){
		Boolean valido = true;
		switch(tipoSeleccionado) {
		case SECCION:{
			valido = true;
			break;
		}
		case METADATO:{
			for(Nodo n: nPadre.getHijos()) {
				if(n.tipoNodo.name().equals("METADATO")) {
					valido = false;
				}
					
			}
		break;
		}
		/*	case SITIO_WEB_REALACIONADO:{
		 * 	valido = true;	
		 * 	break;
		 * }
		 * case SITIO_WEB_EJERCICIOS:{
		 * 	valido = true;
		 * 	break;
		 * }
		 */
		default:{
			valido = false;
			System.out.println(valido);
			break;
		}
		}
		
		return valido;
	}
	
	/*private Boolean hacerValidacionesEditorial(TipoNodo tipoSeleccionado){
		Boolean valido = false;
		return valido;
	}*/
	
	private Boolean hacerValidacionesResumen(TipoNodo tipoSeleccionado){
		Boolean valido = true;
		switch(tipoSeleccionado) {
		case PARRAFO:{
			valido = true;
			break;
		}
		default:{
			valido = false;
			break;
		}
		}
		return valido;
	}
	
	/*private Boolean hacerValidacionesPalabraClave(TipoNodo tipoSeleccionado){
		Boolean valido = false;
		return valido;
	}
	*/
}


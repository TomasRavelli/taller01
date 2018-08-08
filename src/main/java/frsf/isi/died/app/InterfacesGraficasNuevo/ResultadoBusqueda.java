package frsf.isi.died.app.InterfacesGraficasNuevo;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import frsf.isi.died.tp.estructuras.Nodo;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;

public class ResultadoBusqueda extends JPanel{
	
	String[] columnas = {"ID","Titulo"};
	DefaultTableModel modeloTabla = new DefaultTableModel(null,columnas);
	JTable tabla = new JTable(modeloTabla);
	JScrollPane scrollTabla = new JScrollPane(tabla);
	
	public ResultadoBusqueda () {
		
	}
	
	public ResultadoBusqueda (Menu ventana, List<Nodo> condiciones, MaterialCapacitacion material) {
		
		List <MaterialCapacitacion> listaResultado = encontrar(ventana,condiciones);
		
		this.setPreferredSize(new Dimension(800,600));
		this.setVisible(true);
		this.setLayout(null);
		
		JLabel resultado = new JLabel ("Resultados de busqueda:");
		resultado.setBounds(20,20,500,30);
		this.add(resultado);
		
		scrollTabla.setBounds(20,70,600,350);
		this.add(scrollTabla);
		
		JButton atras = new JButton("Atras");
		atras.setBounds(620, 510, 150, 40);
		this.add(atras);
		
		for (MaterialCapacitacion m : listaResultado) {
			Object[] obj = {m.getId(),m.getTitulo()};
			modeloTabla.addRow(obj);
		}
		
		atras.addActionListener(e->volverAtras(ventana,material));
	}
	
	
	public void volverAtras(Menu ventana, MaterialCapacitacion material) {
		ventana.setContentPane(new BuscarArbolN(ventana,material));
		ventana.pack();
	}
	
	
	private List<MaterialCapacitacion> encontrar (Menu ventana, List<Nodo> condiciones){
		
		List<MaterialCapacitacion> aux = ventana.getMateriales().listaMateriales();
		for (Nodo nodo : condiciones) {
			aux = encontrar2(nodo,aux);
		}
		return aux;
	}
	
	
	private List<MaterialCapacitacion> encontrar2 (Nodo nodo, List<MaterialCapacitacion> aux){
		
		List<MaterialCapacitacion> retorno = new ArrayList<>();
		for (MaterialCapacitacion m : aux) {
			if ((m.getArbol().getRaiz().tipoNodo.equals(nodo.tipoNodo)) && (m.getArbol().getRaiz().getValor().contains(nodo.getValor()))) {
				retorno.add(m);
			}
			else {
				if (encontrar3(nodo,m.getArbol().getRaiz().getHijos())) {
					retorno.add(m);
				}
			}
		}
		return retorno;
	}
	
	
	private Boolean encontrar3 (Nodo nodo, List<Nodo> aux){
		
		for (Nodo n : aux) {
			if (nodo.tipoNodo.equals(n.tipoNodo) && n.getValor().contains(nodo.getValor())) {
				return true;
			}
		}
		
		for (Nodo n : aux) {
			return encontrar3(nodo,n.getHijos());
		}
		return false;
	}
}
package frsf.isi.died.app.InterfacesGraficasNuevo;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ResultadoBusqueda extends JPanel{
	
	String[] columnas = {"Tipo de nodo","Valor"};
	DefaultTableModel modeloTabla = new DefaultTableModel(null,columnas);
	JTable tabla = new JTable(modeloTabla);
	JScrollPane scrollTabla = new JScrollPane(tabla);
	
	public ResultadoBusqueda () {
		
	}
	
	public ResultadoBusqueda (Menu ventana) {
		
		this.setPreferredSize(new Dimension(800,600));
		this.setVisible(true);
		this.setLayout(null);
		
		JLabel resultado = new JLabel ("Resultados de busqueda:");
		resultado.setBounds(20,20,500,30);
		this.add(resultado);
		
		scrollTabla.setBounds(20,70,600,350);
		this.add(scrollTabla);
		
	}
}
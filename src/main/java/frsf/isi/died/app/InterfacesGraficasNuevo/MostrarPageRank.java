package frsf.isi.died.app.InterfacesGraficasNuevo;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import frsf.isi.died.app.dao.MaterialCapacitacionDaoDefault;
import frsf.isi.died.tp.estructuras.Arista;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;
import java.util.*;

public class MostrarPageRank extends JPanel{
	
	private final Double d = 0.85;
	private DefaultTableModel modeloTablaPR;
	private JTable tablaPR;
	
	public MostrarPageRank() {
		
	}
	
	public MostrarPageRank(MaterialCapacitacionDaoDefault materiales,List<MaterialCapacitacion> nodos) {
		String[] columnasLibro = {"ID","Titulo"};
		modeloTablaPR = new DefaultTableModel(null,columnasLibro);
	    tablaPR = new JTable(modeloTablaPR);
		JScrollPane scrollTablaPR = new JScrollPane(tablaPR);	
		scrollTablaPR.setBorder(javax.swing.BorderFactory.createTitledBorder("Page Rank"));
		this.add(scrollTablaPR );
		agregarPRaTabla(modeloTablaPR, calcularPR(materiales, nodos));
	}
	
	
	public List<MaterialCapacitacion> calcularPR(MaterialCapacitacionDaoDefault materiales,List<MaterialCapacitacion> nodos){
	
		Boolean diferencia = true;
		List<MaterialCapacitacion> resultado = new ArrayList<>();
		materiales.actualizarPR();
		
		while(diferencia) {
			for(MaterialCapacitacion m: nodos) {
				Double sumatoria = 0.0;
				
				for(MaterialCapacitacion nE: nodosEntrantes(materiales,m)) {					
					sumatoria += nE.getPR()/materiales.gradoSalida(nE);
				}
				
				sumatoria = (1-d)+d*sumatoria;
				if((Math.abs(m.getPR()-sumatoria))<=0.000000001) {
					resultado.remove(m);
					m.setPR(sumatoria);
					resultado.add(m);
				}
				else {
					m.setPR(sumatoria);
				}
			}
			if(resultado.size() == nodos.size()) {
				diferencia = false;
			}	
		}
	
		resultado.sort((n1,n2) -> Double.compare(n2.getPR(),n1.getPR()));
		return resultado;
	}
	
	
	public void agregarPRaTabla( DefaultTableModel modelo, List<MaterialCapacitacion> nodos){
		for(MaterialCapacitacion m: nodos) {
			Object[] aux = {m.getId().toString(),m.getTitulo()};
			modelo.addRow(aux);
		}
	}
	
	
	private List<MaterialCapacitacion> nodosEntrantes(MaterialCapacitacionDaoDefault mat, MaterialCapacitacion nodoActual){
		List<MaterialCapacitacion> resultado = new ArrayList<>();
		for(Arista<MaterialCapacitacion> a: mat.getAristas()) {
			if(a.getFin().getValor().equals(nodoActual)) {
				resultado.add(a.getInicio().getValor());
			}			
		}
		return resultado;
	}
}
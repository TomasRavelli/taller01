package frsf.isi.died.app.InterfacesGraficasNuevo;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;

import frsf.isi.died.app.controller.GrafoController;
import frsf.isi.died.app.grafo.ControlPanel;
import frsf.isi.died.app.grafo.GrafoPanel;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;

public class MuestraNodos extends JPanel{
	
public MuestraNodos(){
		
	}
	
	public MuestraNodos(Menu ventana, List<MaterialCapacitacion> vertices, List<MaterialCapacitacion> encontrados){
		
		this.setLayout(new BorderLayout());
		ControlPanel controlPanel = new ControlPanel();
		GrafoPanel grafoPanel = new GrafoPanel();
		GrafoController grfController = new GrafoController(grafoPanel,controlPanel, ventana, vertices,encontrados);
		this.add(controlPanel , BorderLayout.PAGE_START);
		this.add(grafoPanel , BorderLayout.CENTER);
	}

}

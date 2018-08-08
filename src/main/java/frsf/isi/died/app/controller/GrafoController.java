package frsf.isi.died.app.controller;

import java.awt.Color;
import java.util.List;
import frsf.isi.died.app.InterfacesGraficasNuevo.Menu;
import frsf.isi.died.app.dao.MaterialCapacitacionDao;
import frsf.isi.died.app.grafo.AristaView;
import frsf.isi.died.app.grafo.ControlPanel;
import frsf.isi.died.app.grafo.GrafoPanel;
import frsf.isi.died.app.grafo.VerticeView;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;

public class GrafoController {

	private GrafoPanel vistaGrafo;
	private ControlPanel vistaControl;
	private MaterialCapacitacionDao materialDao;
	private List<MaterialCapacitacion> vertices;
	
	public GrafoController(GrafoPanel panelGrf, ControlPanel panelCtrl, Menu ventana, List<MaterialCapacitacion> vert,List<MaterialCapacitacion> encontrados) {
		this.vistaGrafo = panelGrf;
		this.vistaGrafo.setController(this);
		this.vistaControl = panelCtrl;
		this.vistaControl.setController(this);
		this.materialDao = ventana.getMateriales();
		this.vertices = vert;
		this.vistaControl.armarPanel(vertices, ventana, encontrados);
	}


	public void crearVertice(Integer coordenadaX, Integer coordenadaY, Color color, MaterialCapacitacion mc) {
		VerticeView v = new VerticeView(coordenadaX, coordenadaY, color);
		v.setId(mc.getId());
		v.setNombre(mc.getTitulo());
		this.vistaGrafo.agregar(v);
		this.vistaGrafo.repaint();
	}

	public void crearArista(AristaView arista) {
		this.materialDao.crearCamino(arista.getOrigen().getId(), arista.getDestino().getId());
		this.vistaGrafo.agregar(arista);
		this.vistaGrafo.repaint();
	}

	public void buscarCamino(Integer nodo1, Integer nodo2, Integer saltos) {
		List<MaterialCapacitacion> camino = this.materialDao.buscarCamino(nodo1, nodo2, saltos);
		this.vistaGrafo.caminoPintar(camino);
		this.vistaGrafo.repaint();
	}
	
	public void buscarCamino(Integer nodo1, Integer nodo2) {
		List<MaterialCapacitacion> camino = this.materialDao.buscarCamino(nodo1, nodo2);
		this.vistaGrafo.caminoPintar(camino);
		this.vistaGrafo.repaint();
		
	}

	public List<MaterialCapacitacion> listaVertices() {
		return this.vertices;
	}
}

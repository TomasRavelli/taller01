package frsf.isi.died.app.dao;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import frsf.isi.died.app.InterfacesGraficasNuevo.Menu;
import frsf.isi.died.app.csv.CsvDatasource;
import frsf.isi.died.tp.estructuras.Arista;
import frsf.isi.died.tp.estructuras.Grafo;
import frsf.isi.died.tp.modelo.Biblioteca;
import frsf.isi.died.tp.modelo.BibliotecaABB;
import frsf.isi.died.tp.modelo.productos.Libro;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;
import frsf.isi.died.tp.modelo.productos.Video;

public class MaterialCapacitacionDaoDefault implements MaterialCapacitacionDao{

	private static Grafo<MaterialCapacitacion> GRAFO_MATERIAL = new Grafo<MaterialCapacitacion>();
	private static Biblioteca biblioteca = new BibliotecaABB();
	
	private CsvDatasource dataSource;
	
	public MaterialCapacitacionDaoDefault() {
		dataSource = new CsvDatasource();
		//if(GRAFO_MATERIAL.esVacio()) {
			borrar();
			cargarGrafo();
		//}
	}
	

	private void borrar() {
		for(MaterialCapacitacion v : GRAFO_MATERIAL.listaVertices()) {
			GRAFO_MATERIAL.deleteNodo(v);
		}
	}
	
	
	private void cargarGrafo() {
	
		List<List<String>> libros = dataSource.readFile("libros.csv");
		for(List<String> filaLibro : libros) {
			Libro aux = new Libro();
			aux.loadFromStringRow(filaLibro);
			GRAFO_MATERIAL.addNodo(aux);
		}
		List<List<String>> videos= dataSource.readFile("videos.csv");
		for(List<String> filaVideo: videos) {
			Video aux = new Video();
			aux.loadFromStringRow(filaVideo);
			GRAFO_MATERIAL.addNodo(aux);
		}
		List<List<String>> aristas= dataSource.readFile("aristas.csv");
		for(List<String> filaArista: aristas) {
			MaterialCapacitacion n1 = this.findById(Integer.valueOf(filaArista.get(0)));
			MaterialCapacitacion n2 = this.findById(Integer.valueOf(filaArista.get(2)));
			GRAFO_MATERIAL.conectar(n1, n2);
		}	
 	}
	
	
	@Override
	public void agregarLibro(Libro mat) {
		GRAFO_MATERIAL.addNodo(mat);	
		biblioteca.agregar(mat);
		try {
			dataSource.agregarFilaAlFinal("libros.csv", mat.asCsvRow());
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void borrarMaterial(MaterialCapacitacion param) {
		GRAFO_MATERIAL.deleteNodo(param);
	}
	
	
	public void actualizarMaterial(MaterialCapacitacion viejo, MaterialCapacitacion nuevo) {
		GRAFO_MATERIAL.updateNodo(viejo, nuevo);
	}
	

	@Override
	public void agregarVideo(Video mat) {
		GRAFO_MATERIAL.addNodo(mat);				
		biblioteca.agregar(mat);
		try {
			dataSource.agregarFilaAlFinal("videos.csv", mat.asCsvRow());
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public List<Libro> listaLibros() {
		List<Libro> libros = new ArrayList<>();
		for(MaterialCapacitacion mat : GRAFO_MATERIAL.listaVertices()) {
			if(mat.esLibro()) libros.add((Libro)mat); 
		}
		return libros;
	}
	

	@Override
	public List<Video> listaVideos() {
		List<Video> vids = new ArrayList<>();
		for(MaterialCapacitacion mat : GRAFO_MATERIAL.listaVertices()) {
			if(mat.esVideo()) vids.add((Video)mat); 
		}
		return vids;
	}
	

	@Override
	public List<MaterialCapacitacion> listaMateriales() {
		return GRAFO_MATERIAL.listaVertices();
	}
	

	@Override
	public MaterialCapacitacion findById(Integer id) {
		for(MaterialCapacitacion mat : GRAFO_MATERIAL.listaVertices()) {
			if(mat.getId().equals(id)) return mat;
		}
		return null;
	}
	

	@Override
	public List<MaterialCapacitacion> buscarCamino(Integer idOrigen, Integer idDestino, Integer saltos) {
		MaterialCapacitacion n1 = this.findById(idOrigen);
		MaterialCapacitacion n2 = this.findById(idDestino);
		return GRAFO_MATERIAL.buscarCaminoNSaltos(n1, n2, saltos);
	}
	
	
	public List<MaterialCapacitacion> buscarCamino(Integer idOrigen, Integer idDestino) {
		MaterialCapacitacion n1 = this.findById(idOrigen);
		MaterialCapacitacion n2 = this.findById(idDestino);
		return GRAFO_MATERIAL.buscarCamino(n1, n2);
	}
	

	@Override
	public void crearCamino(Integer idOrigen, Integer idDestino) {
		MaterialCapacitacion n1 = this.findById(idOrigen);
		MaterialCapacitacion n2 = this.findById(idDestino);
		Arista<MaterialCapacitacion> auxiliar = new Arista<>(GRAFO_MATERIAL.getNodo(n1), GRAFO_MATERIAL.getNodo(n2));
		
		if(!GRAFO_MATERIAL.getAristas().contains(auxiliar)) {
		
		GRAFO_MATERIAL.conectar(n1, n2);
		
		List<String> fila = new ArrayList<>();
		fila.add(n1.getId()+"");
		fila.add(n1.getTitulo());
		fila.add(n2.getId()+"");
		fila.add(n2.getTitulo());
		try {
			dataSource.agregarFilaAlFinal("aristas.csv", fila);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		}
	}
	
	
	public void modificarArchivoVideo (Menu ventana) {

		CsvDatasource archivoL = new CsvDatasource();
		File videos = new File("videos.csv");
	
		if (videos.exists() && videos.delete()) {
		
			for(Video v: ventana.getMateriales().listaVideos()) {
			try {
				archivoL.agregarFilaAlFinal("videos.csv", v.asCsvRow());
			} 
			catch (IOException e1) {
				e1.printStackTrace();
			}
			}
		}
		else {
			JOptionPane.showConfirmDialog(ventana, "No se pudo efectuar el cambio", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
		}			
	}
	
	
	public void modificarArchivoLibro(Menu ventana) {

		CsvDatasource archivoL = new CsvDatasource();
		File libros = new File("libros.csv");
		
		if (libros.exists() && libros.delete()) {
			for(Libro l: ventana.getMateriales().listaLibros()) {
				try {
					archivoL.agregarFilaAlFinal("libros.csv", l.asCsvRow());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		else {
			JOptionPane.showConfirmDialog(ventana, "No se pudo efectuar el cambio", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	public Integer gradoSalida(MaterialCapacitacion m) {
		return GRAFO_MATERIAL.gradoSalida(m);
	}
	
	
	public  List<Arista<MaterialCapacitacion>> getAristas() {
		return GRAFO_MATERIAL.getAristas();
	}
	
	public void actualizarPR() {
		GRAFO_MATERIAL.actualizarPR();
	}
}
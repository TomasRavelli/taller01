package frsf.isi.died.app.interfacesGraficas;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import  javax.swing.*;

import frsf.isi.died.app.dao.MaterialCapacitacionDaoDefault;
import frsf.isi.died.tp.modelo.BibliotecaABB;
import frsf.isi.died.tp.modelo.productos.Libro;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;
import frsf.isi.died.tp.modelo.productos.Video;

public class BuscarMaterial extends JFrame{
	
	Integer validacionBoton = -1;
	
	
	public BuscarMaterial(MaterialCapacitacionDaoDefault materiales) {
	JFrame buscarM = new JFrame("Buscar Material de Capacitacion");
	buscarM.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	buscarM.pack();
	buscarM.setSize(800,600);
	buscarM.setVisible(true);
	JPanel panel = new JPanel();
	buscarM.setContentPane(panel);
	panel.setLayout(null);
	
	JLabel titulo1 = new JLabel("Criterio de Busqueda");
	titulo1.setFont(new Font("Segoe UI Sybol",Font.BOLD,15));
	titulo1.setBounds(40,100,200,20);
	panel.add(titulo1);
	
	JButton titulo = new JButton("Titulo");
	titulo.setBounds(40, 150, 200, 20);
	panel.add(titulo);
	
	JButton calificacion = new JButton("Calificacion");
	calificacion.setBounds(40, 200, 200, 20);
	panel.add(calificacion);

	JButton tema = new JButton("Tema");
	tema.setBounds(40, 250, 200, 20);
	panel.add(tema);
	

	JButton rangoFecha = new JButton("Rango Fecha Publicacion");
	rangoFecha.setBounds(40, 300, 200, 20);
	panel.add(rangoFecha);
	
	JLabel titulo2 = new JLabel("Ordenar por:");
	titulo2.setFont(new Font("Segoe UI Sybol",Font.BOLD,15));
	titulo2.setBounds(450,100,200,20);
	panel.add(titulo2);
	
	ButtonGroup opciones = new ButtonGroup();
	
	JRadioButton tituloAlf = new JRadioButton("Titulo alfabeticamente");
	tituloAlf.setBounds(430, 150, 200, 20);
	tituloAlf.setVisible(true);
	opciones.add(tituloAlf);
	panel.add(tituloAlf);
	if(tituloAlf.isSelected()) {
		validacionBoton = 0;
	}
	
	JRadioButton xCalif = new JRadioButton("Calificacion");
	xCalif.setBounds(430, 200, 200, 20);
	xCalif.setVisible(true);
	opciones.add(xCalif);
	panel.add(xCalif);
	if(xCalif.isSelected()) {
		validacionBoton = 1;
	}
	
	JRadioButton xPrecio = new JRadioButton("Precio");
	xPrecio.setBounds(430, 250, 200, 20);
	xPrecio.setVisible(true);
	opciones.add(xPrecio);
	panel.add(xPrecio);
	if(xPrecio.isSelected()) {
		validacionBoton = 2;
	}
	
	JRadioButton xFechaPub = new JRadioButton("Fecha publicacion");
	xFechaPub.setBounds(430, 300, 200, 20);
	xFechaPub.setVisible(true);
	opciones.add(xFechaPub);
	panel.add(xFechaPub);
	if(xFechaPub.isSelected()) {
		validacionBoton = 3;
	}
	
	JRadioButton xRelevancia = new JRadioButton("Relevancia");
	xRelevancia.setBounds(430, 350, 200, 20);
	xRelevancia.setVisible(true);
	opciones.add(xRelevancia);
	panel.add(xRelevancia);
	if(xRelevancia.isSelected()) {
		validacionBoton = 4;
	}
	
	JButton buscar = new JButton("Buscar");
	buscar.setBounds(500, 500, 100, 30);
	buscar.setVisible(true);
	panel.add(buscar);
	
	JButton cancelar = new JButton("Cancelar");
	cancelar.setBounds(650, 500, 100, 30);
	cancelar.setVisible(true);
	panel.add(cancelar);
	
	//Dibujar campo titulo
	JTextField escribirTitulo = new JTextField();
	escribirTitulo.setBounds(40, 450, 200, 20);
	escribirTitulo.setVisible(false);
	panel.add(escribirTitulo);
	
	//Dibujar campo calficacion
	JLabel min = new JLabel("Min:");
	min.setBounds(40,400,30,20);
	min.setVisible(false);
	panel.add(min);
	
	JTextField escribirMin = new JTextField();
	escribirMin.setBounds(75, 400, 60, 20);
	escribirMin.setVisible(false);
	panel.add(escribirMin);
	
	JLabel max = new JLabel("Max:");
	max.setBounds(165,400,40,20);
	max.setVisible(false);
	panel.add(max);
	
	JTextField escribirMax = new JTextField();
	escribirMax.setBounds(210, 400, 60, 20);
	escribirMax.setVisible(false);
	panel.add(escribirMax);
	
	//Dibujar campo tema
	JTextField escribirTema = new JTextField();
	escribirTema.setBounds(40, 450, 200, 20);
	escribirTema.setVisible(false);
	panel.add(escribirTema);
	
	//Dibujar campo fecha minima
	JTextField fechaDia = new JTextField();
	fechaDia.setBounds(40, 400, 200, 20);
	fechaDia.setVisible(false);
	panel.add(fechaDia);
	
	
	//Dibujar campo fecha maxima
		JTextField fechaDia2 = new JTextField();
		fechaDia2.setBounds(40,450, 200, 20);
		fechaDia2.setVisible(false);
		panel.add(fechaDia2);	
			
	titulo.addActionListener(e->mostrarTitulo(escribirTitulo,min,escribirMin,max,escribirMax,escribirTema,fechaDia,fechaDia2,buscar,buscarM));
	
	calificacion.addActionListener(e->mostrarCalificacion(escribirTitulo,min,escribirMin,max,escribirMax,escribirTema,fechaDia,fechaDia2,buscar));
	
	tema.addActionListener(e->mostrarTema(escribirTitulo,min,escribirMin,max,escribirMax,escribirTema,fechaDia, fechaDia2,buscar));
	
	rangoFecha.addActionListener(e->mostrarFecha(escribirTitulo,min,escribirMin,max,escribirMax,escribirTema,fechaDia, fechaDia2, buscar));

	tituloAlf.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e){
			validacionBoton=0;
		}
	});
	
	xCalif.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e){
			validacionBoton=1;
		}
	});
	
	xPrecio.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e){
			validacionBoton=2;
		}
	});
	
	xFechaPub.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e){
			validacionBoton=3;
		}
	});
	
	xRelevancia.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e){
			validacionBoton=4;
		}
	});
	
	
	cancelar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e){
			new Menu();
			buscarM.dispose();
		}
	});
	



	}
	
	private void mostrarTitulo(JTextField eTit,JLabel min,JTextField emin,JLabel max, JTextField emax,
			JTextField eTe, JTextField fD, JTextField fD2,JButton buscar,JFrame buscarM) {
		
		eTit.setVisible(true);
		min.setVisible(false);
		emin.setVisible(false);
		max.setVisible(false);
		emax.setVisible(false);
		eTe.setVisible(false);
		fD.setVisible(false);
		fD2.setVisible(false);
		
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				switch(validacionBoton) {
				case 0:{
				
				ordenarPorTitulo(buscarPorTitulo(eTit.getText()),buscarM);
				break;
				}
				case 1:{
					//ordenarPorCalificacion();
					break;
				}
				case 2:{
					//ordenarPorPrecio();
					break;
				}
				case 3:{
					//ordenarPorFecha();
					break;
				}
				case 4:{
					//ordenarPorRelevancia();
				}
				default:{
					JOptionPane noEligio = new JOptionPane();
					noEligio.showConfirmDialog(buscarM, "Debe elegir un criterio de ordenamiento.", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);

				}
				}
			}
		});
		
	}
	
	private void mostrarCalificacion(JTextField eTit,JLabel min,JTextField emin,JLabel max, JTextField emax,JTextField eTe, JTextField fD, JTextField fD2,JButton buscar) {
		
		eTit.setVisible(false);
		min.setVisible(false);
		emin.setVisible(false);
		max.setVisible(false);
		emax.setVisible(false);
		eTe.setVisible(true);
		fD.setVisible(false);
		fD2.setVisible(false);
		
	}
	

	private void mostrarTema(JTextField eTit,JLabel min,JTextField emin,JLabel max, JTextField emax,JTextField eTe, JTextField fD, JTextField fD2, JButton buscar) {
		
		eTit.setVisible(false);
		min.setVisible(true);
		emin.setVisible(true);
		max.setVisible(true);
		emax.setVisible(true);
		eTe.setVisible(false);
		fD.setVisible(false);
		fD2.setVisible(false);
	}
	
	private void mostrarFecha(JTextField eTit,JLabel min,JTextField emin,JLabel max, JTextField emax,JTextField eTe, JTextField fD, JTextField fD2, JButton buscar) {
		
		eTit.setVisible(false);
		min.setVisible(false);
		emin.setVisible(false);
		max.setVisible(false);
		emax.setVisible(false);
		eTe.setVisible(false);
		fD.setVisible(true);
		fD2.setVisible(true);
	}
	
	public List<MaterialCapacitacion> buscarPorTitulo(String titulo) {
		CsvDatasource archivo1 = new CsvDatasource();
		CsvDatasource archivo2 = new CsvDatasource();
		BibliotecaABB materiales = new BibliotecaABB();
		List<MaterialCapacitacion> encontrados = new ArrayList<>();
		if(!titulo.isEmpty()) {
		
		agregarLibros(materiales,archivo1.readFile("libros.csv"));
		agregarVideos(materiales,archivo2.readFile("videos.csv"));
		
		for(MaterialCapacitacion m: materiales.materiales() ) {
			if( m.getTitulo().contains(titulo) ){
				encontrados.add(m);
			}
		}
		}
		
		return encontrados;
		}
	public void ordenarPorTitulo(List<MaterialCapacitacion> encontrados, JFrame buscarM) {
		encontrados.sort((e1,e2) -> e1.getTitulo().compareTo(e2.getTitulo()));
		if(encontrados.isEmpty()){
		JOptionPane noEncontrado = new JOptionPane();
		noEncontrado.showConfirmDialog(buscarM, "Material no encontrado", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			MuestraResultados muestra = new MuestraResultados(encontrados);
			buscarM.dispose();
		}

	}
	
	private void agregarLibros(BibliotecaABB materiales, List<List<String>> libros) {
		
		for(int i=0; i< libros.size(); i++) {
			Libro l = new Libro();
			l.loadFromStringRow(libros.get(i));
			materiales.agregar(l);
		}		
	
	}
	
private void agregarVideos(BibliotecaABB materiales, List<List<String>> videos) {
		
		for(int i=0; i< videos.size(); i++) {
			Video l = new Video();
			l.loadFromStringRow(videos.get(i));
			materiales.agregar(l);
		}		
	
	}
	

}

package frsf.isi.died.app.InterfacesGraficasNuevo;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.PriorityQueue;

import  javax.swing.*;

import frsf.isi.died.app.dao.MaterialCapacitacionDao;
import frsf.isi.died.app.dao.MaterialCapacitacionDaoDefault;
import frsf.isi.died.tp.modelo.BibliotecaABB;
import frsf.isi.died.tp.modelo.productos.Libro;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;
import frsf.isi.died.tp.modelo.productos.Video;
import frsf.isi.died.app.InterfacesGraficasNuevo.Menu;
import frsf.isi.died.app.dao.*;

public class BuscarMaterial extends JPanel{
	
	Integer validacionBoton = -1;		
			
	public BuscarMaterial(Menu m) {
	
	this.setVisible(true);
    this.setPreferredSize(new Dimension(800,600));
	this.setLayout(null);
	
	
	JLabel titulo1 = new JLabel("Criterio de Busqueda");
	titulo1.setFont(new Font("Segoe UI Sybol",Font.BOLD,15));
	titulo1.setBounds(40,100,200,20);
	this.add(titulo1);
	
	JButton titulo = new JButton("Titulo");
	titulo.setBounds(40, 150, 200, 20);
	this.add(titulo);
	
	JButton calificacion = new JButton("Calificacion");
	calificacion.setBounds(40, 200, 200, 20);
	this.add(calificacion);

	JButton tema = new JButton("Tema");
	tema.setBounds(40, 250, 200, 20);
	this.add(tema);
	

	JButton rangoFecha = new JButton("Rango Fecha Publicacion");
	rangoFecha.setBounds(40, 300, 200, 20);
	this.add(rangoFecha);
	
	JLabel titulo2 = new JLabel("Ordenar por:");
	titulo2.setFont(new Font("Segoe UI Sybol",Font.BOLD,15));
	titulo2.setBounds(450,100,200,20);
	this.add(titulo2);
	
	ButtonGroup opciones = new ButtonGroup();
	
	JRadioButton tituloAlf = new JRadioButton("Titulo alfabeticamente");
	tituloAlf.setBounds(430, 150, 200, 20);
	tituloAlf.setVisible(true);
	opciones.add(tituloAlf);
	this.add(tituloAlf);
	
	
	JRadioButton xCalif = new JRadioButton("Calificacion");
	xCalif.setBounds(430, 200, 200, 20);
	xCalif.setVisible(true);
	opciones.add(xCalif);
	this.add(xCalif);
	
	
	JRadioButton xPrecio = new JRadioButton("Precio");
	xPrecio.setBounds(430, 250, 200, 20);
	xPrecio.setVisible(true);
	opciones.add(xPrecio);
	this.add(xPrecio);
	
	
	JRadioButton xFechaPub = new JRadioButton("Fecha publicacion");
	xFechaPub.setBounds(430, 300, 200, 20);
	xFechaPub.setVisible(true);
	opciones.add(xFechaPub);
	this.add(xFechaPub);
	
	
	JRadioButton xRelevancia = new JRadioButton("Relevancia");
	xRelevancia.setBounds(430, 350, 200, 20);
	xRelevancia.setVisible(true);
	opciones.add(xRelevancia);
	this.add(xRelevancia);
	
	
	JButton wishlist = new JButton("Wishlist");
	wishlist.setBounds(350, 500, 100, 30);
	wishlist.setVisible(true);
	this.add(wishlist);
	
	JButton buscar = new JButton("Buscar");
	buscar.setBounds(500, 500, 100, 30);
	buscar.setVisible(true);
	this.add(buscar);
	
	JButton cancelar = new JButton("Cancelar");
	cancelar.setBounds(650, 500, 100, 30);
	cancelar.setVisible(true);
	this.add(cancelar);
	
	//Dibujar campo titulo
	JTextField escribirTitulo = new JTextField();
	escribirTitulo.setBounds(40, 450, 200, 20);
	escribirTitulo.setVisible(false);
	this.add(escribirTitulo);
	
	//Dibujar campo calficacion
	JLabel min = new JLabel("Min:");
	min.setBounds(40,400,30,20);
	min.setVisible(false);
	this.add(min);
	
	JTextField escribirMin = new JTextField();
	escribirMin.setBounds(75, 400, 60, 20);
	escribirMin.setVisible(false);
	this.add(escribirMin);
	
	JLabel max = new JLabel("Max:");
	max.setBounds(165,400,40,20);
	max.setVisible(false);
	this.add(max);
	
	JTextField escribirMax = new JTextField();
	escribirMax.setBounds(210, 400, 60, 20);
	escribirMax.setVisible(false);
	this.add(escribirMax);
	
	//Dibujar campo tema
	JTextField escribirTema = new JTextField();
	escribirTema.setBounds(40, 450, 200, 20);
	escribirTema.setVisible(false);
	this.add(escribirTema);
	
	//Dibujar campo fecha minima
	JTextField fechaDia = new JTextField();
	fechaDia.setBounds(40, 400, 200, 20);
	fechaDia.setVisible(false);
	this.add(fechaDia);
	
	
	//Dibujar campo fecha maxima
		JTextField fechaDia2 = new JTextField();
		fechaDia2.setBounds(40,450, 200, 20);
		fechaDia2.setVisible(false);
		this.add(fechaDia2);	
		

	titulo.addActionListener(e->mostrarTitulo(escribirTitulo,min,escribirMin,max,escribirMax,escribirTema,fechaDia,fechaDia2,buscar,m));
	
	calificacion.addActionListener(e->mostrarCalificacion(escribirTitulo,min,escribirMin,max,escribirMax,escribirTema,fechaDia,fechaDia2,buscar,m));
	
	tema.addActionListener(e->mostrarTema(escribirTitulo,min,escribirMin,max,escribirMax,escribirTema,fechaDia, fechaDia2,buscar,m));
	
	rangoFecha.addActionListener(e->mostrarFecha(escribirTitulo,min,escribirMin,max,escribirMax,escribirTema,fechaDia, fechaDia2, buscar,m));

	
	
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
			m.setContentPane(new Inicio(m));
			m.pack();
		}
	});
	
	wishlist.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e){
			m.setContentPane(new MuestraWish(m));
			m.pack();
		}
	});


	}
	

	private void mostrarTitulo(JTextField eTit,JLabel min,JTextField emin,JLabel max, JTextField emax,
			JTextField eTe, JTextField fD, JTextField fD2,JButton buscar,Menu buscarM) {
		
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
					ordenarPorTitulo(buscarPorTitulo(eTit.getText(),buscarM.getMateriales()),buscarM);
					break;
				}
				case 1:{
					ordenarPorCalificacion(buscarPorTitulo(eTit.getText(),buscarM.getMateriales()),buscarM);
					break;
				}
				case 2:{
					ordenarPorPrecio(buscarPorTitulo(eTit.getText(),buscarM.getMateriales()),buscarM);
					break;
				}
				case 3:{
					ordenarPorFecha(buscarPorTitulo(eTit.getText(),buscarM.getMateriales()),buscarM);
					break;
				}
				case 4:{
					ordenarPorRelevancia(buscarPorTitulo(eTit.getText(),buscarM.getMateriales()),buscarM);
					break;
				}
				default:{
					JOptionPane noEligio = new JOptionPane();
					noEligio.showConfirmDialog(buscarM, "Debe elegir un criterio de ordenamiento.", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
					break;
				}
				}
			}
		});
		
	}
	
	private void mostrarCalificacion(JTextField eTit,JLabel min,JTextField emin,JLabel max, JTextField emax,JTextField eTe, JTextField fD, JTextField fD2,JButton buscar,Menu buscarM) {
		
		eTit.setVisible(false);
		min.setVisible(true);
		emin.setVisible(true);
		max.setVisible(true);
		emax.setVisible(true);
		eTe.setVisible(false);
		fD.setVisible(false);
		fD2.setVisible(false);
		
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				switch(validacionBoton) {
				case 0:{
					ordenarPorTitulo(buscarPorCalificacion(Double.valueOf(emin.getText()),Double.valueOf(emax.getText()),buscarM.getMateriales()),buscarM);
					break;
				}
				case 1:{
					ordenarPorCalificacion(buscarPorCalificacion(Double.valueOf(emin.getText()),Double.valueOf(emax.getText()),buscarM.getMateriales()),buscarM);
					break;
				}
				case 2:{
					ordenarPorPrecio(buscarPorCalificacion(Double.valueOf(emin.getText()),Double.valueOf(emax.getText()),buscarM.getMateriales()),buscarM);
					break;
				}
				case 3:{
					ordenarPorFecha(buscarPorCalificacion(Double.valueOf(emin.getText()),Double.valueOf(emax.getText()),buscarM.getMateriales()),buscarM);
					break;
				}
				case 4:{
					ordenarPorRelevancia(buscarPorCalificacion(Double.valueOf(emin.getText()),Double.valueOf(emax.getText()),buscarM.getMateriales()),buscarM);
					break;
				}
				default:{
					JOptionPane noEligio = new JOptionPane();
					noEligio.showConfirmDialog(buscarM, "Debe elegir un criterio de ordenamiento.", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
					break;
				}
				}
			}
		});
	}
	

	private void mostrarTema(JTextField eTit,JLabel min,JTextField emin,JLabel max, JTextField emax,JTextField eTe, JTextField fD, JTextField fD2, JButton buscar,Menu buscarM) {
		
		eTit.setVisible(false);
		min.setVisible(false);
		emin.setVisible(false);
		max.setVisible(false);
		emax.setVisible(false);
		eTe.setVisible(true);
		fD.setVisible(false);
		fD2.setVisible(false);
		
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				switch(validacionBoton) {
				case 0:{
					ordenarPorTitulo(buscarPorTema(eTe.getText(),buscarM.getMateriales()),buscarM);
					break;
				}
				case 1:{
					ordenarPorCalificacion(buscarPorTema(eTe.getText(),buscarM.getMateriales()),buscarM);
					break;
				}
				case 2:{
					ordenarPorPrecio(buscarPorTema(eTe.getText(),buscarM.getMateriales()),buscarM);
					break;
				}
				case 3:{
					ordenarPorFecha(buscarPorTema(eTe.getText(),buscarM.getMateriales()),buscarM);
					break;
				}
				case 4:{
					ordenarPorRelevancia(buscarPorTema(eTe.getText(),buscarM.getMateriales()),buscarM);
					break;
				}
				default:{
					JOptionPane noEligio = new JOptionPane();
					noEligio.showConfirmDialog(buscarM, "Debe elegir un criterio de ordenamiento.", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
					break;
				}
				}
			}
		});
	}
	
	private void mostrarFecha(JTextField eTit,JLabel min,JTextField emin,JLabel max, JTextField emax,JTextField eTe, JTextField fD, JTextField fD2, JButton buscar,Menu buscarM) {
		
		eTit.setVisible(false);
		min.setVisible(false);
		emin.setVisible(false);
		max.setVisible(false);
		emax.setVisible(false);
		eTe.setVisible(false);
		fD.setVisible(true);
		fD2.setVisible(true);
		
		Date fecha_publicacion1 = new Date();
		SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
		try {
			fecha_publicacion1 = d.parse(fD.getText());
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		final Date fecha1 = fecha_publicacion1;
		
		Date fecha_publicacion2 = new Date();
		SimpleDateFormat d2 = new SimpleDateFormat("dd/MM/yyyy");
		try {
			fecha_publicacion2 = d2.parse(fD2.getText());
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		final Date fecha2 = fecha_publicacion2;
		
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				switch(validacionBoton) {
				case 0:{
					ordenarPorTitulo(buscarPorFecha(fecha1,fecha2,buscarM.getMateriales()),buscarM);
					break;
				}
				case 1:{
					ordenarPorCalificacion(buscarPorFecha(fecha1,fecha2,buscarM.getMateriales()),buscarM);
					break;
				}
				case 2:{
					ordenarPorPrecio(buscarPorFecha(fecha1,fecha2,buscarM.getMateriales()),buscarM);
					break;
				}
				case 3:{
					ordenarPorFecha(buscarPorFecha(fecha1,fecha2,buscarM.getMateriales()),buscarM);
					break;
				}
				case 4:{
					ordenarPorRelevancia(buscarPorFecha(fecha1,fecha2,buscarM.getMateriales()),buscarM);
					break;
				}
				default:{
					JOptionPane noEligio = new JOptionPane();
					noEligio.showConfirmDialog(buscarM, "Debe elegir un criterio de ordenamiento.", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
					break;
				}
				}
			}
		});
	}
	
	public List<MaterialCapacitacion> buscarPorTitulo(String titulo, MaterialCapacitacionDaoDefault materiales) {
		List<MaterialCapacitacion> encontrados = new ArrayList<>();
		for(MaterialCapacitacion m: materiales.listaMateriales()) {
			if(m.getTitulo().contains(titulo)) {
				encontrados.add(m);
			}
		}
		return encontrados;
	}
	public List<MaterialCapacitacion> buscarPorCalificacion(Double min,Double max, MaterialCapacitacionDaoDefault materiales) {
		List<MaterialCapacitacion> encontrados = new ArrayList<>();
		for(MaterialCapacitacion m: materiales.listaMateriales()) {
			if(m.getCalificacion()>=min && m.getCalificacion()<=max) {
				encontrados.add(m);
			}
		}
		return encontrados;
	}
	public List<MaterialCapacitacion> buscarPorTema(String tema, MaterialCapacitacionDaoDefault materiales) {
		List<MaterialCapacitacion> encontrados = new ArrayList<>();
		for(MaterialCapacitacion m: materiales.listaMateriales()) {
			if(m.getTema().equals(tema)) {
				encontrados.add(m);
			}
		}
		return encontrados;
	}
	public List<MaterialCapacitacion> buscarPorFecha(Date f1,Date f2, MaterialCapacitacionDaoDefault materiales) {
		List<MaterialCapacitacion> encontrados = new ArrayList<>();
		for(MaterialCapacitacion m: materiales.listaMateriales()) {
			if(m.getFechaPublicacion().compareTo(f1)>0 && m.getFechaPublicacion().compareTo(f2)<0) {
				encontrados.add(m);
			}
		}
		return encontrados;
	}
	public void ordenarPorTitulo(List<MaterialCapacitacion> encontrados, Menu buscarM) {
		encontrados.sort((e1,e2) -> e1.getTitulo().compareTo(e2.getTitulo()));
		if(encontrados.isEmpty()){
		JOptionPane noEncontrado = new JOptionPane();
		noEncontrado.showConfirmDialog(buscarM, "Material no encontrado", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			buscarM.setContentPane(new MuestraResultados(buscarM, encontrados));
			buscarM.pack();
		}
	}
	public void ordenarPorCalificacion(List<MaterialCapacitacion> encontrados, Menu buscarM) {
		encontrados.sort((e1,e2) -> e1.getCalificacion().compareTo(e2.getCalificacion()));
		if(encontrados.isEmpty()){
		JOptionPane noEncontrado = new JOptionPane();
		noEncontrado.showConfirmDialog(buscarM, "Material no encontrado", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			buscarM.setContentPane(new MuestraResultados(buscarM, encontrados));
			buscarM.pack();
		}
	}
	public void ordenarPorPrecio(List<MaterialCapacitacion> encontrados, Menu buscarM) {
		encontrados.sort((e1,e2) -> e1.precio().compareTo(e2.precio()));
		if(encontrados.isEmpty()){
		JOptionPane noEncontrado = new JOptionPane();
		noEncontrado.showConfirmDialog(buscarM, "Material no encontrado", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			buscarM.setContentPane(new MuestraResultados(buscarM, encontrados));
			buscarM.pack();
		}
	}
	public void ordenarPorFecha(List<MaterialCapacitacion> encontrados, Menu buscarM) {
		encontrados.sort((e1,e2) -> e1.getFechaPublicacion().compareTo(e2.getFechaPublicacion()));
		if(encontrados.isEmpty()){
		JOptionPane noEncontrado = new JOptionPane();
		noEncontrado.showConfirmDialog(buscarM, "Material no encontrado", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			buscarM.setContentPane(new MuestraResultados(buscarM, encontrados));
			buscarM.pack();;
		}
	}
	public void ordenarPorRelevancia(List<MaterialCapacitacion> encontrados, Menu buscarM) {
		encontrados.sort((e1,e2) -> e1.getRelevancia().compareTo(e2.getRelevancia()));
		if(encontrados.isEmpty()){
		JOptionPane noEncontrado = new JOptionPane();
		noEncontrado.showConfirmDialog(buscarM, "Material no encontrado", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			buscarM.setContentPane(new MuestraResultados(buscarM, encontrados));
			buscarM.pack();
		}
	}
}

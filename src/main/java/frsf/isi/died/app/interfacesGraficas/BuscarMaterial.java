package frsf.isi.died.app.interfacesGraficas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  javax.swing.*;

public class BuscarMaterial extends JFrame{
	
	public static void main(String[] args) {
	javax.swing.SwingUtilities.invokeLater(new Runnable() {
	public void run() {
		BuscarMaterial b1 = new BuscarMaterial();
		
	}
	}); 
	}
	
	public BuscarMaterial() {
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
	
	JRadioButton xCalif = new JRadioButton("Calificacion");
	xCalif.setBounds(430, 200, 200, 20);
	xCalif.setVisible(true);
	opciones.add(xCalif);
	panel.add(xCalif);
	
	JRadioButton xPrecio = new JRadioButton("Precio");
	xPrecio.setBounds(430, 250, 200, 20);
	xPrecio.setVisible(true);
	opciones.add(xPrecio);
	panel.add(xPrecio);
	
	JRadioButton xFechaPub = new JRadioButton("Fecha publicacion");
	xFechaPub.setBounds(430, 300, 200, 20);
	xFechaPub.setVisible(true);
	opciones.add(xFechaPub);
	panel.add(xFechaPub);
	
	JRadioButton xRelevancia = new JRadioButton("Relevancia");
	xRelevancia.setBounds(430, 350, 200, 20);
	xRelevancia.setVisible(true);
	opciones.add(xRelevancia);
	panel.add(xRelevancia);
	
	JButton buscar = new JButton("Buscar");
	buscar.setBounds(650, 500, 100, 30);
	buscar.setVisible(true);
	panel.add(buscar);
	
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
	fechaDia.setBounds(40, 400, 30, 20);
	fechaDia.setVisible(false);
	panel.add(fechaDia);
	
	JLabel barra = new JLabel("/");
	barra.setBounds(80,400,10,20);
	barra.setVisible(false);
	panel.add(barra);
	
	JTextField fechaMes = new JTextField();
	fechaMes.setBounds(90, 400, 30, 20);
	fechaMes.setVisible(false);
	panel.add(fechaMes);
	
	JLabel barra2 = new JLabel("/");
	barra2.setBounds(130,400,10,20);
	barra2.setVisible(false);
	panel.add(barra2);
	
	JTextField fechaAnio = new JTextField();
	fechaAnio.setBounds(140, 400, 65, 20);
	fechaAnio.setVisible(false);
	panel.add(fechaAnio);
	

	//Dibujar campo fecha maxima
		JTextField fechaDia2 = new JTextField();
		fechaDia2.setBounds(40,450, 30, 20);
		fechaDia2.setVisible(false);
		panel.add(fechaDia2);
		
		JLabel barra3 = new JLabel("/");
		barra3.setBounds(80,450,10,20);
		barra3.setVisible(false);
		panel.add(barra3);
		
		JTextField fechaMes2 = new JTextField();
		fechaMes2.setBounds(90, 450, 30, 20);
		fechaMes2.setVisible(false);
		panel.add(fechaMes2);
		
		JLabel barra4 = new JLabel("/");
		barra4.setBounds(130,450,10,20);
		barra4.setVisible(false);
		panel.add(barra4);
		
		JTextField fechaAnio2 = new JTextField();
		fechaAnio2.setBounds(140, 450, 65, 20);
		fechaAnio2.setVisible(false);
		panel.add(fechaAnio2);
		
	titulo.addActionListener(e->mostrarTitulo(escribirTitulo,min,escribirMin,max,escribirMax,escribirTema,fechaDia,barra,fechaMes,barra2,fechaAnio,fechaDia2,barra3,fechaMes2,barra4,fechaAnio2));
	
	calificacion.addActionListener(e->mostrarCalificacion(escribirTitulo,min,escribirMin,max,escribirMax,escribirTema,fechaDia,barra,fechaMes,barra2,fechaAnio,fechaDia2,barra3,fechaMes2,barra4,fechaAnio2));
	
	tema.addActionListener(e->mostrarTema(escribirTitulo,min,escribirMin,max,escribirMax,escribirTema,fechaDia,barra,fechaMes,barra2,fechaAnio,fechaDia2,barra3,fechaMes2,barra4,fechaAnio2));
	
	rangoFecha.addActionListener(e->mostrarFecha(escribirTitulo,min,escribirMin,max,escribirMax,escribirTema,fechaDia,barra,fechaMes,barra2,fechaAnio,fechaDia2,barra3,fechaMes2,barra4,fechaAnio2));
	
	}
	
	private void mostrarTitulo(JTextField eTit,JLabel min,JTextField emin,JLabel max, JTextField emax,JTextField eTe, JTextField fD, JLabel b,JTextField fM,JLabel b2, JTextField fA, JTextField fD2, JLabel b3,JTextField fM2,JLabel b4, JTextField fA2) {
		
		eTit.setVisible(true);
		min.setVisible(false);
		emin.setVisible(false);
		max.setVisible(false);
		emax.setVisible(false);
		eTe.setVisible(false);
		fD.setVisible(false);
		b.setVisible(false);
		fM.setVisible(false);
		b2.setVisible(false);
		fA.setVisible(false);
		fD2.setVisible(false);
		b3.setVisible(false);
		fM2.setVisible(false);
		b4.setVisible(false);
		fA2.setVisible(false);
		this.validate();

	}
	
private void mostrarCalificacion(JTextField eTit,JLabel min,JTextField emin,JLabel max, JTextField emax,JTextField eTe, JTextField fD, JLabel b,JTextField fM,JLabel b2, JTextField fA, JTextField fD2, JLabel b3,JTextField fM2,JLabel b4, JTextField fA2) {
		
		eTit.setVisible(false);
		min.setVisible(true);
		emin.setVisible(true);
		max.setVisible(true);
		emax.setVisible(true);
		eTe.setVisible(false);
		fD.setVisible(false);
		b.setVisible(false);
		fM.setVisible(false);
		b2.setVisible(false);
		fA.setVisible(false);
		fD2.setVisible(false);
		b3.setVisible(false);
		fM2.setVisible(false);
		b4.setVisible(false);
		fA2.setVisible(false);
		this.validate();

	}

private void mostrarTema (JTextField eTit,JLabel min,JTextField emin,JLabel max, JTextField emax,JTextField eTe, JTextField fD, JLabel b,JTextField fM,JLabel b2, JTextField fA, JTextField fD2, JLabel b3,JTextField fM2,JLabel b4, JTextField fA2) {
	
	eTit.setVisible(true);
	min.setVisible(false);
	emin.setVisible(false);
	max.setVisible(false);
	emax.setVisible(false);
	eTe.setVisible(true);
	fD.setVisible(false);
	b.setVisible(false);
	fM.setVisible(false);
	b2.setVisible(false);
	fA.setVisible(false);
	fD2.setVisible(false);
	b3.setVisible(false);
	fM2.setVisible(false);
	b4.setVisible(false);
	fA2.setVisible(false);
	this.validate();

}

private void mostrarFecha(JTextField eTit,JLabel min,JTextField emin,JLabel max, JTextField emax,JTextField eTe, JTextField fD, JLabel b,JTextField fM,JLabel b2, JTextField fA, JTextField fD2, JLabel b3,JTextField fM2,JLabel b4, JTextField fA2) {
	
	eTit.setVisible(false);
	min.setVisible(false);
	emin.setVisible(false);
	max.setVisible(false);
	emax.setVisible(false);
	eTe.setVisible(false);
	fD.setVisible(true);
	b.setVisible(true);
	fM.setVisible(true);
	b2.setVisible(true);
	fA.setVisible(true);
	fD2.setVisible(true);
	b3.setVisible(true);
	fM2.setVisible(true);
	b4.setVisible(true);
	fA2.setVisible(true);
	this.validate();

}

}

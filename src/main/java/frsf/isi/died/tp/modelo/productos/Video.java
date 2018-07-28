/**
 * 
 */
package frsf.isi.died.tp.modelo.productos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @author alumno
 *
 */
public class Video extends MaterialCapacitacion{

	static Double COSTOSEG=0.15;
	private Integer duracion;
	
	public Video() {
	}
	public Video(Integer id,String titulo) {
		this.id=id;
		this.titulo=titulo;
	}
	public Video(Integer id,String titulo, Double costo, Integer duracion) {
		this.id=id;
		this.titulo=titulo;
		this.costo=costo;
		this.duracion=duracion;
	}
	public Video(Integer id,String titulo, Double costo, Integer duracion,Relevancia r, Date date) {
		this.id=id;
		this.titulo=titulo;
		this.costo=costo;
		this.duracion=duracion;
		this.relevancia = r;
		this.calificacion = 0.0;
		this.votantes = 0;
		this.fecha_publicacion = date;
	}
	
	
	public Integer getDuracion(){
		return duracion;
	}
	public Double getCostoxSeg() {
		return COSTOSEG;
	}
	
	public Boolean esVideo() {
		return true;
	}
	public Boolean esLibro() {
		return false;
	}
	public Double precio(){
		return(this.costo+this.duracion.doubleValue()*this.COSTOSEG);
	}

	@Override
	public List<String> asCsvRow() {
		List<String> lista = new ArrayList<String>();
		lista.add("0");
		lista.add(this.id+"");
		lista.add("\""+this.titulo.toString()+"\"");
		lista.add(this.costo.toString());
		lista.add(this.duracion.toString());
		lista.add(this.COSTOSEG.toString());
		lista.add(this.calificacion.toString());
		lista.add(this.relevancia.toString());
		lista.add(this.fecha_publicacion.toString());
		return lista;
	}
	

	@Override
	public void loadFromStringRow(List<String> datos) {
		this.id =Integer.valueOf(datos.get(1));
		this.titulo = datos.get(2);
		this.costo =Double.valueOf(datos.get(3));
		this.duracion =Integer.valueOf(datos.get(4));
		this.COSTOSEG =Double.valueOf(datos.get(5));
		this.calificacion =Double.valueOf(datos.get(6));
		this.relevancia =Relevancia.valueOf(datos.get(7));
		
		
		//SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formato = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        Date fechaDate = new Date();
        try {
            fechaDate = formato.parse(datos.get(8));
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
		this.fecha_publicacion = fechaDate;
		System.out.println(fecha_publicacion);
		
	}
	
}

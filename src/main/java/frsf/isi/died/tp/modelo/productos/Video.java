/**
 * 
 */
package frsf.isi.died.tp.modelo.productos;

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
	public Boolean esVideo() {
		return true;
	}
	public Boolean esLibro() {
		return false;
	}
	public Double precio(){
		return(this.costo+this.duracion.doubleValue()*this.COSTOSEG);
	}
	
}

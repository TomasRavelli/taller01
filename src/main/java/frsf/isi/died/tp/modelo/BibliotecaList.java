package frsf.isi.died.tp.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import frsf.isi.died.tp.modelo.productos.*;

public class BibliotecaList implements Biblioteca{
	private ArrayList<MaterialCapacitacion> materiales;

	public BibliotecaList() {
		this.materiales = new ArrayList<>();
	}
	public void agregar(MaterialCapacitacion mat) {
		materiales.add(mat);
	}
	public Integer cantidadMateriales() {
		return materiales.size();
	}
	public Integer cantidadLibros() {
		Integer contador=0;
		for(MaterialCapacitacion mat:materiales) {
			if(mat.esLibro()) contador++;
		}
		return contador;
	}

	public Integer cantidadVideos() {
		Integer contador=0;
		for(MaterialCapacitacion mat:materiales) {
			if(mat.esVideo()) contador++;
		}
		return contador;
	}

	public Collection<MaterialCapacitacion> materiales(){
		return this.materiales;
	}

	public void imprimir() {
		for(MaterialCapacitacion mat:materiales) {
			System.out.println(mat.toString());
		}
	}

	public void ordenarPorPrecio(Boolean b) {
		if(b == false) {
			Collections.sort(materiales);
		}
		else { 
			Collections.sort(materiales, (m1,m2)-> m1.precio().compareTo(m2.precio()));				
		}
	}
	@Override
	public MaterialCapacitacion buscar(Integer costo) {
		Collections.sort(materiales, (m1,m2)-> m1.getCosto().compareTo(m2.getCosto()));
		return buscadorBinario(0,materiales.size()-1,costo);
	}
	private MaterialCapacitacion buscadorBinario(Integer i, Integer f, Integer costo) throws RuntimeException{
		// TODO Auto-generated method stub
		Integer medio = (f+i)/2;

		if(i > f) {
			throw new RuntimeException("Material de precio " + costo +" no encontrado");
		}
		else {
			if (materiales.get(medio).getCosto().intValue() == costo) {
				return materiales.get(medio);}
			else {
				if(costo > materiales.get(medio).getCosto().intValue()) {
					return buscadorBinario(medio+1,f,costo);}
				else {
					return buscadorBinario(i,medio-1,costo);
				}
			}
		}

	}
}
		
	


	







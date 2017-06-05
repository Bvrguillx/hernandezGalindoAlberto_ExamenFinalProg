package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

@SuppressWarnings("serial")
public class ListaCoches<E> extends ArrayList<E> {

	// CONSTANTES Y VARIABLES
	ListaCoches<E> parkin = (ListaCoches<E>) new ArrayList<E>();
	private final int CAPACIDAD_MAXIMA = 50;
	private Comparator<E> comparador;

	@SuppressWarnings("unchecked")
	public ListaCoches(Comparator<Coche> comparador) {
		super();
		this.comparador = (Comparator<E>) comparador;
	}

	/**
	 * MODIFICACION DEL METODO DE ANIADIR Y
	 * ORDENACION DESCENDENTE
	 */
	@Override
	public boolean add(E elemento){
		if (elemento != null){
			if (this.size() < CAPACIDAD_MAXIMA){
				super.add(elemento);
				Collections.sort(this, comparador);
				return true;
			} else {
				throw new RuntimeException("NO HAY ESPACIO PARA MAS DE 50 FERRARIS BRO");
			}
		} else {
			throw new RuntimeException("NO ACEPTO COSAS VACIAS O NULAS BRO");
		}
	}
	
	/**
	 * ANIADIR UNA COLECCION Y ORDENARLA POSTERIORMENTE
	 */
	public boolean addAll(Collection<? extends E> coleccion) {
		if (coleccion.size() + this.size() < CAPACIDAD_MAXIMA){
			super.addAll(coleccion);
			Collections.sort(this, comparador);
			return true;
		} else {
			throw new RuntimeException("SOMOS DEMASIADOS FERRARIS EN ESTE CUCHITRIL");
		}
	}
	
	/**
	 * METODO QUE DEVUELVE LA LISTA INVERSA, PERO SIN CAMBIAR EL ORDEN REAL
	 * 
	 * @return LISTA INVERTIDA
	 */
	public ListaCoches<Coche> reverse(){
		ListaCoches<Coche> auxiliar = new ListaCoches<Coche>(
				(Coche a, Coche b) -> b.getHoraSubida().compareTo(a.getHoraSubida())
				);
		for (int indice = this.size()-1; indice >= 0; indice--){
			auxiliar.add((Coche) this.get(indice));
		}
		return auxiliar;
	}
	
	
}

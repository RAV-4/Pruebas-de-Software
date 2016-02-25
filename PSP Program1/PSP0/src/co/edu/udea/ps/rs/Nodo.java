package co.edu.udea.ps.rs;

public class Nodo {
	
	private double dato;
	private Nodo siguiente;
	private Nodo anterior;
	
	public Nodo() {
		anterior = null;
		dato = 0;
		siguiente = null;
	}
	
	public Nodo(double dato){
		anterior = null;
		this.dato = dato;
		siguiente = null;
	}
	
	public double getDato() {
		return dato;
	}
	public void setDato(double dato) {
		this.dato = dato;
	}
	public Nodo getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}
	public Nodo getAnterior() {
		return anterior;
	}
	public void setAnterior(Nodo anterior) {
		this.anterior = anterior;
	}
	
}

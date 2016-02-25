package co.edu.udea.ps.rs;

public class ListaDobleLigada {
	
	Nodo primero;
	Nodo ultimo;
	
	public ListaDobleLigada() {
		primero = null;
		ultimo = null;
	}
	
	public ListaDobleLigada(double dato){
		Nodo nuevo = new Nodo(dato);
		primero = nuevo;
		ultimo = nuevo;
	}

	public Nodo getPrimero() {
		return primero;
	}

	public void setPrimero(Nodo primero) {
		this.primero = primero;
	}

	public Nodo getUltimo() {
		return ultimo;
	}

	public void setUltimo(Nodo ultimo) {
		this.ultimo = ultimo;
	}
	
	public boolean esVacia() {
		if(primero == null){
			return true;
		}
		return false;
	}
	
	public void insertar(Double dato) {
		Nodo nuevo = new Nodo(dato);
		if (primero == null) {
			primero = nuevo;
			ultimo = nuevo;
		}else{
			ultimo.setSiguiente(nuevo);
			nuevo.setAnterior(ultimo);
			ultimo = nuevo;
		}
	}
	
	public int tamaño() {
		Nodo recorrer = primero;
		int tam=0;
		while(recorrer != null){
			tam++;
			recorrer = recorrer.getSiguiente();
		}
		return tam;
	}
	
	public double media() {
		Nodo recorrer = primero;
		double med;
		double sumatoria = 0;
		while (recorrer != null){
			sumatoria = sumatoria + recorrer.getDato();
			recorrer = recorrer.getSiguiente();
		}
		med = sumatoria/tamaño();
		return med;
	}
	
	public double desviacion(){
		Nodo recorrer = primero;
		double med = media();
		double aux = 0;
		double des = 0;
		while (recorrer != null){
			aux = aux + (recorrer.getDato()-med)*(recorrer.getDato()-med);
			recorrer =recorrer.getSiguiente();
		}
		if(tamaño() == 1){
			return des;
		}
		des = Math.sqrt(aux/(tamaño()-1));
		return des;
	}

}

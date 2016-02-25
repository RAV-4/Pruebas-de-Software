package co.edu.udea.ps.rs.test;

import static org.junit.Assert.*;

import org.junit.Test;

import co.edu.udea.ps.rs.ListaDobleLigada;

public class ListaDobleLigadaTest {

	ListaDobleLigada lista;
	double dato = 12.4;
	double datoDos = 13.7;
	double dato1 = 186;
	double dato2 = 699;
	double dato3 = 132;
	double dato4 = 272;
	double dato5 = 291;
	double dato6 = 331;
	double dato7 = 199;
	double dato8 = 1890;
	double dato9 = 788;
	double dato10 = 1601;

	
	@Test
	public void crearListaVacia() {
		lista = new ListaDobleLigada();
		assertEquals(lista.getPrimero(), null);
	}
	
	@Test
	public void crearListaConDato(){ // con esta prueba tambien validamos el getPrimero
		lista = new ListaDobleLigada(dato);
		assertTrue(dato == lista.getPrimero().getDato());
	}
	
	@Test
	public void getPrimero(){
		lista = new ListaDobleLigada(dato);
		assertTrue(dato == lista.getUltimo().getDato());
	}

	@Test
	public void esVacia(){
		lista = new ListaDobleLigada(dato);
		assertEquals(lista.esVacia(), false);
	}
	
	@Test
	public void insertar(){
		lista = new ListaDobleLigada(dato);
		lista.insertar(datoDos);
		assertTrue(datoDos == lista.getUltimo().getDato());
	}
	
	@Test
	public void tamaño(){
		lista = new ListaDobleLigada(dato);
		lista.insertar(datoDos);
		assertEquals(lista.tamaño(), 2);
	}
	
	@Test
	public void calculaMedia1(){
		lista = new ListaDobleLigada(dato);
		assertTrue(dato == lista.media());
	}
	
	@Test
	public void calculaMedia2(){
		lista = new ListaDobleLigada(dato);
		lista.insertar(datoDos);
		assertTrue(13.05 == lista.media());
	}
	
	@Test
	public void calculaMedia3(){
		lista = new ListaDobleLigada(dato1);
		lista.insertar(dato2);
		lista.insertar(dato3);
		lista.insertar(dato4);
		lista.insertar(dato5);
		lista.insertar(dato6);
		lista.insertar(dato7);
		lista.insertar(dato8);
		lista.insertar(dato9);
		lista.insertar(dato10);
		assertTrue(638.9 == lista.media());
	}
	
	@Test
	public void calcularDesviacion1(){
		lista = new ListaDobleLigada(dato);
		System.out.println(lista.desviacion());
		assertTrue(0 == lista.desviacion());
	}
	
	@Test
	public void calcularDesviacion2(){
		lista = new ListaDobleLigada(dato1);
		lista.insertar(dato2);
		lista.insertar(dato3);
		lista.insertar(dato4);
		lista.insertar(dato5);
		lista.insertar(dato6);
		lista.insertar(dato7);
		lista.insertar(dato8);
		lista.insertar(dato9);
		lista.insertar(dato10);
		assertTrue(625.6339806770231 == lista.desviacion());
	}
}

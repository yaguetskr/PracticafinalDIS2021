package prfinal.dis2021;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class listasuperheroestest {

	@Before
	public void setUp() throws Exception {
		System.out.println("Iniciando");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Prueba realizada");
	}

	@Test
	public void testListasuperheroes() {
		listasuperheroes list=new listasuperheroes();
		assertEquals(new ArrayList<superheroe>(),list.lista());
	}

	@Test
	public void testLista() {
		listasuperheroes list=new listasuperheroes();
		assertEquals(new ArrayList<superheroe>(),list.lista());
	}

	@Test
	public void testAdd() {
		listasuperheroes list=new listasuperheroes();
		list.add(new superheroe("1","Hombre","Clarke Kent","Superman",new Habilidades("magicos","fuego volador"),"Krypton"));
		System.out.println(new superheroe("1","Hombre","Clarke Kent","Superman",new Habilidades("magicos","fuego volador"),"Krypton"));
		System.out.println( list.lista().get(0));
		assertEquals("Clarke Kent",list.lista().get(0).getNombre());
	}

}

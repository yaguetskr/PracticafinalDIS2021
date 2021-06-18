package prfinal.dis2021;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Habilidadestest {

	@Before
	public void setUp() throws Exception {
		System.out.println("Iniciando");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Prueba realizada");
	}

	@Test
	public void testHabilidadesStringString() {
		Habilidades habs=new Habilidades("magicos","fuego volador");
		assertEquals("magicos",habs.getTipo());
		assertEquals("fuego volador",habs.getDefinicion());
		
	}

	@Test
	public void testGetTipo() {
		Habilidades habs=new Habilidades("magicos","fuego volador");
		assertEquals("magicos",habs.getTipo());
	}

	@Test
	public void testSetTipo() {
		Habilidades habs=new Habilidades("0","fuego volador");
		habs.setTipo("magicos");
		assertEquals("magicos",habs.getTipo());
	}

	@Test
	public void testGetDefinicion() {
		Habilidades habs=new Habilidades("magicos","fuego volador");
		assertEquals("fuego volador",habs.getDefinicion());
	}

	@Test
	public void testSetDefinicion() {
		Habilidades habs=new Habilidades("magicos","0");
		habs.setDefinicion("fuego volador");
		assertEquals("fuego volador",habs.getDefinicion());
	}

	@Test
	public void testToString() {

		Habilidades habs=new Habilidades("magicos","fuego volador");
		assertEquals("\n\t\t\t<Habilidades>\n\t\t\t\t<Tipo>magicos</Tipo>\n\t\t\t\t<Definicion>fuego volador</Definicion>\n\t\t\t</Habilidades>\n",habs.toString());
	}

}

package prfinal.dis2021;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Batallastest {

	@Before
	public void setUp() throws Exception {
		System.out.println("Iniciando");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Prueba realizada");
	}

	@Test
	public void testBatallas() {
		
		Batallas bat=new Batallas("Madrid","21-1-2041","3-1-2000");
		assertEquals("Madrid",bat.getLugar());
		assertEquals("21-1-2041",bat.getFechacom());
		assertEquals("3-1-2000",bat.getFechafin());
	}

	@Test
	public void testGetLugar() {
		Batallas bat=new Batallas("Madrid","21-1-2041","3-1-2000");
		assertEquals("Madrid",bat.getLugar());
		
	}

	@Test
	public void testSetLugar() {
		Batallas bat=new Batallas("Asturias","21-1-2041","3-1-2000");
		bat.setLugar("Madrid");
		assertEquals("Madrid",bat.getLugar());
	}

	@Test
	public void testGetFechacom() {
		Batallas bat=new Batallas("Madrid","21-1-2041","3-1-2000");
		assertEquals("21-1-2041",bat.getFechacom());
	}

	@Test
	public void testSetFechacom() {
		Batallas bat=new Batallas("Asturias","0","3-1-2000");
		bat.setFechacom("21-1-2041");
		assertEquals("21-1-2041",bat.getFechacom());
	}

	@Test
	public void testGetFechafin() {
		Batallas bat=new Batallas("Madrid","21-1-2041","3-1-2000");
		assertEquals("3-1-2000",bat.getFechafin());
	}

	@Test
	public void testSetFechafin() {
		Batallas bat=new Batallas("Asturias","21-1-2041","0");
		bat.setFechacom("3-1-2000");
		assertEquals("3-1-2000",bat.getFechacom());
		
	}

	@Test
	public void testToString() {
		
		Batallas bat=new Batallas("Madrid","21-1-2041","3-1-2000");
		assertEquals("\n\t\t\t\t<batalla>\n\t\t\t\t\t<lugar>Madrid</lugar>\n\t\t\t\t\t<Fecha comienzo>21-1-2041</Fecha comienzo>\n\t\t\t\t\t<Fecha fin>3-1-2000</Fecha fin>\n\t\t\t\t</batalla>\n",bat.toString());
	}

}


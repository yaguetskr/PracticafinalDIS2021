package prfinal.dis2021;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class superheroetest {

	@Before
	public void setUp() throws Exception {
		System.out.println("Iniciando");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Prueba realizada");
	}



	@Test
	public void testSuperheroeStringStringStringStringHabilidadesString() {
		superheroe superh=new superheroe("1","Hombre","Clarke Kent","Superman",new Habilidades("magicos","fuego volador"),"Krypton");
		assertEquals("1",superh.getId());
		assertEquals("Hombre",superh.getGenero());
		assertEquals("Clarke Kent",superh.getNombre());
		assertEquals("Superman",superh.getSecretid());
		assertEquals("Krypton",superh.getProcedencia());
	}

	@Test
	public void testAddbatalla() {
		superheroe superh=new superheroe("1","Hombre","Clarke Kent","Superman",new Habilidades("magicos","fuego volador"),"Krypton");
		superh.addbatalla(new Batallas("Madrid","21-1-2041","3-1-2000"));
		assertEquals(new Batallas("Madrid","21-1-2041","3-1-2000"),superh.getBats().get(0));
	}

	@Test
	public void testGetGenero() {
		superheroe superh=new superheroe("1","Hombre","Clarke Kent","Superman",new Habilidades("magicos","fuego volador"),"Krypton");
		assertEquals("Hombre",superh.getGenero());
	}

	@Test
	public void testSetGenero() {
		superheroe superh=new superheroe("1","0","Clarke Kent","Superman",new Habilidades("magicos","fuego volador"),"Krypton");
		superh.setGenero("Hombre");
		assertEquals("Hombre",superh.getGenero());
	}

	@Test
	public void testGetProcedencia() {
		superheroe superh=new superheroe("1","Hombre","Clarke Kent","Superman",new Habilidades("magicos","fuego volador"),"Krypton");
		assertEquals("Krypton",superh.getProcedencia());
	}

	@Test
	public void testSetProcedencia() {
		superheroe superh=new superheroe("1","Hombre","Clarke Kent","Superman",new Habilidades("magicos","fuego volador"),"0");
		superh.setProcedencia("Krypton");
		assertEquals("Krypton",superh.getProcedencia());
	}

	@Test
	public void testGetNombre() {
		superheroe superh=new superheroe("1","Hombre","Clarke Kent","Superman",new Habilidades("magicos","fuego volador"),"Krypton");
		assertEquals("Clarke Kent",superh.getNombre());
	}

	@Test
	public void testSetNombre() {
		superheroe superh=new superheroe("1","Hombre","0","Superman",new Habilidades("magicos","fuego volador"),"0");
		superh.setNombre("Clarke Kent");
		assertEquals("Clarke Kent",superh.getNombre());
	}

	@Test
	public void testGetSecretid() {
		superheroe superh=new superheroe("1","Hombre","Clarke Kent","Superman",new Habilidades("magicos","fuego volador"),"Krypton");
		assertEquals("Superman",superh.getNombre());
	}

	@Test
	public void testSetSecretid() {
		superheroe superh=new superheroe("1","Hombre","Clarke Kent","0",new Habilidades("magicos","fuego volador"),"0");
		superh.setNombre("Superman");
		assertEquals("Superman",superh.getNombre());
	}

	@Test
	public void testGetBats() {
		superheroe superh=new superheroe("1","Hombre","Clarke Kent","Superman",new Habilidades("magicos","fuego volador"),"Krypton");
		superh.addbatalla(new Batallas("Madrid","21-1-2041","3-1-2000"));
		assertEquals(new Batallas("Madrid","21-1-2041","3-1-2000"),superh.getBats().get(0));
	}

	@Test
	public void testSetBats() {
		superheroe superh=new superheroe("1","Hombre","Clarke Kent","Superman",new Habilidades("magicos","fuego volador"),"Krypton");
		ArrayList bats=new ArrayList<Batallas>();
		bats.add(new Batallas("Madrid","21-1-2041","3-1-2000"));
		superh.setBats(bats);
		assertEquals(bats,superh.getBats());
	}

	@Test
	public void testGetHabs() {
		superheroe superh=new superheroe("1","Hombre","Clarke Kent","Superman",new Habilidades("magicos","fuego volador"),"Krypton");
		assertEquals(new Habilidades("magicos","fuego volador"),superh.getHabs());
	}

	@Test
	public void testSetHabs() {
		Habilidades habs=new Habilidades("magicos","fuego volador");
		superheroe superh=new superheroe("1","Hombre","Clarke Kent","Superman",new Habilidades("0","0"),"Krypton");
		superh.setHabs(habs);
		assertEquals(new Habilidades("magicos","fuego volador"),superh.getHabs());
	}

	@Test
	public void testGetHabstipo() {
		superheroe superh=new superheroe("1","Hombre","Clarke Kent","Superman",new Habilidades("magicos","fuego volador"),"Krypton");
		assertEquals("magicos",superh.getHabstipo());
	}

	@Test
	public void testGetHabsdef() {
		superheroe superh=new superheroe("1","Hombre","Clarke Kent","Superman",new Habilidades("magicos","fuego volador"),"Krypton");
		assertEquals("fuego volador",superh.getHabsdef());
	}


	@Test
	public void testGetId() {
		superheroe superh=new superheroe("1","Hombre","Clarke Kent","Superman",new Habilidades("magicos","fuego volador"),"Krypton");
		assertEquals("1",superh.getId());
	}

	@Test
	public void testSetId() {
		superheroe superh=new superheroe("0","Hombre","Clarke Kent","Superman",new Habilidades("magicos","fuego volador"),"Krypton");
		superh.setId("1");
		assertEquals("1",superh.getId());
	}

}

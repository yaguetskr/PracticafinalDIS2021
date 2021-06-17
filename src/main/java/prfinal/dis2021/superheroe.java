package prfinal.dis2021;



import java.util.ArrayList;
public class superheroe {
	
	String id;
	String genero;
	String nombre;
	String secretid;
	ArrayList<Batallas> bats=new ArrayList<Batallas>();
	Habilidades habs;
	String procedencia;
	

	public superheroe() {
		
	}
	
	superheroe(String ident,String gen,String nom,String secret,Habilidades ha,String orig) {
		this.id=ident;
		this.genero=gen;
		this.nombre=nom;
		this.secretid=secret;
		this.habs=ha;
		this.procedencia=orig;
	}
	
	public void addbatalla(Batallas bat) {
		bats.add(bat);
		
	}
	
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSecretid() {
		return secretid;
	}
	public void setSecretid(String secretid) {
		this.secretid = secretid;
	}
	public ArrayList<Batallas> getBats() {
		return bats;
	}
	public void setBats(ArrayList<Batallas> bats) {
		this.bats = bats;
	}
	public Habilidades getHabs() {
		return habs;
	}
	public void setHabs(Habilidades habs) {
		this.habs = habs;
	}
	public String getHabstipo() {
		return habs.tipo;
	}
	public String getHabsdef() {
		return habs.definicion;
	}
	@Override
	public String toString() {
		return "\n\t\t<Superheroe>\n\t\t\t<Nombre>" +this.nombre +"</Nombre>\n\t\t\t<Identidad secreta>"+this.secretid+"</Identidad secreta>\n\t\t\t<Id>"+ this.id +"</Id>\n\t\t\t<Batallas>"+ this.bats+"\t\t\t</Batallas>\n\t\t\t"+ this.habs+"\n\t\t\t<Genero>"+this.genero+"</Genero>\n\t\t\t<Procedencia>"+ this.procedencia +"</Procedencia>\n\t\t</Superheroe>\n";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}

package prfinal.dis2021;



import java.util.ArrayList;
import java.util.List;

public class listasuperheroes {
	
	
	
	List<superheroe> lista;
	
	
	listasuperheroes() {
		
		lista=new ArrayList<superheroe>();
	}

	public List<superheroe> lista(){
		return this.lista;
	}
	
	
	public void add(superheroe superh) {
		this.lista.add(superh);
	}
	 
	

	 
	 

	
	
	
}

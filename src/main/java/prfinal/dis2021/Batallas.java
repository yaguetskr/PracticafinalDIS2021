package prfinal.dis2021;



public class Batallas {
	
	String lugar;
	String Fechacom;
	String Fechafin;
	
	Batallas(String lug,String fechac,String fechaf){
		lugar=lug;
		Fechacom=fechac;
		Fechafin=fechaf;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public String getFechacom() {
		return Fechacom;
	}
	public void setFechacom(String fechacom) {
		Fechacom = fechacom;
	}
	public String getFechafin() {
		return Fechafin;
	}
	public void setFechafin(String fechafin) {
		Fechafin = fechafin;
	}
	public String toString() {
		return"\n\t\t\t\t<batalla>\n\t\t\t\t\t<lugar>" +this.lugar +"</lugar>\n\t\t\t\t\t<Fecha comienzo>"+this.Fechacom+"</Fecha comienzo>\n\t\t\t\t\t<Fecha fin>"+this.Fechafin+"</Fecha fin>\n\t\t\t\t</batalla>\n";
	}
	
}

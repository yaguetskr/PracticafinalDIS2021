package prfinal.dis2021;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import javax.servlet.annotation.WebServlet;

import com.google.gson.Gson;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.View;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */


@Theme("mytheme")
public class MyUI extends UI implements View{
	
	
	
	
	
	ArrayList<superheroe> lista=new ArrayList<superheroe>();
	Gson gson = new Gson();
	
	

	

    
	
	
    HorizontalLayout opcioneslayout=new HorizontalLayout();
   
    int pos=-1;
    
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	try (Reader readerjson = new FileReader("heroes.json")) {

            // Convert JSON File to Java Object
    		
    		superheroe[] supers =gson.fromJson(readerjson, superheroe[].class);

    		lista.addAll(Arrays.asList(supers));

        } catch (IOException e) {
            
        }
    	setinicio();
    	
    }
    
    

    
    void setinicio() {
    	
    	
    	
    	
    	
    	final VerticalLayout layout = new VerticalLayout();
    	HorizontalLayout horizontal=new HorizontalLayout();
    	HorizontalLayout horizontal2=new HorizontalLayout();
    	
    	
    	Grid<superheroe> grid=new Grid<>();
    	grid.addColumn(superheroe::getNombre).setCaption("Nombre");
    	grid.addColumn(superheroe::getId).setCaption("ID");
    	grid.setWidth("100%");
    	Grid<superheroe> griddetalle=new Grid<>();
    	griddetalle.addColumn(superheroe::getId).setCaption("ID");
    	griddetalle.addColumn(superheroe::getNombre).setCaption("Nombre");
    	griddetalle.addColumn(superheroe::getGenero).setCaption("Genero");
    	griddetalle.addColumn(superheroe::getSecretid).setCaption("Identidad secreta");
    	griddetalle.addColumn(superheroe::getProcedencia).setCaption("Procedencia");
    	griddetalle.addColumn(superheroe::getHabstipo).setCaption("Tipo de habilidades");
    	griddetalle.addColumn(superheroe::getHabsdef).setCaption("Definicion de habilidades");
    	griddetalle.setWidth("100%");
    	griddetalle.setVisible(false);
    	Grid<Batallas> gridbatallas=new Grid<>();
    	gridbatallas.addColumn(Batallas::getLugar).setCaption("Lugar");
    	gridbatallas.addColumn(Batallas::getFechacom).setCaption("Fecha de comienzo");
    	gridbatallas.addColumn(Batallas::getFechafin).setCaption("Fecha final");
    	gridbatallas.setVisible(false);
    	gridbatallas.setWidth("100%");
    	Button cambiarcrear = new Button("Crear heroe");
    	Button cambiareditar = new Button("Editar este heroe");
    	cambiareditar.setVisible(false);
    	
    	final TextField idfield = new TextField();
    	Button buscar = new Button("Buscar heroe");
    	
    	
    	cambiarcrear.addClickListener(e -> {
        	
        	setcrearheroe();
        });
    	
    	cambiareditar.addClickListener(e -> {
        	
        		seteditarheroe(pos);
        	
        });
    	
    	buscar.addClickListener(e -> {
    		Integer encontrado=0;
        	superheroe superh=null;
    		for(superheroe i : lista) {
    			
    			if (i.getId().equals(idfield.getValue())) {
    				
    				
    				superh=i;
    				encontrado=1;
    				griddetalle.setItems(Arrays.asList(superh));
    				griddetalle.setVisible(true);
    				gridbatallas.setItems((superh.getBats()));
    				griddetalle.setVisible(true);
    				pos=lista.indexOf(superh);
    	    		
    	    		gridbatallas.setVisible(true);
    	    		cambiareditar.setVisible(true);
    			}
    			
    		}
    		if(encontrado==0) {
				griddetalle.setVisible(false);
				System.out.println(1);
				layout.addComponent(new Label("Heroe no encontrado"));
				cambiareditar.setVisible(false);
			}
			
    		
    		
    		
    		
        	
        });
    	
    	
    	horizontal.addComponents(cambiarcrear);
    	horizontal2.addComponents(idfield,buscar,cambiareditar);
        layout.addComponents(horizontal,grid,horizontal2,griddetalle,gridbatallas);
        grid.setItems(lista);
        setContent(layout);
    	
    	
    	
    }
    
    
    void setcrearheroe() {
    	
    	ArrayList<Batallas> battles =new ArrayList<>();
    	
    	Grid<Batallas> grid=new Grid<>();
    	grid.setWidth("100%");
    	grid.addColumn(Batallas::getLugar).setCaption("Lugar");
    	grid.addColumn(Batallas::getFechacom).setCaption("Inicio");
    	grid.addColumn(Batallas::getFechafin).setCaption("Fin");
    	
        final TextField namefield = new TextField();
        final TextField generofield = new TextField();
        final TextField secretidfield = new TextField();
        final TextField lugarfield = new TextField();
        final TextField fechacfield = new TextField();
        final TextField fechafinfield = new TextField();
        final TextField procedenciafield = new TextField();
        final TextField tipofield = new TextField();
        final TextField definicionfield = new TextField();
        
        Label  batallaslb = new Label ("Batallas en las que ha participado (al menos una) :");
        Label  datoslb = new Label ("Datos del heroe :");
        Button crear = new Button("Crear heroe");
        Button añadir = new Button("Añadir batalla");
        Button inicio = new Button("Inicio");
        
        HorizontalLayout form2layout=new HorizontalLayout();
        HorizontalLayout form1layout=new HorizontalLayout();
        HorizontalLayout batallasform=new HorizontalLayout();
        VerticalLayout crearheroe=new VerticalLayout();
        
        namefield.setCaption("Nombre:");
        generofield.setCaption("Genero:");
        secretidfield.setCaption("Identidad secreta:");
        lugarfield.setCaption("Lugar de batalla:");
        fechacfield.setCaption("Fecha de inicio");
        fechafinfield.setCaption("Fecha de fin:");
        procedenciafield.setCaption("Procedencia:");
        tipofield.setCaption("Tipo de habilidades:");
        definicionfield.setCaption("Descripción de las habilidades:");
        batallasform.addComponents(lugarfield,fechacfield,fechafinfield);
        form1layout.addComponents(namefield,generofield,secretidfield);
        form2layout.addComponents(procedenciafield,tipofield,definicionfield);

        inicio.addClickListener(e -> {
        	setinicio();
        });
        
        añadir.addClickListener(e -> {
        	battles.add(new Batallas(lugarfield.getValue(),fechacfield.getValue(),fechafinfield.getValue()));
        	grid.setItems(battles);
        });
        
        crear.addClickListener(e -> {
        	
        	if(battles.isEmpty()==false) {
        		String id=Integer.toString(lista.size()+1);
	        	superheroe sup=new superheroe(id,generofield.getValue(),namefield.getValue(),secretidfield.getValue(),new Habilidades(tipofield.getValue(),definicionfield.getValue() ) ,procedenciafield.getValue() );
	        	sup.bats=battles;
	        	lista.add(sup);
	        	
	        	
	        	try (FileWriter writer = new FileWriter("heroes.json")) {
	        		
	                gson.toJson(lista, writer);
	            } catch (IOException j) {
	                j.printStackTrace();
	            }
	        	
	            crearheroe.addComponent(new Label("Heroe añadido correctamente"));
	            form1layout.setVisible(true);
	            
        	}else {
        		crearheroe.addComponent(new Label("No puedes crear un heroe sin batallas"));
        	}
        });
        
        grid.setItems(battles);
        crearheroe.addComponents(inicio,batallaslb,batallasform,añadir,grid,datoslb,form1layout,form2layout,crear);
    	setContent(crearheroe);
    }

    
    void seteditarheroe(int pos){
    	
    	ArrayList<Batallas> battles =new ArrayList<>();
    	
    	Grid<Batallas> grid=new Grid<>();
    	grid.setWidth("100%");
    	grid.addColumn(Batallas::getLugar).setCaption("Lugar");
    	grid.addColumn(Batallas::getFechacom).setCaption("Inicio");
    	grid.addColumn(Batallas::getFechafin).setCaption("Fin");
    	
        final TextField namefield = new TextField();
        namefield.setValue( lista.get(pos).getNombre() );
        final TextField generofield = new TextField();
        generofield.setValue( lista.get(pos).getGenero() );
        final TextField secretidfield = new TextField();
        secretidfield.setValue( lista.get(pos).getSecretid() );
        final TextField lugarfield = new TextField();
        
        final TextField fechacfield = new TextField();
        
        final TextField fechafinfield = new TextField();
        
        final TextField procedenciafield = new TextField();
        procedenciafield.setValue( lista.get(pos).getProcedencia() );
        final TextField tipofield = new TextField();
        tipofield.setValue( lista.get(pos).getHabs().getTipo() );
        final TextField definicionfield = new TextField();
        definicionfield.setValue( lista.get(pos).getHabs().getDefinicion() );
        
        Label  batallaslb = new Label ("Batallas en las que ha participado (al menos una) :");
        Label  datoslb = new Label ("Datos del heroe :");
        Button crear = new Button("Confirmar cambios");
        Button añadir = new Button("Añadir batalla");
        Button inicio = new Button("Inicio");
        
        HorizontalLayout form2layout=new HorizontalLayout();
        HorizontalLayout form1layout=new HorizontalLayout();
        HorizontalLayout batallasform=new HorizontalLayout();
        VerticalLayout crearheroe=new VerticalLayout();
        
        namefield.setCaption("Nombre:");
        generofield.setCaption("Genero:");
        secretidfield.setCaption("Identidad secreta:");
        lugarfield.setCaption("Lugar de batalla:");
        fechacfield.setCaption("Fecha de inicio");
        fechafinfield.setCaption("Fecha de fin:");
        procedenciafield.setCaption("Procedencia:");
        tipofield.setCaption("Tipo de habilidades:");
        definicionfield.setCaption("Descripción de las habilidades:");
        batallasform.addComponents(lugarfield,fechacfield,fechafinfield);
        form1layout.addComponents(namefield,generofield,secretidfield);
        form2layout.addComponents(procedenciafield,tipofield,definicionfield);

        inicio.addClickListener(e -> {
        	setinicio();
        });
        
        añadir.addClickListener(e -> {
        	battles.add(new Batallas(lugarfield.getValue(),fechacfield.getValue(),fechafinfield.getValue()));
        	grid.setItems(battles);
        });
        
        crear.addClickListener(e -> {
        	String id=lista.get(pos).getId();
        	superheroe sup=new superheroe(id,generofield.getValue(),namefield.getValue(),secretidfield.getValue(),new Habilidades(tipofield.getValue(),definicionfield.getValue() ) ,procedenciafield.getValue() );
        	sup.bats=battles;

        	lista.set(pos,sup);
        	
        	
        	try (FileWriter writer = new FileWriter("heroes.json")) {
        		
                gson.toJson(lista, writer);
            } catch (IOException j) {
                j.printStackTrace();
            }
            
            crearheroe.addComponent(new Label("Heroe editado correctamente"));
            form1layout.setVisible(true);
        });
        
        grid.setItems(battles);
        crearheroe.addComponents(inicio,batallaslb,batallasform,añadir,grid,datoslb,form1layout,form2layout,crear);
    	setContent(crearheroe);
    }
    
    
    
    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}

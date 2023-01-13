package ec.edu.ups.proyectoWeb.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.proyectoWeb.bussines.GestionPersonaON;
import ec.edu.ups.proyectoWeb.model.Persona;

@Named
@RequestScoped
public class PersonaBeans {

	private String cedula;
	private String nombre;
	private String direccion;
	private String correo;
	
	private List<Persona> personas;
	
	@PostConstruct
	public void init() {
		llenarLista();
	}
	
	@Inject
	private GestionPersonaON personaOn;
	
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void guardar() {	
		
		Persona per = new Persona();
		
		per.setCedula(this.cedula);
		per.setNombre(this.nombre);
		per.setCorreo(this.correo);
		per.setDireccion(this.direccion );
		
		
		personaOn.guardarPersona(per);
		
	}
	
	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public void llenarLista() {
		personas = personaOn.getClientes();
	}
}

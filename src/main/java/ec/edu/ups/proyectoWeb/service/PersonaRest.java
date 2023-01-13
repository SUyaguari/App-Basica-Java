package ec.edu.ups.proyectoWeb.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ec.edu.ups.proyectoWeb.bussines.GestionPersonaON;
import ec.edu.ups.proyectoWeb.model.Persona;

@Path("persona")
public class PersonaRest {

	@Inject
	private GestionPersonaON gestion;
	
	@Path("ingreso")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Respuesta crearCliente(Persona persona) {
		Respuesta res= new Respuesta();
		try {
			gestion.guardarPersona(persona);
			res.setCodigo(1);
			res.setMensaje("Guardado Correctamente");
			return res;
		}catch(Exception e) {
			res.setCodigo(99);
			res.setMensaje("Error al guardar");
			return res;
		}
	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Persona> getClientes(){
		List<Persona> clientes = gestion.getClientes();
		return clientes;
	}
}

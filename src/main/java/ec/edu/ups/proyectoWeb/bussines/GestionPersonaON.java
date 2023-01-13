package ec.edu.ups.proyectoWeb.bussines;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.proyectoWeb.dao.PersonaDAO;
import ec.edu.ups.proyectoWeb.model.Persona;

@Stateless
public class GestionPersonaON {

	@Inject
	private PersonaDAO personaDao;
	
	public void guardarPersona(Persona pe) {
		
		Persona p  = personaDao.read(pe.getCedula());
		if(p==null) 
			personaDao.insert(pe);
		}
	
	public Persona buscarUsuario(String cedula, String correo) {
		
	Persona p = personaDao.read(cedula);
		
		if(p != null & p.getCorreo().equals(correo)) {
			
			return p;	
			
		}
				
		return null;
	}
	
	public List<Persona> getClientes() {
		return personaDao.getList();
	}
}

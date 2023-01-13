package ec.edu.ups.proyectoWeb.service;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;


	@Provider
	public class CORSFilter implements ContainerResponseFilter {

	    @Override
	    public void filter(ContainerRequestContext request, ContainerResponseContext response) throws IOException {
	    	request.getHeaders().add("Access-Control-Allow-Origin", "*");
	        //cres.getHeaders().add("Vary", "Origen");
	    	response.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
	    	response.getHeaders().add("Access-Control-Allow-Credentials", "true");
	    	response.getHeaders().add("Access-Control-Allow-Headers", "X-Requested-With");
	    	response.getHeaders().add("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS, HEAD");
	    	response.getHeaders().add("Access-Control-Max-Age", "1209600");
	    }
	}



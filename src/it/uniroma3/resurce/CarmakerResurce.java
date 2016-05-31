package it.uniroma3.resurce;


import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import it.uniroma3.resurce.Carmaker;
import it.uniroma3.resurce.Car;


@Stateless
@Path("/carmaker/{id}")
public class CarmakerResurce {

	@Context
	private UriInfo uriInfo;

	@PersistenceContext(unitName = "unit-progetto")
	private EntityManager em;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Carmaker getCarmaker(@PathParam("id") int id) {
		try {
			Carmaker cm = em.find(Carmaker.class, id);
			if (cm==null) {
				throw new WebApplicationException(Response.Status.NOT_FOUND);
			} else {
				return cm;
			}
		} catch (Exception e) {
			String errorMessage = "Error";
			throw new WebApplicationException(
					Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(errorMessage).type("text/plain").build());
		}
	}

	@DELETE
	public Response deleteCarmaker(@PathParam("id") int id) {
		try {
			Carmaker carmaker = em.find(Carmaker.class, id);
			em.remove(carmaker);
			return Response.ok(carmaker).status(Response.Status.OK).build();
		} catch (Exception e) {
			String errorMessage = "Error";
			throw new WebApplicationException(
					Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(errorMessage).type("text/plain").build());
		}
	}
	


}

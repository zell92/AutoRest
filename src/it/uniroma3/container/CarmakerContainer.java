package it.uniroma3.container;

import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import it.uniroma3.resurce.Car;
import it.uniroma3.resurce.Carmaker;



@Stateless
@Path("/carmakers")
public class CarmakerContainer {

	@Context
	private UriInfo uriInfo;

	@PersistenceContext(unitName = "unit-progetto")
	private EntityManager em;

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Carmaker> getCarmakers() {
		try {
			List<Carmaker> carmakers =
					em.createQuery("SELECT c FROM Carmaker c").getResultList();
			return carmakers;
		} catch (Exception e) {
			System.out.println("Errore");
			return null;
		}

	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response createCarmaker(@FormParam("name") String name) {
		List<Car> cars = new LinkedList<Car>();
		Carmaker carmaker = new Carmaker(name, cars);
		try {
			em.persist(carmaker);
			return Response.created(URI.create("/" + carmaker.getId())).entity(carmaker).build();
		} catch (Exception e)  {
			String errorMessage = "Error";
			throw new WebApplicationException(
					Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(errorMessage).type("text/plain").build());
		}
	}


}

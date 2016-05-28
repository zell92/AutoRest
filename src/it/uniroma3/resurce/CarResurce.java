package it.uniroma3.resurce;


import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import it.uniroma3.resurce.Car;


@Stateless
@Path("/car/{id}")
public class CarResurce {

	@Context
	private UriInfo uriInfo;

	@PersistenceContext(unitName = "unit-progetto")
	private EntityManager em;

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Car getCar(@PathParam("id") int id) {
		try {
			Car c = em.find(Car.class, id);
			if (c==null) {
				throw new WebApplicationException(Response.Status.NOT_FOUND);
			} else {
				return c;
			}
		} catch (Exception e) {
			String errorMessage = "Error";
			throw new WebApplicationException(
					Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(errorMessage).type("text/plain").build());
		}
	}

	@DELETE
	//@Transactional
	public Response deleteProduct(@PathParam("id") int id) {
		try {
			Car car = em.find(Car.class, id);
			em.remove(car);
			return Response.ok(car).status(Response.Status.OK).build();
		} catch (Exception e) {
			String errorMessage = "Error";
			throw new WebApplicationException(
					Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(errorMessage).type("text/plain").build());
		}
	}
}

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
@Path("/cars")
public class CarContainer {

	@Context
	private UriInfo uriInfo;

	@PersistenceContext(unitName = "unit-progetto")
	private EntityManager em;

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Car> getCars() {
		try {
			List<Car> cars =
					em.createQuery("SELECT c FROM Car c").getResultList();
			return cars;
		} catch (Exception e) {
			System.out.println("Errore");
			return null;
			}

	}

	@Path("/{id}")
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Car> getCarmakerCars(@PathParam("id") int id) {
		try {
			List<Car> cars =
					em.createQuery("SELECT c FROM Car c WHERE c.carmaker.id = :cmId").setParameter("cmId", id).getResultList();
			return cars;
		} catch (Exception e) {
			System.out.println("Errore");
			return null;
			}

	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response createCar(
			@FormParam("model") String model,
			@FormParam("price") Float price,
			@FormParam("description") String description,
			@FormParam("code") String code,
			@FormParam("carmakerId") Long carmakerId) {
		Carmaker cm = null;
		try {
			if(carmakerId!=null)
			 cm = em.find(Carmaker.class, carmakerId);
			Car car = new Car(model,price,description,code,cm);
			em.persist(car);
			return Response.created(URI.create("/" + car.getId())).entity(car).build();
		} catch (Exception e)  {
			String errorMessage = "Error";
			throw new WebApplicationException(
					Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(errorMessage).type("text/plain").build());
		}
	}
	
	
	
	

}

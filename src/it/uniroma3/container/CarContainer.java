package it.uniroma3.container;


import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import it.uniroma3.resurce.Car;


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

}

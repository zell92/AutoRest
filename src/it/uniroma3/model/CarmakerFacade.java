package it.uniroma3.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class CarmakerFacade {
	
	@PersistenceContext(unitName = "unit-progetto")
	private EntityManager em;
	
	public Carmaker createCarmaker(String name) {
		
		List<Car> cars = new LinkedList<Car>();
		Carmaker carmaker = new Carmaker(name,cars);
		em.persist(carmaker);
		return carmaker;
	}
	
	public List<Carmaker> getAllCarmakers() {
        CriteriaQuery<Carmaker> cq = em.getCriteriaBuilder().createQuery(Carmaker.class);
        cq.select(cq.from(Carmaker.class));
        List<Carmaker> carmakers= em.createQuery(cq).getResultList();
		return carmakers;
	}
	

	
	public List<Car> getCars(Carmaker carmaker) {
		List<Car> cars = this.em.createQuery("SELECT c FROM Car c WHERE c.carmaker.id = :cmId").setParameter("cmId", carmaker.getId()).getResultList();
		if(cars.size() == 0) 
			return null;
		else
			return cars;
	}
	public Carmaker getCarmaker(Long id) {
		return this.em.find(Carmaker.class, id);
	}
	
	
    private void deleteCarmaker(Carmaker carmaker) {
        em.remove(carmaker);
    }

	public void deleteCarmaker(Long id) {
        Carmaker carmaker = em.find(Carmaker.class, id);
        deleteCarmaker(carmaker);
	}

	
}

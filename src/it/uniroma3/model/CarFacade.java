package it.uniroma3.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class CarFacade {

	@PersistenceContext(unitName = "unit-progetto")
	private EntityManager em;

	public Car createCar(String model, Float price, String description, String code,Carmaker carmaker) {
		Car car = new Car(model,price,description,code,carmaker);
		
		this.em.persist(car);
		return car;
	}

	
	public List<Car> getAllCars() {
        CriteriaQuery<Car> cq = em.getCriteriaBuilder().createQuery(Car.class);
        cq.select(cq.from(Car.class));
        List<Car> cars = em.createQuery(cq).getResultList();
		return cars;
	}
	
	
	
	public Car getCar(Long id) {
	    Car car = em.find(Car.class, id);
		return car;
	}
	
	public void updateCar(Car car){
		this.em.merge(car);
	}
	 private void deleteCar(Car car) {
	        em.remove(car);
	    }

		public void deleteCar(Long id) {
	        Car car = em.find(Car.class, id);
	        deleteCar(car);
		}
	

}

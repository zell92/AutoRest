package it.uniroma3.controller;

import it.uniroma3.model.Car;
import it.uniroma3.model.Carmaker;
import it.uniroma3.model.CarmakerFacade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
public class CarmakerController {
	@ManagedProperty(value="#{param.carmakerId}")
	private Long id;
	private String name;
	private List<Car> cars;
	private List<Carmaker> carmakers;
	private Carmaker carmaker;


	
	@EJB
	private CarmakerFacade carmakerFacade;

	public String createCarmaker() {
		try{
		this.carmaker = carmakerFacade.createCarmaker(name);
		return listCarmakers(); 
		}catch(EJBTransactionRolledbackException e){
			return "errore";
		}
		
	}
	


	public String showCars(){
		this.carmaker = this.carmakerFacade.getCarmaker(id);
		
		this.cars=this.carmakerFacade.getCars(this.carmaker);	
		if(this.cars==null)
			this.cars= new ArrayList<Car>();

			return "listaMacchine";
	}
	
	
	public String listCarmakers(){
		this.carmakers=this.carmakerFacade.getAllCarmakers();	
			return "listaCaseAutomobilistiche";
	}
	
	public String deleteCarmaker(){
		this.carmakerFacade.deleteCarmaker(this.id);
		return listCarmakers();
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public List<Car> getCars() {
		return cars;
	}



	public void setCars(List<Car> cars) {
		this.cars = cars;
	}



	public Carmaker getCarmaker() {
		return carmaker;
	}



	public void setCarmaker(Carmaker carmaker) {
		this.carmaker = carmaker;
	}



	public List<Carmaker> getCarmakers() {
		return carmakers;
	}



	public void setCarmakers(List<Carmaker> carmakers) {
		this.carmakers = carmakers;
	}








}

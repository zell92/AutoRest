package it.uniroma3.controller;

import it.uniroma3.model.Car;
import it.uniroma3.model.Carmaker;
import it.uniroma3.model.CarmakerFacade;


import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CreatorController {

	private List<Carmaker> carmakers;
	
	@EJB
	private CarmakerFacade carmakerFacade;


	public String newCar(){
		this.carmakers=this.carmakerFacade.getAllCarmakers();	
		return "newCar";
	}




	public List<Carmaker> getCarmakers() {
		return carmakers;
	}



	public void setCarmakers(List<Carmaker> carmakers) {
		this.carmakers = carmakers;
	}








}

package it.uniroma3.resurce;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQuery(name = "findAllCarmakers", query = "SELECT cm FROM Carmaker cm")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Carmaker {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@XmlAttribute
	private long id;
	
	@Column(nullable=false)
	@XmlElement
	private String name;
	
	
	@OneToMany(mappedBy = "carmaker", cascade = {CascadeType.REMOVE})
	@XmlElement
	private List<Car> cars;

	public Carmaker() {}

	public Carmaker(String name,List<Car> cars) {
		this.name = name;
		this.cars = cars;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	
}

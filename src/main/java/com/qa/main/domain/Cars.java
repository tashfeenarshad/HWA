package com.qa.main.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cars {

		// Columns 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//@Column(name = "carMake")
	//@Column(unique = true)-can be dine
	 @Column(nullable = false)
	private String carMake; //creates a column called car_make with datatype in mysql it would be VARCHAR(255)
	
	 @Column(nullable = false)
	private int Bhp; //column=age datatype=int

	//constructors 
	 //default
	 public Cars() {}
	 // for creating(without id)
	  public Cars(String carMake, int bhp) {
		super();
		this.carMake = carMake;
		Bhp = bhp;
	}


	 
	// for reading 
	public Cars(long id, String carMake, int bhp) {
		super();
		this.id = id;
		this.carMake = carMake;
		this.Bhp = bhp;
	}
	 
	 
	
	// getters and setters
	 public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

	public String getCarMake() {
		return carMake;
	}

	public void setCarMake(String carMake) {
		this.carMake = carMake;
	}

	public int getBhp() {
		return Bhp;
	}

	public void setBhp(int bhp) {
		Bhp = bhp;
	}
	//override methods
	@Override
	public int hashCode() {
		return Objects.hash(Bhp, carMake, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cars other = (Cars) obj;
		return Bhp == other.Bhp && Objects.equals(carMake, other.carMake) && id == other.id;
	}
	
	
	
}

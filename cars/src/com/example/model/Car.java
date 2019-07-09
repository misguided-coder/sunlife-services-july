package com.example.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {

	@XmlElement(name="vin")
	int vin;
	
	@Size(min=5,max=8,message="Model length should be in between 5 and 8 only.")
	@XmlElement(name="model")
	String model;
	
	@NotEmpty(message="Make can not be empty string")
	@XmlElement(name="make")
	String make;
	
	@Min(5000)
	@Max(100000)
	@XmlElement(name="price")
	double price;

	public Car() {
	}

	public Car(String model, String make, double price) {
		this.model = model;
		this.make = make;
		this.price = price;
	}

	public Car(int vin, String model, String make, double price) {
		this.vin = vin;
		this.model = model;
		this.make = make;
		this.price = price;
	}

	public int getVin() {
		return vin;
	}

	public void setVin(int vin) {
		this.vin = vin;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}

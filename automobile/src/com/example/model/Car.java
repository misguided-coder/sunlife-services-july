package com.example.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {

	@XmlElement(name="vin")
	//@JsonIgnore(true)
	//@XmlAttribute(name="vin")
	@JsonProperty("vin")
	int vin;
	
	@XmlElement(name="model")
	@JsonProperty("name")
	String model;
	
	@XmlElement(name="make")
	String make;
	
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

package com.example.resource;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Singleton;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.hibernate.validator.constraints.NotEmpty;

import com.example.model.Car;

@Path("API")
@Singleton
public class CarManagerResource {

	Map<Integer, Car> data = null;

	public CarManagerResource() {
		System.out.println("Inside CarManagerResource constructor!!!!!");
		data = new HashMap<>();
		data.put(100,new Car(100, "XF", "Jaguar", 89000000.00));
		data.put(101,new Car(101, "A5", "Audi", 6000000.00));
		data.put(102,new Car(102, "Q7", "Audi", 80000000.00));
		data.put(103,new Car(103, "X5", "BMW", 12000000.00));
		data.put(104,new Car(104, "X6", "BMW", 5000000.00));
	}

	@DELETE
	@Path("CAR/VIN/{vin}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteCar(@PathParam("vin") int vin) {
		System.out.println("Inside deleteCar()!!!!!!");
		data.remove(vin);
		return "Car '"+vin+"' deleted successfully";
	}


	@PUT
	@Path("CAR/VIN/{vin}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateCar(Car car,@PathParam("vin") int vin) {
		System.out.println("Inside updateCar()!!!!!!");
		car.setVin(vin);
		data.put(vin, car);
		return "Car '"+vin+"' updated successfully";
	}


	@POST
	@Path("CAR")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String oneMoreCar(@Valid Car car) {
		System.out.println("Inside oneMoreCar()!!!!!!");
		int vin = data.size()+100;
		car.setVin(vin);
		data.put(vin, car);
		return "Car '"+vin+"' added successfully";
	}
	
	
	@POST
	@Path("CAR")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_XML)
	public String newCar(@Valid Car car) {
		System.out.println("Inside newCar()!!!!!!");
		int vin = data.size()+100;
		car.setVin(vin);
		data.put(vin, car);
		return "Car '"+vin+"' added successfully";
	}
	
	@POST
	@Path("CAR/MODEL/{model}/MAKE/{make}/PRICE/{price}")
	@Produces(MediaType.TEXT_PLAIN)
	public String addNewCar(
			@Size(min=5,max=8,message="Model length should be in between 5 and 8 only.")
			@PathParam("model") String model,
			@NotEmpty(message="Make can not be empty string")
			@PathParam("make") String make,
			@Min(5000)
			@Max(100000)
			@PathParam("price") double price) {
		System.out.println("Inside addNewCar()!!!!!!");
		int vin = data.size()+100;
		Car car = new Car(vin,model,make,price);
		data.put(vin, car);
		return "Car '"+vin+"' added successfully";
	}
	
	
	@POST
	@Path("CAR")
	@Produces(MediaType.TEXT_PLAIN)
	public String addCar(@QueryParam("model") String model,
			@QueryParam("make") String make,
			@QueryParam("price") double price) {
		System.out.println("Inside addCar()!!!!!!");
		int vin = data.size()+100;
		Car car = new Car(vin,model,make,price);
		data.put(vin, car);
		return "Car '"+vin+"' added successfully";
	}
	

	@GET
	@Path("CARS")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Car> readAllCars(@PathParam("vin") int vin) {
		System.out.println("Inside readAllCars()!!!!!!");
		return data.values();
	}
	
	@GET
	@Path("CAR")
	@Produces(MediaType.APPLICATION_JSON)
	public @Valid Car readFromDB(@QueryParam("vin") int vin) {
		System.out.println("Inside readFromDB()!!!!!!");
		return data.get(vin);
	}
	
	@GET
	@Path("CAR/VIN/{vin}")
	@Produces(MediaType.APPLICATION_JSON)
	public Car readDataFromDB(@PathParam("vin") int vin) {
		System.out.println("Inside readDataFromDB()!!!!!!");
		return data.get(vin);
	}
	
	
	@GET
	@Path("getSingleCar/{vin}")
	//@Produces({ "application/json" })
	@Produces(MediaType.APPLICATION_JSON)
	public Car readDynamicDataFromDB(@PathParam("vin") int vin) {
		System.out.println("Inside readDynamicDataFromDB()!!!!!!");
		return data.get(vin);
	}

	@GET
	@Path("getSingleCar")
	@Produces({ "application/xml", "application/json" })
	public Car readDynamicCar() {
		System.out.println("Inside readDynamicCar()!!!!!!");
		Car car = new Car(2000, "XF", "Jaguar", 89000000.00);
		return car;
	}

	@GET
	@Path("getCar") // URI ----- http://localhost:8080/automobile/rest/car/single
	@Produces("text/plain")
	public String readSingleCar() {
		System.out.println("Inside readSingleCar()!!!!!!");
		return "It is all about luxury cars";
	}

	@GET
	@Path("getCar")
	@Produces("application/xml")
	public String readOneCar() {
		System.out.println("Inside readOneCar()!!!!!!");
		return "<car><vin>1000</vin><model>X6</model><make>BMW</make><price>2900000.00</price></car>";
	}

	@GET
	@Path("getCar")
	@Produces("application/json")
	public String readOneCarOnly() {
		System.out.println("Inside readOneCarOnly()!!!!!!");
		return "{\"vin\":1000,\"model\":\"X6\",\"make\":\"BMW\",\"price\":2900000.00}";
	}

	@GET
	@Path("getCar")
	@Produces("text/html")
	public String readOneCarHTMLOnly() {
		System.out.println("Inside readOneCarHTMLOnly()!!!!!!");
		return "<div><h2>VIN : 1000</h2><h2>Model : Q5</h2><h2>Make : Audi</h2><h2>Price : 10000000.00</h2></div>";
	}

}

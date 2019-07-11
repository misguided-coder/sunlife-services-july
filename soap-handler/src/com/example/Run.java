package com.example;

import javax.xml.ws.Endpoint;

public class Run {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:5000/services/calc",new Calculator());
	}
}

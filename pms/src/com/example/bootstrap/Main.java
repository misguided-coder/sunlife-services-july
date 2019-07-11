package com.example.bootstrap;

import javax.xml.ws.Endpoint;

import com.example.service.PoliticianServiceImpl;

public class Main {
	
	public static void main(String[] args) {
		
		Endpoint.publish("http://localhost:7000/pms/services",new PoliticianServiceImpl());
		System.out.println("Server is up and Service is also running........");
	}

}

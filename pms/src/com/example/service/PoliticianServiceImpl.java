package com.example.service;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService(
		//serviceName = "PoliticianSecretService",
		portName = "IPoliticianService", 
		//targetNamespace = "http://sunlife.example.com",
		endpointInterface="com.example.service.IPoliticianService")
public class PoliticianServiceImpl {

	Map<String, String> info = new HashMap<>();

	public PoliticianServiceImpl() {
		info.put("Lalu", "240CR");
		info.put("Raja", "740CR");
		info.put("Pawar", "290CR");
		info.put("Sonia", "540CR");
	}

	@WebMethod(operationName="FraudCount")
	public String fraudCount(@WebParam(name="policitianName") String policitianName) {
		System.out.println("Inside fraudCount()!!!!");
		return info.get(policitianName);
	}

}



package com.example.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class Main {

	public static void main(String[] args) throws Exception {
		
		URL wsdlLocation = new URL("http://localhost:7000/pms/services?wsdl");
		QName name = new QName("http://service.example.com/", "PoliticianServiceImplService");
		
		Service service = Service.create(wsdlLocation, name);
		
		IPoliticianService port = service.getPort(IPoliticianService.class);
		String result = port.fraudCount("Raja");
		
		System.out.printf("Fraud Count : %s%n",result);
		
	}
	
}

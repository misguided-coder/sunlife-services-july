package com.example;

import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;

public class Client {

	public static void main(String[] args)  throws Exception{
		
	URL url = new URL("file:///C:/workspace/client/src/CALC1.0.0.wsdl");
		
	QName qname = new QName("http://example.com/", "CalculatorService");
 
        Service service = Service.create(url, qname);
 
        Calculator calculatorPort = service.getPort(Calculator.class);
        
        Map<String, Object> req_ctx = ((BindingProvider)calculatorPort).getRequestContext();
        
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "Bearer 84d3862e387caa12219ee321280d610d");
        
        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
        
         System.out.println(calculatorPort.doSum(20, 40));
				
	}
}

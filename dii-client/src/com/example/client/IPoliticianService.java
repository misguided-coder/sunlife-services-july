package com.example.client;

import javax.jws.WebService;

@WebService(targetNamespace="http://service.example.com/")
public interface IPoliticianService {
	public String fraudCount(String arg0);
}

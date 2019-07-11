package com.example.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
//@SOAPBinding(style=Style.DOCUMENT)
public interface IPoliticianService {
	@WebMethod
	public String fraudCount(String policitianName) ;
}

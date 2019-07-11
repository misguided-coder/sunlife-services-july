package com.example;

import java.util.Date;

import javax.jws.WebService;

@WebService
public class Calculator {

	public int doSum(int a,int b){
		System.out.println("Inside doSum() "+new Date());
		return a+b;
	}

	public int doDiff(int a,int b){
		System.out.println("Inside doDiff() "+new Date());
		return a-b;
	}	
}

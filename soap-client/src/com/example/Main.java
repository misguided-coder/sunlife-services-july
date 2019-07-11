package com.example;

public class Main {
	
	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();
		CalculatorSoap port = calculator.getCalculatorSoap(); 
		int rs = port.add(10,40);
		System.out.printf("SUM : %s%n",rs);
	}

}

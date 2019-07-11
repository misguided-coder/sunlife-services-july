package com.example;

import javax.jws.HandlerChain;
import javax.jws.WebService;

@WebService
@HandlerChain(file="./handler-chain.xml")
public class Calculator {

	public int sum(int ,int j)
		return i+j;
	}
}

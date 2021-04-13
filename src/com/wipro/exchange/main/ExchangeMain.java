package com.wipro.exchange.main;

import com.wipro.exchange.exception.InvalidDestinationNodeException;
import com.wipro.exchange.exception.InvalidSourceNodeException;
import com.wipro.exchange.service.ExchangeService;

public class ExchangeMain {

	public static void main(String[] args) throws InvalidSourceNodeException, InvalidDestinationNodeException {
		
		
		int source[]= {10,2,5,4,5,10};
		int destination[]={1,5,10,2,2,5};
		int index=0;
		
		ExchangeService ess = new ExchangeService();
		
		System.out.println(ess.searchExchange(source, destination, index));
		
	}
}

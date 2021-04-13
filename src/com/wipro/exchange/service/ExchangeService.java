package com.wipro.exchange.service;

import com.wipro.exchange.entity.ExchangeBean;
import com.wipro.exchange.entity.ExchangeDestinationBean;
import com.wipro.exchange.entity.ExchangeSourceBean;
import com.wipro.exchange.exception.*;

public class ExchangeService {
	
	int count=0;
	public ExchangeDestinationBean edb = new ExchangeDestinationBean();
	public boolean validateExchange(int sourceID, int destinationID) throws InvalidDestinationNodeException,InvalidSourceNodeException{
		boolean result = false;
		
		try {
		if(sourceID>=1 && sourceID<=10) 
			count++;
		else {
			throw new InvalidSourceNodeException();
		}
		if(destinationID>=1 && destinationID<=10) 
			count++;
		else {
			throw new InvalidDestinationNodeException();
		}
		if(sourceID!=destinationID)
			result=true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(count==3) 
				result=true;
		}
		return result;
	}
	public ExchangeSourceBean registerSource(int sourceID, int destinationID) throws InvalidDestinationNodeException {
		

		ExchangeSourceBean esb = new ExchangeSourceBean();
		 try { 
			 if(validateExchange(sourceID, destinationID)) {
				 esb.setSourceID(sourceID);
				 esb.setSourceKey("*"+sourceID+"*"); 
				 esb.setConnectionState(true);
			 }else { 
				 esb.setSourceKey("");
				 esb.setConnectionState(false); 
			 } 
			 }catch(InvalidSourceNodeException e) {
				 e.printStackTrace(); 
			 } 
		return esb;
	}
	
	public ExchangeDestinationBean registerDestination(int sourceID, int destinationID) throws InvalidSourceNodeException{
		
		ExchangeDestinationBean edb = new ExchangeDestinationBean();
		 try { 
			 if(validateExchange(sourceID, destinationID)) {
				 edb.setDestinationID(destinationID);
				 edb.setDestinationKey("+"+destinationID+"+");
				 edb.setConnectionState(true); 
			 }else {
				 edb.setDestinationKey("");
				 edb.setConnectionState(false); 
			} 
			}catch(InvalidDestinationNodeException e) { 
				e.printStackTrace(); 
			}
		return edb;
	}
	
	public ExchangeBean transmitStatus(ExchangeSourceBean source, ExchangeDestinationBean dest) {
		
		ExchangeBean eb = new ExchangeBean();
		
		if(source.isConnectionState()==true && dest.isConnectionState()==true) {
			eb.setExchangeStatus(true);
			eb.setSourceID(source.getSourceID());
			eb.setDestinationID(dest.getDestinationID());
		}
		else {
			eb.setSourceID(source.getSourceID());
			eb.setDestinationID(dest.getDestinationID());
			eb.setExchangeStatus(false);
		}
		 
		return eb;
	}
	public ExchangeBean[] testService(int source[],int destination[]) throws InvalidDestinationNodeException, InvalidSourceNodeException {
		int length=source.length;
		ExchangeSourceBean[] sBean=new ExchangeSourceBean[length];
		ExchangeDestinationBean[] dBean=new ExchangeDestinationBean[length];
		ExchangeBean[] eba = new ExchangeBean[length];
		
		for(int i=0;i<length;i++) {
			
			sBean[i]=registerSource(source[i], destination[i]);
			dBean[i]=registerDestination(source[i], destination[i]);
			eba[i]=transmitStatus(sBean[i], dBean[i]);
		}
		
		return eba;
	}
	public String searchExchange(int source[],int destination[],int index) throws InvalidDestinationNodeException, InvalidSourceNodeException{
		
		ExchangeBean[] status=testService(source, destination);
		int len=source.length;
		
		return status[index].toString();
	}
}

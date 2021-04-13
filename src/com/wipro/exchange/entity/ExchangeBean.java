package com.wipro.exchange.entity;

public class ExchangeBean {
	private int sourceID;
	private int destinationID;
	private boolean exchangeStatus;
	public ExchangeBean() {
		// TODO Auto-generated constructor stub
	}
	public int getSourceID() {
		return sourceID;
	}
	public void setSourceID(int sourceID) {
		this.sourceID = sourceID;
	}
	public int getDestinationID() {
		return destinationID;
	}
	public void setDestinationID(int destinationID) {
		this.destinationID = destinationID;
	}
	public boolean isExchangeStatus() {
		return exchangeStatus;
	}
	public void setExchangeStatus(boolean exchangeStatus) {
		this.exchangeStatus = exchangeStatus;
	}
	@Override
	public String toString() {
		return sourceID+"-"+destinationID+":"+(isExchangeStatus()?"Success":"Failure");
	}

}

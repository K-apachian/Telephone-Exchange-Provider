package com.wipro.exchange.entity;

public class ExchangeDestinationBean {
	private int destinationID;
	private String destinationKey;
	private boolean connectionState;
	public ExchangeDestinationBean() {
		// TODO Auto-generated constructor stub
	}
	public int getDestinationID() {
		return destinationID;
	}
	public void setDestinationID(int destinationID) {
		this.destinationID = destinationID;
	}
	public String getDestinationKey() {
		return destinationKey;
	}
	public void setDestinationKey(String destinationKey) {
		this.destinationKey = destinationKey;
	}
	public boolean isConnectionState() {
		return connectionState;
	}
	public void setConnectionState(boolean connectionState) {
		this.connectionState = connectionState;
	}
	@Override
	public String toString() {
		return "ExchangeDestinationBean [destinationID=" + destinationID + ", destinationKey=" + destinationKey
				+ ", connectionState=" + connectionState + "]";
	}

}

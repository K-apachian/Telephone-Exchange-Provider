package com.wipro.exchange.entity;

public class ExchangeSourceBean {
	private int sourceID;
	private String sourceKey;
	private boolean connectionState;
	public ExchangeSourceBean() {
		// TODO Auto-generated constructor stub
	}

	public int getSourceID() {
		return sourceID;
	}
	public void setSourceID(int sourceID) {
		this.sourceID = sourceID;
	}
	public String getSourceKey() {
		return sourceKey;
	}
	public void setSourceKey(String sourceKey) {
		this.sourceKey = sourceKey;
	}
	public boolean isConnectionState() {
		return connectionState;
	}
	public void setConnectionState(boolean connectionState) {
		this.connectionState = connectionState;
	}
	@Override
	public String toString() {
		return "ExchangeSourceBean [sourceID=" + sourceID + ", sourceKey=" + sourceKey + ", connectionState="
				+ connectionState + "]";
	}

}

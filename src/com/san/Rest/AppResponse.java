package com.san.Rest;

public class AppResponse {
	public final static String ERROR="error";
	private String status;
	private String message;
	private Object payLoad;
	public AppResponse()
	{
		this.status="sucess";
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getPayLoad() {
		return payLoad;
	}
	public void setPayLoad(Object payLoad) {
		this.payLoad = payLoad;
	}

}

package com.test.models;

import java.util.List;

public class TestPojo   {
	
	private String status;
	private List<GetPOJOres> data = null;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<GetPOJOres> getData() {
		return data;
	}

	public void setData(List<GetPOJOres> data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	/*private String Data;

	public String getData() {
		return Data;
	}

	public void setData(String data) {
		Data = data;
	}
	*/
	

	



}
package com.lina.service;

public class Response {
	private int status;
	private Object data;

	public Object getData() {
		return data;
	}

	public int getStatus() {
		return status;
	}

	public Response(int status, Object data) {
		this.status = status;
		this.data = data;
	}
}

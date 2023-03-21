package com.example.demo.apiuResponce;

public class ApiResponce {
	private String message;
	private boolean success;
	private Object result;

	public ApiResponce(String message, boolean success, Object result) {
		super();
		this.message = message;
		this.success = success;
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "ApiResponce [message=" + message + ", success=" + success + ", result=" + result + "]";
	}

}

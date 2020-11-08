package com.tyagi.models;

public class DatabaseUpdateStatus {

	private int id;
	
	private boolean success;
	
	private int code;
	
	private String message;
	
	private DB_ACTIONS action;
	
	public DatabaseUpdateStatus() {}

	public DatabaseUpdateStatus(int id, boolean success, int code, String message, DB_ACTIONS action) {
		super();
		this.success = success;
		this.code = code;
		this.action = action;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	

	public void setMessage(String message) {
		this.message = message;
	}

	public DB_ACTIONS getAction() {
		return action;
	}

	public void setAction(DB_ACTIONS action) {
		this.action = action;
	}
	
	public String getMessage() {
		if(this.code == 204) {
			if(this.action == DB_ACTIONS.UPDATE) {
				this.message = "Record(s) updated successfully";
			}else if(this.action == DB_ACTIONS.DELETE) {
				this.message = "Record(s) deleted successfully";
			}
		}else if(this.code == 201) {
			this.message = "Record(s) created successfully";
		}
		return message;
	}
}

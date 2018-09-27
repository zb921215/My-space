package com.company.entity;


import java.util.List;

public class JsonResult {

	private String status;

	private String message;

	private Object data;

	private long total;

	private List rows;

	public JsonResult() {

	}

	public JsonResult(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public long getTotal() {
		return total;
	}



	public void setTotal(long total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}


}

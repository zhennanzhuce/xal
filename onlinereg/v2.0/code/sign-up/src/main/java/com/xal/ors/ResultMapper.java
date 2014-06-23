package com.xal.ors;

import java.util.ArrayList;

public class ResultMapper {
	private Object data;
	private boolean success;
	private ArrayList<String> msg;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public ArrayList<String> getMsg() {
		return msg;
	}

	public void setMsg(ArrayList<String> msg) {
		this.msg = msg;
	}

}

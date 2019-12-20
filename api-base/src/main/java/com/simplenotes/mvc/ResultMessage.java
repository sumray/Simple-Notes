package com.simplenotes.mvc;

public class ResultMessage {
	private int code;
	private String msg;
	private Object data;

	private static final int FAIL = 500;
	private static final int SUCCESS = 200;

	public ResultMessage(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public ResultMessage(int code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public static ResultMessage success() {
		return new ResultMessage(SUCCESS, "SUCCESS");
	}

	public static ResultMessage success(Object data) {
		return new ResultMessage(SUCCESS, "SUCCESS", data);
	}

	public static ResultMessage fail() {
		return new ResultMessage(FAIL, "FAIL");
	}

	public static ResultMessage fail(Object data) {
		return new ResultMessage(FAIL, "FAIL", data);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}

package com.mooc.common;

public class Data implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String code;
	private String msg;
	private Object data;
	
	public Data(String code, String msg, Object data2) {
		this.code = code;
		this.msg = msg;
		this.data = data2;
	}
	
	public Data(String code,String msg){
		this.code=code;
		this.msg=msg;
	}
	public Data(String msg){
		this.msg=msg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
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
	public void setData(String data) {
		this.data = data;
	}
	
//	public String toJsonString(){
//		if(Strings.isNullOrEmpty(this.data))
//			return "{\"code\":\""+this.code+"\",\"msg\":\""+this.msg+"\",\"data\":\"\"}";
//		return "{\"code\":\""+this.code+"\",\"msg\":\""+this.msg+"\",\"data\":"+this.data+"}";
//		
//	}
	
	

}

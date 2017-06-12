package model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class UserSession {
	/*
	 * 存在会话属性里的 数据封装类
	 * 用户相关   用户名和购物车
	 * 
	 * */
	private String cname;
	private List<String> car;
	public UserSession(){
		car = new LinkedList<String>();
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public List<String> getCar() {
		return car;
	}
	public void setCar(List<String> car) {
		this.car = car;
	}
	
}

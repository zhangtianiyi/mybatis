package model;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDaoImpl;
import entity.Customer;
public class LoginModel {
	public String handle(String username, String userpass, String isCookie){
		/*
		 * 判断登陆是否成功（查表），  设置cookie！   登陆就要建立会话吗？ 
		 * */
		String res = "fail";
		List<Customer> customerList = new ArrayList<>();
		Map<String, Object> map = new HashMap<String, Object>();
        Map<String, String> namePass = new HashMap<String, String>();
        namePass.put(username, userpass);
        map.put("cusMap", namePass);
        customerList = new CustomerDaoImpl().queryCustomerByNamepass(map);
        if(customerList != null && customerList.size() > 0)
        	res = "success";
		return res;
	}
	
	// 处理用户cookies信息
	public Cookie[] setCookies(String name,String pass) throws UnsupportedEncodingException
	{
		Cookie[] cookies = new Cookie[2];
		String username = URLEncoder.encode(name,"UTF-8");
		String userpass = URLEncoder.encode(pass,"UTF-8");			
		Cookie nameCookie = new Cookie("username",username );
		Cookie passCookie = new Cookie("userpass",userpass );
		nameCookie.setPath("/");
		passCookie.setPath("/");
		nameCookie.setMaxAge(864000);
		passCookie.setMaxAge(864000);
		cookies[0] = nameCookie; 
		cookies[1] = passCookie;
		return cookies;
	}
	
	public void success(UserSession us, HttpSession session, String username){              
		us = (UserSession) session.getAttribute("loginBean");
		if (us == null) {
			us = new UserSession();
			us.setCname(username);
			session.setAttribute("loginBean", us);
			session.setMaxInactiveInterval(60 * 30);   //半小时没操作，重新登陆
		}
	}
}

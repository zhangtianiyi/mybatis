package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Customer;
import model.RegisterModel;

//处理注册的请求
public class RegisterServlet extends HttpServlet{
	public RegisterServlet(){
		super();
	}

	public void init() throws ServletException{
	}
	
	public void destroy()
	{
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doPost(request, response); 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");    
		request.setCharacterEncoding("UTF-8");    
		//原来的user里面绝对有什么东西，待会再看  backnews?
		RequestDispatcher view = null;
		Customer customer = new Customer();
		request.setAttribute("userBean", customer);
		//1 处理请求，把请求的结果封装起来
		Map<String, String> registerMap = new HashMap<String, String>();
		registerMap.put("cname", request.getParameter("username").trim());
		registerMap.put("cpass", request.getParameter("userpass").trim());
		registerMap.put("again_userpass", request.getParameter("again_userpass").trim());
		registerMap.put("cphone", request.getParameter("phone").trim());
		registerMap.put("caddress", request.getParameter("address").trim());
		registerMap.put("crealname", request.getParameter("realname").trim());
		//2 调用model的业务逻辑，判断注册成功或失败原因并跳转
		String hint = new RegisterModel().handle(registerMap);
		//3 根据处理结果返回响应（请求分派）
		request.setAttribute("hint", hint);
		if(hint == "注册成功"){
			view = request.getRequestDispatcher("/view/login.jsp");
		} else {
			view = request.getRequestDispatcher("/view/register.jsp");
		}
		view.forward(request, response);
	}
}

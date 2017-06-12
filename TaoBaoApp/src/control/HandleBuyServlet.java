package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.rowset.CachedRowSetImpl;

import model.HandleGoodsModel;
import model.PageShow;
import model.UserSession;

public class HandleBuyServlet extends HttpServlet{
	public HandleBuyServlet() {
        super();
    }

	 public void init() throws ServletException{
	 }
	  
    public void destroy() {
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
    	
    	/*
    	 * 购买商品，将购物车的全部商品遍历，这些商品都是要买的，需要改变很多持久数据（数据库）和缓存数据（购物车等，tomcat内存）
    	 * 保证关系一致性！   清空购物车       增加购买记录，减少商品余额度...
    	 * */
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        /*
         * 一个用户类，差不多用户实体类，封装了用户的相关所有信息，存放在会话属性中
         * 这里不应该是loginBean，而应该是每个用户独有的信息，比如username  sessionId
         * */
        HttpSession session = request.getSession();               
        UserSession loginBean = (UserSession)session.getAttribute("loginBean");   
        List<String> car = loginBean.getCar();
        String cname = loginBean.getCname();
        /*
         * 更新余额，购买记录等
         * */
       String backNews = new HandleGoodsModel().buyGoods(cname, car); 
       car.clear();
       String successBackNews = "您已将购物车中的商品买回家了";
       messShopping(request,response,successBackNews);
    }
 
     // 商品购买处理信息
    public void messShopping(HttpServletRequest request, HttpServletResponse response, String mess) throws IOException
    {
    	PrintWriter out = response.getWriter();
        out.print("<br><br><br>");
        out.print("<center><font size=5 color=red><B>"+mess+"</B></font>&nbsp;已成功添加购物车");
        out.print("<br><br><br>");
        out.print("<a href='/TaoBaoApp/control/HandleGoodsServlet?key=1'>返回继续购物</a>");
        out.print("&nbsp;or&nbsp;");
        out.print("<a href=/TaoBaoApp/control/HandleCarServlet?key=1>查看购物车</a></center>");
    }
}

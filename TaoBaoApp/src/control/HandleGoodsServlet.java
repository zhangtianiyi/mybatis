package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.rowset.CachedRowSetImpl;

import data.Data;
import entity.Goods;
import model.HandleGoodsModel;
import model.PageShow;
import model.UserSession;
//商品查询，（分类，鞋  ）。商品显示。（价格升序/销量降序）
public class HandleGoodsServlet extends HttpServlet {
	public HandleGoodsServlet(){
		super();
	}

	public void init() throws ServletException{
	}
	
	public void destroy(){
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
		response.setContentType("text/html;chartset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String keyvalue = request.getParameter("key");
		int key = Integer.parseInt(keyvalue);          
		String keyWord = request.getParameter("keyWord");
		List<Goods> goodsList = new ArrayList<Goods>();
		
		HttpSession session = request.getSession(); 
		Data data = new Data();
		switch(key){
		//基本测试通过，一个dbDao功能，select * 返回结果集，这里还改了jsp
			case 1: //显示商品（购物列表）
				goodsList = new HandleGoodsModel().queryGoods();
				data.setDataGoodsList(goodsList);
	            session.setAttribute("data", data);
				request.getRequestDispatcher("/view/showGoods.jsp").forward(request, response);
			case 2:   //显示商品详细信息
				request.getRequestDispatcher("/view/showGoodsDetail.jsp").forward(request, response);
			case 3:       
				goodsList = new HandleGoodsModel().queryGoodsByKeyWord(keyWord);
				data.setDataGoodsList(goodsList);
	            session.setAttribute("data", data);
				request.getRequestDispatcher("/view/showGoods.jsp").forward(request, response);
		}
	}
}
  
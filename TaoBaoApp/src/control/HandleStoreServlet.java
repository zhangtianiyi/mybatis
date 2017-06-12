package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.Data;
import entity.Goods;
import entity.Store;
import model.HandleGoodsModel;
import model.HandleStoreModel;
import model.PageShow;
//店铺的数据库相关操作：显示店铺，查询店铺。 （销量升序，原来顺序）
public class HandleStoreServlet extends HttpServlet{
	public HandleStoreServlet(){
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
		int sid = 0;
		//因为一个servlet可能会收到来自不同的请求的参数
		//所以一定要注意不要某个请求参数一个有，一个没有，就会产生空指针（要保持一致性）
		//而且就算是每个请求都有的请求参数，也要使名值对的名保持一致
		if(key == 2){
			String t = request.getParameter("id").trim();
			sid = Integer.parseInt(t);
		}
		List<Store> storeList = new ArrayList<Store>();
		List<Goods> goodsList = new ArrayList<Goods>();
		
		HttpSession session = request.getSession();        
		Data data = new Data();
		switch(key){
			case 1: 
				storeList = new HandleStoreModel().queryStore();
				data.setDataStoreList(storeList);
	            session.setAttribute("data", data);
				request.getRequestDispatcher("/view/showStore.jsp").forward(request, response);
			case 2:  
				goodsList = new HandleGoodsModel().queryGoodsByStore(sid);
				data.setDataGoodsList(goodsList);
	            session.setAttribute("data", data);
				request.getRequestDispatcher("/view/showGoods.jsp").forward(request, response);
			case 3:       
				storeList = new HandleStoreModel().queryStoreByKeyWord(keyWord);
				data.setDataStoreList(storeList);
	            session.setAttribute("data", data);
				request.getRequestDispatcher("/view/showStore.jsp").forward(request, response);
		}
	}
}

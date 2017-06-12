package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.rowset.CachedRowSetImpl;

import dao.BuyRecordDaoImpl;
import dao.GoodsDaoImpl;
import dao.StoreDaoImpl;
import entity.BuyRecord;
import entity.Goods;
import entity.Store;

public class HandleGoodsModel {
	public List<Goods> queryGoods() throws ServletException, IOException
	{   
		return new GoodsDaoImpl().queryGoods();
	}
	
	public List<Goods> queryGoodsByKeyWord(String keyWord) throws ServletException, IOException
	{   
		return new GoodsDaoImpl().queryGoodsByKeyWord(keyWord);
	}
	
	public List<Goods> queryGoodsByStore(int sid) throws ServletException, IOException
	{   
		return new GoodsDaoImpl().queryGoodsByStore(sid);
	}
	
	public String buyGoods(String cname, List<String> car){  //购买商品，即清空购物车
		String res = "car is null";  //购物车为空
        
		List<BuyRecord> buyRecordList = new LinkedList<>();
		List<Goods> goodsList = new LinkedList<>();
		List<Store> storeList = new LinkedList<>();
        for (int i = 0; i < car.size(); i++) {
        	Goods goods = new Goods();
        	Store store = new Store();
        	BuyRecord buyRecord = new BuyRecord();       //用实体bean来封装数据，往数据库传？
        	
            String[] goodsStrs = car.get(i).split(",");
            for (int j = 0; j < goodsStrs.length; j++) {
            	buyRecord.setCname(cname);         //顾客名
                buyRecord.setGname(goodsStrs[1]);  //商品名
                buyRecord.setGprice(Double.parseDouble(goodsStrs[3]));  //商品价格
                buyRecord.setBnum(1);  //购买数量，可扩展为一次买多个
                
                //考虑多线程和事务
                if (j == 0){  //商品标识
                	goods.setGid(Integer.parseInt(goodsStrs[0]));
                }
                if (j == 4) //商品余额
                {
                	int balance = Integer.parseInt(goodsStrs[4]);
                    if (balance <= 1){
                       return "goods no enough"; //商品余额不足
                    }
                    goods.setGbalance(balance-1);
                    goods.setGnum(goods.getGnum() + 1);  //商品已销售数量
                }
                if (j == 5) { //店铺标识
                	store.setSid(Integer.parseInt(goodsStrs[5]));
                	store.setSnum(store.getSnum() + 1);  //店铺已销售数量
                }
            }
            
            buyRecordList.add(buyRecord);
    		goodsList.add(goods);
    		storeList.add(store);
        }
        //方法的组合。
        //orderServiceImpl.insertOrderBatch(listOrder);
        //goodsDaoImpl.updateGoods(Listgoods);
        //这里暂时先不处理store
        new GoodsDaoImpl().updateGoods(goodsList);
        new BuyRecordDaoImpl().insertMultiBuyRecord(buyRecordList);
        new StoreDaoImpl().updateStore(storeList);
        return res;
	}
}

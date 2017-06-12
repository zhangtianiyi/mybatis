package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;

import com.sun.rowset.CachedRowSetImpl;

import dao.GoodsDaoImpl;
import dao.StoreDaoImpl;
import entity.Goods;
import entity.Store;

public class HandleStoreModel {
	public List<Store> queryStore() throws ServletException, IOException
	{   
		return new StoreDaoImpl().queryStore();
	}
	
	public List<Store> queryStoreByKeyWord(String keyWord) throws ServletException, IOException
	{   
		return new StoreDaoImpl().queryStoreByKeyWord(keyWord);
	}
}

package dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import db.DbSqlSession;
import entity.Customer;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public List<Customer> queryCustomerByNamepass(Map<String, Object> map) {
		SqlSession sqlSession = null;
		 try {
	         sqlSession = DbSqlSession.getSqlSession();
	         return sqlSession.getMapper(CustomerDao.class).queryCustomerByNamepass(map);
	     }catch (IOException e) {
	         e.printStackTrace();
	     }finally {
	    	 if (sqlSession != null)
	    		 sqlSession.close();
	     }
		 return new ArrayList<Customer>();
	}

	@Override
	public void insertCustomer(Map<String, String> registerMap) {
		SqlSession sqlSession = null;
		 try {
	         sqlSession = DbSqlSession.getSqlSession();
	         sqlSession.getMapper(CustomerDao.class).insertCustomer(registerMap);
	         sqlSession.commit();
	     }catch (IOException e) {
	         e.printStackTrace();
	     }finally {
	    	 if (sqlSession != null)
	    		 sqlSession.close();
	     }
	}

	@Override
	public List<Customer> queryCustomerByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}

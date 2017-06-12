package dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import db.DbSqlSession;
import entity.Goods;
import entity.Store;

public class StoreDaoImpl implements StoreDao{

	@Override
	public List<Store> queryStore() {
		SqlSession sqlSession = null;
		 try {
	         sqlSession = DbSqlSession.getSqlSession();
	         return sqlSession.getMapper(StoreDao.class).queryStore();
	     } catch (IOException e) {
	         e.printStackTrace();
	     }finally {
	    	 if(sqlSession != null)
	    		 sqlSession.close();
	     }
		 return null;
	}

	@Override
	public List<Store> queryStoreByKeyWord(String keyWord) {
		SqlSession sqlSession = null;
		 try {
	         sqlSession = DbSqlSession.getSqlSession();
	         return sqlSession.getMapper(StoreDao.class).queryStoreByKeyWord(keyWord);
	     } catch (IOException e) {
	         e.printStackTrace();
	     }finally {
	    	 sqlSession.close();
	     }
		 return null;
	}

	@Override
	public void updateStore(List<Store> storeList) {
		 SqlSession sqlSession = null;
		 try {
	         sqlSession = DbSqlSession.getSqlSession();
	         sqlSession.getMapper(StoreDao.class).updateStore(storeList);
	         sqlSession.commit();
	     }catch (IOException e) {
	         e.printStackTrace();
	     }finally {
	         sqlSession.close();
	     }
	}
}

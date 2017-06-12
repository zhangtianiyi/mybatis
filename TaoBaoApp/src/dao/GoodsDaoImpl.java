package dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import db.DbSqlSession;
import entity.Goods;

public class GoodsDaoImpl implements GoodsDao{
	
	@Override
	public List<Goods> queryGoods() {
		 SqlSession sqlSession = null;
		 try {
	         sqlSession = DbSqlSession.getSqlSession();
	         return sqlSession.getMapper(GoodsDao.class).queryGoods();
	     } catch (IOException e) {
	         e.printStackTrace();
	     }finally {
	    	 sqlSession.close();
	     }
		 return null;
	}

	@Override
	public List<Goods> queryGoodsByKeyWord(String keyWord) {
		SqlSession sqlSession = null;
		 try {
	         sqlSession = DbSqlSession.getSqlSession();
	         return sqlSession.getMapper(GoodsDao.class).queryGoodsByKeyWord(keyWord);
	     } catch (IOException e) {
	         e.printStackTrace();
	     }finally {
	    	 sqlSession.close();
	     }
		 return null;
	}

	@Override
	public List<Goods> queryGoodsByStore(int sid) {
		SqlSession sqlSession = null;
		 try {
	         sqlSession = DbSqlSession.getSqlSession();
	         return sqlSession.getMapper(GoodsDao.class).queryGoodsByStore(sid);
	     } catch (IOException e) {
	         e.printStackTrace();
	     }finally {
	    	 sqlSession.close();
	     }
		 return null;
	}

	@Override
	public void deleteGoodsById(int gid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGoods(List<Goods> goodsList) {
		 SqlSession sqlSession = null;
		 try {
	         sqlSession = DbSqlSession.getSqlSession();
	         sqlSession.getMapper(GoodsDao.class).updateGoods(goodsList);
	         sqlSession.commit();
	     }catch (IOException e) {
	         e.printStackTrace();
	     }finally {
	         sqlSession.close();
	     }
	}
}

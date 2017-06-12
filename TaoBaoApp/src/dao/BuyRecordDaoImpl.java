package dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import db.DbSqlSession;
import entity.BuyRecord;

public class BuyRecordDaoImpl implements BuyRecordDao{

	@Override
	public List<BuyRecord> queryBuyRecord() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BuyRecord> queryBuyRecordByName(String Name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BuyRecord> queryBuyRecordByKeyName(BuyRecord buyRecord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBuyRecordById(int bid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMultiBuyRecordById(List<Integer> bids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertMultiBuyRecord(List<BuyRecord> buyRecords) {
		SqlSession sqlSession = null;
		 try {
	         sqlSession = DbSqlSession.getSqlSession();
	         sqlSession.getMapper(BuyRecordDao.class).insertMultiBuyRecord(buyRecords);
	         sqlSession.commit();
	     }catch (IOException e) {
	         e.printStackTrace();
	     }finally {
	    	 if (sqlSession != null)
	    		 sqlSession.close();
	     }
		
	}

}

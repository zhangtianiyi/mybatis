package dao;

import java.util.List;

import entity.BuyRecord;

public interface BuyRecordDao {
	/**查询全部订单**/
    public List<BuyRecord> queryBuyRecord();
    /** 用用户名查询订单**/
    public List<BuyRecord> queryBuyRecordByName(String Name);
    /** 查询By关键字用户名**/
    public List<BuyRecord> queryBuyRecordByKeyName(BuyRecord buyRecord);
    /** 删除单条 By id **/
    public void deleteBuyRecordById(int bid);
    /** 删除批量 By id **/
    public void deleteMultiBuyRecordById(List<Integer> bids);
    /** 批量插入数据**/
    public void insertMultiBuyRecord(List<BuyRecord> buyRecords);
}

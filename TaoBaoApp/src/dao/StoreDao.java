package dao;

import java.util.List;

import entity.Goods;
import entity.Store;

public interface StoreDao {
	/** 查询所有店铺列表**/
    public List<Store> queryStore();
    /** 店铺关键字查询**/
    public List<Store> queryStoreByKeyWord(String keyWord);
    /** 更新店铺信息**/
    public void updateStore(List<Store> storeLst);
}

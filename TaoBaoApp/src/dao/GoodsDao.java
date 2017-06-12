package dao;

import java.util.List;

import entity.Goods;

public interface GoodsDao {
	/** 查询所有商品列表**/
    public List<Goods> queryGoods();
    /** 商品关键字查询**/
    public List<Goods> queryGoodsByKeyWord(String keyWord);
    /** 关键字和分类 查询**/
    public List<Goods> queryGoodsByStore(int sid);
    /** 通过商品唯一标识单个删除数据 **/
    public void deleteGoodsById(int gid);
    /** 更新商品信息**/
    public void updateGoods(List<Goods> goodsList);
}

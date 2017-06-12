package data;

import java.util.List;

import entity.Goods;
import entity.Store;

public class Data {
	private List<Goods> dataGoodsList;
	private List<Store> dataStoreList;
	
	public List<Store> getDataStoreList() {
		return dataStoreList;
	}

	public void setDataStoreList(List<Store> dataStoreList) {
		this.dataStoreList = dataStoreList;
	}

	public List<Goods> getDataGoodsList() {
		return dataGoodsList;
	}

	public void setDataGoodsList(List<Goods> dataGoodsList) {
		this.dataGoodsList = dataGoodsList;
	}
	
}

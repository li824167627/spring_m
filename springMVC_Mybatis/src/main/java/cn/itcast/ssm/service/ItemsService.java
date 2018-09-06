package cn.itcast.ssm.service;

import java.util.List;

import cn.itcast.ssm.bean.po.ItemsCustom;
import cn.itcast.ssm.bean.po.ItemsQueryVo;

public interface ItemsService {

	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;

	public ItemsCustom findItemsById(Integer id) throws Exception;

	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception;
	
	public void deleteItems(Integer id, ItemsCustom itemsCustom) throws Exception;
	
	
	
	
}

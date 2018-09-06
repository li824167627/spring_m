package cn.itcast.ssm.mapper;

import java.util.List;

import cn.itcast.ssm.bean.po.Items;
import cn.itcast.ssm.bean.po.ItemsCustom;
import cn.itcast.ssm.bean.po.ItemsQueryVo;

public interface ItemsMapperCustom {

	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo);
	public ItemsCustom findItemsById(Integer id);
	public int updateByPrimaryKey(Items record);
	public int updateByPrimaryKeySelective(Items record);
	public int updateByPrimaryKeyWithBLOBs(Items record);
	public void updateItems(Integer id, ItemsCustom itemsCustom);
	public void delectByPrimaryKey(Integer id, ItemsCustom itemsCustom);
	
	
}

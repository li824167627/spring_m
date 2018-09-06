package cn.itcast.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.ssm.bean.po.Items;
import cn.itcast.ssm.bean.po.ItemsCustom;
import cn.itcast.ssm.bean.po.ItemsQueryVo;
import cn.itcast.ssm.mapper.ItemsMapperCustom;
import cn.itcast.ssm.service.ItemsService;

@Service
public class ItemsServiceImpl implements ItemsService {

	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	
	

	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {

		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception {
		Items items = itemsMapperCustom.findItemsById(id);
		
		ItemsCustom itemsCustom = new ItemsCustom();
		
		BeanUtils.copyProperties(items,itemsCustom);
		
		return itemsCustom;
	}

	@Override
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
		
		//添加业务校验，通常在service接口对关键参数进行校验
		//校验id是否为空，如果为空抛出异常
		
		itemsCustom.setId(id);
		itemsMapperCustom.updateByPrimaryKeyWithBLOBs(itemsCustom);

	}

	@Override
	public void deleteItems(Integer id, ItemsCustom itemsCustom) throws Exception {
		itemsCustom.setId(id);
		itemsMapperCustom.delectByPrimaryKey(id, itemsCustom);
		
		
	}

}

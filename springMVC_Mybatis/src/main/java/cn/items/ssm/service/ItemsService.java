package cn.items.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;

public interface ItemsService {
		@Autowired
		public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
}

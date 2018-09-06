package cn.itcast.ssm.mapper;

import java.util.List;

import cn.itcast.ssm.bean.po.OrdersCustom;

public interface OrdersMapperCustom {
	public List<OrdersCustom> findOrdersUser()throws Exception;
}

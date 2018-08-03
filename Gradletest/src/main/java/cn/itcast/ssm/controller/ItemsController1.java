package cn.itcast.ssm.controller;
import org.springframework.stereotype.Controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.po.Orders;


  @Controller
public class ItemsController1{
	
	  @RequestMapping("/queryItems")
	  public ModelAndView queryItem()throws Exception {
		
		
		//调用service查找数据库，查询商品列表，这里使用静态数据模拟
		List<Orders> itmesList = new ArrayList<Orders>(); 
		//向list中填充静态数据
		
		Orders orders_1 = new Orders();
		orders_1.setId(1);;
		orders_1.setUserId(1);
		orders_1.setNumber("1");
		orders_1.setCreatetime(null);
		orders_1.setNote("手机");
		
		itmesList.add(orders_1);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itmesList",itmesList);
		
		modelAndView.setViewName("items/itemsList.jsp");
		
		return modelAndView;
	}

}

package cn.itcast.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import cn.itcast.ssm.po.Orders;

public class ItemsController1 implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		//调用service查找数据库，查询商品列表，这里使用静态数据模拟
		List<Orders> itmesList = new ArrayList<Orders>(); 
		//向list中填充静态数据
		
		Orders orders_1 = new Orders();
		orders_1.setId(1);
		orders_1.setUserId(1);
		orders_1.setNumber("1");
		orders_1.setCreatetime(null);
		orders_1.setNote("手机");
		
		itmesList.add(orders_1);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itmesList",itmesList);
		
		modelAndView.setViewName("itemsList.jsp");
		
		return modelAndView;
	}

}

package cn.itcast.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.bean.po.ItemsCustom;
import cn.itcast.ssm.service.impl.ItemsServiceImpl;

@Controller
@RequestMapping("/items")
public class ItemsController {

	@Autowired
	private ItemsServiceImpl itemsServiceImpl;

	// @RequestMapping实现对queryItems方法和url方法进行映射，一个方法对应一个url
	// 一般讲url和方法名写成一样
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletResponse response) throws Exception {
		// 测试forward后request是否可以共享
		// System.out.println(request.getParameter("id"));

//		response.setCharacterEncoding("utf-8");
//		response.setContentType("application/json;charset=utf-8");
//		response.getWriter().write("json串");
//		System.out.println(response.getWriter());

		List<ItemsCustom> itmesList = itemsServiceImpl.findItemsList(null);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itmesList", itmesList);
		modelAndView.setViewName("items/itemsList");

		return modelAndView;

	}
	// @RequestMapping("/editItems")
	// 限制http请求的方法,可以post和get
//	@RequestMapping(value="/editItems",method= {RequestMethod.POST,RequestMethod.GET})
//	public ModelAndView editItems()throws Exception{
//		
//		ItemsCustom itemsCustom = itemsServiceImpl.findItemsById(1);
//		
//		ModelAndView modelAndView = new ModelAndView();
//		
//		modelAndView.addObject("itemsCustom",itemsCustom);
//		
//		modelAndView.setViewName("items/editItems");
//		
//		return modelAndView;
//	}
	//通过@RequestsParam对简单类型的参数进行绑定
	//如果不使用@RequestParam,要求request传入参数名称和controller方法的形参名称一致，方可绑定成功
	//如果使用@RequestParam,不用限制request传入参数名称和controller方法的形参名称一致
	//通过defaultValue可以设置默认值，如果id参数没有传入，将默认值和形参绑定。
	//通过required属性指定参数是否必须传入,如果设置为true,没有传入参数，报下面的错误
	@RequestMapping(value = "/editItems", method = { RequestMethod.POST, RequestMethod.GET })
	public String editItems(Model model,@RequestParam(value="id") Integer id_items) throws Exception {

		ItemsCustom itemsCustom = itemsServiceImpl.findItemsById(id_items);
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("application/json;charset=utf-8");
//		response.getWriter().write("json串");
		//System.out.println(response.getWriter());

//		ModelAndView modelAndView = new ModelAndView();
//		
//		modelAndView.addObject("itemsCustom",itemsCustom);
//		
//		modelAndView.setViewName("items/editItems");
		model.addAttribute("itemsCustom", itemsCustom);

		return "items/editItems";
	}

	@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit(HttpServletRequest request,Integer id,ItemsCustom itemsCustom) throws Exception {
		//调用service更新商品信息，页面需要将商品信息传到此方法
		itemsServiceImpl.updateItems(id,itemsCustom);
		// 重定向
		
		return "redirect:queryItems.action"; 
//		return "success";
		// 页面转发
		//return "success";
		
	}
	
	//批量删除商品信息
	@RequestMapping("/deleteItems")
	public String deleteItems(Integer[] items_id)throws Exception{
		
		return "success";
		
	}

}

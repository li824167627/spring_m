package cn.itcast.ssm.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import cn.itcast.ssm.po.ItemsCustom;
import cn.items.ssm.service.ItemsService;

@Controller
public class ItemsController{
	
	@Autowired
	private ItemsService itemsService;   
	
	//@RequestMapping实现对queryItems方法和url方法进行映射，一个方法对应一个url
	//一般讲url和方法名写成一样
	@RequestMapping("/queryItems")
	public ModelAndView queryItems() throws Exception {
		
		List<ItemsCustom> itmesList = itemsService.findItemsList(null);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itmesList",itmesList);
		
		modelAndView.setViewName("items/itmesList");
		
		return modelAndView;
	
	}

}

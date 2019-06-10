package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import shop.bean.OrganizationUser;
import shop.bean.ParentUser;
import shop.bean.TeacherUser;
import shop.bean.User;

@Controller
public class IndexController
{
	@RequestMapping(value = "/")
	public String index()
	{	
		//从session取得User,根据User的类型返回相应的首页
		User user=new ParentUser();
		
		//用户未登陆，转到登陆页面
		if(user==null)
			return "redirect:/login";
		
		if(user instanceof ParentUser)
			return "parentUser";
		if(user instanceof OrganizationUser)
			return "OrganizationUser";
		if(user instanceof TeacherUser)
			return "TeacherUser";
		
		throw new RuntimeException("未知用户类型");
	}
	@RequestMapping(value="/login")
	public ModelAndView login()
	{
		ModelAndView mav=new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
}
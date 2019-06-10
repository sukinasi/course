package shop.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import shop.bean.ParentUser;
import shop.service.ParentUserService;

@Controller
class ParentUserLoginController extends LoginTemplate
{
	@Autowired
	ParentUserService pus;
	
	@RequestMapping(value="/ParentUserlogin")
	@ResponseBody
	public Map<String,String> login(String userName,String password)
	{
		return ajaxTemplate(userName,password);
	}
	
	@Override
	protected int loginUser(String userName, String password)
	{
		return pus.login(userName, password);
	}

	
	//处理修改信息的请求
	@RequestMapping(value="/changeParentUserInfo",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> changeInfo(@Validated ParentUser user)
	{
		Map<String,String> result=new HashMap();
		if(pus.changeInfo(user))
			result.put("result", "succeed");
		else
			result.put("result", "fail");
		return result;
	}
	
	
	//展示修改信息页
	@RequestMapping(value="/changeParentUserInfo",method=RequestMethod.GET)
	public ModelAndView showChangeInfoForm(@RequestParam(required=true)String userName)
	{
		ModelAndView mav=new ModelAndView("changeParentUserInfo");
		return mav;
	}
}
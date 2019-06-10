package shop.controller;


import java.util.HashMap;
import java.util.Map;


public abstract class LoginTemplate
{
	public Map<String,String> ajaxTemplate(String userName,String password)
	{
		Map<String,String> result= new HashMap<String, String>();
		Integer ret=loginUser(userName,password);
		result.put("result",String.valueOf(ret));
		return result;
	}
	
	/**
	 * 具体的用户登陆函数，判定给定的用户名和密码是否正确。子类必须实现。
	 * @return 返回0代表“用户名不存在”，1代表“密码不正确”，2代表“登陆成功”
	 */
	protected abstract int loginUser(String userName,String password);
	

}


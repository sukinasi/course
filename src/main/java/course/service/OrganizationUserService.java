
package course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import course.bean.OrganizationUser;
import course.bean.User;
import course.dao.OrganizationUserDao;
@Service
public class OrganizationUserService
{
	/**
	 * TODO 目前手动注入了依赖，日后应该改成Autowired
	 */
	OrganizationUserDao pud=new OrganizationUserDao();

	public boolean register(OrganizationUser userInfo)
	{
		// 查找用户名是否存在
		User user = pud.findByUserName(userInfo.getUserName());
		if(user!=null)
			return false;
		
		return pud.register(userInfo);
	}

	/**
	 * @return 返回0代表“用户名不存在”，1代表“密码不正确”，2代表“登陆成功”
	 */
	public int login(String userName, String password)
	{
		// 查找用户名是否存在
		User user = pud.findByUserName(userName);
		if(user==null)
			return 0;
		
		//检验密码是否正确
		if (!password.equals(user.getPassword()))
			return 1;
		return 2;
		
	}

	public boolean changeSelfInfo(OrganizationUser userInfo)
	{
		OrganizationUser user=pud.findByUserName(userInfo.getUserName());
		
		//找不到用户
		if(user==null)
			return false;
		
		/**
		 * TODO 设置user的各项，注意不可更改项。
		 */
		user.setAge(userInfo.getAge());
		user.setAddress(userInfo.getAddress());
		user.setRealm(userInfo.getRealm());
		
		return pud.updateUser(user);
		
	}

	
	public OrganizationUser getSelfInfo(String userName)
	{
		return pud.findByUserName(userName);
	}
}

package shop.bean;

public class OrganizationUser extends User
{
	private String realm;//教育领域
	private String id;//标识码
	private String address;//店面地址
	private String age;//教育合适年龄
	public String getRealm()
	{
		return realm;
	}
	public void setRealm(String realm)
	{
		this.realm = realm;
	}
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getAge()
	{
		return age;
	}
	public void setAge(String age)
	{
		this.age = age;
	}
	public String getInfo()
	{
		return info;
	}
	public void setInfo(String info)
	{
		this.info = info;
	}
	private String info;//简介
}

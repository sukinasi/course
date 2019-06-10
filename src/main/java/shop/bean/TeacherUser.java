package shop.bean;

public class TeacherUser extends User
{
	private String name;
	private String sex;
	private String age;
	private String realm;
	private String time;//从教年限
	private String agg;//教育合适年龄
	private String id;//身份证号码
	private String info;//简介
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	public String getAge()
	{
		return age;
	}
	public void setAge(String age)
	{
		this.age = age;
	}
	public String getRealm()
	{
		return realm;
	}
	public void setRealm(String realm)
	{
		this.realm = realm;
	}
	public String getTime()
	{
		return time;
	}
	public void setTime(String time)
	{
		this.time = time;
	}
	public String getAgg()
	{
		return agg;
	}
	public void setAgg(String agg)
	{
		this.agg = agg;
	}
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getInfo()
	{
		return info;
	}
	public void setInfo(String info)
	{
		this.info = info;
	}
}

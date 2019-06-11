package course.bean;

import javax.validation.constraints.NotNull;

public class ParentUser extends User
{
	public ParentUser()
	{
	}

	public ParentUser(String userName, String password)
	{
		this.userName=userName;
		this.password=password;
	}

	@NotNull
	private String childName;
	private String age;
	private String childSex;
	private String parentName;

	public String getChildName()
	{
		return childName;
	}

	public void setChildName(String childName)
	{
		this.childName = childName;
	}

	public String getAge()
	{
		return age;
	}

	public void setAge(String age)
	{
		this.age = age;
	}

	public String getChildSex()
	{
		return childSex;
	}

	public void setChildSex(String childSex)
	{
		this.childSex = childSex;
	}

	public String getParentName()
	{
		return parentName;
	}

	public void setParentName(String parentName)
	{
		this.parentName = parentName;
	}
}

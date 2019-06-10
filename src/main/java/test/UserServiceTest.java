package test;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.validation.ObjectError;

import shop.bean.ParentUser;
import shop.bean.User;

public class UserServiceTest
{
	private static Validator validator;
	
	@BeforeClass
	public static void setUp()
	{
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	public void registerParentUser()
	{
		ParentUser user = new ParentUser();
		user.setAge("10");
	}

	public void registerTeacherUser()
	{

	}

	public void registerOrganiazationUser()
	{

	}

	@Test
	public void testValidation()
	{ 
		User user=new ParentUser();
		Set<ConstraintViolation<User>> vio=validator.validate(user);
		for(ConstraintViolation c:vio)
			System.out.println(c.getMessage());

	}
	

	
	
	
	
	
}

package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.validation.ObjectError;

import course.bean.ParentUser;
import course.bean.User;
import course.service.ParentUserService;

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


	@Test
	public void tsetLogin()
	{
		ParentUserService pus=new ParentUserService();
		
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

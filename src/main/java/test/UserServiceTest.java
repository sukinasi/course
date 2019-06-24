package test;

import static org.hamcrest.CoreMatchers.allOf;
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

import course.bean.Comment;
import course.bean.News;
import course.bean.ParentUser;
import course.bean.User;
import course.dao.CommentForSubjectDao;
import course.dao.CommentForUserDao;
import course.dao.NewsDao;
import course.dao.CommentDao;
import course.service.SubjectCommentService;
import course.service.NewsService;
import course.service.ParentUserService;
import util.UserFactory;

public class UserServiceTest {
	private static Validator validator;
	private static ParentUserService pus;
	private static SubjectCommentService scs;
	private static NewsService ns;
	private static CommentDao cd;

	private static CommentForSubjectDao cfcd;
	private static CommentForUserDao cfud;
	
	private static NewsDao nd;
	/**
	 * 进行一些初始化工作
	 */
	@BeforeClass
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		pus = new ParentUserService();
		scs = new SubjectCommentService();
		ns = new NewsService();
		cd = new CommentDao();
		
		cfcd = new CommentForSubjectDao();
		cfud = new CommentForUserDao();
		
		nd =new NewsDao();
		
	}

	/**
	 * 测试评论上传
	 */
	@Test
	public void testupcomment() {
		List<String> idList = new LinkedList<String>();
		idList.add("1");
		idList.add("2");
		idList.add("3");
		idList.add("4");
		
		assertEquals(true,scs.addComment("1","1",addcom("1", "qqqqq", "2")) );
		assertEquals(true,scs.addComment("1","1",addcom("2", "qqqqq", "2")) );
		assertEquals(true,scs.addComment("1","1",addcom("3", "qqqqq", "2")) );
		assertEquals(true,scs.addComment("1","1",addcom("4", "qqqqq", "2")) );


		assertEquals("1",scs.checkComment("1").get(0).getCommentId());
		assertEquals("2",scs.checkComment("1").get(1).getCommentId());
		
		assertEquals(true,scs.deleteSubjectComment("2"));
		assertEquals(true,scs.deleteSubjectComment("3"));
		assertEquals("4",scs.checkComment("1").get(1).getCommentId());
	
	}

	public Comment addcom(String CommentId, String setDescription, String Star) {
		Comment comment = new Comment();
		comment.setCommentId(CommentId);
		comment.setDescription(setDescription);
		comment.setStar(Star);
		return comment;
	}

	/**
	 * 测试用户登陆
	 */
	@Test
	public void tsetLogin() {

		// 测试登陆成功
		assertEquals(2, pus.login("tchj", "123456"));

		// 测试密码错误的登陆
		assertEquals(1, pus.login("tchj", "111"));

		// 测试用户名不存在的登陆
		assertEquals(0, pus.login("sss", "123"));

	}

	/**
	 * 测试用户注册
	 */
	@Test
	public void testRegister() {

		// 测试已注册过用户是否能注册
		assertEquals(false, pus.register(new ParentUser("tchj", "123456")));

		// 测试注册用户是否能注册
		assertEquals(true, pus.register(new ParentUser("ycb", "123456")));

	}

	/**
	 * 校验数据绑定功能
	 */
	@Test
	public void testValidation() {
		User user = new ParentUser();
		Set<ConstraintViolation<User>> vio = validator.validate(user);
		for (ConstraintViolation c : vio)
			System.out.println(c.getMessage());

	}

	/**
	 * 测试修改用户数据
	 */
	@Test
	public void testchangeInfO() {
		// 测试用户名不存在的情况
		assertEquals(false, pus.changeSelfInfo(new ParentUser("tchj123", "123456")));

		// 测试能否改变密码
		assertEquals(true, pus.changeSelfInfo(new ParentUser("tchj", "123")));

		/**
		 * TODO 测试能否修改不可变元素
		 */

	}

}

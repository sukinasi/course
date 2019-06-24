package course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sun.net.httpserver.Authenticator.Success;

import course.bean.Comment;
import course.service.SubjectCommentService;
import course.service.TeacherCommentService;
import course.service.UserCommentService;

@Controller
public class CommentController {
	TeacherCommentService tcs = new TeacherCommentService();
	SubjectCommentService scs = new SubjectCommentService();
	UserCommentService ucs = new UserCommentService();

	@RequestMapping(value = "/commentUpLoad", method = RequestMethod.GET)
	public ModelAndView upconmmentget() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("commentUpLoad");
		return mav;
	}

	@RequestMapping(value = "/commentUpLoad", method = RequestMethod.POST)
	@ResponseBody()
	public String upconmment(String userName, String teacherUserName, String teacherStar,
			String teacherDiscription, String subjectId, String subjectStar, String subjectDiscription) {
		Comment teacherComment = new Comment();
		Comment subjectComment = new Comment();


		teacherComment.setDescription(teacherDiscription);
		teacherComment.setDescription(teacherStar);
		teacherComment.setType("1");
		subjectComment.setDescription(subjectDiscription);
		subjectComment.setDescription(subjectStar);
		subjectComment.setType("2");
		
		tcs.addComment(userName, teacherUserName, teacherComment);

		scs.addComment(userName, subjectId, subjectComment);

		
		return "success";
	}// 添加评论

	@RequestMapping(value = "/checkTeacherComment", method = RequestMethod.GET)
	public ModelAndView checkTeacherCommentget() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("checkTeacherComment");
		return mav;
	}

	@RequestMapping(value = "/checkTeacherComment", method = RequestMethod.POST)
	public ModelAndView checkTeacherComment(String teacherUserName) {

		ModelAndView mav = new ModelAndView();

		tcs.checkComment(teacherUserName);

		return mav;
	}// 查看教师评论

	@RequestMapping(value = "/checksubjectComment", method = RequestMethod.GET)
	public ModelAndView checksubjectCommentget() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("checksubjectComment");
		return mav;
	}

	@RequestMapping(value = "/checksubjectComment", method = RequestMethod.POST)
	public ModelAndView checksubjectComment(String subjectId) {

		ModelAndView mav = new ModelAndView();

		scs.checkComment(subjectId);

		return mav;
	}// 查看课程评论

	@RequestMapping(value = "/checkUserComment", method = RequestMethod.GET)
	public ModelAndView checkUserCommentget() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("checkUserComment");
		return mav;
	}

	@RequestMapping(value = "/checkUserComment", method = RequestMethod.POST)
	public ModelAndView checkUserComment(String userName) {

		ModelAndView mav = new ModelAndView();

		ucs.checkComment(userName);

		return mav;
	}// 查看用户评论

	@RequestMapping(value = "/deleteComment", method = RequestMethod.GET)
	public ModelAndView deleteCommentget() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("deleteComment");
		return mav;
	}

	@RequestMapping(value = "/deleteComment", method = RequestMethod.POST)
	@ResponseBody()
	public String deleteComment(String CommentId) {

		tcs.deleteTeacherComment(CommentId);

		scs.deleteSubjectComment(CommentId);

		ucs.deleteUserComment(CommentId);
		return "success";
	}// 删除用户评论

}

package course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import course.bean.Comment;
import course.service.CourseCommentService;
import course.service.TeacherCommentService;
import course.service.UserCommentService;

@Controller
public class CommentController {
	TeacherCommentService tcs = new TeacherCommentService();
	CourseCommentService ccs = new CourseCommentService();
	UserCommentService ucs = new UserCommentService();

	@RequestMapping(value = "/commentUpLoad", method = RequestMethod.GET)
	public ModelAndView upconmmentget() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("commentUpLoad");
		return mav;
	}

	@RequestMapping(value = "/commentUpLoad", method = RequestMethod.POST)
	public ModelAndView upconmment(String userName, String teacherUserName, String teacherStar,
			String teacherDiscription, String CourseId, String courseStar, String courseDiscription) {
		Comment teacherComment = new Comment();
		Comment courseComment = new Comment();

		ModelAndView mav = new ModelAndView();

		teacherComment.setDescription(teacherDiscription);
		teacherComment.setDescription(teacherStar);
		courseComment.setDescription(courseDiscription);
		courseComment.setDescription(courseStar);

		tcs.addComment(userName, teacherUserName, teacherComment);

		ccs.addComment(userName, CourseId, courseComment);

		mav.setViewName("success");
		return mav;
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

	@RequestMapping(value = "/checkCourseComment", method = RequestMethod.GET)
	public ModelAndView checkCourseCommentget() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("checkCourseComment");
		return mav;
	}

	@RequestMapping(value = "/checkCourseComment", method = RequestMethod.POST)
	public ModelAndView checkCourseComment(String CourseId) {

		ModelAndView mav = new ModelAndView();

		ccs.checkComment(CourseId);

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
	public ModelAndView deleteComment(String CommentId) {

		ModelAndView mav = new ModelAndView();
		tcs.deleteTeacherComment(CommentId);

		ccs.deleteCourseComment(CommentId);

		ucs.deleteUserComment(CommentId);
		return mav;
	}// 删除用户评论

}

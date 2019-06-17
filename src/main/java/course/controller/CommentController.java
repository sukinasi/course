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

	Comment teacherComment = new Comment();
	Comment courseComment = new Comment();
	
	
	
	@RequestMapping(value="/commentUpLoad",method = RequestMethod.GET)
	public ModelAndView upconmmentget() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("commentUpLoad");
		return mav;
	}

	@RequestMapping(value="/commentUpLoad",method = RequestMethod.POST)
	public ModelAndView upconmment(String userName, String teacherUserName, String teacherStar,String teacherDiscription, String CourseId, String courseStar, String courseDiscription) {
		ModelAndView mav = new ModelAndView();

		teacherComment.setDescription(teacherDiscription);
		teacherComment.setDescription(teacherStar);
		courseComment.setDescription(courseDiscription);
		courseComment.setDescription(courseStar);

		tcs.addComment(userName, teacherUserName, teacherComment);

		ccs.addComment(userName, CourseId, courseComment);
		
		mav.setViewName("success");
		return mav;
	}

	@RequestMapping("/checkTeacherComment")
	public ModelAndView checkTeacherComment(String teacherUserName) {

		ModelAndView mav = new ModelAndView();

		tcs.checkComment(teacherUserName);

		return mav;
	}

	@RequestMapping("/checkCourseComment")
	public ModelAndView checkCourseComment(String CourseId) {

		ModelAndView mav = new ModelAndView();

		ccs.checkComment(CourseId);

		return mav;
	}

	@RequestMapping("/checkUserComment")
	public ModelAndView checkUserComment(String userName) {

		ModelAndView mav = new ModelAndView();

		ucs.checkComment(userName);

		return mav;
	}

	@RequestMapping("/deleteComment")
	public ModelAndView deleteComment(String CommentId) {

		ModelAndView mav = new ModelAndView();
		tcs.deleteTeacherComment(CommentId);

		ccs.deleteCourseComment(CommentId);

		ucs.deleteUserComment(CommentId);
		return mav;
	}

}

package course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import course.bean.Comment;
import course.service.CourseCommentService;
import course.service.TeacherCommentService;

@Controller
public class CommentController {
	@RequestMapping("/commentUpLoad")
	public ModelAndView upconmment(String teacherUserName,String teacherStar,String teacherDiscription,String CourseId,String courseStar,String courseDiscription)
	{
		ModelAndView mav=new ModelAndView();
		Comment teacherComment=new Comment();
		Comment courseComment=new Comment();
		
		teacherComment.setDescription(teacherDiscription);
		teacherComment.setDescription(teacherStar);
		courseComment.setDescription(courseDiscription);
		courseComment.setDescription(courseStar);
		
		TeacherCommentService tcs=new TeacherCommentService();
		CourseCommentService ccs=new CourseCommentService();
		
		tcs.addComment(teacherUserName,teacherComment);
		
		ccs.addComment(CourseId,courseComment);
	
		mav.setViewName("success");
		return mav;
	}
	
}

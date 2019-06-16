package course.service;

import org.springframework.stereotype.Service;

import course.bean.Comment;
import course.dao.CommentForCourseDao;
import course.dao.CourseCommentDao;


@Service
public class CourseCommentService {
	CourseCommentDao ccd=new CourseCommentDao();
	CommentForCourseDao cfcd =new CommentForCourseDao();
	
	public boolean addComment(String courseId, Comment courseComment) {
		ccd.addList(courseComment);
		cfcd.addrelationship(courseId,courseComment);
		return true;
	
		
	}

	

}

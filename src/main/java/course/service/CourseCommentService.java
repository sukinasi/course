package course.service;

import java.util.List;

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
		cfcd.addrelationship(courseId,courseComment.getCommentId());
		return true;
	}
	public List<Comment> checkComment(String courseId) {	
		return ccd.gainComment(cfcd.checkCommentId(courseId));
		}
	

}

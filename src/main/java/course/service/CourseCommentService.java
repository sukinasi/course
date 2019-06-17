package course.service;

import java.util.List;

import org.springframework.stereotype.Service;

import course.bean.Comment;
import course.dao.CommentForCourseDao;
import course.dao.CommentForUserDao;
import course.dao.CourseCommentDao;

@Service
public class CourseCommentService {
	CourseCommentDao ccd = new CourseCommentDao();
	CommentForCourseDao cfcd = new CommentForCourseDao();
	CommentForUserDao cfud = new CommentForUserDao();

	public boolean addComment(String userName, String courseId, Comment courseComment) {
		ccd.addList(courseComment);
		cfcd.addrelationship(courseId, courseComment.getCommentId());
		cfud.addrelationship(userName, courseComment.getCommentId());
		return true;
	}

	public List<Comment> checkComment(String courseId) {
		return ccd.gainComment(cfcd.checkCommentId(courseId));
	}

}

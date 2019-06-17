package course.service;

import java.util.List;

import org.springframework.stereotype.Service;

import course.bean.Comment;
import course.dao.CommentForCourseDao;
import course.dao.CommentForUserDao;
import course.dao.CourseCommentDao;
import util.UserFactory;

@Service
public class CourseCommentService {
	CourseCommentDao ccd=UserFactory.CourseCommentDaoFactory();
	CommentForCourseDao cfcd = UserFactory.CommentForCourseDaoFactory();
	CommentForUserDao cfud = UserFactory.CommentForUserDaoFactory();

	public boolean addComment(String userName, String courseId, Comment courseComment) {
		ccd.addList(courseComment);
		cfcd.addrelationship(courseId, courseComment.getCommentId());
		cfud.addrelationship(userName, courseComment.getCommentId());
		return true;
	}

	public List<Comment> checkComment(String courseId) {
		return ccd.gainComment(cfcd.checkCommentId(courseId));
	}

	public void deleteCourseComment(String commentId) {
		ccd.delete(commentId);
		cfcd.delete(commentId);
	}


}

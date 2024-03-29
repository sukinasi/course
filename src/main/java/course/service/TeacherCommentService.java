package course.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;
import course.bean.Comment;
import course.dao.CommentForTeacherDao;
import course.dao.CommentForUserDao;
import course.dao.CommentDao;
import course.dao.CommentForSubjectDao;
import util.UserFactory;

@Service
public class TeacherCommentService {
	CommentDao cd=UserFactory.CommentDaoFactory();
	CommentForSubjectDao cfsd = UserFactory.CommentForSubjectDaoFactory();
	CommentForTeacherDao cftd =UserFactory.CommentForTeacherDaoFactory();
	CommentForUserDao cfud = UserFactory.CommentForUserDaoFactory();
	
	public boolean addComment(String userName,String teacherUserName,Comment teacherComment) {
		cd.addList(teacherComment);
		cftd.addrelationship(teacherUserName,teacherComment.getCommentId());
		cfud.addrelationship(userName,teacherComment.getCommentId());
		return true;
	}
	
	public List<Comment> checkComment(String teacherUserName) {	
		return cd.gainComment(cftd.checkCommentId(teacherUserName));
		}

	public boolean deleteTeacherComment(String commentId) {
		cd.delete(commentId);
		cfsd.delete(commentId);
		cftd.delete(commentId);
		cfud.delete(commentId);
		return true;
	}

}

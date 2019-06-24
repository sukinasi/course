package course.service;

import java.util.List;

import org.springframework.stereotype.Service;

import course.bean.Comment;
import course.dao.CommentDao;
import course.dao.CommentForSubjectDao;
import course.dao.CommentForTeacherDao;
import course.dao.CommentForUserDao;
import util.UserFactory;

@Service
public class SubjectCommentService {
	CommentDao cd=UserFactory.CommentDaoFactory();
	CommentForSubjectDao cfsd = UserFactory.CommentForSubjectDaoFactory();
	CommentForTeacherDao cftd =UserFactory.CommentForTeacherDaoFactory();
	CommentForUserDao cfud = UserFactory.CommentForUserDaoFactory();

	public boolean addComment(String userName, String subjectId, Comment subjectComment) {
		cd.addList(subjectComment);
		cfsd.addrelationship(subjectId, subjectComment.getCommentId());
		cfud.addrelationship(userName, subjectComment.getCommentId());
		return true;
	}

	
	public List<Comment> checkComment(String subjectId) {
		return cd.gainComment(cfsd.checkCommentId(subjectId));
	}

	public boolean deleteSubjectComment(String commentId) {
		cd.delete(commentId);
		cfsd.delete(commentId);
		cftd.delete(commentId);
		cfud.delete(commentId);
		return true;
	}


}

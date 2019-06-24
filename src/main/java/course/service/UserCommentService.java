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
public class UserCommentService {
	CommentDao cd=UserFactory.CommentDaoFactory();
	CommentForSubjectDao cfsd = UserFactory.CommentForSubjectDaoFactory();
	CommentForTeacherDao cftd =UserFactory.CommentForTeacherDaoFactory();
	CommentForUserDao cfud = UserFactory.CommentForUserDaoFactory();

	public List<Comment> checkComment(String userName) {

		return cd.gainComment(cfud.checkCommentId(userName));
	}


	public boolean deleteUserComment(String commentId) {
		cd.delete(commentId);
		cfsd.delete(commentId);
		cftd.delete(commentId);
		cfud.delete(commentId);
		return true;
	}

}

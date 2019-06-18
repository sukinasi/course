package course.service;

import java.util.List;

import org.springframework.stereotype.Service;

import course.bean.Comment;
import course.dao.CommentForUserDao;
import util.UserFactory;

@Service
public class UserCommentService {
	CommentForUserDao cfud = UserFactory.CommentForUserDaoFactory();

	public List<Comment> checkComment(String userName) {

		return cfud.gainComment(cfud.checkCommentId(userName));
	}


	public boolean deleteUserComment(String commentId) {
		cfud.delete(commentId);
		return true;
	}

}

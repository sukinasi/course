package course.service;

import java.util.List;

import org.springframework.stereotype.Service;

import course.bean.Comment;
import course.dao.CommentForUserDao;

@Service
public class UserCommentService {
	CommentForUserDao cfud = new CommentForUserDao();

	public List<Comment> checkComment(String userName) {

		return cfud.gainComment(cfud.checkCommentId(userName));
	}

}

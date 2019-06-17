package course.dao;

import java.util.LinkedList;
import java.util.List;

import course.bean.Comment;
import course.bean.UserComment;

public class CommentForUserDao {
	UserComment userrelationship = new UserComment();
	private List<UserComment> ul = new LinkedList<UserComment>();

	public void addrelationship(String userName, String CommentId) {
		userrelationship.setUserName(userName);
		userrelationship.setCommentId(CommentId);
		ul.add(userrelationship);
	}

	public List<String> checkCommentId(String userName) {

		List<String> idList = new LinkedList<String>();

		for (int i = 0; i <= ul.size(); i++) {
			if (ul.get(i).getUserName() == userName)
				idList.add(ul.get(i).getCommentId());
		}
		return idList;
	}

	public List<Comment> gainComment(List<String> idList) {
		List<Comment> courseCommentList = new LinkedList<Comment>();

		List<Comment> teacherCommentList = new LinkedList<Comment>();

		List<Comment> outCommentList = new LinkedList<Comment>();

		for (int q = 0; q <= idList.size(); q++) {

			for (int i = 0; i <= courseCommentList.size(); i++) {
				if (courseCommentList.get(i).getCommentId() == idList.get(q))
					outCommentList.add(courseCommentList.get(i));
			}

			for (int p = 0; p <= teacherCommentList.size(); p++) {
				if (teacherCommentList.get(p).getCommentId() == idList.get(q))
					outCommentList.add(teacherCommentList.get(p));
			}

		}
		return outCommentList;
	}
}

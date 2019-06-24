package course.dao;

import java.util.LinkedList;
import java.util.List;

import course.bean.Comment;
import course.bean.UserComment;
import util.UserFactory;

public class CommentForUserDao {
	
	
	private List<UserComment> ul = new LinkedList<UserComment>();
	
	
	CommentDao cd = UserFactory.CommentDaoFactory();

	public void addrelationship(String userName, String CommentId) {
		UserComment userrelationship = new UserComment();
		userrelationship.setUserName(userName);
		userrelationship.setCommentId(CommentId);
		ul.add(userrelationship);
	}

	public List<String> checkCommentId(String userName) {

		List<String> idList = new LinkedList<String>();

		for (int i = 0; i < ul.size(); i++) {
			if (ul.get(i).getUserName() == userName)
				idList.add(ul.get(i).getCommentId());
		}
		return idList;
	}

	public void delete(String commentId) {
		for (int i = 0; i < ul.size(); i++) {
			if (ul.get(i).getCommentId() == commentId)
				ul.remove(i);
		}

	}
}

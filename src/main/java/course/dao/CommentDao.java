package course.dao;

import java.util.LinkedList;
import java.util.List;

import course.bean.Comment;

public class CommentDao {
	private List<Comment> CommentList;
	private Comment NULL;

	public CommentDao() {
		CommentList = new LinkedList<Comment>();
	}

	public boolean addList(Comment comment) {
		CommentList.add(comment);
		return true;
	}

	public List<Comment> gainComment(List<String> idList) {
		List<Comment> outCommentList = new LinkedList<Comment>();
		for (int q = 0; q < idList.size(); q++) {
			for (int i = 0; i < CommentList.size(); i++) {
				if (CommentList.get(i).getCommentId() == idList.get(q))
					outCommentList.add(CommentList.get(i));
			}
		}
		return outCommentList;
	}

	public Comment select(String commentId) {
		Comment comment = new Comment();
		for (int i = 0; i < CommentList.size(); i++) {
			if (CommentList.get(i).getCommentId() == commentId) {
				comment = CommentList.get(i);
				return comment;
			}
		}
		return NULL;
	}

	public void delete(String commentId) {
		for (int i = 0; i < CommentList.size(); i++) {
			if (CommentList.get(i).getCommentId() == commentId)
				CommentList.remove(i);
		}
	}

}

package course.dao;

import java.util.LinkedList;
import java.util.List;

import course.bean.Comment;

public class TeacherCommentDao {
	private List<Comment> teacherCommentList;
	private Comment NULL;

	public TeacherCommentDao() {
		teacherCommentList = new LinkedList<Comment>();
	}

	public void addList(Comment comment) {
		teacherCommentList.add(comment);
	}

	public List<Comment> gainComment(List<String> idList) {
		List<Comment> outCommentList = new LinkedList<Comment>();
		for (int q = 0; q <= idList.size(); q++) {
			for (int i = 0; i <= teacherCommentList.size(); i++) {
				if (teacherCommentList.get(i).getCommentId() == idList.get(q))
					outCommentList.add(teacherCommentList.get(i));
			}
		}
		return outCommentList;
	}

	public Comment select(String commentId) {
		Comment comment = new Comment();
		for (int i = 0; i <= teacherCommentList.size(); i++) {
			if (teacherCommentList.get(i).getCommentId() == commentId) {
				comment = teacherCommentList.get(i);
				return comment;
			}
		}
		return NULL;
	}

	public void delete(String commentId) {
		for (int i = 0; i <= teacherCommentList.size(); i++) {
			if (teacherCommentList.get(i).getCommentId() == commentId)
				teacherCommentList.remove(i);
		}
	}

}

package course.dao;

import java.util.LinkedList;
import java.util.List;
import course.bean.TeacherComment;

public class CommentForTeacherDao {
	

	private List<TeacherComment> tl = new LinkedList<TeacherComment>();

	public void addrelationship(String teacherUserName, String CommentId) {
		TeacherComment teacherrelationship = new TeacherComment();
		teacherrelationship.setTeacherUserName(teacherUserName);
		teacherrelationship.setCommentId(CommentId);
		tl.add(teacherrelationship);
	}

	public List<String> checkCommentId(String teacherUserName) {

		List<String> idList = new LinkedList<String>();

		for (int i = 0; i < tl.size(); i++) {
			if (tl.get(i).getTeacherUserName() == teacherUserName)
				idList.add(tl.get(i).getCommentId());
		}
		return idList;
	}

	public void delete(String commentId) {
		for (int i = 0; i < tl.size(); i++) {
			if (tl.get(i).getCommentId() == commentId)
				tl.remove(i);
		}
	}

}

package course.dao;

import java.util.LinkedList;
import java.util.List;

import course.bean.Comment;
import course.bean.CourseComment;

public class CommentForCourseDao {
	

	private List<CourseComment> cl = new LinkedList<CourseComment>();

	public boolean addrelationship(String courseId, String CommentId) {
		CourseComment courserelationship = new CourseComment();
		courserelationship.setCourseId(courseId);
		courserelationship.setCommentId(CommentId);
		cl.add(courserelationship);
		return true;
	}

	public List<String> checkCommentId(String CourseId) {

		List<String> idList = new LinkedList<String>();

		for (int i = 0; i < cl.size(); i++) {
			
			if (cl.get(i).getCourseId() == CourseId) 
				idList.add(cl.get(i).getCommentId());	
		}
		return idList;
	}

	public void delete(String commentId) {
		for (int i = 0; i < cl.size(); i++) {
			if (cl.get(i).getCommentId() == commentId)
				cl.remove(i);
		}
	}
}

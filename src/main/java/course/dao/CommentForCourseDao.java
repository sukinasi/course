package course.dao;


import java.util.LinkedList;
import java.util.List;

import course.bean.Comment;
import course.bean.CourseComment;

public class CommentForCourseDao {
	CourseComment courserelationship =new CourseComment();
	private List<CourseComment> cl =new LinkedList<CourseComment>();
	public void addrelationship(String courseId, Comment courseComment) {
		courserelationship.setCourseId(courseId);
		courserelationship.setComment(courseComment);
		cl.add(courserelationship);
	}

}

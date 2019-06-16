package course.dao;


import java.util.LinkedList;
import java.util.List;

import course.bean.Comment;
import course.bean.CourseComment;

public class CommentForCourseDao {
	CourseComment courserelationship =new CourseComment();
	
	private List<CourseComment> cl =new LinkedList<CourseComment>();
	
	public void addrelationship(String courseId, String CommentId) {
		courserelationship.setCourseId(courseId);
		courserelationship.setCommentId(CommentId);
		cl.add(courserelationship);
	}

	public List<String> checkCommentId(String CourseId) {
		
		List<String> idList=new LinkedList<String>();
		
		for(int i=0;i<=cl.size();i++) {
			if(cl.get(i).getCourseId()==CourseId)
				idList.add(cl.get(i).getCommentId());	
		}		
		return idList;
	}
}

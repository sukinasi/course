package course.dao;

import java.util.LinkedList;
import java.util.List;
import course.bean.Comment;
import course.bean.TeacherComment;

public class CommentForTeacherDao {
	TeacherComment teacherrelationship =new TeacherComment();
	private List<TeacherComment> tl=new LinkedList<TeacherComment>();
	
	public void addrelationship(String teacherUserName, Comment teacherComment) {
		teacherrelationship.setTeacherUserName(teacherUserName);
		teacherrelationship.setComment(teacherComment);
		tl.add(teacherrelationship);
		
	}

}

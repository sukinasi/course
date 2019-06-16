package course.dao;

import java.util.LinkedList;
import java.util.List;

import course.bean.Comment;

public class TeacherCommentDao {
	private List<Comment> teacherCommentList;

	public TeacherCommentDao()
	{
		teacherCommentList=new LinkedList<Comment>();	
	}
	
	public void addList(Comment comment) {
		teacherCommentList.add(comment);
	}

}

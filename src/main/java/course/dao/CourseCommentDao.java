package course.dao;

import java.util.LinkedList;
import java.util.List;

import course.bean.Comment;

public class CourseCommentDao {
	private List<Comment> courseCommentList;
	
	public CourseCommentDao()
	{
		courseCommentList=new LinkedList<Comment>();	
	}
	
	public void addList(Comment comment) {
		courseCommentList.add(comment);		
	}
}

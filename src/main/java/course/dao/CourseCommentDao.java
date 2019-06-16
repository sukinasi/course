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
	
	public List<Comment> gainComment(List<String> idList){
		 List<Comment> outCommentList=new LinkedList<Comment>();
		 for(int q=0;q<=idList.size();q++) {
		for(int i=0;i<=courseCommentList.size();i++) {
			if(courseCommentList.get(i).getCommentId()==idList.get(q))
				outCommentList.add(courseCommentList.get(i));
		}
		 }
		return outCommentList;
	}
}

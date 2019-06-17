package course.dao;

import java.util.LinkedList;
import java.util.List;

import course.bean.Comment;

public class CourseCommentDao {
	private List<Comment> courseCommentList;
	private Comment NULL;
	
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
	public Comment select(String commentId) {
		Comment comment=new Comment();
		for(int i=0;i<=courseCommentList.size();i++) {
			if(courseCommentList.get(i).getCommentId()==commentId){
				comment=courseCommentList.get(i);
				return comment;
				}		
		}
		return NULL;
	}

	public void delete(String commentId) {
		for(int i=0;i<=courseCommentList.size();i++) {
			if(courseCommentList.get(i).getCommentId()==commentId)
				courseCommentList.remove(i);
		}	
	}

	
}

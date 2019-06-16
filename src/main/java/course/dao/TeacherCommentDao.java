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

	public List<Comment> gainComment(List<String> idList){
		 List<Comment> outCommentList=new LinkedList<Comment>();
		 for(int q=0;q<=idList.size();q++) {
		for(int i=0;i<=teacherCommentList.size();i++) {
			if(teacherCommentList.get(i).getCommentId()==idList.get(q))
				outCommentList.add(teacherCommentList.get(i));
		}
		 }
		return outCommentList;
		
		
	}

}

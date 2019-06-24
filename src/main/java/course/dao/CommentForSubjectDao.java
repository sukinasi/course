package course.dao;

import java.util.LinkedList;
import java.util.List;

import course.bean.Comment;
import course.bean.SubjectComment;

public class CommentForSubjectDao {
	

	private List<SubjectComment> cl = new LinkedList<SubjectComment>();

	public boolean addrelationship(String subjectId, String CommentId) {
		SubjectComment subjectrelationship = new SubjectComment();
		subjectrelationship.setSubjectId(subjectId);
		subjectrelationship.setCommentId(CommentId);
		cl.add(subjectrelationship);
		return true;
	}

	public List<String> checkCommentId(String subjectId) {

		List<String> idList = new LinkedList<String>();

		for (int i = 0; i < cl.size(); i++) {		
			if (cl.get(i).getSubjectId() == subjectId) 
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

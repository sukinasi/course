package course.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;
import course.bean.Comment;
import course.dao.CommentForTeacherDao;
import course.dao.CommentForUserDao;
import course.dao.TeacherCommentDao;

@Service
public class TeacherCommentService {
	TeacherCommentDao tcd=new TeacherCommentDao();
	CommentForTeacherDao cftd =new CommentForTeacherDao();
	CommentForUserDao cfud =new CommentForUserDao();
	
	public boolean addComment(String userName,String teacherUserName,Comment teacherComment) {
		tcd.addList(teacherComment);
		cftd.addrelationship(teacherUserName,teacherComment.getCommentId());
		cfud.addrelationship(userName,teacherComment.getCommentId());
		return true;
	}
	
	public List<Comment> checkComment(String teacherUserName) {	
		return tcd.gainComment(cftd.checkCommentId(teacherUserName));
		}

}

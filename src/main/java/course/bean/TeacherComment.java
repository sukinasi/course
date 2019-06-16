package course.bean;

public class TeacherComment {
private String teacherUserName;
private Comment comment;
public String getTeacherUserName() {
	return teacherUserName;
}

public void setTeacherUserName(String teacherUserName) {
	this.teacherUserName = teacherUserName;
}

public Comment getComment() {
	return comment;
}

public void setComment(Comment comment) {
	this.comment = comment;
}
}

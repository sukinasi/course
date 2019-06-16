package course.bean;

public class CourseComment {
private String CourseId;
private Comment comment;
public String getCourseId() {
	return CourseId;
}

public void setCourseId(String courseId) {
	CourseId = courseId;
}

public Comment getComment() {
	return comment;
}

public void setComment(Comment comment) {
	this.comment = comment;
}

}

package util;

import course.dao.CommentForCourseDao;
import course.dao.CommentForTeacherDao;
import course.dao.CommentForUserDao;
import course.dao.CourseCommentDao;
import course.dao.NewsDao;
import course.dao.TeacherCommentDao;

public class UserFactory {
private static CommentForCourseDao cfcd=new CommentForCourseDao();

private static CommentForTeacherDao cftd=new CommentForTeacherDao();

private static CommentForUserDao cfd=new CommentForUserDao();

private static CourseCommentDao ccd =new CourseCommentDao();

private static TeacherCommentDao tcd=new TeacherCommentDao();

private static NewsDao nd=new NewsDao();

public static CommentForCourseDao CommentForCourseDaoFactory() {
	return cfcd;
}
public static CommentForTeacherDao CommentForTeacherDaoFactory() {
	return cftd;
}
public static CommentForUserDao CommentForUserDaoFactory() {
	return cfd;
}
public static CourseCommentDao CourseCommentDaoFactory() {
	return ccd;
}
public static TeacherCommentDao TeacherCommentDaoFactory() {
	return tcd;
}
public static NewsDao NewsDaoFactory() {
	return nd;
}
}

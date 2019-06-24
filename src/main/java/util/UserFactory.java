package util;

import course.dao.CommentForSubjectDao;
import course.dao.CommentForTeacherDao;
import course.dao.CommentForUserDao;
import course.dao.NewsDao;
import course.dao.CommentDao;

public class UserFactory {
private static CommentForSubjectDao cfsd=new CommentForSubjectDao();

private static CommentForTeacherDao cftd=new CommentForTeacherDao();

private static CommentForUserDao cfd=new CommentForUserDao();

private static CommentDao cd=new CommentDao();

private static NewsDao nd=new NewsDao();

public static CommentForSubjectDao CommentForSubjectDaoFactory() {
	return cfsd;
}
public static CommentForTeacherDao CommentForTeacherDaoFactory() {
	return cftd;
}
public static CommentForUserDao CommentForUserDaoFactory() {
	return cfd;
}

public static CommentDao CommentDaoFactory() {
	return cd;
}
public static NewsDao NewsDaoFactory() {
	return nd;
}
}

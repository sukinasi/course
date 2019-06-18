package course.service;

import course.bean.News;
import course.dao.NewsDao;
import util.UserFactory;

public class NewsService {

	public boolean addNews(News news) {
		NewsDao nd = UserFactory.NewsDaoFactory();
		nd.aaddList(news);
		return true;
	}

}

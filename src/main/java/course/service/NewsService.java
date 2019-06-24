package course.service;

import java.util.List;

import course.bean.Comment;
import course.bean.News;
import course.dao.NewsDao;
import util.UserFactory;

public class NewsService {
	NewsDao nd = UserFactory.NewsDaoFactory();

	public boolean addNews(News news) {

		nd.addList(news);
		return true;
	}
	public List<String> getNewsLine() {	
		return nd.getNewsTopicList();
	}
	public News checkNews(String newsId) {
		return nd.getNews(newsId);
	}

	public boolean deleteNews(String newsId) {
		nd.delete(newsId);
		return true;
		
	}


}

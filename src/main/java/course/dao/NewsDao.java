package course.dao;

import java.util.LinkedList;
import java.util.List;

import course.bean.Comment;
import course.bean.News;

public class NewsDao {
	private List<News> newsList;
	private News NULL;

	public NewsDao() {
		newsList = new LinkedList<News>();
	}

	public boolean addList(News news) {
		newsList.add(news);
		return true;
	}
	
	public List<String> getNewsTopicList() {
		 List<String> outTopicList=new LinkedList<String>();
		 for(int i=0;i<newsList.size();i++) {
			 outTopicList.add(newsList.get(i).getTopic());
		 }		 
		return outTopicList;
	}

	public News getNews(String newsId) {
		News news = new News();
		for (int i = 0; i < newsList.size(); i++) {
			if (newsList.get(i).getNewsId() == newsId)
				news = newsList.get(i);
			}
		return news;
	}

	public boolean delete(String newsId) {
		for(int i=0;i<newsList.size();i++) {
			if(newsList.get(i).getNewsId()==newsId)
				newsList.remove(i);
		}	
		return true;
		
	}

}

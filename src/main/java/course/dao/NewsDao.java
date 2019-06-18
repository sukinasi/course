package course.dao;

import java.util.LinkedList;
import java.util.List;

import course.bean.News;

public class NewsDao {
	private List<News> newsList;
	private News NULL;
	
	public NewsDao()
	{
		newsList=new LinkedList<News>();	
	}
	public boolean aaddList(News news) {
		newsList.add(news);
		return true;
	}
	

}

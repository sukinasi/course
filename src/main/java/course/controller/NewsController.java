package course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import course.bean.News;
import course.service.NewsService;

@Controller
public class NewsController {

	NewsService ns = new NewsService();

	@RequestMapping(value = "/upNews", method = RequestMethod.GET)
	public ModelAndView upNewsGet() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("upNews");
		return mav;
	}

	@RequestMapping(value = "/upNews", method = RequestMethod.POST)
	public ModelAndView upNews(String newsId, String topic, String content) {
		
		ModelAndView mav = new ModelAndView();
		News news = new News();
		
		news.setNewId(newsId);
		news.setTopic(topic);
		news.setContent(content);
		
		ns.addNews(news);
		
		mav.setViewName("success");
		return mav;
	}
	

}

package course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import course.bean.News;
import course.service.NewsService;

@Controller
public class NewsController {

	NewsService ns = new NewsService();
/**
 * 添加新闻
 */
	@RequestMapping(value = "/upNews", method = RequestMethod.GET)
	public ModelAndView upNewsGet() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("upNews");
		return mav;
	}

	@RequestMapping(value = "/upNews", method = RequestMethod.POST)
	@ResponseBody()
	public String upNews(String newsId, String topic, String content) {

		News news = new News();

		news.setNewId(newsId);
		news.setTopic(topic);
		news.setContent(content);

		ns.addNews(news);
		return "success";
	}
	
	/**
	 * 查看新闻列表
	 */
	@RequestMapping(value = "/getNewsLine", method = RequestMethod.GET)
	public ModelAndView getNewsLineGet() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getNewsLine");
		return mav;
	}

	@RequestMapping(value = "/getNewsLine", method = RequestMethod.POST)
	public ModelAndView getNewsLine() {
		ModelAndView mav = new ModelAndView();
		ns.getNewsLine();
		return mav;
	}
	/**
	 * 查看新闻
	 */

	@RequestMapping(value = "/checkNews", method = RequestMethod.GET)
	public ModelAndView checkNewsGet() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("checkNews");
		return mav;
	}

	@RequestMapping(value = "/checkNews", method = RequestMethod.POST)
	public ModelAndView checkNews(String newsId) {
		ModelAndView mav = new ModelAndView();
		ns.checkNews(newsId);
		return mav;
	}
	/**
	 * 删除新闻
	 */
	@RequestMapping(value = "/deleteNews", method = RequestMethod.GET)
	public ModelAndView deleteNewsGet() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("deleteNews");
		return mav;
	}

	@RequestMapping(value = "/deleteNews", method = RequestMethod.POST)
	@ResponseBody()
	public String deleteNews(String newsId) {
		ns.deleteNews(newsId);
		return "success";
	}
	
}

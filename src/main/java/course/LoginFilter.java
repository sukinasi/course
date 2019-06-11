package course;



import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "sessionFilter", urlPatterns =
{ "/user/*" })
public class LoginFilter implements Filter
{
	String NO_LOGIN = "您还未登录";

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException
	{
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpSession session = request.getSession(true);
		String parm = request.getQueryString();
		System.out.println("filter url:" + request.getServletPath() + (parm != null ? "?" + parm : ""));
		// session中包含user对象,则是登录状态
		if (session != null && session.getAttribute("user") != null)
		{
			filterChain.doFilter(request, response);
		} 
		else
		{
			String requestType = request.getHeader("X-Requested-With");
			// 判断是否是ajax请求
			if (requestType != null && "XMLHttpRequest".equals(requestType))
			{
				response.getWriter().write(this.NO_LOGIN);
			} 
			else
			{
				session.setAttribute("goUrl", request.getServletPath() + (parm != null ? "?" + parm : ""));
				System.out.println("拦截地址:" + request.getServletPath() + (parm != null ? "?" + parm : ""));
				request.getRequestDispatcher("/login").forward(request, response);
				return;
			}
			return;
		}
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException{}

	@Override
	public void destroy(){}

}
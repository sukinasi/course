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

@WebFilter(filterName = "adminFilter", urlPatterns =
{ "/admin/*" })
public class AdminFilter implements Filter
{

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException
	{
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpSession session = request.getSession(true);
		String parm = request.getQueryString();
		System.out.println("filter url:" + request.getServletPath() + (parm != null ? "?" + parm : ""));
		Object obj=session.getAttribute("user");
		String user=obj!=null?(String)obj:null;
		if (user != null && user.equals("admin"))
		{
			filterChain.doFilter(request, response);
		} 
		else
		{
			session.setAttribute("url", "/index");
			request.setAttribute("msg", "权限不足");
			System.out.println("拦截地址:" + request.getServletPath() + (parm != null ? "?" + parm : ""));
			request.getRequestDispatcher("/fail").forward(request, response);
			return;
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
	}

	@Override
	public void destroy()
	{
	}

}
package cn.jluibm.filter;

import java.io.IOException;
import java.util.List;

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

import cn.jluibm.model.dao.IDao;
import cn.jluibm.model.dao.impl.EssayDao;
import cn.jluibm.model.entity.Essay;
import cn.jluibm.model.entity.User;
import cn.jluibm.utils.ReflectionTools;
import cn.jluibm.utils.SQLTools;

/**
 * Servlet Filter implementation class EssayInitFilter
 */
public class EssayInitFilter implements Filter
{

    public EssayInitFilter() {}

	public void destroy() {}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, 
			FilterChain chain) throws IOException, ServletException 
	{
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		HttpSession session = request.getSession();
		if(session.getAttribute("essayAuthor") == null)
		{
			//假设存放的是user键值
			User user = (User) session.getAttribute("user");
			//假设以username代表作者
			String essayAuthor = (String) ReflectionTools.getter(user, "name");
			//类型为文章
			int essayType = 1;
			//放入session
			session.setAttribute("essayAuthor", essayAuthor);
			session.setAttribute("essayType", essayType);
			//读取essay信息
			IDao<Essay> essayDao = new EssayDao();
			String queryAllEssaySql = SQLTools.QUERY_ESSAY + "where author = ? and type = ?";
			//存入List
			List<Essay> essayList = essayDao.getForList(queryAllEssaySql, 
					essayAuthor, essayType);
			//存入session
			session.setAttribute("essayList", essayList);
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException 
	{
		
	}

}

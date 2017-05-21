package cn.jluibm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter
{

	@Override
	public void destroy()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException
	{
		request.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
	}

	//获取到编码方式
	private String encoding;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
		ServletContext servletContest = filterConfig.getServletContext();
		encoding = servletContest.getInitParameter("encoding");
	}

}

package cn.jluibm.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hyec on 2017/5/7.
 * 示例页面,项目发布时删除。
 */
public class HelloWorldServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取参数
        String str = request.getParameter("hello");

        //有效判断
        if(str == null) {
            str = "You input nothing.";
        }

        //返回页面
        request.setAttribute("message",str);
        request.getRequestDispatcher("/WEB-INF/helloworld.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("message", "Welcome to IBMClub.");
        request.getRequestDispatcher("/WEB-INF/helloworld.jsp").forward(request,response);
    }
}

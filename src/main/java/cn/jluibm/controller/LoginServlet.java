package cn.jluibm.controller;

import cn.jluibm.model.dao.impl.UserDao;
import cn.jluibm.model.entity.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import cn.jluibm.utils.SQLTools;

/**
 * Created by hyec on 2017/5/12.
 */
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private transient String redirectUrl;
	private transient UserDao userDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        redirectUrl = config.getInitParameter("redirect");
        if (redirectUrl == null) {
            redirectUrl = "/";
        }
        init();
    }

    @Override
    public void init() throws ServletException {
        this.userDao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fromUrl = request.getParameter("from");
        if (fromUrl != null) {
            request.setAttribute("from", fromUrl);
        }

        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirectUrl = request.getParameter("from");
        if (redirectUrl == null || redirectUrl.length() == 0) {
            redirectUrl = this.redirectUrl;
        }

        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = userDao.getSingleObject(SQLTools.QUERY_USER + "where email=? and password=?", email, password);

        if (user != null) {
            session.setAttribute("user", user);
            response.sendRedirect(request.getContextPath() + redirectUrl);
        } else {
            request.setAttribute("email", email);
            request.setAttribute("message", "用户名密码不匹配。");
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }

    }

}

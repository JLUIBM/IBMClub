package cn.jluibm.controller;

import cn.jluibm.model.dao.impl.UserDao;
import cn.jluibm.model.entity.User;
import cn.jluibm.utils.FormTools;
import cn.jluibm.utils.SQLTools;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by hyec on 2017/5/28.
 */
public class UserListServlet extends HttpServlet {

    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<User> users = userDao.getForList(SQLTools.QUERY_USER);
        request.setAttribute("users", users);

        request.getRequestDispatcher("/WEB-INF/admin/userlist.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if (!FormTools.checkText(method)) {
            response.sendRedirect("/error");
        }
    }
}

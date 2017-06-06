package cn.jluibm.controller;

import cn.jluibm.model.dao.impl.UserDao;
import cn.jluibm.model.entity.User;
import cn.jluibm.utils.FormTools;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hyec on 2017/5/7.
 */
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int parameterLen;

        User user = new User();
        List<String> messages = new ArrayList<>();

        try {
            String email = request.getParameter("email");
            if (!FormTools.checkEmail(email)) {
                throw new RegisterException("Email");
            }
        } catch (RegisterException re) {
            re.printStackTrace();
        }

        user.setEmail(request.getParameter("email"));

        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));

        user.setRealname(request.getParameter("realname"));


        //TODO: 实现下列功能
        user.setUsername("test");
        user.setSex(false);
        user.setAcademy("2015");
        user.setDegree(0);
        user.setGrade(0);
        user.setPermission(0);
        user.setPhoneNum("000");
        user.setStudentNum("000");
        user.setSignupTime(new Date());
        user.setQq("");

        if(!FormTools.checkEmail(user.getEmail())) {
            messages.add("邮箱非法。");
        }

//        parameterLen = user.getUsername().length();
//        if(parameterLen < 5 || parameterLen > 20) {
//            messages.add("用户名长度不合适");
//        } else {
//            //TODO: 用户名重复检测
//        }

        parameterLen = user.getPassword().length();
        if(parameterLen < 6 || parameterLen > 20) {
            messages.add("密码长度不合适");
        }

        parameterLen = user.getRealname().length();
        if(parameterLen < 1 || parameterLen > 20) {
            messages.add("姓名长度不合适");
        }

        if(messages.size() > 0) {
            request.setAttribute("email", user.getEmail());
            request.setAttribute("username", user.getUsername());
            request.setAttribute("realname", user.getRealname());
            request.setAttribute("messages", messages);

            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else {

            new UserDao().addObject(user);
            HttpSession session = request.getSession();
            session.setAttribute("user", session);

            response.sendRedirect("/user");
        }

    }

    private static class RegisterException extends Exception {
        public RegisterException(String message) {
            super(message);
        }

        @Override
        public String getMessage() {
            return super.getMessage();
        }
    }

}


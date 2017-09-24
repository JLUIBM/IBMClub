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
import java.util.*;

/**
 * Created by hyec on 2017/5/28.
 */
public class UserListServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final int pageSize = 10;

    private static final String[] allowedCondition = {
            "degree", "grade", "sex"
    };
    private static final String[] shownColumns = {
            "user_id"
    };

    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = new UserDao();
    }

    private List<User> getList(Map<String, String[]> parameters) {

        StringBuilder sqlBuilder = new StringBuilder();
        List<Object> args = new LinkedList<Object>();

        boolean firstCond = true;
        for (String key : parameters.keySet()) {
            if (Arrays.binarySearch(allowedCondition, key) > 0) {

                if (firstCond) {
                    sqlBuilder.append(" WHERE ");
                    firstCond = false;
                } else {
                    sqlBuilder.append(" AND ");
                }

                sqlBuilder.append(key).append(" = ?");
                args.add(parameters.get(key)[0]);
            }
        }

        int page = Integer.parseInt(parameters.getOrDefault("page", new String[]{"0"})[0]);

        sqlBuilder.insert(0, SQLTools.QUERY_USER);
        sqlBuilder.append(" LIMIT ?, ?;");
        args.add(page);
        args.add(pageSize);

        return userDao.getForList(sqlBuilder.toString(), args.toArray());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String[]> parameters = request.getParameterMap();

        List<User> userList = getList(parameters);

        if (parameters.containsKey("type")) {
            response.sendError(404, "TODO function.");
        } else {
            request.setAttribute("users", userList);
            request.getRequestDispatcher("/WEB-INF/admin/userlist.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");

        if ("DELETE".equals(method)) {
            String[] strIds = request.getParameterMap().getOrDefault("id", new String[]{});
            try {
                delUsers(strIds);
            } catch (NumberFormatException nfe) {
                response.sendError(400, "Unrecognized userId");
                return;
            }
        } else {
            response.sendError(400, "Only support delete method");
        }

        response.sendRedirect(request.getHeader("Referer"));
    }

//    TODO: RESTful requests.
//    @Override
//    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String[] strIds = request.getParameterMap().getOrDefault("id", new String[]{});
//
//        try {
//            delUsers(strIds);
//        } catch (NumberFormatException nfe) {
//            response.sendError(400, "Unrecognized userId");
//            return;
//        }
//
//        request.getRequestDispatcher("/WEB-INF/info.jsp").forward(request, response);
//    }

    private void delUsers(String[] strIds) throws NumberFormatException {
        List<Integer> intIds = new LinkedList<>();
        for (String strId : strIds) {
            int intId = Integer.parseInt(strId);
            intIds.add(intId);
        }

        for (int userId : intIds) {
            userDao.deleteObjectByKey(userId);
        }
    }
}

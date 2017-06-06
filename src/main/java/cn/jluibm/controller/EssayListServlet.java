package cn.jluibm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jluibm.model.dao.IDao;
import cn.jluibm.model.dao.impl.EssayDao;
import cn.jluibm.model.entity.Essay;
import cn.jluibm.utils.SQLTools;


public class EssayListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		//取作者信息 找essay
		String essayAuthor = (String) session.getAttribute("essayAuthor");
		int essayType = (int) session.getAttribute("essayType");
		//读取essay信息
		IDao<Essay> essayDao = new EssayDao();
		String queryAllEssaySql = SQLTools.QUERY_ESSAY + "where author = ? and type = ?";
		//存入List
		List<Essay> essayList = essayDao.getForList(queryAllEssaySql, 
				essayAuthor, essayType);
		//存入session
		session.setAttribute("essayList", essayList);
		//跳转
		request.getRequestDispatcher("/WEB-INF/essayjsp/essayList.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}

package com.semi.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.dao.QnaDao;
import com.semi.domain.QnaVo;

@WebServlet("/qna/list")
public class QnaListController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String spageNum = req.getParameter("pageNum");
		String field = req.getParameter("field");
		String keyword = req.getParameter("keyword");
		int pageNum = 1;
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		int startRow =(pageNum-1)*10+1;
		int endRow= startRow+9;
		
		QnaDao dao = QnaDao.getDao();
		
		int startPageNum = (pageNum-1)/10*10+1;
		int endPageNum= startPageNum+9;
		int pageCount = (int)Math.ceil(dao.getCount(field,keyword)/10.0); 
		if(endPageNum>pageCount) {
			endPageNum=pageCount;
		}
		ArrayList<QnaVo> list = dao.list(field, keyword, startRow, endRow);
		
		req.setAttribute("list", list);
		req.setAttribute("field", field);
		req.setAttribute("keyword", keyword);
		req.setAttribute("pageNum",pageNum);
		req.setAttribute("startPageNum",startPageNum);
		req.setAttribute("endPageNum",endPageNum);
		req.setAttribute("pageCount",pageCount);
		
		req.getRequestDispatcher("/qna/list.jsp").forward(req, resp);
		
		
	}
	
}

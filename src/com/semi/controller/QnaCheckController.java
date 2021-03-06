package com.semi.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.dao.QnaDao;
import com.semi.domain.QnaVo;

@WebServlet("/qna/check")
public class QnaCheckController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			int status= (int)session.getAttribute("status");
			boolean isAdmin = false;
			if(status==4) {
				isAdmin=true;
			}
			if(isAdmin) {
				int num = Integer.parseInt(req.getParameter("num"));
				QnaVo vo = QnaDao.getDao().load(num);
				req.setAttribute("vo", vo);
				req.getRequestDispatcher("/qna/load.jsp").forward(req, resp);
			}else {
				int num = Integer.parseInt(req.getParameter("num"));
				req.setAttribute("num", num);
				req.getRequestDispatcher("/qna/check.jsp").forward(req, resp);
			}
		}catch(NullPointerException ne) {
			int num = Integer.parseInt(req.getParameter("num"));
			req.setAttribute("num", num);
			req.getRequestDispatcher("/qna/check.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int num = Integer.parseInt(req.getParameter("num"));
		String writer = req.getParameter("writer");	
		String pwd = req.getParameter("pwd");
		QnaDao dao = QnaDao.getDao();
		int n =dao.check(num, writer, pwd);
		if(n>0) {
			req.setAttribute("vo", dao.load(num));
			req.getRequestDispatcher("/qna/load.jsp").forward(req, resp);
		}else {
			req.setAttribute("num", num);
			req.setAttribute("writer", writer);
			req.setAttribute("code","정보가 일치하지 않습니다");
			req.getRequestDispatcher("/qna/check.jsp").forward(req, resp);
		}
	}
	
}

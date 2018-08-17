package controllers;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Message;
import utils.DBUtil;

/**
 * Servlet implementation class Update
 */
@WebServlet("/update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Update() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String _token = (String)request.getParameter("_token");
	if(_token != null && _token.equals(request.getSession().getId())){
		EntityManager em = DBUtil.createEntityManager();

		Message m =em.find(Message.class,(Integer)(request.getSession().getAttribute("message_id")));

		String status = request.getParameter("status");
		m.setStatus(status);

	String content = request.getParameter("content");
	m.setContent(content);;

	Timestamp currentTime = new Timestamp(System.currentTimeMillis());
	m.setUpdated_at(currentTime);


	em.getTransaction().begin();
	em.getTransaction().commit();
    request.getSession().setAttribute("flush", "タスク更新が完了しました。");
	em.close();

	request.getSession().removeAttribute("message_id");

	response.sendRedirect(request.getContextPath()+"/index");
	}
	}

}

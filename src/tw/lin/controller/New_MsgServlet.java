package tw.lin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import tw.lin.bean.Msg;
import tw.lin.dao.MsgDao;
import tw.lin.factory.Factory;

@WebServlet("/new_Msg")
public class New_MsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String message = request.getParameter("msg");
		MsgDao msgdao = Factory.getMsgFactory();
		Msg fuckingMsg = new Msg();
		fuckingMsg.setMessage(message);
		msgdao.addMsg(fuckingMsg);
		
		//傳來JSON------------------------------------
	
		
		//JSON轉 ------------------------------------
		
		
		
		// 重整有值
		// request.getRequestDispatcher("index.jsp").forward(request, response);
		response.sendRedirect("index.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

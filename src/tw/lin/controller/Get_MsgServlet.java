package tw.lin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import net.sf.json.JSONArray;
import tw.lin.bean.Msg;
import tw.lin.dao.MsgDao;
import tw.lin.factory.Factory;

@WebServlet("/get_Msg")
public class Get_MsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		

		MsgDao msgdao = Factory.getMsgFactory();
		List<Msg> mlist = msgdao.getAllMsg();

		JSONArray json = JSONArray.fromObject(mlist);

		PrintWriter out = response.getWriter();
		out.print(json);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

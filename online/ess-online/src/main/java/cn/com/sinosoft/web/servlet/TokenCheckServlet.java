package cn.com.sinosoft.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenCheckServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		try {
			String echostr = (String) req.getParameter("echostr");
			String signature = (String) req.getParameter("signature");
			String timestamp = (String) req.getParameter("timestamp");
			String nonce = (String) req.getParameter("nonce");
			String token ="";
			String[] list = {token,timestamp,nonce}; 
			Arrays.sort(list);
			String result = list[0]+list[1]+list[2];
			if(result.equals(signature)){
				//正常流程，成功
				PrintWriter writer = resp.getWriter();
				writer.write(echostr);
			}
			//测试流程
			PrintWriter writer = resp.getWriter();
			writer.write(echostr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}

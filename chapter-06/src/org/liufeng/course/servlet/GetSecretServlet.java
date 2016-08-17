package org.liufeng.course.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 授权后的回调请求处理
 * @author liufeng
 * @date 2013-11-12
 */
public class GetSecretServlet extends HttpServlet {
	
	private static final long serialVersionUID = -1847238807216447030L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		InputStream in = request.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in, "utf-8"));
		
		String content = null;
		content = br.readLine();
		
		while(content != null) {
			System.out.println(content);
			content = br.readLine();
		}
		br.close();
		
		Enumeration<String> paraNames = request.getParameterNames();
		while(paraNames.hasMoreElements()){
			String param = paraNames.nextElement(); 
			String value = request.getParameter(param);
			System.out.println(param+":"  + value);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}

package main.webapp.java;

/**
 * 这个类主要的功能是获取前端页面用户输入的用户名和密码 然后调用LoginSuccess方法进行用户名和密码与数据库中数据进行匹配
 * 并进行跳转，用户名和密码正确跳转login_success.jsp，错误跳转login_failed.jsp
 */

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//  登录方法
public class loginServlet implements javax.servlet.Servlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws Exception  {
		String username = request.getParameter("username");// 取得用户名
		String password = request.getParameter("password");// 取得密码
		System.out.println("取得用户名和密码");
		 
		LoginSuccess db = new LoginSuccess(); // 构建登陆对象
		boolean canLogin = db.LoginSuccess(username, password);// 取得用户名和密码
		if (canLogin) {// 根据登陆情况，跳转页面
			System.out.println("用户名和密码正确");
			response.sendRedirect("login_success.jsp");
		} else {
			response.sendRedirect("login_failed.jsp");
			System.out.println("用户名和密码错误");
		}
	}

	public void destroy() {
	}

	public ServletConfig getServletConfig() {
		return null;
	}

	public String getServletInfo() {
		return null;
	}

	public void init(ServletConfig arg0) throws ServletException {
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		HttpServletRequest rq = (HttpServletRequest) request;
		HttpServletResponse rs = (HttpServletResponse) response;
		try {
			doPost(rq, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

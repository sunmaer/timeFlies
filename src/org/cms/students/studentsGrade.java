/**
 * 
 */
package org.cms.students;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cms.javaBean.PageUtil;
import org.cms.javaBean.StudentBean;

/**
 *类描述：
 *@author: 赵晨宇
 *@date： 日期：2016年12月2日 时间：上午11:47:35
 *@version 1.0
 */
public class studentsGrade extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public studentsGrade() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String str = request.getParameter("pageNo");
		if (str == null){
			str = "0";
		}
		int pageNo = Integer.parseInt(str);
		if(pageNo<1) {pageNo=1;}
		StudentBean student = new StudentBean();
		//设置每页显示十条数据
        PageUtil page = student.getPage(pageNo, 10);
        page.setPageNo(pageNo);
        request.setAttribute("page", page);
        request.getRequestDispatcher("/Admin/studentsGrade.jsp").forward(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

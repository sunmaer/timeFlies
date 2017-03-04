/**
 * 
 */
package org.cms.students;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cms.dbo.DBConnection;

/**
 *类描述：
 *@author: 赵晨宇
 *@date： 日期：2016年12月4日 时间：下午5:17:08
 *@version 1.0
 */
public class deleteStudents extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public deleteStudents() {
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

		doPost(request,response);
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

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8"); 
		PrintWriter out = response.getWriter();
		
		String studentId=request.getParameter("studentId");	
		
		DBConnection db_connection = DBConnection.getInstance();	//实例化连接数据库类
		
		//<--==========================================-->
		//学生基本信息表--basicinformation--删除sql语句
		String sql1 = "delete from basicinformation where studentId='"+studentId+"'";
		//学生成绩信息表--grade--删除sql语句
		String sql2 = "delete from grade where studentId='"+studentId+"'";

		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		
		try {
			ps1 = db_connection.getPreparedStatement(sql1);
			ps2 = db_connection.getPreparedStatement(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(sql1);
		try {
			ps1.executeUpdate();
			ps2.executeUpdate();
			
			out.print("success");
			System.out.println("--学生信息删除成功--");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("--学生信息删除错误--");
			
			out.print("error");
			
		}finally{
			try {
				//关闭PreparedStatement，释放资源
				db_connection.close(ps1);
				db_connection.close(ps2);
				
				out.flush();
				out.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("--学生信息删除操作关闭失败--");
				e.printStackTrace();
			}
		}//<--==========================================-->
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

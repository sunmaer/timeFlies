/**
 * 增加学生
 */
package org.cms.students;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import org.cms.dbo.DBConnection;

/**
 *类描述：
 *@author: 赵晨宇
 *@date： 日期：2016年11月16日 时间：下午7:09:48
 *@version 1.0
 */
public class addStudents extends HttpServlet {

	DBConnection db_connection;

	/**
	 * Constructor of the object.
	 */
	public addStudents() {
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
		//获取提交表单值
		String name=request.getParameter("name");
		String studentId=request.getParameter("studentId");
		String sex=request.getParameter("sex");
		String idCard=request.getParameter("idCard");
		String age=request.getParameter("age");
		String birthDay=request.getParameter("birthDay");
		
		String dorm=request.getParameter("dorm");
		String homeland=request.getParameter("homeland");
		
		String qq=request.getParameter("qq");
		String phoneNumber=request.getParameter("phoneNumber");
		
		//社会经历
		String self=request.getParameter("self");
		String firstTheme=request.getParameter("firstTheme");	
		String firstContent=request.getParameter("firstContent");
		String secondTheme=request.getParameter("secondTheme");	
		String secondContent=request.getParameter("secondContent");
		String thirdTheme=request.getParameter("thirdTheme");
		String thirdContent=request.getParameter("thirdContent");	
		String fourthTheme=request.getParameter("fourthTheme");
		String fourthContent=request.getParameter("fourthContent");
		
		String c=request.getParameter("c");
		String cplus=request.getParameter("cplus");	
		String java=request.getParameter("java");
		String dataBase=request.getParameter("dataBase");	
		String dataStructures=request.getParameter("dataStructures");
		String algorithm=request.getParameter("algorithm");
		String operateSystem=request.getParameter("operateSystem");	
		String composition=request.getParameter("composition");
		String network=request.getParameter("network");	
		
		db_connection = DBConnection.getInstance();	//实例化连接数据库类
		
		//<--==========================================-->
		//学生基本信息表--basicinformation--增加sql语句
		String sql1 = "insert into basicinformation values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		//学生成绩信息表--grade--增加sql语句
		String sql2 = "insert into grade values(?,?,?,?,?,?,?,?,?,?)";

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
			ps1.setString(1, studentId);
			ps1.setString(2, name);
			ps1.setString(3, sex);
			ps1.setString(4, age);
			ps1.setString(5, birthDay);
			ps1.setString(6, idCard);
			ps1.setString(7, dorm);
			ps1.setString(8, homeland);
			ps1.setString(9, phoneNumber);
			ps1.setString(10, qq);
			ps1.setString(11, self);
			ps1.setString(12, firstTheme);
			ps1.setString(13, firstContent);
			ps1.setString(14, secondTheme);
			ps1.setString(15, secondContent);
			ps1.setString(16, thirdTheme);
			ps1.setString(17, thirdContent);
			ps1.setString(18, fourthTheme);
			ps1.setString(19, fourthContent);
			
			ps2.setString(1, studentId);
			ps2.setString(2, c);
			ps2.setString(3, java);
			ps2.setString(4, dataBase);
			ps2.setString(5, cplus);
			ps2.setString(6, dataStructures);
			ps2.setString(7, algorithm);
			ps2.setString(8, operateSystem);
			ps2.setString(9, composition);
			ps2.setString(10, network);
			
			ps1.executeUpdate();
			ps2.executeUpdate();
			
			out.print("success");
			System.out.println("--学生信息插入成功--");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("--学生信息插入错误--");
			
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
				System.out.println("--学生信息插入操作关闭失败--");
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

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
public class updateInfo extends HttpServlet {

	private DBConnection db_connection;

	/**
	 * Constructor of the object.
	 */
	public updateInfo() {
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
		
		db_connection = DBConnection.getInstance();	//实例化连接数据库类
		
		//<--==========================================-->
		//学生基本信息表--basicinformation--修改sql语句
		String sql1 = "update basicinformation set name='"+name+"',sex='"+sex+"',idCard='"+idCard+"',age='"+age+"',birthDay='"+birthDay;
		String sql2 = "',dorm='"+dorm+"',homeland='"+homeland+"',qq='"+qq+"',phoneNumber='"+phoneNumber+"',self='"+self+"',firstTheme='"+firstTheme+"',firstContent='"+firstContent+"',secondTheme='"+secondTheme+"',secondContent='"+secondContent+"',thirdTheme='"+thirdTheme+"',thirdContent='"+thirdContent+"',fourthTheme='"+fourthTheme+"',fourthContent='"+fourthContent+"' where studentId='"+studentId+"';";
		String sql = sql1+sql2;
		System.out.println(sql);
		PreparedStatement ps = null;
		
		try {
			ps = db_connection.getPreparedStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(sql1);
		try {
			ps.executeUpdate();
			
			out.print("success");
			System.out.println("--学生信息修改成功--");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("--学生信息修改错误--");
			
			out.print("error");
			
		}finally{
			try {
				//关闭PreparedStatement，释放资源
				db_connection.close(ps);
				
				out.flush();
				out.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("--学生信息修改操作关闭失败--");
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

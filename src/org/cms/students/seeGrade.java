/**
 * 
 */
package org.cms.students;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cms.dbo.DBConnection;
import org.cms.javaBean.PageUtil;
import org.cms.javaBean.StudentBean;

import com.mysql.jdbc.PreparedStatement;

/**
 *类描述：
 *@author: 赵晨宇
 *@date： 日期：2016年12月2日 时间：下午4:13:08
 *@version 1.0
 */
public class seeGrade extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public seeGrade() {
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
		//从页面获得学号参数
		String studentId = request.getParameter("studentId");

		DBConnection db_connection = DBConnection.getInstance();	//实例化连接数据库类
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    PreparedStatement ps1 = null;
	    ResultSet rs1 = null;
	    String sql="select * from basicinformation where studentId ="+studentId;
	    ArrayList<StudentBean> studentsList = new ArrayList<StudentBean>();
        try {
           ps = (PreparedStatement) db_connection.getPreparedStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
                StudentBean student = new StudentBean();
       			
       			//根据学号查询该学生的成绩
       			ps1 = (PreparedStatement) db_connection.getPreparedStatement("select * from grade where studentId="+studentId);
                rs1 = ps1.executeQuery();
                while(rs1.next()) {
                	//基本信息
           			student.setStudentId(rs.getString(1));
           			student.setName(rs.getString(2));
           			student.setSex(rs.getString(3));
           			student.setAge(rs.getString(4));
           			student.setBirthDay(rs.getString(5));
           			student.setIdCard(rs.getString(6));
           			student.setDorm(rs.getString(7));
           			student.setHomeland(rs.getString(8));
           			student.setPhoneNumber(rs.getString(9));
           			student.setQq(rs.getString(10));
           		    //社会经历
           			student.setSelf(rs.getString(11));
           			student.setFirstTheme(rs.getString(12));
           			student.setFirstContent(rs.getString(13));
           			student.setSecondTheme(rs.getString(14));
           			student.setSecondContent(rs.getString(15));
           			student.setThirdTheme(rs.getString(16));
           			student.setThirdContent(rs.getString(17));
           			student.setFourthTheme(rs.getString(18));
           			student.setFourthContent(rs.getString(19));
           			//学生成绩
           			student.setC(rs1.getString(2));
           			student.setJava(rs1.getString(3));
           			student.setDataBase(rs1.getString(4));
           			student.setCplus(rs1.getString(5));
           			student.setDataStructures(rs1.getString(6));
           			student.setAlgorithm(rs1.getString(7));
           			student.setOperateSystem(rs1.getString(8));
           			student.setComposition(rs1.getString(9));
           			student.setNetwork(rs1.getString(10));
                }
                db_connection.close(ps1);
       			studentsList.add(student);
           }
           
           request.setAttribute("studentsList", studentsList);
           request.getRequestDispatcher("/Admin/seeGrade.jsp").forward(request, response);
	       } catch (SQLException e) {
	           e.printStackTrace();
	       }finally{
	    	   try {
				db_connection.close(ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       }
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

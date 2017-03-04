/**
 * 
 */
package org.cms.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cms.dbo.DBConnection;

import com.mysql.jdbc.PreparedStatement;

/**
 *类描述：
 *@author: 赵晨宇
 *@date： 日期：2016年12月11日 时间：下午7:33:34
 *@version 1.0
 */
public class index extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public index() {
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
		
		DBConnection db_connection = DBConnection.getInstance();	//实例化连接数据库类
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    ArrayList info=new ArrayList();
	    
	    //统计学生总数
	    int totalCount = 0; 
	    //统计男生人数
	    int maleCount = 0;
	    //统计女生人数
	    int femaleCount = 0;
	    //统计课程总数 
	    int courseCount = 0;
	    //统计班级总数
	    int classCount = 4;
	    
        try {
        	//统计学生总数
			ps = (PreparedStatement) db_connection.getPreparedStatement("select count(studentId) from basicinformation");
			rs = ps.executeQuery();
	        while(rs.next()){
	            totalCount = rs.getInt(1);
	        }
	        System.out.println("学生总数为："+totalCount);
	        
	        //统计男生人数
			ps = (PreparedStatement) db_connection.getPreparedStatement("select count(studentId) from basicinformation where sex = 'M'");
			rs = ps.executeQuery();
	        while(rs.next()){
	            maleCount = rs.getInt(1);
	        }
	        System.out.println("男生人数为："+maleCount);
	        
	        //统计女生人数
			ps = (PreparedStatement) db_connection.getPreparedStatement("select count(studentId) from basicinformation where sex = 'F'");
			rs = ps.executeQuery();
	        while(rs.next()){
	            femaleCount = rs.getInt(1);
	        }
	        System.out.println("女生人数为："+femaleCount);
	        
	        //统计课程总数
			ps = (PreparedStatement) db_connection.getPreparedStatement("select count(*) from information_schema.columns where table_schema='coi' and table_name='grade' ");
			rs = ps.executeQuery();
	        while(rs.next()){
	            courseCount = rs.getInt(1)-1;
	        }
	        System.out.println("课程总数为："+courseCount);
	        
	        info.add(totalCount);
	        info.add(maleCount);
	        info.add(femaleCount);
	        info.add(courseCount);
	        info.add(classCount);
	        
	        request.setAttribute( "info",info); 
            request.getRequestDispatcher("/Admin/index.jsp").forward(request,response);
	        
        } catch (SQLException e) {
			// TODO Auto-generated catch block
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

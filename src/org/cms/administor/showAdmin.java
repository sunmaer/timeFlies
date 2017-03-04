/**
 * 
 */
package org.cms.administor;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.cms.dbo.DBConnection;
import org.cms.javaBean.StudentBean;
import org.cms.javaBean.adminBean;

import com.mysql.jdbc.PreparedStatement;

/**
 *类描述：
 *@author: 赵晨宇
 *@date： 日期：2016年12月5日 时间：下午6:10:55
 *@version 1.0
 */
public class showAdmin extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public showAdmin() {
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
		
		HttpServletRequest req = (HttpServletRequest) request; 
		HttpSession session = req.getSession();     
        // 获取Session中存储的对象     
        Object userName = session.getAttribute("userName");
        System.out.println(userName);
//		System.out.println("-------------11111"+userName);
		DBConnection db_connection = DBConnection.getInstance();	//实例化连接数据库类
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    String sql="select * from admin where userName='"+userName+"'";
	    ArrayList<adminBean> adminList = new ArrayList<adminBean>();
        try {
           ps = (PreparedStatement) db_connection.getPreparedStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
                adminBean admin = new adminBean();
       			
       			admin.setUserName(rs.getString(2));
       			admin.setPassWord(rs.getString(3));
       			
       			adminList.add(admin);
           }
           request.setAttribute("adminList", adminList);
           request.getRequestDispatcher("/Admin/admin.jsp").forward(request, response);
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

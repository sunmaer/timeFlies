/*
* @Author: 赵晨宇
* @Date:   2016-10-19 20:26:15
* @Last Modified by:   SMH
* @Last Modified time: 2016-10-27 17:05:22
*/
package org.cms.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.cms.dbo.DBConnection;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		DBConnection db_connection = DBConnection.getInstance();	//实例化连接数据库类
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    HttpServletRequest req = (HttpServletRequest) request; 
		HttpSession session = req.getSession();
		System.out.println(userName);
		PrintWriter out = response.getWriter();
		
		if(userName!=null && !userName.equals("")){
	        String sql="select * from admin where userName='"+userName+"'";
	        sql +="and passWord='"+passWord+"'";
	        try {
				ps = (PreparedStatement) db_connection.getPreparedStatement(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
				rs=ps.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	           
            try {
				if(rs.next())
				   {
					session.setAttribute("userName",userName);
				    out.print("success");      
				   }else {
				      out.print("wrong");
				   }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            try {
				db_connection.close(ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}else{
             out.print("null"); 
        }       
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}

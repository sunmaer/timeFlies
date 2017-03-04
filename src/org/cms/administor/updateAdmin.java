/**
 * 
 */
package org.cms.administor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.cms.dbo.DBConnection;

/**
 *��������
 *@author: �Գ���
 *@date�� ���ڣ�2016��12��5�� ʱ�䣺����7:23:29
 *@version 1.0
 */
public class updateAdmin extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public updateAdmin() {
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
		
		HttpServletRequest req = (HttpServletRequest) request; 
		HttpSession session = req.getSession();     
        // ��ȡSession�д洢�Ķ���     
        Object userName = session.getAttribute("userName");
		//��ȡ�ύ��ֵ
		String passWord=request.getParameter("passWord");
		String confirmPassWord=request.getParameter("confirmPassWord");		
//		System.out.println("passWord = "+passWord);
//		System.out.println("confirmPassWord = "+confirmPassWord);
		DBConnection db_connection = DBConnection.getInstance();	//ʵ�����������ݿ���
		
		//<--==========================================-->
		String sql = "update admin set passWord='"+passWord+"' where userName='"+userName+"';";

		System.out.println(sql);
		PreparedStatement ps = null;
		
		try {
			ps = db_connection.getPreparedStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(sql1);
		if(passWord.equals(confirmPassWord)) {
			try {
				ps.executeUpdate();
				
				out.print("success");
				System.out.println("--����Ա��Ϣ�޸ĳɹ�--");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("--����Ա��Ϣ�޸Ĵ���--");
				
				out.print("error");
				
			}finally{
				try {
					//�ر�PreparedStatement���ͷ���Դ
					db_connection.close(ps);
					
					out.flush();
					out.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("--����Ա��Ϣ�޸Ĳ����ر�ʧ��--");
					e.printStackTrace();
				}
			}
		
		}
		else {
			out.print("passwordError");
			//�ر�PreparedStatement���ͷ���Դ
			try {
				db_connection.close(ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			out.flush();
			out.close();
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

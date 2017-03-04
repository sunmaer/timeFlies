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
 *��������
 *@author: �Գ���
 *@date�� ���ڣ�2016��12��12�� ʱ�䣺����8:54:17
 *@version 1.0
 */
public class deleteAll extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public deleteAll() {
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
		
		DBConnection db_connection = DBConnection.getInstance();	//ʵ�����������ݿ���
		
		//<--==========================================-->
		//��ҳ���ȡѡ��ѧ����ѧ��
		String[]  studentsId = request.getParameterValues("studentsId[]"); 
		String  studentsAll  =  "";
		if  (studentsId!=null) 
		{ 
		     for(int  i=0;i<studentsId.length;i++) 
		    { 
		    	 studentsAll = studentsAll + studentsId[i] + ","  ; 
		     } 
		     System.out.println(studentsAll);
		     studentsAll = studentsAll.substring(0, studentsAll.length()-1);      
		}  
	    String  sql1 = "delete from basicinformation where studentId in("+studentsAll+")"; 
	    String  sql2 = "delete from grade where studentId in("+studentsAll+")";

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
			System.out.println("--ѧ����Ϣ����ɾ���ɹ�--");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("--ѧ����Ϣ����ɾ������--");
			
			out.print("error");
			
		}finally{
			try {
				//�ر�PreparedStatement���ͷ���Դ
				db_connection.close(ps1);
				db_connection.close(ps2);
				
				out.flush();
				out.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("--ѧ����Ϣ����ɾ�������ر�ʧ��--");
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

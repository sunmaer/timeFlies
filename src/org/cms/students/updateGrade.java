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
 *@date�� ���ڣ�2016��12��4�� ʱ�䣺����7:05:47
 *@version 1.0
 */
public class updateGrade extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public updateGrade() {
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
		//��ȡ�ύ��ֵ
		String studentId=request.getParameter("studentId");
		String c=request.getParameter("c");
		String cplus=request.getParameter("cplus");	
		String java=request.getParameter("java");
		String dataBase=request.getParameter("dataBase");	
		String dataStructures=request.getParameter("dataStructures");
		String algorithm=request.getParameter("algorithm");
		String operateSystem=request.getParameter("operateSystem");	
		String composition=request.getParameter("composition");
		String network=request.getParameter("network");	
		
		DBConnection db_connection = DBConnection.getInstance();	//ʵ�����������ݿ���
		
		//<--==========================================-->
		//ѧ���ɼ���Ϣ��--grade--�޸�sql���
		String sql1 = "update grade set c='"+c+"',java='"+java+"',`dataBase`='"+dataBase+"',cplus='"+cplus;
		String sql2 = "',dataStructures='"+dataStructures+"',algorithm='"+algorithm+"',operateSystem='"+operateSystem+"',composition='"+composition+"',network='"+network+"' where studentId='"+studentId+"';";
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
			System.out.println("--ѧ���ɼ���Ϣ�޸ĳɹ�--");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("--ѧ���ɼ���Ϣ�޸Ĵ���--");
			
			out.print("error");
			
		}finally{
			try {
				//�ر�PreparedStatement���ͷ���Դ
				db_connection.close(ps);
				
				out.flush();
				out.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("--ѧ���ɼ���Ϣ�޸Ĳ����ر�ʧ��--");
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

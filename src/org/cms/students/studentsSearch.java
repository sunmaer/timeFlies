/**
 * 
 */
package org.cms.students;

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
import org.cms.javaBean.PageUtil;
import org.cms.javaBean.StudentBean;

import com.mysql.jdbc.PreparedStatement;

/**
 *��������
 *@author: �Գ���
 *@date�� ���ڣ�2016��12��13�� ʱ�䣺����2:36:47
 *@version 1.0
 */
public class studentsSearch extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public studentsSearch() {
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
		//��ҳ����ɸѡ���;����ɸѡ��Ϣ
		String type = request.getParameter("type");
		String keyWords = request.getParameter("keyWords");
		System.out.println("ɸѡ���"+type);
		System.out.println("ɸѡ�ؼ��ʣ�"+keyWords);
		DBConnection db_connection = DBConnection.getInstance();	//ʵ�����������ݿ���

	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    PreparedStatement ps1 = null;
	    ResultSet rs1 = null;
	    String sql1,sql2;
	    if(type.equals("ѧ��")) {
	    	//��ѧ������
		    sql1="select count(studentId) from basicinformation where studentId = '"+ keyWords +"'";
		    sql2="select * from basicinformation where studentId = '"+ keyWords +"' limit ";
	    }else if(type.equals("����")) {
	    	//����������
	    	sql1="select count(studentId) from basicinformation where name like '%"+ keyWords +"%'";
		    sql2="select * from basicinformation where name like '%"+ keyWords +"%' limit ";
	    }else if(type.equals("����")) {
	    	//����������
	    	sql1="select count(studentId) from basicinformation where dorm like '%"+ keyWords +"%'";
		    sql2="select * from basicinformation where dorm like '%"+ keyWords +"%' limit ";
	    }else {
	    	//����������
	    	sql1="select count(studentId) from basicinformation where homeland like '%"+ keyWords +"%'";
		    sql2="select * from basicinformation where homeland like '%"+ keyWords +"%' limit ";
	    }
	    
	    
	   //��ҳ��ʾ
       String str = request.getParameter("pageNo");
   	   if (str == null){
   		   str = "0";
   	   }
   	   int pageNo = Integer.parseInt(str);
   	   if(pageNo<1) {pageNo=1;}
   	   //����ÿҳ��ʾʮ������
   	   int pageSize = 10;
   	   PageUtil page;
       ArrayList<StudentBean> studentsList = new ArrayList<StudentBean>();

       try {
           //��ȡ����������
           int totalCount = 0; 
           ps = (PreparedStatement) db_connection.getPreparedStatement(sql1);
           rs = ps.executeQuery();
           while(rs.next()){
               totalCount = rs.getInt(1);
           }
           if(totalCount == 0) {//����ʧ��
	           request.getRequestDispatcher("/Admin/studentSearchFail.jsp").forward(request, response);
           }
           else {
	           ps = (PreparedStatement) db_connection.getPreparedStatement(sql2 + (pageNo-1)*pageSize+","+pageSize);
	           rs = ps.executeQuery();
	           while(rs.next()){
	                StudentBean student = new StudentBean();
	       			
	       			//����ѧ�Ų�ѯ��ѧ���ĳɼ�
	       			ps1 = (PreparedStatement) db_connection.getPreparedStatement("select * from grade where studentId= '"+rs.getString(1)+"'");
	      
	                rs1 = ps1.executeQuery();
	                while(rs1.next()) {
	                	//������Ϣ
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
	           		    //��ᾭ��
	           			student.setSelf(rs.getString(11));
	           			student.setFirstTheme(rs.getString(12));
	           			student.setFirstContent(rs.getString(13));
	           			student.setSecondTheme(rs.getString(14));
	           			student.setSecondContent(rs.getString(15));
	           			student.setThirdTheme(rs.getString(16));
	           			student.setThirdContent(rs.getString(17));
	           			student.setFourthTheme(rs.getString(18));
	           			student.setFourthContent(rs.getString(19));
	           			//ѧ���ɼ�
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
	           page = new PageUtil(pageSize, totalCount);
	           page.setData(studentsList);
	           
	           ArrayList info=new ArrayList();
      		   //�����������͹ؼ��ʣ�Ϊ��ҳ������
	           info.add(type);
	           info.add(keyWords);
      			
	           page.setPageNo(pageNo);
	           request.setAttribute("page", page);
	           request.setAttribute("info", info);
	           request.getRequestDispatcher("/Admin/studentSearch.jsp").forward(request, response);
           }
           
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
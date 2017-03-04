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
 * 
 */

/**
 *类描述：
 *@author: 赵晨宇
 *@date： 日期：2016年12月14日 时间：下午7:51:05
 *@version 1.0
 */
public class gradeSearch extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public gradeSearch() {
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
		//从页面获得筛选类别和具体的筛选信息
		String type = request.getParameter("type");
		String keyWords = request.getParameter("keyWords");
		System.out.println("筛选类别："+type);
		System.out.println("筛选关键词："+keyWords);
		DBConnection db_connection = DBConnection.getInstance();	//实例化连接数据库类

	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    PreparedStatement ps1 = null;
	    ResultSet rs1 = null;
	    String sql1,sql2;
	    if(type.equals("学号")) {
	    	//按学号搜索
		    sql1="select count(studentId) from basicinformation where studentId = '"+ keyWords +"'";
		    sql2="select * from basicinformation where studentId = '"+ keyWords +"' limit ";
	    }else {
	    	//按姓名搜索
	    	sql1="select count(studentId) from basicinformation where name like '%"+ keyWords +"%'";
		    sql2="select * from basicinformation where name like '%"+ keyWords +"%' limit ";
	    }
	    
	    
	   //分页显示
       String str = request.getParameter("pageNo");
   	   if (str == null){
   		   str = "0";
   	   }
   	   int pageNo = Integer.parseInt(str);
   	   if(pageNo<1) {pageNo=1;}
   	   //设置每页显示十条数据
   	   int pageSize = 10;
   	   PageUtil page;
       ArrayList<StudentBean> studentsList = new ArrayList<StudentBean>();

       try {
           //获取总数据条数
           int totalCount = 0; 
           ps = (PreparedStatement) db_connection.getPreparedStatement(sql1);
           rs = ps.executeQuery();
           while(rs.next()){
               totalCount = rs.getInt(1);
           }
           if(totalCount == 0) {//搜索失败
	           request.getRequestDispatcher("/Admin/gradeSearchFail.jsp").forward(request, response);
           }
           else {
	           ps = (PreparedStatement) db_connection.getPreparedStatement(sql2 + (pageNo-1)*pageSize+","+pageSize);
	           rs = ps.executeQuery();
	           while(rs.next()){
	                StudentBean student = new StudentBean();
	       			
	       			//根据学号查询该学生的信息
	       			ps1 = (PreparedStatement) db_connection.getPreparedStatement("select * from basicinformation where studentId= '"+rs.getString(1)+"'");
	      
	                rs1 = ps1.executeQuery();
	                while(rs1.next()) {
	                	//基本信息
	           			student.setStudentId(rs.getString(1));
	           			student.setName(rs1.getString(2));
	           			student.setSex(rs1.getString(3));
	           			student.setAge(rs1.getString(4));
	           			student.setBirthDay(rs1.getString(5));
	           			student.setIdCard(rs1.getString(6));
	           			student.setDorm(rs1.getString(7));
	           			student.setHomeland(rs1.getString(8));
	           			student.setPhoneNumber(rs1.getString(9));
	           			student.setQq(rs1.getString(10));
	           		    //社会经历
	           			student.setSelf(rs1.getString(11));
	           			student.setFirstTheme(rs1.getString(12));
	           			student.setFirstContent(rs1.getString(13));
	           			student.setSecondTheme(rs1.getString(14));
	           			student.setSecondContent(rs1.getString(15));
	           			student.setThirdTheme(rs1.getString(16));
	           			student.setThirdContent(rs1.getString(17));
	           			student.setFourthTheme(rs1.getString(18));
	           			student.setFourthContent(rs1.getString(19));
	           			//学生成绩
	           			student.setC(rs.getString(2));
	           			student.setJava(rs.getString(3));
	           			student.setDataBase(rs.getString(4));
	           			student.setCplus(rs.getString(5));
	           			student.setDataStructures(rs.getString(6));
	           			student.setAlgorithm(rs.getString(7));
	           			student.setOperateSystem(rs.getString(8));
	           			student.setComposition(rs.getString(9));
	           			student.setNetwork(rs.getString(10));
	                }
	                db_connection.close(ps1);
	              
	       			studentsList.add(student);
	           }
	           page = new PageUtil(pageSize, totalCount);
	           page.setData(studentsList);
	           
	           ArrayList info=new ArrayList();
      		   //加入搜索类别和关键词，为分页传参数
	           info.add(type);
	           info.add(keyWords);
      			
	           page.setPageNo(pageNo);
	           request.setAttribute("page", page);
	           request.setAttribute("info", info);
	           request.getRequestDispatcher("/Admin/gradeSearch.jsp").forward(request, response);
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

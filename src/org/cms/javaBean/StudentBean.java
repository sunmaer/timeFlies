/**
 * 学生实体类
 */
package org.cms.javaBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.cms.dbo.DBConnection;

import com.mysql.jdbc.PreparedStatement;

/**
 *类描述：
 *@author: 赵晨宇
 *@date： 日期：2016年11月30日 时间：下午7:09:02
 *@version 1.0
 */
public class StudentBean {
	//学生基本信息
	private String name;
	private String studentId;
	private String sex;
	private String idCard;
	private String age;
	private String birthDay;
	
	private String dorm;
	private String homeland;
	
	private String qq;
	private String phoneNumber;
	
	//社会经历
	private String self;
	private String firstTheme;	
	private String firstContent;
	private String secondTheme;	
	private String secondContent;
	private String thirdTheme;
	private String thirdContent;	
	private String fourthTheme;
	private String fourthContent;
	
	//学生成绩
	private String c;
	private String cplus;	
	private String java;
	private String dataBase;	
	private String dataStructures;
	private String algorithm;
	private String operateSystem;	
	private String composition;
	private String network;

	//根据页码和每页的容量来得到数据
    public PageUtil getPage(int pageNo, int pageSize) {
       ArrayList<StudentBean> studentsList = new ArrayList<StudentBean>();

       DBConnection db_connection = DBConnection.getInstance();	//实例化连接数据库类
       PreparedStatement ps = null;
       ResultSet rs = null;
       PreparedStatement ps1 = null;
       ResultSet rs1 = null;
       PageUtil page = null;
       try {
           //获取总数据条数
           int totalCount = 0; 
           ps = (PreparedStatement) db_connection.getPreparedStatement("select count(studentId) from basicinformation");
           rs = ps.executeQuery();
           while(rs.next()){
               totalCount = rs.getInt(1);
           }
           ps = (PreparedStatement) db_connection.getPreparedStatement("select * from basicinformation limit " + (pageNo-1)*pageSize+","+pageSize);
           rs = ps.executeQuery();
           while(rs.next()){
                StudentBean student = new StudentBean();
       			
       			//根据学号查询该学生的成绩
       			ps1 = (PreparedStatement) db_connection.getPreparedStatement("select * from grade where studentId= '"+rs.getString(1)+"'");
      
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
           page = new PageUtil(pageSize, totalCount);
           page.setData(studentsList);
           
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

       return page;
   }
   
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getDorm() {
		return dorm;
	}
	public void setDorm(String dorm) {
		this.dorm = dorm;
	}
	public String getHomeland() {
		return homeland;
	}
	public void setHomeland(String homeland) {
		this.homeland = homeland;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		this.self = self;
	}

	public String getFirstTheme() {
		return firstTheme;
	}

	public void setFirstTheme(String firstTheme) {
		this.firstTheme = firstTheme;
	}

	public String getFirstContent() {
		return firstContent;
	}

	public void setFirstContent(String firstContent) {
		this.firstContent = firstContent;
	}

	public String getSecondTheme() {
		return secondTheme;
	}

	public void setSecondTheme(String secondTheme) {
		this.secondTheme = secondTheme;
	}

	public String getSecondContent() {
		return secondContent;
	}

	public void setSecondContent(String secondContent) {
		this.secondContent = secondContent;
	}

	public String getThirdTheme() {
		return thirdTheme;
	}

	public void setThirdTheme(String thirdTheme) {
		this.thirdTheme = thirdTheme;
	}

	public String getThirdContent() {
		return thirdContent;
	}

	public void setThirdContent(String thirdContent) {
		this.thirdContent = thirdContent;
	}

	public String getFourthTheme() {
		return fourthTheme;
	}

	public void setFourthTheme(String fourthTheme) {
		this.fourthTheme = fourthTheme;
	}

	public String getFourthContent() {
		return fourthContent;
	}

	public void setFourthContent(String fourthContent) {
		this.fourthContent = fourthContent;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public String getCplus() {
		return cplus;
	}

	public void setCplus(String cplus) {
		this.cplus = cplus;
	}

	public String getJava() {
		return java;
	}

	public void setJava(String java) {
		this.java = java;
	}
	public String getDataBase() {
		return dataBase;
	}
	public void setDataBase(String dataBase) {
		this.dataBase = dataBase;
	}
	public String getDataStructures() {
		return dataStructures;
	}
	public void setDataStructures(String dataStructures) {
		this.dataStructures = dataStructures;
	}
	public String getAlgorithm() {
		return algorithm;
	}
	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}
	public String getOperateSystem() {
		return operateSystem;
	}
	public void setOperateSystem(String operateSystem) {
		this.operateSystem = operateSystem;
	}
	public String getComposition() {
		return composition;
	}
	public void setComposition(String composition) {
		this.composition = composition;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	
	
}

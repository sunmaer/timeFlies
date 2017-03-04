/*
* @Author: 赵晨宇
* @Date:   2016-10-19 19:57:11
* @Last Modified by:   SMH
* @Last Modified time: 2016-10-27 17:05:32
*/

package org.cms.dbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库连接类
 * */
public class DBConnection {
	
	private static DBConnection DB = null;
	public static synchronized DBConnection  getInstance(){
		if(DB == null){
			DB = new DBConnection();
		}
		return DB;
	}
	
	//数据库: MYSQL
	//端口: 3306
	//数据库名: cst1404
	private final static String url = "jdbc:mysql://localhost:3306/coi?useUnicode=true&characterEncoding=UTF-8"; 
	private final static String user = "root"; 			//用户名
	private final static String password = ""; 		//密码
		
	private Connection connection = null;		
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	
	public  DBConnection(){
		//加载MYSQL的JDBC的驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库驱动加载失败！");
			e.printStackTrace();
		}
		
		//创建连接
		try {
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("数据库连接成功！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库连接失败！");
			e.printStackTrace();
		}
	}
	
	/**
	 * @return Statement
	 * */
	public Statement getStatement() throws SQLException{
		statement = connection.createStatement();
		return statement;
	}
	
	/**
	 * @param sql 要执行的SQL语句
	 * @return PreparedStatement
	 * */
	public PreparedStatement getPreparedStatement(String sql)
			throws SQLException{
		preparedStatement = connection.prepareStatement(sql);
		return preparedStatement;
	}
	
	/**
	 * 关闭Statement
	 * @param statement	自定义的Statement
	 * */
	public void close(Statement statement) throws SQLException{
		if(statement != null){
			statement.close();
		}
	}
	
	/**
	 * 关闭 PreparedStatement
	 * @param preparedStatement  自定义的PreparedStatement
	 * */
	public void close(PreparedStatement preparedStatement) throws SQLException{
		if(preparedStatement != null){
			preparedStatement.close();
		}
	}
	
	/**
	 * 关闭ResultSet、Statement
	 * @param resultSet 自定义的ResultSet
	 * @param statement 自定义的Statement
	 * */
	public void close(ResultSet resultSet,Statement statement) throws SQLException{
		if(resultSet != null){
			resultSet.close();
		}
		if(statement != null){
			statement.close();
		}
	}
	
	/**
	 * 关闭 PreparedStatement、ResultSet
	 * @param resultSet 自定义的ResultSet
	 * @param preparedStatement 自定义的PreparedStatement
	 * */
	public void close(ResultSet resultSet,PreparedStatement preparedStatement) throws SQLException{
		if(resultSet != null){
			resultSet.close();
		}
		if(preparedStatement != null){
			preparedStatement.close();
		}
	}
}

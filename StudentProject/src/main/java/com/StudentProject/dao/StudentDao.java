package com.StudentProject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.StudentProject.bean.StudentBean;
public class StudentDao {
	static Connection con;
	static PreparedStatement ps;
	
	public StudentDao() {
		con = MySqlConnection.getInstance();
	}

	public static int Insertdata(StudentBean ss) {
		int result = 0;
		
		String query = "insert into student values (?,?,?,?,?,?)";
		
		
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, ss.getName());
			ps.setString(2, ss.getMobileno());
			ps.setString(3, ss.getAddress());
			ps.setString(4, ss.getEmail());
			ps.setString(5, ss.getTech());
			ps.setString(6, ss.getCollege());
			
			result = ps.executeUpdate();	
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}	
		return result;
	}
	
	public static int DeleteData(StudentBean s) {
		int Result = 0;
		
		String query1 = "delete from student where Name = ?";
		
		try {
			ps = con.prepareStatement(query1);
			ps.setString(1, s.getName());
			Result = ps.executeUpdate();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return Result;
	}
	public static int UpdateData(StudentBean s) {
		int Result = 0;
		String query2= "update from student set Name = ? where Email =?";
		try {
			ps= con.prepareStatement (query2);
			ps.setString(1, s.getName());
			Result = ps.executeUpdate();
		} catch (SQLException e) {
					e.printStackTrace();
		}
	
		return Result;
		
	}
}

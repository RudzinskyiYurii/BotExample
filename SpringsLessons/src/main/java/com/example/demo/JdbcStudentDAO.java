package com.example.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.PreparedStatement;

public class JdbcStudentDAO implements StudentDAO {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void insert(Student student) {

		String query = "INSERT INTO Student " + "(id, first_name, last_name) VALUES (?, ?, ?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
			statement.setLong(1, student.getId());
			statement.setString(2, student.getFirstName());
			statement.setString(3, student.getLastName());
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public Student findByLastName(String lastName) {
		
		String querySelect = "SELECT * FROM Student WHERE last_name = ?";
		
		Connection conn = null;
		Student student = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(querySelect);
			ps.setString(1, lastName);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				student = new Student(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"));
				rs.close();
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
				
		}
		return student;
	}

}

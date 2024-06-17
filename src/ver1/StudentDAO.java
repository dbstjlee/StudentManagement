package ver1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentDAO implements StudentImpl {

	public static final String ADD_STUDENT = " insert into students( name, age, email) values( ?, ?, ?) ";
	public static final String VIEW_STUDENT = " select * from students ";
	public static final String UPDATE_STUDENT1 = " update students set email = ? where name = ? ";
	public static final String UPDATE_STUDENT2 = " update students set age = ? where name = ? ";
	public static final String DELETE_STUDENT1 = " delete from students where name = ? ";
	public static final String DELETE_STUDENT2 = " delete from students where email = ? ";

	@Override
	public int addStudent(String name, int age, String email) throws SQLException {
		int result = 0;

		try (Connection conn = DBConnetionManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(ADD_STUDENT)) {
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setString(3, email);
			result = pstmt.executeUpdate();
		}
		return result;
	}

	@Override
	public List<StudentDTO> viewStudent() throws SQLException {

		List<StudentDTO> list = new ArrayList<>();
		try (Connection conn = DBConnetionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(VIEW_STUDENT);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				list.add(new StudentDTO(id, name, age, email));
			}

//			while (rs.next()) {
//				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3)
//						+ "\t" + rs.getDouble(4) + "\t" + rs.getString(5));
//			}
		}
		return list;
	}

	@Override
	public StudentDTO updateStudent(int id, String name, int age, String email) throws SQLException {

		StudentDTO dto1 = null;

		try (Connection conn = DBConnetionManager.getConnection()) {
			PreparedStatement pstmt1 = conn.prepareStatement(UPDATE_STUDENT1);
			pstmt1.setInt(1, id);
			pstmt1.setString(2, name);
			pstmt1.setInt(3, age);
			pstmt1.setString(4, email);
			pstmt1.executeUpdate();
			
			PreparedStatement pstmt2 = conn.prepareStatement(UPDATE_STUDENT2);
			pstmt2.setInt(1, id);
			pstmt2.setString(2, name);
			pstmt2.setInt(3, age);
			pstmt2.setString(4, email);
			pstmt2.executeUpdate();
		}
		return dto1;
	}

	@Override
	public StudentDTO deleteStudent(int id, String name, int age, String email) throws SQLException {

		StudentDTO dto2 = null;

		try (Connection conn = DBConnetionManager.getConnection()) {
			PreparedStatement pstmt1 = conn.prepareStatement(DELETE_STUDENT1);
			pstmt1.setInt(1, id);
			pstmt1.setString(2, name);
			pstmt1.setInt(3, age);
			pstmt1.setString(4, email);
			pstmt1.executeUpdate();

			PreparedStatement pstmt2 = conn.prepareStatement(DELETE_STUDENT2);
			pstmt2.setInt(1, id);
			pstmt2.setString(2, name);
			pstmt2.setInt(3, age);
			pstmt2.setString(4, email);
			pstmt2.executeUpdate();
		}
		return dto2;
	}

}

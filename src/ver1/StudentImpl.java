package ver1;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public interface StudentImpl {

	int addStudent(String name, int age, String email) throws SQLException;
	
	List<StudentDTO> viewStudent() throws SQLException;
	
	StudentDTO updateStudent(int id, String name, int age, String email) throws SQLException;
	
	StudentDTO deleteStudent(int id, String name, int age, String email) throws SQLException;
	
}

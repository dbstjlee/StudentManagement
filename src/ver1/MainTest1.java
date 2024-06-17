package ver1;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MainTest1 {

	public static void main(String[] args) throws SQLException {

		try (Scanner scanner = new Scanner(System.in)) {
			StudentDAO student = new StudentDAO();
			while (true) {
				System.out.println("A. 학생 정보 추가");
				System.out.println("B. 학생 정보 조회");
				System.out.println("C. 학생 정보 수정");
				System.out.println("D. 학생 정보 삭제");
				System.out.println("E. 종료");
				System.out.println("---------------------------------");
				System.out.print("입력해주세요 : ");
				String choice = scanner.nextLine();

				if (choice.equals("A")) {
					System.out.println("추가할 학생 이름을 입력하세요.");
					scanner.nextLine();
					student.addStudent("이름2", 25, "b@naver.com");
					System.out.println("학생 추가 완료");
				} else if (choice.equals("B")) {
					List<StudentDTO> list = student.viewStudent();
					System.out.println(list.toString());
				} else if (choice.equals("C")) {
					student.updateStudent(1, "이름1", 20, "b@naver.com");
					System.out.println("학생 수정 완료");
				} else if (choice.equals("D")) {
					student.deleteStudent(1, "이름1", 20, "a@naver.com");
					System.out.println("학생 삭제 완료");
				} else if (choice.equals("E")) {
					scanner.close();
					System.out.println("프로그램 종료");
					break;
				} else {
					System.out.println("잘못된 선택입니다.");

				}

			} // end of while

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

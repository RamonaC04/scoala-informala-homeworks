import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		StudentRepository studentRepository = new StudentRepository();
		try {
			studentRepository.add(new Student("Popescu", "Ana", 'F', "2870604204482", new Date(87, 2, 5)));
		} catch (EmptyFieldException | BirthdayException | UpperLowerCaseException e1) {

			e1.printStackTrace();
		}
		try {
			studentRepository.delete("");
		} catch (EmptyFieldException e) {
			e.printStackTrace();
			System.out.println("CNP field is empty, student does not exist.");
		}
		System.out.println(studentRepository.getStudentsWithAGivenAge(29));
	}

}

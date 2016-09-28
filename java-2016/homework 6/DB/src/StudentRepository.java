import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class StudentRepository {

	private List<Student> lista;

	public StudentRepository() {
		lista = new ArrayList<Student>();

	}

	public void add(Student student) throws EmptyFieldException, BirthdayException, UpperLowerCaseException {
		Date data = new Date();
		if (student.getFirstName() == null && !student.getFirstName().equals("") && student.getLastName() == null
				&& !student.getLastName().equals("")) {
			throw new EmptyFieldException();
		} else if (student.getBirthday().getYear() < 1900 && student.getBirthday().getYear() > (data.getYear() - 18)) {
			throw new BirthdayException();
		} else if (student.getGender() != 'M' && student.getGender() != 'F' && student.getGender() != 'm'
				&& student.getGender() != 'f') {
			throw new UpperLowerCaseException();
		} else
			lista.add(student);
		System.out.println("You have successfully added  student  to the database!");

	}

	public void display() {
		if (lista.size() > 0) {
			System.out.println(lista);
		}
	}

	public void delete(String cnpPeCareVreauSaIlSterg) throws EmptyFieldException {
		if (cnpPeCareVreauSaIlSterg != null && !cnpPeCareVreauSaIlSterg.equals("")) {
			for (Student st : lista) {
				if (st.getCnp().equals(cnpPeCareVreauSaIlSterg))
					lista.remove(st);
			}
		} else {
			throw new EmptyFieldException();
		}

	}

	public List<Student> getStudentsWithAGivenAge(int ageInYears) {
		ArrayList<Student> result = new ArrayList<Student>();
		Date data = new Date();
		for (Student st : lista) {
			if (data.getYear() - st.getBirthday().getYear() == ageInYears) {
				result.add(st);
			}
		}
		return result;
	}

}

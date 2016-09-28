import java.util.Calendar;
import java.util.Date;

public class Student {

	public String firstName;
	public String lastName;
	public Character gender;
	public String cnp;
	public Date birthday;

	public Student(String firstName, String lastName, Character gender, String cnp, Date birthday) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.cnp = cnp;
		this.birthday = birthday;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public String toString() {
		return firstName + " " + lastName + " " + birthday + " " + gender + " " + cnp;
	}
}
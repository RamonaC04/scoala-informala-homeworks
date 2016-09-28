
public class BirthdayException extends Exception {

	@Override
	public String toString() {
		return this.getClass() + " date of birth  not between 1900 and current year";
	}

}

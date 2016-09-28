
public class UpperLowerCaseException extends Exception {

	@Override
	public String toString() {
		return this.getClass() + " gender should be M ,F,m,f";

	}
}

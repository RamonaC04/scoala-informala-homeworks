
 public class NrOfSalesManagersException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return this.getClass() + " There has to be only one sales manager per team";
	}

}

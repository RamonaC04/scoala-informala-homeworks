package ex;

public class WeekDay implements Comparable<WeekDay> {

	private String zi;

	public WeekDay(String day) {
		this.zi = day;
	}

	@Override
	public String toString() {
		return "WeekDay [zi=" + zi + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((zi == null) ? 0 : zi.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WeekDay other = (WeekDay) obj;
		if (zi == null) {
			if (other.zi != null)
				return false;
		} else if (!zi.equals(other.zi))
			return false;
		return true;
	}

	@Override
	public int compareTo(WeekDay o) {
		if (this.zi.equals(o.zi))
			return 0;
		else if (this.zi.equals("luni"))
			return -1;
		else if (this.zi.equals("marti") && !o.zi.equals("luni"))
			return -1;
		else if (this.zi.equals("miercuri") && !o.zi.equals("luni ") && !o.zi.equals("marti"))
			return -1;
		else if (this.zi.equals("joi") && !o.zi.equals("luni") && !o.zi.equals("marti ") && !o.zi.equals("miercuri"))
			return -1;

		return 1;
	}

}

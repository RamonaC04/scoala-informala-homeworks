package ex;

public class Iepure implements Comparable<Iepure> {

	private Integer greutate;

	public Iepure(Integer greutate) {
		super();
		this.greutate = greutate;
	}

	@Override
	public int compareTo(Iepure o) {
		return this.greutate.compareTo(o.greutate);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((greutate == null) ? 0 : greutate.hashCode());
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
		Iepure other = (Iepure) obj;
		if (greutate == null) {
			if (other.greutate != null)
				return false;
		} else if (!greutate.equals(other.greutate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Iepure [greutate=" + greutate + "]";
	}

}

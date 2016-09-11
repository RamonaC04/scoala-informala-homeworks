//mm, cm, dm, m, km, inch, foot, miles
public class ConvertireUnitMasura {
	
	public static final String KILO_METERS = "km";
	public static final String METERS = "m";
	public static final String MILES = "miles";
	public static final String CENTI_METERS = "cm";
	public static final String MILI_METERS = "mm";
	public static final String DECI_METERS = "dm";
	public static final String INCH = "in";
	public static final String FOOT = "ft";

	public double transformDistance(double distance, String umFrom, String umTo) {
		switch (umFrom) {
		case (KILO_METERS):
			if (umTo == KILO_METERS)
				return distance;
			if (umTo == METERS)
				return distance /1000;
			if (umTo == MILES)
				return distance *0.6214;
			if (umTo == CENTI_METERS)
				return distance /100000;
			if (umTo == MILI_METERS)
				return distance/1000000;
			if (umTo == DECI_METERS)
				return distance/10000;
			if (umTo == INCH)
				return distance/39370.0787;
			if (umTo == FOOT)
				return distance/3280.8399;
			break;
		case (METERS):
			if (umTo == KILO_METERS)
				return distance*1000;
			if (umTo == METERS)
				return distance ;
			if (umTo == MILES)
				return distance * 0.0006;
			if (umTo == CENTI_METERS)
				return distance * 10;
			if (umTo == MILI_METERS)
				return distance;
			if (umTo == DECI_METERS)
				return distance;
			if (umTo == INCH)
				return distance;
			if (umTo == FOOT)
				return distance;
			break;

		case (MILES):
			if (umTo == KILO_METERS)
				return distance;
			if (umTo == METERS)
				return distance * 1000;
			if (umTo == MILES)
				return distance * 10000;
			if (umTo == CENTI_METERS)
				return distance * 10;
			if (umTo == MILI_METERS)
				return distance;
			if (umTo == DECI_METERS)
				return distance;
			if (umTo == INCH)
				return distance;
			if (umTo == FOOT)
				return distance;
			break;
		case (CENTI_METERS):
			if (umTo == KILO_METERS)
				return distance;
			if (umTo == METERS)
				return distance * 1000;
			if (umTo == MILES)
				return distance * 10000;
			if (umTo == CENTI_METERS)
				return distance * 10;
			if (umTo == MILI_METERS)
				return distance;
			if (umTo == DECI_METERS)
				return distance;
			if (umTo == INCH)
				return distance;
			if (umTo == FOOT)
				return distance;
			break;

		case (MILI_METERS):
			if (umTo == KILO_METERS)
				return distance;
			if (umTo == METERS)
				return distance * 1000;
			if (umTo == MILES)
				return distance * 10000;
			if (umTo == CENTI_METERS)
				return distance * 10;
			if (umTo == MILI_METERS)
				return distance;
			if (umTo == DECI_METERS)
				return distance;
			if (umTo == INCH)
				return distance;
			if (umTo == FOOT)
				return distance;
			break;
		case (DECI_METERS):
			if (umTo == KILO_METERS)
				return distance;
			if (umTo == METERS)
				return distance * 1000;
			if (umTo == MILES)
				return distance * 10000;
			if (umTo == CENTI_METERS)
				return distance * 10;
			if (umTo == MILI_METERS)
				return distance;
			if (umTo == DECI_METERS)
				return distance;
			if (umTo == INCH)
				return distance;
			if (umTo == FOOT)
				return distance;
			break;
		case (INCH):
			if (umTo == KILO_METERS)
				return distance;
			if (umTo == METERS)
				return distance * 1000;
			if (umTo == MILES)
				return distance * 10000;
			if (umTo == CENTI_METERS)
				return distance * 10;
			if (umTo == MILI_METERS)
				return distance;
			if (umTo == DECI_METERS)
				return distance;
			if (umTo == INCH)
				return distance;
			if (umTo == FOOT)
				return distance;
			break;
		case (FOOT):
			if (umTo == KILO_METERS)
				return distance;
			if (umTo == METERS)
				return distance * 1000;
			if (umTo == MILES)
				return distance * 10000;
			if (umTo == CENTI_METERS)
				return distance * 10;
			if (umTo == MILI_METERS)
				return distance;
			if (umTo == DECI_METERS)
				return distance;
			if (umTo == INCH)
				return distance;
			if (umTo == FOOT)
				return distance;
		}
		return distance;

	}

}

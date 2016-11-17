package Main;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Package> list = new ArrayList<>();
		list.add(new Package("Cluj", 2, 5.0, new Date(2004)));
		list.add(new Package("Belarus", 140, 5.0, new Date(2003)));
		list.add(new Package("Apahida", 25, 5.0, new Date(2002)));
		list.add(new Package("Cluj", 2, 7.0, new Date(2003)));
		list.add(new Package("New York", 5000, 5.0, new Date(2004)));
		list.add(new Package("Rusia", 180, 5.0, new Date(2001)));
		list.add(new Package("Bulgaria", 250, 5.0, new Date(2004)));

		List<Package> orderedPackages = new PackageSorter().order(list);
		CourierThread courier = new CourierThread(orderedPackages);
		courier.start();
	}
}

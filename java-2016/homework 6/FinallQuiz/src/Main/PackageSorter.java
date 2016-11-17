package Main;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PackageSorter {

	public List<Package> order(List<Package> packages) {
		Map<String, Map<Date, List<Package>>> sorted = packages.stream().collect(
				Collectors.groupingBy(Package::getTargetLocation, Collectors.groupingBy(Package::getDeliveryDate)));

		List<Package> sortedList = new ArrayList<>();
		for (String k : sorted.keySet()) {
			for (Date dateKey : sorted.get(k).keySet()) {
				sortedList.addAll(sorted.get(k).get(dateKey));
			}
		}

		return sortedList;
	}
}

package com.roytuts.java.remove.duplicate.objects.from.list;

import java.util.Comparator;

public class CarComparator implements Comparator<Car> {

	@Override
	public int compare(Car c1, Car c2) {
		int m = c1.getMake().compareToIgnoreCase(c2.getMake());

		if (m != 0) {
			return m;
		}

		int md = c1.getModel().compareToIgnoreCase(c2.getModel());

		if (md != 0) {
			return md;
		}

		return Integer.compare(c1.getYear(), c2.getYear());
	}

}

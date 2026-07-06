package comparators;

import java.util.Comparator;

import tp01.Alumno;

public class PromedioComparator implements Comparator<Alumno> {
	
	@Override
	public int compare(Alumno a1, Alumno a2) {
		
		return Double.compare(a2.getPromedio(), a1.getPromedio());
	}

}

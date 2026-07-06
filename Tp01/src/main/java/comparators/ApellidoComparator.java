package comparators;

import java.util.Comparator;

import tp01.Alumno;

public class ApellidoComparator implements Comparator<Alumno> {
	
    @Override
	
	public int compare(Alumno a1, Alumno a2) {
		int resultado = a1.getApellido().compareTo(a2.getApellido());
		if(resultado == 0) {
			resultado = a1.getNombre().compareTo(a2.getNombre());
		}
		return resultado;
	}

}

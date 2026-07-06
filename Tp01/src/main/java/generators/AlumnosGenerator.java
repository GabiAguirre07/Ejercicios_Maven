package generators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import com.github.javafaker.Faker;

import tp01.Alumno;

public class AlumnosGenerator {
	public static final int limiteAlumnos = 50;
	public static Faker faker = new Faker (new Locale("es"));
	
	public List<Alumno> generate(){
		List<Alumno> lista = new ArrayList<Alumno>();
		for (int i = 0; i < limiteAlumnos; i++) {
			Alumno a = Alumno.builder()
				    .id(faker.number().numberBetween(1,100000))
				    .apellido(faker.name().lastName())
				    .nombre(faker.name().firstName())
				    .edad(faker.number().numberBetween(18, 65))
				    .dni(faker.numerify("########"))
				    .nroLE(faker.bothify("LE-####"))
				    .materiasAprobadas(faker.number().numberBetween(0, 40))
				    .promedio(faker.number().randomDouble(2, 1, 10))
				    .build();
			lista.add(a);
			
			
		}
		return lista;
	}
	
	public void mostrarListaAlumnos(List<Alumno> alumnos) {
		for (Alumno alu : alumnos) {
			System.out.print("------");
			System.out.println("id: " + alu.getId());
			System.out.println("\tApellido y Nombre: " + alu.getApellido() + ", " + alu.getNombre());
			System.out.println("\tEdad: " + alu.getEdad() + " Años");
			System.out.println("\tMaterias aprobadas: " + alu.getMateriasAprobadas());
			System.out.println(String.format("\tPromedio: %.2f",alu.getPromedio()));
			System.out.println("\tLegajo: " + alu.getNroLE());
		}

	}

}

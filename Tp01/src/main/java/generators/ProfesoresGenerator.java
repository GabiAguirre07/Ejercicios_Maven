package generators;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.github.javafaker.Faker;

import tp01.Alumno;
import tp01.Profesor;

public class ProfesoresGenerator {
	public static final int limiteDocentes = 20;
	public static Faker faker = new Faker (new Locale("es"));
	private static final String[] TITULOS_DOCENTES = {
		    "Ingeniero en Sistemas de Información",
		    "Licenciado en Ciencias de la Computación",
		    "Analista Universitario de Sistemas",
		    "Magíster en Ingeniería de Software",
		    "Doctor en Ciencias Informáticas",
		    "Ingeniero en Electrónica",
		    "Licenciado en Bioinformática"
		};
	
	public List<Profesor> generate(){
		List<Profesor> lista = new ArrayList<Profesor>();
		
		
		for (int i = 0; i < limiteDocentes; i++) {
			String tituloAleatorio = faker.options().nextElement(TITULOS_DOCENTES);
			Profesor p = Profesor.builder()
				    .id(faker.number().numberBetween(1,1000))
				    .apellido(faker.name().lastName())
				    .nombre(faker.name().firstName())
				    .edad(faker.number().numberBetween(25, 70))
				    .dni(faker.numerify("########"))
				    .legajo(faker.numerify("#####"))
				    .titulo(tituloAleatorio)
				    .build();
			lista.add(p);
			
			
		}
		return lista;
	}
	
	public void MostrarProfesores(List<Profesor> profesores) {

		for (Profesor prof : profesores) {
			System.out.print("------");
			System.out.println("id: " + prof.getId());
			System.out.println("\tApellido y Nombre: " + prof.getApellido() + ", " + prof.getNombre());
			System.out.println("\tTitulo: " + prof.getTitulo());
			System.out.println("\tDNI: " + prof.getDni());
			System.out.println("\tLegajo: " + prof.getLegajo());
			System.out.println("\tEdad: " + prof.getEdad() + " Años");
		}
	}

	

}
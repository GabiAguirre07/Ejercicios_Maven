package tp01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import comparators.ApellidoComparator;
import comparators.LegajoComparator;
import comparators.PromedioComparator;
import comparators.EdadComparator;



import generators.AlumnosGenerator;
import generators.ProfesoresGenerator;

public class Principal {

	public static void main(String[] args) {
		
		List<Alumno> la = new ArrayList<Alumno>();
		List<Profesor> lp = new ArrayList<Profesor>();
		AlumnosGenerator listaAlumnos = new AlumnosGenerator();
		ProfesoresGenerator listaProfesores = new ProfesoresGenerator();
		
		System.out.println("Lista de alumnos: ");
		la = listaAlumnos.generate();
		listaAlumnos.mostrarListaAlumnos(la);
		System.out.println("--------------------------------------------------------");
		System.out.println("Lista de profesores: ");
		lp = listaProfesores.generate();
		listaProfesores.MostrarProfesores(lp);
		
		System.out.println("================================================================================================================================================================");
		System.out.println("Punto 1: Ordenar los alumnos por apellido. ");
		System.out.println("================================================================================================================================================================");
		Collections.sort(la, new ApellidoComparator());
		
		for(Alumno a:la) {
			System.out.println("Alumno:" + a.getApellido() + ", " + a.getNombre() + " - Promedio: " + a.getPromedio());
		}
		
		System.out.println("================================================================================================================================================================");
		System.out.println("Punto 2: Ordenar los profesores por Legajo, de mayor a menor. ");
		Collections.sort(lp, new LegajoComparator());
		
		for(Profesor p:lp) {
			System.out.println("Profesor:" + p.getApellido() + ", " + p.getNombre() + " - Edad: " + p.getEdad() + " - Título: " + p.getTitulo() + " - Legajo: " + p.getLegajo());
		}
		
		System.out.println("================================================================================================================================================================");
		System.out.println("Punto 3: Identificar el mayor promedio de toda la lista de alumnos. ");
		Alumno aluMayorProm = null;
		double MayorPromedio = 0;
		
		for(Alumno alu:la) {
			
			if(alu.getPromedio() > MayorPromedio) {
				MayorPromedio = alu.getPromedio();
				aluMayorProm = alu;
			}
		}
		
		System.out.println("El alumno con mayor promedio es: " + aluMayorProm.getApellido() + ", " + aluMayorProm.getNombre() + " - Promedio: " + aluMayorProm.getPromedio());
		
		System.out.println("================================================================================================================================================================");
		System.out.println("Punto 4: Identificar el menor promedio de toda la lista de alumnos. ");
		Alumno aluMenorProm = null;
		double MenorPromedio = 999999;
		
		for(Alumno alu:la) {
			
			if(alu.getPromedio() < MenorPromedio) {
				MenorPromedio = alu.getPromedio();
				aluMenorProm = alu;
			}
		}
		
		System.out.println("El alumno con menor promedio es: " + aluMenorProm.getApellido() + ", " + aluMenorProm.getNombre() + " - Promedio: " + aluMenorProm.getPromedio());
		
		System.out.println("================================================================================================================================================================");
		System.out.println("Punto 5: Identificar los alumnos que tienen un promedio mayor a 7, y esa lista ordenarla de mayor a menor promedio. ");
		ArrayList<Alumno> PromMayorA7 = new ArrayList<Alumno>();
         
		for(Alumno alu:la) {
			
			if(alu.getPromedio() > 7) {
				PromMayorA7.add(alu);
			}
		}
        
         if(PromMayorA7.size() != 0) {
        	 Collections.sort(PromMayorA7,new PromedioComparator());
        	 System.out.println("Los alumnos con promedio mayor a 7 son: ");
        	 
        	 for(Alumno a:PromMayorA7) {
        		 System.out.println("Alumno:" + a.getApellido() + ", " + a.getNombre() + " - Promedio: " + a.getPromedio());
        	 }
         }
         else {
        	 System.out.println("No hay alumnos con promedio mayor a 7. ");
         }
         
         System.out.println("================================================================================================================================================================");
 		 System.out.println("Punto 6: Identificar los profesores cuyo título sea Ing. en Sistemas. ");
 		 ArrayList<Profesor> ingEnSistemas = new ArrayList<Profesor>();
 		 
 		 Iterator<Profesor> itProf = lp.iterator();
 		 
 		 while(itProf.hasNext()) {
 			 Profesor p = itProf.next();
 			 if(p.getTitulo().equalsIgnoreCase("ingeniero en sistemas de Información")) {
 				 ingEnSistemas.add(p);
 			 }
 		 }
 		 
 		 if(ingEnSistemas.size() != 0) {
 			
 			 System.out.println("Los profesores Ing. en Sistemas son: ");
 		   	
 			 for(Profesor p:ingEnSistemas) {
 		   		 System.out.println("Profesor:" + p.getApellido() + ", " + p.getNombre() + " - Legajo: " + p.getLegajo());
 		   	 }
 		 }
 		 
 		else {
       	 System.out.println("No hay profesores Ing. En Sistemas. ");
        }
 		 
 		System.out.println("================================================================================================================================================================");
		System.out.println("Punto 7: Ordenar los profesores por edad, de Mayor a Menor, imprimiendo sus datos por pantalla. ");
		
		Collections.sort(lp,new EdadComparator());
		
		for(Profesor p:lp) {
	   		 System.out.println("Profesor:" + p.getApellido() + ", " + p.getNombre() + " - Edad: " + p.getEdad() + " - Título: " + p.getTitulo() + " - Legajo: " + p.getLegajo());
	   	 }
		
		System.out.println("================================================================================================================================================================");
		System.out.println("Punto 8: Sumar las edades de todos los profesores y mostrar el resultado por pantalla. ");
		itProf = lp.iterator();
		int EdadTotal = 0;
		 while(itProf.hasNext()) {
 			 Profesor p = itProf.next();
 			 EdadTotal += p.getEdad();
 		 }
		
		 System.out.println("La edad total de todos los profesores es: " + EdadTotal);
		
		 System.out.println("================================================================================================================================================================");
		 System.out.println("Punto 9: Sacar un promedio total, y un promedio de los mejores alumnos, los que tienen su promedio superior a 7. ");
		 double PromedioTotal = 0;
		 Iterator<Alumno> itAlum = la.iterator();
			 while(itAlum.hasNext()) {
	 			 Alumno a = itAlum.next();
	 			 PromedioTotal += a.getPromedio();
	 		 }
		 
		 if(la.size() != 0)
		 {
			 double PromedioGeneral = PromedioTotal / la.size(); 
			 System.out.printf("El promedio general de todos los alumnos es: %.2f%n ", PromedioGeneral);
			 
			 if(PromMayorA7.size() != 0) {
				 PromedioTotal = 0;
	        	 
				 itAlum = PromMayorA7.iterator();
				 while(itAlum.hasNext()) {
		 			 Alumno a = itAlum.next();
		 			 PromedioTotal += a.getPromedio();
		 		 }
				 
				 PromedioGeneral = PromedioTotal / PromMayorA7.size();
				 System.out.printf("El promedio general de los alumnos con promedio mayor a 7 es: %.2f%n ", PromedioGeneral);
			 }
			
			 else {
				 System.out.println("No hay alumnos con promedio mayor a 7. ");
			 } 
		 }
		 else {
			 System.out.println("No hay alumnos registrados ");
		 }
		 
	}
	

}


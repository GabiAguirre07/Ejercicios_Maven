package tp01;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor
@ToString
@SuperBuilder

public class Persona {
	private int id;
	private String apellido;
	private String nombre;
	private int edad;
	private String dni;
	
	
	

}

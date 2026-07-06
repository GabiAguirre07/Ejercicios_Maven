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
@SuperBuilder
@ToString(callSuper = true)
public class Profesor extends Persona{
	private String legajo;
	private String titulo;

}

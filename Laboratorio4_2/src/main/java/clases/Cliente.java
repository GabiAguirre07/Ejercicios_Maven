package clases;
import java.util.Vector;

import lombok.Getter;

@Getter
public class Cliente {
	 private String apellido;
	 private String nombre;
	 private Integer nroCliente;
	 private Banco b;
	private Vector<Cuenta> listaCuentas;
	
	 public Cliente(String apellido, String nombre, int nroCliente, Banco b) {
	        this.apellido = apellido;
	        this.nombre = nombre;
	        this.nroCliente = nroCliente;
	        this.b = b;
	        this.listaCuentas = new Vector<>();
	    }
	
	
	public void addCuenta(Cuenta c) {
		if(c != null) {
			this.listaCuentas.add(c);
			this.b.addCuenta(c); // Agrego la cuenta al banco correspondiente.
		}
	}
	
	

}



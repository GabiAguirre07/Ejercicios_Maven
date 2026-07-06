package clases;



import java.util.ArrayList;

import lombok.Getter;

@Getter
public class Banco {
	 private String nombre;
     private ArrayList<Cuenta> listaCuentas = new ArrayList<Cuenta>();
     private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
     
    
    public Banco(String nombre) {
        this.nombre = nombre;
    }
    
    public void addCuenta(Cuenta c) {
    		this.listaCuentas.add(c);
    	}
    
    public void addCliente(Cliente cl) {
    	if(cl != null) {
    		this.listaClientes.add(cl);
    	}
	}
    
    public float getDisponibleEnBanco() {
    	float MontoTotal = 0;
    	for(Cuenta c:listaCuentas) {
    	MontoTotal += c.getSaldo();
    	}
    	return MontoTotal;
    }
    
   /*public float getDisponibleEnBanco() {
        return listaCuentas.stream()
                           .map(Cuenta::getSaldo)
                           .reduce(0f, Float::sum);
    } VERSION MODERNA */

    }


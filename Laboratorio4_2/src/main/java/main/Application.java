package main;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.javafaker.Faker;

import clases.Banco;
import clases.Cliente;
import clases.Comision;
import clases.Cuenta;
import clases.Deposito;
import clases.Extraccion;
import clases.Reembolso;
import clases.Transaccion;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        
       
    }
    @Bean
    public CommandLineRunner demo() {
        return args -> {
        	Faker f = new Faker();
        	
        	ArrayList<Banco> bancos = new ArrayList<Banco>(); // Lista de Bancos
        	// Creamos el Banco.
        	String nombre = f.company().name();
            Banco b1 = new Banco(nombre);
            bancos.add(b1); // Agregamos el banco a la lista de bancos.
           
            // Agregamos el primer cliente.
            nombre = f.name().firstName();
            String apellido =  f.name().lastName();
            int nroCliente = f.number().numberBetween(1000, 9999);
            Cliente cl1 = new Cliente(apellido,nombre,nroCliente,b1);
            b1.addCliente(cl1); // Registramos el cliente al banco.
           
            // Creamos la primera cuenta
            int nroCuenta = f.number().numberBetween(100000, 999999);
            float saldo = f.number().numberBetween(10000, 999999);;
            Cuenta cu1 = new Cuenta(nroCuenta,cl1,saldo);
            cl1.addCuenta(cu1); // Asocimos la cuenta al cliente y banco.
           
            // Realizamos un depósito a la cuenta recientemente creada.
            Transaccion tr = new Deposito(240.3F);
            		        
            cu1.addTransaccion(tr); // Registramos el deposito en la cuenta.
             tr = new Extraccion(150.7F);
            
            cu1.addTransaccion(tr);// Registramos la extracción en la cuenta.
            
            // Realizamos un reembolso a la cuenta por cancelación de compra.
            tr = new Reembolso(50.1F, "Cancelación de compra");
            cu1.addTransaccion(tr);
            
         // Realizamos una comisión a la cuenta por mantenimiento de la cuenta.
            tr = new Comision(cu1.getSaldo(),"Mantenimiento de la cuenta", 0.03F);
            cu1.addTransaccion(tr);
            
            
            nroCuenta = f.number().numberBetween(100000, 999999);
            saldo = f.number().numberBetween(10000, 999999);;
            Cuenta cu2 = new Cuenta(nroCuenta,cl1,saldo);// Creamos otra cuenta del mismo cliente.
            cl1.addCuenta(cu2); // Asocimos la cuenta al cliente y banco.
           
            // Realizamos un depósito a la cuenta recientemente creada.
            tr = new Deposito(540.3F);
            cu2.addTransaccion(tr); // Registramos el deposito en la cuenta.
            
            tr = new Extraccion(340.1F);
            cu2.addTransaccion(tr);// Registramos la extracción en la cuenta.
            
            // Agregamos el segundo cliente.
            nombre = f.name().firstName();
            apellido =  f.name().lastName();
            nroCliente = f.number().numberBetween(1000, 9999);
            Cliente cl2 = new Cliente(apellido,nombre,nroCliente,b1);
            b1.addCliente(cl2); // Registramos el cliente al banco.
           
            // Creamos la primera cuenta
             nroCuenta = f.number().numberBetween(100000, 999999);
              saldo = f.number().numberBetween(10000, 999999);;
             Cuenta cu3 = new Cuenta(nroCuenta,cl2,saldo);
            cl2.addCuenta(cu3); // Asocimos la cuenta al cliente y banco.
           
            // Realizamos un depósito a la cuenta recientemente creada.
            tr = new Deposito(740.3F);
            cu3.addTransaccion(tr); // Registramos el deposito en la cuenta.
            
            
         // Creamos otro Banco.
        	 nombre = f.company().name();
            Banco b2 = new Banco(nombre);
            bancos.add(b2); // Agregamos el banco a la lista de bancos.
           
            // Agregamos el primer cliente.
            nombre = f.name().firstName();
             apellido =  f.name().lastName();
             nroCliente = f.number().numberBetween(1000, 9999);
            Cliente cl3 = new Cliente(apellido,nombre,nroCliente,b2);
            b2.addCliente(cl3); // Registramos el cliente al banco.
           
            // Creamos la primera cuenta
             nroCuenta = f.number().numberBetween(100000, 999999);
             saldo = f.number().numberBetween(10000, 999999);;
            Cuenta cu4 = new Cuenta(nroCuenta,cl3,saldo);
            cl3.addCuenta(cu4); // Asocimos la cuenta al cliente y banco.
           
            // Realizamos un depósito a la cuenta recientemente creada.
            tr = new Deposito(140.3F);
            cu4.addTransaccion(tr); // Registramos el deposito en la cuenta.
            
            for(Banco b:bancos) {
            	System.out.println("Banco: " + b.getNombre());
                for(Cliente cl:b.getListaClientes())
                {
                	 System.out.println("Cliente: " + cl.getApellido() + ", " + cl.getNombre());
                     System.out.println("Cuentas:");
                     for(Cuenta c:cl.getListaCuentas()) {
                     	System.out.println("NroCuenta: " + c.getNroCuenta() +  " - Saldo: $" + c.getSaldo());
                     	
                     	System.out.println("Actividades Bancarias: ");
                          for(Transaccion t:c.getListaTrans()) {
                         	 if(t instanceof Deposito) {
                               	Deposito d = (Deposito)t;
                               	System.out.println("Depósito de $" + t.getMonto() + " realizado el: " + d.getFechaDeposito());
                               }
                               else if(t instanceof Extraccion) {
                               	Extraccion e = (Extraccion) t;
                               	System.out.println("Extracción de $" + t.getMonto() + " realizada el: " + e.getFechaExtraccion());
                               }
                               else if(t instanceof Reembolso) {
                                  	Reembolso r = (Reembolso) t;
                                  	System.out.println("Reembolso de $" + t.getMonto() + " - Motivo: " + r.getMotivo());
                                  }
                               else if(t instanceof Comision) {
                                 	Comision com = (Comision) t;
                                 	System.out.println("Comisión de $" + t.getMonto() + " - Motivo: " + com.getMotivo());
                                 }
                          }
                          System.out.println("===============================================================");
                     }
                     System.out.println("===============================================================");
                }
                System.out.println("Monto total en el Banco: $" + b.getDisponibleEnBanco() );
                System.out.println("===============================================================");
            }
            
           
            
           
            
            
            
            

        	
};
    }
}



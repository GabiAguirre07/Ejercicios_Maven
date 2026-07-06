package clases;



import java.time.LocalDate;

import lombok.Getter;

@Getter
public class Deposito extends Transaccion {
	
	private LocalDate fechaDeposito;
	
	public Deposito(float monto) throws Exception {
			super(monto);
			this.fechaDeposito = LocalDate.now();
	}
		
}

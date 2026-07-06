package clases;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public class Extraccion extends Transaccion {
	
	private LocalDate fechaExtraccion;
	
	public Extraccion (Float monto) throws Exception {
		super(monto);
		this.fechaExtraccion = LocalDate.now();
	}
	
	@Override
	public float getMonto() {
		return super.getMonto() * (-1);
	}
	
}

package clases;

import lombok.Getter;

@Getter
public class Reembolso extends Transaccion {
	
	private String motivo;
	
	public Reembolso(float monto, String motivo) throws Exception {
		super(monto);
		this.motivo = motivo;
	}
	
}

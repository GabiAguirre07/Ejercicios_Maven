package clases;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Transaccion {
	protected float monto;
	
	public Transaccion(float monto) throws Exception{
		if (monto > 0) {
			this.monto = monto;
		} else throw new Exception("El monto no puede ser negativo");
	}

	
}

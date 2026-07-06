package clases;


import lombok.Getter;


@Getter
public class Comision extends Transaccion {

	private String motivo;
	
	private float porcIncr;
	
	public Comision( float saldo,String motivo, float porcIncr) throws Exception {
		super(saldo * porcIncr); // Se calcula el monto de la comisión directamente al crear el objeto.
		this.motivo = motivo;
		this.porcIncr = porcIncr;
	}
	
	
	@Override
	public float getMonto() {
		return super.getMonto() * (-1);
	}
	
	}
	


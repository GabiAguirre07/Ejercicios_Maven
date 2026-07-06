package clases;

import java.util.Vector;

import lombok.Getter;

@Getter

public class Cuenta {
	private int nroCuenta;
	private Cliente cliente;
	private Vector<Transaccion> listaTrans;
	private float saldo;

	public Cuenta(int nroCuenta, Cliente cliente, float saldo) {
		this.nroCuenta = nroCuenta;
		this.cliente = cliente;
		this.saldo = saldo;
		this.listaTrans = new Vector<Transaccion>();
	}

	public <T extends Transaccion> void addTransaccion(T t) {
		if (t == null)
			return;
		this.listaTrans.add(t);
        this.saldo += t.getMonto();
	}

}

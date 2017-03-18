package br.pro.hashi.ensino.desagil.lucianogic.model;

public class MockEmitter implements Emitter {
	private boolean signal;

	public MockEmitter(boolean signal) {
		this.signal = signal;
	}

	@Override
	public boolean read() {
		return signal;
	}
}

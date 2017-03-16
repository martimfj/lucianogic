package br.pro.hashi.ensino.desagil.lucianogic.model;

public class Switch implements Emitter {
	private boolean on;

	public Switch() {
		on = false;
	}

	public void setOn(boolean on) {
		this.on = on;
	}

	@Override
	public boolean read() {
		return on;
	}
}

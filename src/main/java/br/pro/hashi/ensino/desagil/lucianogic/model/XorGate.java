package br.pro.hashi.ensino.desagil.lucianogic.model;

public class XorGate extends Gate {
	private Emitter[] emitters;

	public XorGate() {
		super(2);
		emitters = new Emitter[2];
	}

	@Override
	public boolean read() {
		// A * not(B) + not(A) * B
		return (emitters[0].read() && !emitters[1].read() || !emitters[0].read() && emitters[1].read());
	}

	@Override
	protected void doConnect(Emitter emitter, int index) {
		emitters[index] = emitter;
	}
}

package br.pro.hashi.ensino.desagil.lucianogic.model;

public class MuxGate extends Gate {
	private Emitter[] emitters;

	public MuxGate() {
		super(3);
		emitters = new Emitter[3];
	}

	@Override
	public boolean read() {
		return (emitters[0].read() && (!emitters[2].read())) || (emitters[1].read() && emitters[2].read());
	}

	@Override
	protected void doConnect(Emitter emitter, int index) {
		emitters[index] = emitter;
	}
}

package br.pro.hashi.ensino.desagil.lucianogic.model;

public class AndGate extends Gate {
	private NandGate nandGate;
	private NotGate notGate;

	public AndGate() {
		super(2);
		nandGate = new NandGate();
		notGate = new NotGate();
		notGate.connect(nandGate, 0);
	}

	@Override
	public boolean read() {
		return notGate.read();
	}

	@Override
	protected void doConnect(Emitter emitter, int index) {
		nandGate.connect(emitter, index);
	}
}
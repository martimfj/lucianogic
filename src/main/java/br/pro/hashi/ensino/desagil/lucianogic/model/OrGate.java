package br.pro.hashi.ensino.desagil.lucianogic.model;

public class OrGate extends Gate {
	private NandGate nandTop;
	private NandGate nandBottom;
	private NandGate nandRight;

	public OrGate() {
		super(2);

		nandTop = new NandGate();

		nandBottom = new NandGate();

		nandRight = new NandGate();
		nandRight.connect(nandTop, 0);
		nandRight.connect(nandBottom, 1);
		name = "OrGate";
	}

	@Override
	public boolean read() {
		return nandRight.read();
	}

	@Override
	protected void doConnect(Emitter emitter, int index) {
		switch(index) {
		case 0:
			nandTop.connect(emitter, 0);
			nandTop.connect(emitter, 1);
			break;
		case 1:
			nandBottom.connect(emitter, 0);
			nandBottom.connect(emitter, 1);
			break;
		}
	}
}

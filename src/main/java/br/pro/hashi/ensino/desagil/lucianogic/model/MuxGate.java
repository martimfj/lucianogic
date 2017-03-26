package br.pro.hashi.ensino.desagil.lucianogic.model;

public class MuxGate extends Gate {
	private NandGate nandLeft;
	private NandGate nandTop;
	private NandGate nandBottom;
	private NandGate nandRight;

	public MuxGate() {
		super(3);

		nandLeft = new NandGate();

		nandTop = new NandGate();
		nandTop.connect(nandLeft, 1);

		nandBottom = new NandGate();

		nandRight = new NandGate();
		nandRight.connect(nandTop, 0);
		nandRight.connect(nandBottom, 1);
		name = "MuxGate";
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
			break;
		case 1:
			nandBottom.connect(emitter, 1);
			break;
		case 2:
			nandLeft.connect(emitter, 0);
			nandLeft.connect(emitter, 1);
			nandBottom.connect(emitter, 0);
			break;
		}
	}
}

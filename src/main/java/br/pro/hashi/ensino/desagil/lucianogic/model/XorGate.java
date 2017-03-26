package br.pro.hashi.ensino.desagil.lucianogic.model;

public class XorGate extends Gate {
	private NandGate nandLeft;
	private NandGate nandTop;
	private NandGate nandBottom;
	private NandGate nandRight;

	public XorGate() {
		super(2);

		nandLeft = new NandGate();

		nandTop = new NandGate();
		nandTop.connect(nandLeft, 1);

		nandBottom = new NandGate();
		nandBottom.connect(nandLeft, 0);

		nandRight = new NandGate();
		nandRight.connect(nandTop, 0);
		nandRight.connect(nandBottom, 1);
		name = "XorGate";
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
			nandLeft.connect(emitter, 0);
			break;
		case 1:
			nandLeft.connect(emitter, 1);
			nandBottom.connect(emitter, 1);
			break;
		}
	}
}

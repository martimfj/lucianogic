package br.pro.hashi.ensino.desagil.lucianogic.model;

public class XorGate extends Gate {
	private NandGate nandGate_1;
	private NandGate nandGate_2;
	private NandGate nandGate_3;
	private NandGate nandGate_4;

	public XorGate() {
		super(2);
		nandGate_1 = new NandGate();
		nandGate_2 = new NandGate();
		nandGate_3 = new NandGate();
		nandGate_4 = new NandGate();
		nandGate_2.connect(nandGate_1, 0);
		nandGate_3.connect(nandGate_1, 0);
		nandGate_4.connect(nandGate_2, 0);
		nandGate_4.connect(nandGate_3, 1);
	}

	@Override
	public boolean read() {
		return nandGate_4.read();
	}

	@Override
	protected void doConnect(Emitter emitter, int index) {
		if(index == 0) {
			nandGate_1.connect(emitter, 0);
			nandGate_2.connect(emitter, 1);
		}
		else {
			nandGate_1.connect(emitter, 1);
			nandGate_3.connect(emitter, 1);
		}
	}
}
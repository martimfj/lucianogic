package br.pro.hashi.ensino.desagil.lucianogic.model;


public class LED implements Receiver {
	private int r;
	private int g;
	private int b;

	private Emitter emitter;


	public LED(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;

		emitter = null;
	}


	public int getR() {
		return r;
	}
	public int getG() {
		return g;
	}
	public int getB() {
		return b;
	}


	public boolean isOn() {
		return emitter.read();
	}


	@Override
	public void connect(Emitter emitter, int index) {
		if(index != 0) {
			throw new IndexOutOfBoundsException();
		}
		this.emitter = emitter;
	}
}

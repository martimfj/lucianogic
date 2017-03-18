package br.pro.hashi.ensino.desagil.lucianogic.model;

import org.junit.Assert;
import org.junit.Test;

public class XorGateTest {
	@Test
	public void ifReceivesFalseFalseShouldEmitFalse() {
		XorGate xorGate = new XorGate();

		xorGate.connect(new MockEmitter(false), 0);
		xorGate.connect(new MockEmitter(false), 1);

		Assert.assertEquals(false, xorGate.read());
	}

	@Test
	public void ifReceivesFalseTrueShouldEmitTrue() {
		XorGate xorGate = new XorGate();

		xorGate.connect(new MockEmitter(false), 0);
		xorGate.connect(new MockEmitter(true), 1);

		Assert.assertEquals(true, xorGate.read());
	}

	@Test
	public void ifReceivesTrueFalseShouldEmitTrue() {
		XorGate xorGate = new XorGate();

		xorGate.connect(new MockEmitter(true), 0);
		xorGate.connect(new MockEmitter(false), 1);

		Assert.assertEquals(true, xorGate.read());
	}

	@Test
	public void ifReceivesTrueTrueShouldEmitFalse() {
		XorGate xorGate = new XorGate();

		xorGate.connect(new MockEmitter(true), 0);
		xorGate.connect(new MockEmitter(true), 1);

		Assert.assertEquals(false, xorGate.read());
	}
}

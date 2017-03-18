package br.pro.hashi.ensino.desagil.lucianogic.model;

import org.junit.Assert;
import org.junit.Test;

public class OrGateTest {
	@Test
	public void ifReceivesFalseFalseShouldEmitFalse() {
		OrGate orGate = new OrGate();

		orGate.connect(new MockEmitter(false), 0);
		orGate.connect(new MockEmitter(false), 1);

		Assert.assertEquals(false, orGate.read());
	}

	@Test
	public void ifReceivesFalseTrueShouldEmitTrue() {
		OrGate orGate = new OrGate();

		orGate.connect(new MockEmitter(false), 0);
		orGate.connect(new MockEmitter(true), 1);

		Assert.assertEquals(true, orGate.read());
	}

	@Test
	public void ifReceivesTrueFalseShouldEmitTrue() {
		OrGate orGate = new OrGate();

		orGate.connect(new MockEmitter(true), 0);
		orGate.connect(new MockEmitter(false), 1);

		Assert.assertEquals(true, orGate.read());
	}

	@Test
	public void ifReceivesTrueTrueShouldEmitTrue() {
		OrGate orGate = new OrGate();

		orGate.connect(new MockEmitter(true), 0);
		orGate.connect(new MockEmitter(true), 1);

		Assert.assertEquals(true, orGate.read());
	}
}

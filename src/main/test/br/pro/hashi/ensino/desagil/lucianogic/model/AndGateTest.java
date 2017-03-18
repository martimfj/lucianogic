package br.pro.hashi.ensino.desagil.lucianogic.model;

import org.junit.Assert;
import org.junit.Test;

public class AndGateTest {
	@Test
	public void ifReceivesFalseFalseShouldEmitFalse() {
		AndGate andGate = new AndGate();

		andGate.connect(new MockEmitter(false), 0);
		andGate.connect(new MockEmitter(false), 1);

		Assert.assertEquals(false, andGate.read());
	}

	@Test
	public void ifReceivesFalseTrueShouldEmitFalse() {
		AndGate andGate = new AndGate();

		andGate.connect(new MockEmitter(false), 0);
		andGate.connect(new MockEmitter(true), 1);

		Assert.assertEquals(false, andGate.read());
	}

	@Test
	public void ifReceivesTrueFalseShouldEmitFalse() {
		AndGate andGate = new AndGate();

		andGate.connect(new MockEmitter(true), 0);
		andGate.connect(new MockEmitter(false), 1);

		Assert.assertEquals(false, andGate.read());
	}

	@Test
	public void ifReceivesTrueTrueShouldEmitTrue() {
		AndGate andGate = new AndGate();

		andGate.connect(new MockEmitter(true), 0);
		andGate.connect(new MockEmitter(true), 1);

		Assert.assertEquals(true, andGate.read());
	}
}

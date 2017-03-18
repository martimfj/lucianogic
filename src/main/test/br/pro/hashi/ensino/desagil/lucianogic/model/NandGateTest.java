package br.pro.hashi.ensino.desagil.lucianogic.model;

import org.junit.Assert;
import org.junit.Test;

public class NandGateTest {
	@Test
	public void ifReceivesFalseFalseShouldEmitTrue() {
		NandGate nandGate = new NandGate();

		nandGate.connect(new MockEmitter(false), 0);
		nandGate.connect(new MockEmitter(false), 1);

		Assert.assertEquals(true, nandGate.read());
	}

	@Test
	public void ifReceivesFalseTrueShouldEmitTrue() {
		NandGate nandGate = new NandGate();

		nandGate.connect(new MockEmitter(false), 0);
		nandGate.connect(new MockEmitter(true), 1);

		Assert.assertEquals(true, nandGate.read());
	}

	@Test
	public void ifReceivesTrueFalseShouldEmitTrue() {
		NandGate nandGate = new NandGate();

		nandGate.connect(new MockEmitter(true), 0);
		nandGate.connect(new MockEmitter(false), 1);

		Assert.assertEquals(true, nandGate.read());
	}

	@Test
	public void ifReceivesTrueTrueShouldEmitFalse() {
		NandGate nandGate = new NandGate();

		nandGate.connect(new MockEmitter(true), 0);
		nandGate.connect(new MockEmitter(true), 1);

		Assert.assertEquals(false, nandGate.read());
	}
}

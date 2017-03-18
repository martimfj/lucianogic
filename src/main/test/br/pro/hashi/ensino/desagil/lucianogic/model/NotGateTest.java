package br.pro.hashi.ensino.desagil.lucianogic.model;

import org.junit.Assert;
import org.junit.Test;

public class NotGateTest {
	@Test
	public void ifReceivesFalseShouldEmitTrue() {
		NotGate notGate = new NotGate();

		notGate.connect(new MockEmitter(false), 0);

		Assert.assertEquals(true, notGate.read());
	}

	@Test
	public void ifReceivesTrueShouldEmitFalse() {
		NotGate notGate = new NotGate();

		notGate.connect(new MockEmitter(true), 0);

		Assert.assertEquals(false, notGate.read());
	}
}

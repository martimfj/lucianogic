package br.pro.hashi.ensino.desagil.lucianogic.model;

import org.junit.Assert;
import org.junit.Test;

public class MuxGateTest {
	@Test
	public void ifReceivesFalseFalseFalseShouldEmitFalse() {
		MuxGate muxGate = new MuxGate();

		muxGate.connect(new MockEmitter(false), 0);
		muxGate.connect(new MockEmitter(false), 1);
		muxGate.connect(new MockEmitter(false), 2);

		Assert.assertEquals(false, muxGate.read());
	}

	@Test
	public void ifReceivesFalseFalseTrueShouldEmitFalse() {
		MuxGate muxGate = new MuxGate();

		muxGate.connect(new MockEmitter(false), 0);
		muxGate.connect(new MockEmitter(false), 1);
		muxGate.connect(new MockEmitter(true), 2);

		Assert.assertEquals(false, muxGate.read());
	}

	@Test
	public void ifReceivesFalseTrueFalseShouldEmitFalse() {
		MuxGate muxGate = new MuxGate();

		muxGate.connect(new MockEmitter(false), 0);
		muxGate.connect(new MockEmitter(true), 1);
		muxGate.connect(new MockEmitter(false), 2);

		Assert.assertEquals(false, muxGate.read());
	}

	@Test
	public void ifReceivesFalseTrueTrueShouldEmitTrue() {
		MuxGate muxGate = new MuxGate();

		muxGate.connect(new MockEmitter(false), 0);
		muxGate.connect(new MockEmitter(true), 1);
		muxGate.connect(new MockEmitter(true), 2);

		Assert.assertEquals(true, muxGate.read());
	}

	@Test
	public void ifReceivesTrueFalseFalseShouldEmitTrue() {
		MuxGate muxGate = new MuxGate();

		muxGate.connect(new MockEmitter(true), 0);
		muxGate.connect(new MockEmitter(false), 1);
		muxGate.connect(new MockEmitter(false), 2);

		Assert.assertEquals(true, muxGate.read());
	}

	@Test
	public void ifReceivesTrueFalseTrueShouldEmitFalse() {
		MuxGate muxGate = new MuxGate();

		muxGate.connect(new MockEmitter(true), 0);
		muxGate.connect(new MockEmitter(false), 1);
		muxGate.connect(new MockEmitter(true), 2);

		Assert.assertEquals(false, muxGate.read());
	}

	@Test
	public void ifReceivesTrueTrueFalseShouldEmitTrue() {
		MuxGate muxGate = new MuxGate();

		muxGate.connect(new MockEmitter(true), 0);
		muxGate.connect(new MockEmitter(true), 1);
		muxGate.connect(new MockEmitter(false), 2);

		Assert.assertEquals(true, muxGate.read());
	}

	@Test
	public void ifReceivesTrueTrueTrueShouldEmitTrue() {
		MuxGate muxGate = new MuxGate();

		muxGate.connect(new MockEmitter(true), 0);
		muxGate.connect(new MockEmitter(true), 1);
		muxGate.connect(new MockEmitter(true), 2);

		Assert.assertEquals(true, muxGate.read());
	}
}

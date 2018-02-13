package com.github.jimsp.gate.canonial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ResourceCanonico_ESTest {

	@Test
	public void test0() throws Throwable {
		Boolean boolean0 = Boolean.TRUE;
		Boolean boolean1 = new Boolean("");
		ResourceCanonico resourceCanonico0 = ResourceCanonico.create("", boolean0, boolean1);
		assertFalse(resourceCanonico0.getPermanent());
		assertTrue(resourceCanonico0.getPattern());
	}

	@Test
	public void test1() throws Throwable {
		ResourceCanonico resourceCanonico0 = ResourceCanonico.create("", (Boolean) null, (Boolean) null);
		Boolean boolean0 = resourceCanonico0.getPermanent();
		assertNull(boolean0);
	}

	@Test
	public void test2() throws Throwable {
		Boolean boolean0 = new Boolean("");
		ResourceCanonico resourceCanonico0 = new ResourceCanonico("", boolean0, boolean0);
		Boolean boolean1 = resourceCanonico0.getPermanent();
		assertFalse(boolean1);
	}

	@Test
	public void test3() throws Throwable {
		ResourceCanonico resourceCanonico0 = ResourceCanonico.create("", (Boolean) null, (Boolean) null);
		Boolean boolean0 = resourceCanonico0.getPattern();
		assertNull(boolean0);
	}

	@Test
	public void test4() throws Throwable {
		Boolean boolean0 = Boolean.TRUE;
		ResourceCanonico resourceCanonico0 = ResourceCanonico.create("", boolean0, boolean0);
		Boolean boolean1 = resourceCanonico0.getPattern();
		assertTrue(boolean1);
	}

	@Test
	public void test5() throws Throwable {
		ResourceCanonico resourceCanonico0 = ResourceCanonico.create("Y", (Boolean) null, (Boolean) null);
		String string0 = resourceCanonico0.getName();
		assertEquals("Y", string0);
	}

	@Test
	public void test6() throws Throwable {
		Boolean boolean0 = Boolean.TRUE;
		ResourceCanonico resourceCanonico0 = ResourceCanonico.create("", boolean0, boolean0);
		String string0 = resourceCanonico0.getName();
		assertEquals("", string0);
	}

	@Test
	public void test7() throws Throwable {
		Boolean boolean0 = Boolean.valueOf("");
		ResourceCanonico resourceCanonico0 = ResourceCanonico.create((String) null, boolean0, boolean0);
		String string0 = resourceCanonico0.getName();
		assertNull(string0);
	}

	@Test
	public void test8() throws Throwable {
		Boolean boolean0 = Boolean.valueOf("");
		ResourceCanonico resourceCanonico0 = ResourceCanonico.create("", boolean0, boolean0);
		Boolean boolean1 = resourceCanonico0.getPattern();
		assertFalse(boolean1);
	}

	@Test
	public void test9() throws Throwable {
		Boolean boolean0 = Boolean.TRUE;
		ResourceCanonico resourceCanonico0 = new ResourceCanonico("", boolean0, boolean0);
		Boolean boolean1 = resourceCanonico0.getPermanent();
		assertTrue(boolean1);
	}
}

package com.github.jimsp.gate.canonial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OperationCanonico_ESTest {

	@Test
	public void test0() throws Throwable {
		Boolean boolean0 = Boolean.TRUE;
		OperationCanonico operationCanonico0 = OperationCanonico.create("", "", boolean0);
		Boolean boolean1 = operationCanonico0.getPermanent();
		assertTrue(boolean1);
	}

	@Test
	public void test1() throws Throwable {
		Boolean boolean0 = Boolean.valueOf("");
		OperationCanonico operationCanonico0 = OperationCanonico.create("", "", boolean0);
		Boolean boolean1 = operationCanonico0.getPermanent();
		assertFalse(boolean1);
	}

	@Test
	public void test2() throws Throwable {
		Boolean boolean0 = Boolean.valueOf((String) null);
		OperationCanonico operationCanonico0 = OperationCanonico.create("r", (String) null, boolean0);
		String string0 = operationCanonico0.getName();
		assertEquals("r", string0);
	}

	@Test
	public void test3() throws Throwable {
		Boolean boolean0 = Boolean.valueOf("");
		OperationCanonico operationCanonico0 = OperationCanonico.create("", "", boolean0);
		String string0 = operationCanonico0.getName();
		assertEquals("", string0);
	}

	@Test
	public void test4() throws Throwable {
		Boolean boolean0 = Boolean.FALSE;
		OperationCanonico operationCanonico0 = OperationCanonico.create("", "z", boolean0);
		String string0 = operationCanonico0.getDescription();
		assertEquals("z", string0);
		assertEquals("", operationCanonico0.getName());
	}

	@Test
	public void test5() throws Throwable {
		Boolean boolean0 = Boolean.valueOf("");
		OperationCanonico operationCanonico0 = OperationCanonico.create("", "", boolean0);
		String string0 = operationCanonico0.getDescription();
		assertEquals("", string0);
	}

	@Test
	public void test6() throws Throwable {
		Boolean boolean0 = Boolean.valueOf((String) null);
		OperationCanonico operationCanonico0 = OperationCanonico.create((String) null, "", boolean0);
		String string0 = operationCanonico0.getName();
		assertNull(string0);
	}

	@Test
	public void test7() throws Throwable {
		Boolean boolean0 = Boolean.FALSE;
		OperationCanonico operationCanonico0 = new OperationCanonico((String) null, (String) null, boolean0);
		String string0 = operationCanonico0.getDescription();
		assertNull(string0);
	}

	@Test
	public void test8() throws Throwable {
		OperationCanonico operationCanonico0 = new OperationCanonico("", "", (Boolean) null);
		Boolean boolean0 = operationCanonico0.getPermanent();
		assertNull(boolean0);
	}
}

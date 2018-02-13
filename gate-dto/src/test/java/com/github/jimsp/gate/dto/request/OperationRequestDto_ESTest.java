package com.github.jimsp.gate.dto.request;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OperationRequestDto_ESTest {

	@Test
	public void test0() throws Throwable {
		Boolean boolean0 = Boolean.TRUE;
		OperationRequestDto operationRequestDto0 = OperationRequestDto.create("", "", boolean0);
		Boolean boolean1 = operationRequestDto0.getPermanent();
		assertTrue(boolean1);
	}

	@Test
	public void test1() throws Throwable {
		Boolean boolean0 = new Boolean("");
		OperationRequestDto operationRequestDto0 = OperationRequestDto.create("", "", boolean0);
		Boolean boolean1 = operationRequestDto0.getPermanent();
		assertFalse(boolean1);
	}

	@Test
	public void test2() throws Throwable {
		OperationRequestDto operationRequestDto0 = new OperationRequestDto((String) null, "", (Boolean) null);
		String string0 = operationRequestDto0.getName();
		assertNull(string0);
	}

	@Test
	public void test3() throws Throwable {
		Boolean boolean0 = new Boolean("");
		OperationRequestDto operationRequestDto0 = OperationRequestDto.create("K", "", boolean0);
		String string0 = operationRequestDto0.getName();
		assertEquals("K", string0);
		assertEquals("", operationRequestDto0.getDescription());
	}

	public void test4() throws Throwable {
		Boolean boolean0 = new Boolean("");
		OperationRequestDto operationRequestDto0 = OperationRequestDto.create("", "K", boolean0);
		String string0 = operationRequestDto0.getDescription();
		assertEquals("K", string0);
		assertEquals("", operationRequestDto0.getName());
	}

	public void test5() throws Throwable {
		Boolean boolean0 = Boolean.FALSE;
		OperationRequestDto operationRequestDto0 = OperationRequestDto.create("", "", boolean0);
		String string0 = operationRequestDto0.getDescription();
		assertEquals("", string0);
	}

	public void test6() throws Throwable {
		Boolean boolean0 = Boolean.TRUE;
		OperationRequestDto operationRequestDto0 = OperationRequestDto.create("", "", boolean0);
		String string0 = operationRequestDto0.getName();
		assertEquals("", string0);
	}

	public void test7() throws Throwable {
		Boolean boolean0 = new Boolean("");
		OperationRequestDto operationRequestDto0 = OperationRequestDto.create((String) null, (String) null, boolean0);
		String string0 = operationRequestDto0.getDescription();
		assertNull(string0);
	}

	public void test8() throws Throwable {
		OperationRequestDto operationRequestDto0 = new OperationRequestDto("", "", (Boolean) null);
		Boolean boolean0 = operationRequestDto0.getPermanent();
		assertNull(boolean0);
	}
}

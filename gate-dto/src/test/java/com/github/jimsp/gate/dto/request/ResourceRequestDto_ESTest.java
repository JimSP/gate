/*
 * This file was automatically generated by EvoSuite
 * Tue Feb 13 16:38:27 BRST 2018
 */

package com.github.jimsp.gate.dto.request;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ResourceRequestDto_ESTest {

	@Test
	public void test0() throws Throwable {
		Boolean boolean0 = Boolean.TRUE;
		ResourceRequestDto resourceRequestDto0 = new ResourceRequestDto("", boolean0, boolean0);
		Boolean boolean1 = resourceRequestDto0.getPermanent();
		assertTrue(boolean1);
	}

	@Test
	public void test1() throws Throwable {
		Boolean boolean0 = new Boolean("");
		ResourceRequestDto resourceRequestDto0 = ResourceRequestDto.create("", boolean0, boolean0);
		Boolean boolean1 = resourceRequestDto0.getPermanent();
		assertFalse(boolean1);
	}

	@Test
	public void test2() throws Throwable {
		ResourceRequestDto resourceRequestDto0 = ResourceRequestDto.create("", (Boolean) null, (Boolean) null);
		Boolean boolean0 = resourceRequestDto0.getPattern();
		assertNull(boolean0);
	}

	@Test
	public void test3() throws Throwable {
		Boolean boolean0 = new Boolean(true);
		ResourceRequestDto resourceRequestDto0 = new ResourceRequestDto("", boolean0, boolean0);
		Boolean boolean1 = resourceRequestDto0.getPattern();
		assertTrue(boolean1);
	}

	@Test
	public void test4() throws Throwable {
		Boolean boolean0 = new Boolean((String) null);
		ResourceRequestDto resourceRequestDto0 = new ResourceRequestDto((String) null, boolean0, boolean0);
		String string0 = resourceRequestDto0.getName();
		assertNull(string0);
	}

	@Test
	public void test5() throws Throwable {
		Boolean boolean0 = Boolean.FALSE;
		ResourceRequestDto resourceRequestDto0 = new ResourceRequestDto("Y", boolean0, boolean0);
		String string0 = resourceRequestDto0.getName();
		assertEquals("Y", string0);
	}

	@Test
	public void test6() throws Throwable {
		Boolean boolean0 = Boolean.FALSE;
		ResourceRequestDto resourceRequestDto0 = new ResourceRequestDto("", boolean0, boolean0);
		String string0 = resourceRequestDto0.getName();
		assertEquals("", string0);
	}

	@Test
	public void test7() throws Throwable {
		Boolean boolean0 = Boolean.FALSE;
		ResourceRequestDto resourceRequestDto0 = ResourceRequestDto.create("", boolean0, (Boolean) null);
		assertFalse(resourceRequestDto0.getPattern());
	}

	@Test
	public void test8() throws Throwable {
		Boolean boolean0 = Boolean.FALSE;
		ResourceRequestDto resourceRequestDto0 = new ResourceRequestDto("", boolean0, (Boolean) null);
		Boolean boolean1 = resourceRequestDto0.getPattern();
		assertFalse(boolean1);
	}

	@Test
	public void test9() throws Throwable {
		Boolean boolean0 = Boolean.FALSE;
		ResourceRequestDto resourceRequestDto0 = new ResourceRequestDto("", boolean0, (Boolean) null);
		Boolean boolean1 = resourceRequestDto0.getPermanent();
		assertNull(boolean1);
	}
}
package com.github.jimsp.gate.dto.request;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class GroupOperationRequestDto_ESTest {

	public void test0() throws Throwable {
		GroupOperationRequestDto groupOperationRequestDto0 = GroupOperationRequestDto.create("", "v");
		String string0 = groupOperationRequestDto0.getValue();
		assertEquals("", groupOperationRequestDto0.getName());
		assertEquals("v", string0);
	}

	public void test1() throws Throwable {
		GroupOperationRequestDto groupOperationRequestDto0 = GroupOperationRequestDto.create("", "");
		String string0 = groupOperationRequestDto0.getValue();
		assertEquals("", string0);
	}

	public void test2() throws Throwable {
		GroupOperationRequestDto groupOperationRequestDto0 = GroupOperationRequestDto.create("v", "");
		String string0 = groupOperationRequestDto0.getName();
		assertEquals("", groupOperationRequestDto0.getValue());
		assertEquals("v", string0);
	}

	public void test3() throws Throwable {
		GroupOperationRequestDto groupOperationRequestDto0 = new GroupOperationRequestDto("", "");
		String string0 = groupOperationRequestDto0.getName();
		assertEquals("", string0);
	}

	public void test4() throws Throwable {
		GroupOperationRequestDto groupOperationRequestDto0 = GroupOperationRequestDto.create("", "");
		String string0 = groupOperationRequestDto0.toString();
		assertEquals("GroupDto [name=, value=]", string0);
	}

	public void test5() throws Throwable {
		GroupOperationRequestDto groupOperationRequestDto0 = new GroupOperationRequestDto((String) null, "");
		String string0 = groupOperationRequestDto0.getName();
		assertNull(string0);
	}

	public void test6() throws Throwable {
		GroupOperationRequestDto groupOperationRequestDto0 = GroupOperationRequestDto.create((String) null,
				(String) null);
		String string0 = groupOperationRequestDto0.getValue();
		assertNull(string0);
	}
}

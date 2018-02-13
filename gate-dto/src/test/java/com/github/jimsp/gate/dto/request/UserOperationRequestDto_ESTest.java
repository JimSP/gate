package com.github.jimsp.gate.dto.request;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.Test;

public class UserOperationRequestDto_ESTest {

	@Test
	public void test0() throws Throwable {
		Date date0 = new Date();
		UserOperationRequestDto userOperationRequestDto0 = UserOperationRequestDto.create("L", "", date0);
		String string0 = userOperationRequestDto0.getUsername();
		assertEquals("L", string0);
		assertEquals("", userOperationRequestDto0.getPassword());
	}

	@Test
	public void test1() throws Throwable {
		Date date0 = new Date();
		UserOperationRequestDto userOperationRequestDto0 = UserOperationRequestDto.create("", "", date0);
		String string0 = userOperationRequestDto0.getUsername();
		assertEquals("", string0);
	}

	@Test
	public void test2() throws Throwable {
		Date date0 = new Date();
		UserOperationRequestDto userOperationRequestDto0 = UserOperationRequestDto.create("", "L", date0);
		String string0 = userOperationRequestDto0.getPassword();
		assertEquals("L", string0);
		assertEquals("", userOperationRequestDto0.getUsername());
	}

	@Test
	public void test3() throws Throwable {
		Date date0 = new Date();
		UserOperationRequestDto userOperationRequestDto0 = UserOperationRequestDto.create("", "", date0);
		String string0 = userOperationRequestDto0.getPassword();
		assertEquals("", string0);
	}

	@Test
	public void test4() throws Throwable {
		Date date0 = new Date();
		UserOperationRequestDto userOperationRequestDto0 = UserOperationRequestDto.create("", "", date0);
		Date date1 = userOperationRequestDto0.getCreateDate();
		assertEquals(date0, date1);
	}

	@Test
	public void test5() throws Throwable {
		Date date0 = new Date();
		UserOperationRequestDto userOperationRequestDto0 = UserOperationRequestDto.create((String) null, "", date0);
		String string0 = userOperationRequestDto0.getUsername();
		assertNull(string0);
	}

	@Test
	public void test6() throws Throwable {
		UserOperationRequestDto userOperationRequestDto0 = UserOperationRequestDto.create("", "", (Date) null);
		Date date0 = userOperationRequestDto0.getCreateDate();
		assertNull(date0);
	}

	@Test
	public void test7() throws Throwable {
		Date date0 = new Date();
		UserOperationRequestDto userOperationRequestDto0 = new UserOperationRequestDto("", (String) null, date0);
		String string0 = userOperationRequestDto0.getPassword();
		assertNull(string0);
	}
}

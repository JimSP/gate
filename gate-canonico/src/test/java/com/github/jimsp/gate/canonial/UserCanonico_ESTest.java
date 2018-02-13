package com.github.jimsp.gate.canonial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.util.UUID;

import org.junit.Test;

public class UserCanonico_ESTest {

	@Test
	public void test00() throws Throwable {
		Long long0 = new Long(0L);
		UserCanonico userCanonico0 = UserCanonico.create("B", long0);
		String string0 = userCanonico0.getUsername();
		assertEquals("B", string0);
	}

	@Test
	public void test01() throws Throwable {
		UserCanonico userCanonico0 = UserCanonico.create("", "", null, (Long) null);
		String string0 = userCanonico0.getUsername();
		assertEquals("", string0);
	}

	@Test
	public void test02() throws Throwable {
		UUID uUID0 = new UUID(1L, 0L);
		Long long0 = new Long(0L);
		UserCanonico userCanonico0 = UserCanonico.create(uUID0, "", "", null, long0);
		UUID uUID1 = userCanonico0.getToken();
		assertEquals(0L, uUID1.getLeastSignificantBits());
	}

	@Test
	public void test03() throws Throwable {
		UUID uUID0 = new UUID((-1L), 0L);
		UserCanonico userCanonico0 = UserCanonico.create(uUID0, "", "", null, (Long) null);
		UUID uUID1 = userCanonico0.getToken();
		assertEquals((-1L), uUID1.getMostSignificantBits());
	}

	@Test
	public void test04() throws Throwable {
		UUID uUID0 = new UUID(0L, 0L);
		Long long0 = new Long(0L);
		UserCanonico userCanonico0 = UserCanonico.create(uUID0, "", "", null, long0);
		UUID uUID1 = userCanonico0.getToken();
		assertEquals(0L, uUID1.getLeastSignificantBits());
	}

	@Test
	public void test05() throws Throwable {
		UUID uUID0 = new UUID(0L, 1L);
		Long long0 = new Long(0L);
		UserCanonico userCanonico0 = UserCanonico.create("", uUID0, "", "", null, long0);
		UUID uUID1 = userCanonico0.getToken();
		assertSame(uUID1, uUID0);
	}

	@Test
	public void test06() throws Throwable {
		UUID uUID0 = new UUID(0L, (-1L));
		Long long0 = new Long(0L);
		UserCanonico userCanonico0 = UserCanonico.create("", uUID0, "", "", null, long0);
		UUID uUID1 = userCanonico0.getToken();
		assertEquals(0L, uUID1.getMostSignificantBits());
	}

	@Test
	public void test07() throws Throwable {
		Long long0 = new Long(0L);
		UserCanonico userCanonico0 = UserCanonico.create("", long0);
		String string0 = userCanonico0.getPassword();
		assertNull(string0);
	}

	@Test
	public void test08() throws Throwable {
		UUID uUID0 = new UUID(0L, 0L);
		Long long0 = new Long(0L);
		UserCanonico userCanonico0 = UserCanonico.create(uUID0, "", "l", null, long0);
		String string0 = userCanonico0.getPassword();
		assertEquals("l", string0);
		assertEquals("", userCanonico0.getUsername());
	}

	@Test
	public void test09() throws Throwable {
		Long long0 = new Long(1L);
		UserCanonico userCanonico0 = UserCanonico.create("", long0);
		Long long1 = userCanonico0.getLoginTimestamp();
		assertEquals(1L, (long) long1);
	}

	@Test
	public void test10() throws Throwable {
		Long long0 = new Long(0L);
		UserCanonico userCanonico0 = UserCanonico.create("", "", null, long0);
		Long long1 = userCanonico0.getLoginTimestamp();
		assertEquals(0L, (long) long1);
	}

	@Test
	public void test11() throws Throwable {
		Long long0 = new Long((-129L));
		UserCanonico userCanonico0 = UserCanonico.create("", "", null, long0);
		Long long1 = userCanonico0.getLoginTimestamp();
		assertEquals((-129L), (long) long1);
	}

	@Test
	public void test12() throws Throwable {
		Long long0 = new Long((-769L));
		UserCanonico userCanonico0 = UserCanonico.create((UUID) null, "", "", null, long0);
		Long long1 = userCanonico0.getLoginTimestamp();
		assertEquals((-769L), (long) long1);
	}

	@Test
	public void test13() throws Throwable {
		Long long0 = new Long(0L);
		UserCanonico userCanonico0 = UserCanonico.create("", "", null, long0);
		String string0 = userCanonico0.getId();
		assertNull(string0);
	}

	@Test
	public void test14() throws Throwable {
		UUID uUID0 = new UUID(0L, 0L);
		Long long0 = new Long(0L);
		UserCanonico userCanonico0 = UserCanonico.create("T", uUID0, "", "", null, long0);
		String string0 = userCanonico0.getId();
		assertEquals("", userCanonico0.getPassword());
		assertEquals("", userCanonico0.getUsername());
		assertEquals("T", string0);
	}

	@Test
	public void test15() throws Throwable {
		Long long0 = new Long(0L);
		UserCanonico userCanonico0 = UserCanonico.create("", (UUID) null, "", "", null, long0);
		UUID uUID0 = userCanonico0.getToken();
		assertNull(uUID0);
	}

	@Test
	public void test16() throws Throwable {
		UUID uUID0 = new UUID(0L, 0L);
		Long long0 = new Long(0L);
		UserCanonico userCanonico0 = UserCanonico.create(uUID0, "", "", null, long0);
		String string0 = userCanonico0.toString();
		assertEquals(
				"UserCanonico [id=null, token=00000000-0000-0000-0000-000000000000, username=, password=, roles=[], loginTimestamp=0]",
				string0);
	}

	@Test
	public void test17() throws Throwable {
		UUID uUID0 = new UUID(0L, 0L);
		UserCanonico userCanonico0 = UserCanonico.create(uUID0, "", "", null, (Long) null);
		Long long0 = userCanonico0.getLoginTimestamp();
		assertNull(long0);
	}

	@Test
	public void test18() throws Throwable {
		Long long0 = new Long(0L);
		UserCanonico userCanonico0 = UserCanonico.create("", (UUID) null, "", "", null, long0);
		String string0 = userCanonico0.getId();
		assertEquals("", string0);
	}

	@Test
	public void test19() throws Throwable {
		UUID uUID0 = new UUID(0L, 0L);
		Long long0 = new Long(0L);
		UserCanonico userCanonico0 = UserCanonico.create(uUID0, "", "", null, long0);
		String string0 = userCanonico0.getPassword();
		assertEquals("", string0);
	}

	@Test
	public void test20() throws Throwable {
		UserCanonico userCanonico0 = UserCanonico.create((String) null, "", null, (Long) null);
		String string0 = userCanonico0.getUsername();
		assertNull(string0);
	}
}

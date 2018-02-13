package com.github.jimsp.gate.canonial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class RoleCanonico_ESTest {

	@Test
	public void test00() throws Throwable {
		Boolean boolean0 = new Boolean("");
		LinkedList<PermissionCanonico> linkedList0 = new LinkedList<PermissionCanonico>();
		LinkedList<RoleCanonico> linkedList1 = new LinkedList<RoleCanonico>();
		RoleCanonico roleCanonico0 = RoleCanonico.create("", "", boolean0, (Boolean) null, linkedList0, linkedList1);
		assertFalse(roleCanonico0.getAssignable());
	}

	@Test
	public void test01() throws Throwable {
		Boolean boolean0 = Boolean.TRUE;
		LinkedList<RoleCanonico> linkedList0 = new LinkedList<RoleCanonico>();
		RoleCanonico roleCanonico0 = RoleCanonico.create((String) null, (String) null, boolean0, boolean0,
				(List<PermissionCanonico>) null, linkedList0);
		List<PermissionCanonico> list0 = roleCanonico0.getPermissions();
		assertNull(list0);
	}

	@Test
	public void test02() throws Throwable {
		LinkedList<PermissionCanonico> linkedList0 = new LinkedList<PermissionCanonico>();
		LinkedList<RoleCanonico> linkedList1 = new LinkedList<RoleCanonico>();
		RoleCanonico roleCanonico0 = new RoleCanonico("", "", (Boolean) null, (Boolean) null, linkedList0, linkedList1);
		OperationCanonico operationCanonico0 = new OperationCanonico("", "", (Boolean) null);
		ResourceCanonico resourceCanonico0 = ResourceCanonico.create("", (Boolean) null, (Boolean) null);
		PermissionCanonico permissionCanonico0 = new PermissionCanonico("", "", operationCanonico0, resourceCanonico0);
		linkedList0.offerFirst(permissionCanonico0);
		List<PermissionCanonico> list0 = roleCanonico0.getPermissions();
		assertEquals(1, list0.size());
	}

	@Test
	public void test03() throws Throwable {
		Boolean boolean0 = Boolean.TRUE;
		LinkedList<PermissionCanonico> linkedList0 = new LinkedList<PermissionCanonico>();
		LinkedList<RoleCanonico> linkedList1 = new LinkedList<RoleCanonico>();
		RoleCanonico roleCanonico0 = RoleCanonico.create("", "", boolean0, boolean0, linkedList0, linkedList1);
		Boolean boolean1 = roleCanonico0.getPermanent();
		assertTrue(boolean1);
	}

	@Test
	public void test04() throws Throwable {
		Boolean boolean0 = Boolean.valueOf("");
		LinkedList<PermissionCanonico> linkedList0 = new LinkedList<PermissionCanonico>();
		RoleCanonico roleCanonico0 = new RoleCanonico("", "", boolean0, boolean0, linkedList0,
				(List<RoleCanonico>) null);
		Boolean boolean1 = roleCanonico0.getPermanent();
		assertFalse(boolean1);
	}

	@Test
	public void test05() throws Throwable {
		Boolean boolean0 = Boolean.TRUE;
		LinkedList<PermissionCanonico> linkedList0 = new LinkedList<PermissionCanonico>();
		RoleCanonico roleCanonico0 = RoleCanonico.create((String) null, (String) null, boolean0, boolean0, linkedList0,
				(List<RoleCanonico>) null);
		String string0 = roleCanonico0.getName();
		assertNull(string0);
	}

	@Test
	public void test06() throws Throwable {
		Boolean boolean0 = new Boolean("");
		LinkedList<PermissionCanonico> linkedList0 = new LinkedList<PermissionCanonico>();
		LinkedList<RoleCanonico> linkedList1 = new LinkedList<RoleCanonico>();
		RoleCanonico roleCanonico0 = RoleCanonico.create("o", "", boolean0, boolean0, linkedList0, linkedList1);
		String string0 = roleCanonico0.getName();
		assertEquals("o", string0);
		assertEquals("", roleCanonico0.getDescription());
	}

	@Test
	public void test07() throws Throwable {
		Boolean boolean0 = Boolean.valueOf((String) null);
		LinkedList<RoleCanonico> linkedList0 = new LinkedList<RoleCanonico>();
		RoleCanonico roleCanonico0 = RoleCanonico.create((String) null, (String) null, boolean0, boolean0,
				(List<PermissionCanonico>) null, linkedList0);
		String string0 = roleCanonico0.getDescription();
		assertNull(string0);
	}

	@Test
	public void test08() throws Throwable {
		Boolean boolean0 = new Boolean("");
		LinkedList<PermissionCanonico> linkedList0 = new LinkedList<PermissionCanonico>();
		LinkedList<RoleCanonico> linkedList1 = new LinkedList<RoleCanonico>();
		RoleCanonico roleCanonico0 = RoleCanonico.create("", "r", boolean0, boolean0, linkedList0, linkedList1);
		String string0 = roleCanonico0.getDescription();
		assertEquals("", roleCanonico0.getName());
		assertEquals("r", string0);
	}

	@Test
	public void test09() throws Throwable {
		Boolean boolean0 = Boolean.valueOf("");
		LinkedList<PermissionCanonico> linkedList0 = new LinkedList<PermissionCanonico>();
		RoleCanonico roleCanonico0 = new RoleCanonico("", "", boolean0, boolean0, linkedList0,
				(List<RoleCanonico>) null);
		List<RoleCanonico> list0 = roleCanonico0.getChildRoleNames();
		assertNull(list0);
	}

	@Test
	public void test10() throws Throwable {
		Boolean boolean0 = new Boolean(false);
		LinkedList<RoleCanonico> linkedList0 = new LinkedList<RoleCanonico>();
		RoleCanonico roleCanonico0 = new RoleCanonico("", "", boolean0, boolean0, (List<PermissionCanonico>) null,
				linkedList0);
		linkedList0.add(roleCanonico0);
		List<RoleCanonico> list0 = roleCanonico0.getChildRoleNames();
		assertFalse(list0.isEmpty());
	}

	@Test
	public void test11() throws Throwable {
		LinkedList<PermissionCanonico> linkedList0 = new LinkedList<PermissionCanonico>();
		LinkedList<RoleCanonico> linkedList1 = new LinkedList<RoleCanonico>();
		RoleCanonico roleCanonico0 = RoleCanonico.create("", "", (Boolean) null, (Boolean) null, linkedList0,
				linkedList1);
		Boolean boolean0 = roleCanonico0.getAssignable();
		assertNull(boolean0);
	}

	@Test
	public void test12() throws Throwable {
		Boolean boolean0 = Boolean.valueOf("");
		LinkedList<PermissionCanonico> linkedList0 = new LinkedList<PermissionCanonico>();
		RoleCanonico roleCanonico0 = new RoleCanonico("", "", boolean0, boolean0, linkedList0,
				(List<RoleCanonico>) null);
		Boolean boolean1 = roleCanonico0.getAssignable();
		assertFalse(boolean1);
	}

	@Test
	public void test13() throws Throwable {
		LinkedList<PermissionCanonico> linkedList0 = new LinkedList<PermissionCanonico>();
		LinkedList<RoleCanonico> linkedList1 = new LinkedList<RoleCanonico>();
		RoleCanonico roleCanonico0 = new RoleCanonico("", "", (Boolean) null, (Boolean) null, linkedList0, linkedList1);
		List<RoleCanonico> list0 = roleCanonico0.getChildRoleNames();
		assertTrue(list0.isEmpty());
	}

	@Test
	public void test14() throws Throwable {
		Boolean boolean0 = Boolean.TRUE;
		LinkedList<RoleCanonico> linkedList0 = new LinkedList<RoleCanonico>();
		RoleCanonico roleCanonico0 = RoleCanonico.create((String) null, (String) null, boolean0, boolean0,
				(List<PermissionCanonico>) null, linkedList0);
		Boolean boolean1 = roleCanonico0.getAssignable();
		assertTrue(boolean1);
	}

	@Test
	public void test15() throws Throwable {
		LinkedList<PermissionCanonico> linkedList0 = new LinkedList<PermissionCanonico>();
		LinkedList<RoleCanonico> linkedList1 = new LinkedList<RoleCanonico>();
		RoleCanonico roleCanonico0 = new RoleCanonico("", "", (Boolean) null, (Boolean) null, linkedList0, linkedList1);
		Boolean boolean0 = roleCanonico0.getPermanent();
		assertNull(boolean0);
	}

	@Test
	public void test16() throws Throwable {
		LinkedList<PermissionCanonico> linkedList0 = new LinkedList<PermissionCanonico>();
		LinkedList<RoleCanonico> linkedList1 = new LinkedList<RoleCanonico>();
		RoleCanonico roleCanonico0 = new RoleCanonico("", "", (Boolean) null, (Boolean) null, linkedList0, linkedList1);
		List<PermissionCanonico> list0 = roleCanonico0.getPermissions();
		assertTrue(list0.isEmpty());
	}

	@Test
	public void test17() throws Throwable {
		LinkedList<PermissionCanonico> linkedList0 = new LinkedList<PermissionCanonico>();
		LinkedList<RoleCanonico> linkedList1 = new LinkedList<RoleCanonico>();
		RoleCanonico roleCanonico0 = new RoleCanonico("", "", (Boolean) null, (Boolean) null, linkedList0, linkedList1);
		String string0 = roleCanonico0.getDescription();
		assertEquals("", string0);
	}

	@Test
	public void test18() throws Throwable {
		LinkedList<PermissionCanonico> linkedList0 = new LinkedList<PermissionCanonico>();
		LinkedList<RoleCanonico> linkedList1 = new LinkedList<RoleCanonico>();
		RoleCanonico roleCanonico0 = new RoleCanonico("", "", (Boolean) null, (Boolean) null, linkedList0, linkedList1);
		String string0 = roleCanonico0.getName();
		assertEquals("", string0);
	}
}

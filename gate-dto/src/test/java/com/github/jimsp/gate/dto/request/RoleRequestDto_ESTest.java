package com.github.jimsp.gate.dto.request;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class RoleRequestDto_ESTest {

	@Test
	public void test00() throws Throwable {
		Boolean boolean0 = Boolean.TRUE;
		LinkedList<RoleRequestDto> linkedList0 = new LinkedList<RoleRequestDto>();
		RoleRequestDto roleRequestDto0 = RoleRequestDto.create("", "", boolean0, boolean0,
				(List<PermissionRequestDto>) null, linkedList0);
		List<PermissionRequestDto> list0 = roleRequestDto0.getPermissions();
		assertNull(list0);
	}

	@Test
	public void test01() throws Throwable {
		Boolean boolean0 = Boolean.valueOf(false);
		LinkedList<PermissionRequestDto> linkedList0 = new LinkedList<PermissionRequestDto>();
		RoleRequestDto roleRequestDto0 = RoleRequestDto.create("", "", boolean0, boolean0, linkedList0,
				(List<RoleRequestDto>) null);
		linkedList0.add((PermissionRequestDto) null);
		List<PermissionRequestDto> list0 = roleRequestDto0.getPermissions();
		assertEquals(1, list0.size());
	}

	@Test
	public void test02() throws Throwable {
		Boolean boolean0 = Boolean.FALSE;
		LinkedList<PermissionRequestDto> linkedList0 = new LinkedList<PermissionRequestDto>();
		LinkedList<RoleRequestDto> linkedList1 = new LinkedList<RoleRequestDto>();
		RoleRequestDto roleRequestDto0 = RoleRequestDto.create("", "", boolean0, (Boolean) null, linkedList0,
				linkedList1);
		Boolean boolean1 = roleRequestDto0.getPermanent();
		assertNull(boolean1);
	}

	@Test
	public void test03() throws Throwable {
		Boolean boolean0 = Boolean.valueOf("");
		LinkedList<PermissionRequestDto> linkedList0 = new LinkedList<PermissionRequestDto>();
		RoleRequestDto roleRequestDto0 = new RoleRequestDto("", "", boolean0, boolean0, linkedList0,
				(List<RoleRequestDto>) null);
		Boolean boolean1 = roleRequestDto0.getPermanent();
		assertFalse(boolean1);
	}

	@Test
	public void test04() throws Throwable {
		Boolean boolean0 = Boolean.valueOf(true);
		LinkedList<PermissionRequestDto> linkedList0 = new LinkedList<PermissionRequestDto>();
		LinkedList<RoleRequestDto> linkedList1 = new LinkedList<RoleRequestDto>();
		RoleRequestDto roleRequestDto0 = new RoleRequestDto((String) null, "", boolean0, boolean0, linkedList0,
				linkedList1);
		String string0 = roleRequestDto0.getName();
		assertNull(string0);
	}

	@Test
	public void test05() throws Throwable {
		LinkedList<PermissionRequestDto> linkedList0 = new LinkedList<PermissionRequestDto>();
		LinkedList<RoleRequestDto> linkedList1 = new LinkedList<RoleRequestDto>();
		RoleRequestDto roleRequestDto0 = new RoleRequestDto("q", "", (Boolean) null, (Boolean) null, linkedList0,
				linkedList1);
		String string0 = roleRequestDto0.getName();
		assertEquals("q", string0);
		assertEquals("", roleRequestDto0.getDescription());
	}

	@Test
	public void test06() throws Throwable {
		Boolean boolean0 = new Boolean(true);
		LinkedList<RoleRequestDto> linkedList0 = new LinkedList<RoleRequestDto>();
		RoleRequestDto roleRequestDto0 = new RoleRequestDto((String) null, (String) null, boolean0, boolean0,
				(List<PermissionRequestDto>) null, linkedList0);
		String string0 = roleRequestDto0.getDescription();
		assertNull(string0);
	}

	public void test07() throws Throwable {
		Boolean boolean0 = Boolean.valueOf("");
		LinkedList<PermissionRequestDto> linkedList0 = new LinkedList<PermissionRequestDto>();
		RoleRequestDto roleRequestDto0 = new RoleRequestDto("", "Q", boolean0, boolean0, linkedList0,
				(List<RoleRequestDto>) null);
		String string0 = roleRequestDto0.getDescription();
		assertEquals("", roleRequestDto0.getName());
		assertEquals("Q", string0);
	}

	public void test08() throws Throwable {
		Boolean boolean0 = Boolean.TRUE;
		LinkedList<PermissionRequestDto> linkedList0 = new LinkedList<PermissionRequestDto>();
		RoleRequestDto roleRequestDto0 = new RoleRequestDto("", "", boolean0, boolean0, linkedList0,
				(List<RoleRequestDto>) null);
		List<RoleRequestDto> list0 = roleRequestDto0.getChildRoleNames();
		assertNull(list0);
	}

	public void test09() throws Throwable {
		Boolean boolean0 = Boolean.valueOf("");
		LinkedList<PermissionRequestDto> linkedList0 = new LinkedList<PermissionRequestDto>();
		LinkedList<RoleRequestDto> linkedList1 = new LinkedList<RoleRequestDto>();
		RoleRequestDto roleRequestDto0 = new RoleRequestDto("", "", boolean0, boolean0, linkedList0, linkedList1);
		linkedList1.add(roleRequestDto0);
		List<RoleRequestDto> list0 = roleRequestDto0.getChildRoleNames();
		assertEquals(1, list0.size());
	}

	public void test10() throws Throwable {
		Boolean boolean0 = new Boolean(true);
		LinkedList<PermissionRequestDto> linkedList0 = new LinkedList<PermissionRequestDto>();
		LinkedList<RoleRequestDto> linkedList1 = new LinkedList<RoleRequestDto>();
		RoleRequestDto roleRequestDto0 = RoleRequestDto.create("", "", boolean0, boolean0, linkedList0, linkedList1);
		Boolean boolean1 = roleRequestDto0.getAssignable();
		assertTrue(boolean1);
	}

	public void test11() throws Throwable {
		Boolean boolean0 = Boolean.valueOf("");
		LinkedList<PermissionRequestDto> linkedList0 = new LinkedList<PermissionRequestDto>();
		RoleRequestDto roleRequestDto0 = new RoleRequestDto("", "", boolean0, boolean0, linkedList0,
				(List<RoleRequestDto>) null);
		Boolean boolean1 = roleRequestDto0.getAssignable();
		assertFalse(boolean1);
	}

	public void test12() throws Throwable {
		Boolean boolean0 = Boolean.valueOf(false);
		LinkedList<PermissionRequestDto> linkedList0 = new LinkedList<PermissionRequestDto>();
		RoleRequestDto roleRequestDto0 = RoleRequestDto.create("", "", boolean0, boolean0, linkedList0,
				(List<RoleRequestDto>) null);
		List<PermissionRequestDto> list0 = roleRequestDto0.getPermissions();
		assertTrue(list0.isEmpty());
	}

	public void test13() throws Throwable {
		Boolean boolean0 = Boolean.TRUE;
		LinkedList<PermissionRequestDto> linkedList0 = new LinkedList<PermissionRequestDto>();
		RoleRequestDto roleRequestDto0 = new RoleRequestDto("", "", boolean0, boolean0, linkedList0,
				(List<RoleRequestDto>) null);
		Boolean boolean1 = roleRequestDto0.getPermanent();
		assertTrue(boolean1);
	}

	public void test14() throws Throwable {
		Boolean boolean0 = Boolean.valueOf(false);
		LinkedList<PermissionRequestDto> linkedList0 = new LinkedList<PermissionRequestDto>();
		RoleRequestDto roleRequestDto0 = RoleRequestDto.create("", "", boolean0, boolean0, linkedList0,
				(List<RoleRequestDto>) null);
		String string0 = roleRequestDto0.getName();
		assertEquals("", string0);
	}

	public void test15() throws Throwable {
		LinkedList<PermissionRequestDto> linkedList0 = new LinkedList<PermissionRequestDto>();
		LinkedList<RoleRequestDto> linkedList1 = new LinkedList<RoleRequestDto>();
		RoleRequestDto roleRequestDto0 = new RoleRequestDto("", "", (Boolean) null, (Boolean) null, linkedList0,
				linkedList1);
		List<RoleRequestDto> list0 = roleRequestDto0.getChildRoleNames();
		assertTrue(list0.isEmpty());
	}

	public void test16() throws Throwable {
		LinkedList<PermissionRequestDto> linkedList0 = new LinkedList<PermissionRequestDto>();
		LinkedList<RoleRequestDto> linkedList1 = new LinkedList<RoleRequestDto>();
		RoleRequestDto roleRequestDto0 = new RoleRequestDto("", "", (Boolean) null, (Boolean) null, linkedList0,
				linkedList1);
		Boolean boolean0 = roleRequestDto0.getAssignable();
		assertNull(boolean0);
	}

	public void test17() throws Throwable {
		Boolean boolean0 = Boolean.valueOf(false);
		LinkedList<PermissionRequestDto> linkedList0 = new LinkedList<PermissionRequestDto>();
		RoleRequestDto roleRequestDto0 = RoleRequestDto.create("", "", boolean0, boolean0, linkedList0,
				(List<RoleRequestDto>) null);
		String string0 = roleRequestDto0.getDescription();
		assertEquals("", string0);
	}
}

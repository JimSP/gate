package com.github.jimsp.gate.canonial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class PermissionCanonico_ESTest {

	@Test
	public void test00() throws Throwable {
		PermissionCanonico permissionCanonico0 = PermissionCanonico.create("", "", (OperationCanonico) null,
				(ResourceCanonico) null);
		permissionCanonico0.getResource();
		assertFalse(permissionCanonico0.getPermanent());
	}

	@Test
	public void test01() throws Throwable {
		Boolean boolean0 = Boolean.valueOf("");
		OperationCanonico operationCanonico0 = new OperationCanonico("", "", boolean0);
		ResourceCanonico resourceCanonico0 = new ResourceCanonico("", boolean0, boolean0);
		PermissionCanonico permissionCanonico0 = PermissionCanonico.create("", "", operationCanonico0,
				resourceCanonico0);
		permissionCanonico0.getOperation();
		assertFalse(permissionCanonico0.getPermanent());
	}

	@Test
	public void test02() throws Throwable {
		Boolean boolean0 = Boolean.valueOf("");
		OperationCanonico operationCanonico0 = new OperationCanonico("", "", boolean0);
		ResourceCanonico resourceCanonico0 = new ResourceCanonico("", boolean0, boolean0);
		PermissionCanonico permissionCanonico0 = PermissionCanonico.create("k", "", operationCanonico0,
				resourceCanonico0);
		String string0 = permissionCanonico0.getName();
		assertEquals("", permissionCanonico0.getDescription());
		assertEquals("k", string0);
		assertFalse(permissionCanonico0.getPermanent());
	}

	@Test
	public void test03() throws Throwable {
		Boolean boolean0 = Boolean.valueOf("");
		OperationCanonico operationCanonico0 = new OperationCanonico("", "", boolean0);
		ResourceCanonico resourceCanonico0 = new ResourceCanonico("", boolean0, boolean0);
		PermissionCanonico permissionCanonico0 = PermissionCanonico.create("", "k", operationCanonico0,
				resourceCanonico0);
		String string0 = permissionCanonico0.getDescription();
		assertFalse(permissionCanonico0.getPermanent());
		assertEquals("k", string0);
		assertEquals("", permissionCanonico0.getName());
	}

	@Test
	public void test04() throws Throwable {
		Boolean boolean0 = Boolean.valueOf("");
		OperationCanonico operationCanonico0 = new OperationCanonico("", "", boolean0);
		ResourceCanonico resourceCanonico0 = ResourceCanonico.create("", boolean0, boolean0);
		PermissionCanonico permissionCanonico0 = PermissionCanonico.create("", "", operationCanonico0,
				resourceCanonico0);
		permissionCanonico0.getDescription();
		assertFalse(permissionCanonico0.getPermanent());
	}

	@Test
	public void test05() throws Throwable {
		Boolean boolean0 = Boolean.valueOf(true);
		OperationCanonico operationCanonico0 = new OperationCanonico((String) null, (String) null, boolean0);
		ResourceCanonico resourceCanonico0 = ResourceCanonico.create((String) null, boolean0, boolean0);
		PermissionCanonico permissionCanonico0 = PermissionCanonico.create((String) null, (String) null,
				operationCanonico0, resourceCanonico0);
		permissionCanonico0.getName();
		assertFalse(permissionCanonico0.getPermanent());
	}

	@Test
	public void test06() throws Throwable {
		Boolean boolean0 = Boolean.valueOf(true);
		OperationCanonico operationCanonico0 = new OperationCanonico((String) null, (String) null, boolean0);
		ResourceCanonico resourceCanonico0 = ResourceCanonico.create((String) null, boolean0, boolean0);
		PermissionCanonico permissionCanonico0 = new PermissionCanonico("", "", operationCanonico0, resourceCanonico0);
		permissionCanonico0.getResource();
		assertFalse(permissionCanonico0.getPermanent());
	}

	@Test
	public void test07() throws Throwable {
		Boolean boolean0 = new Boolean("");
		OperationCanonico operationCanonico0 = OperationCanonico.create("", "", boolean0);
		ResourceCanonico resourceCanonico0 = ResourceCanonico.create((String) null, boolean0, (Boolean) null);
		PermissionCanonico permissionCanonico0 = new PermissionCanonico((String) null, (String) null,
				operationCanonico0, resourceCanonico0);
		permissionCanonico0.getDescription();
		assertFalse(permissionCanonico0.getPermanent());
	}

	@Test
	public void test08() throws Throwable {
		Boolean boolean0 = Boolean.valueOf(true);
		OperationCanonico operationCanonico0 = new OperationCanonico((String) null, (String) null, boolean0);
		ResourceCanonico resourceCanonico0 = ResourceCanonico.create((String) null, boolean0, boolean0);
		PermissionCanonico permissionCanonico0 = new PermissionCanonico("", "", operationCanonico0, resourceCanonico0);
		Boolean boolean1 = permissionCanonico0.getPermanent();
		assertFalse(boolean1);
	}

	@Test
	public void test09() throws Throwable {
		Boolean boolean0 = Boolean.valueOf(true);
		OperationCanonico operationCanonico0 = new OperationCanonico((String) null, (String) null, boolean0);
		ResourceCanonico resourceCanonico0 = ResourceCanonico.create((String) null, boolean0, boolean0);
		PermissionCanonico permissionCanonico0 = new PermissionCanonico("", "", operationCanonico0, resourceCanonico0);
		permissionCanonico0.getName();
		assertFalse(permissionCanonico0.getPermanent());
	}

	@Test
	public void test10() throws Throwable {
		Boolean boolean0 = Boolean.valueOf(false);
		ResourceCanonico resourceCanonico0 = new ResourceCanonico("", boolean0, boolean0);
		PermissionCanonico permissionCanonico0 = new PermissionCanonico("", "", (OperationCanonico) null,
				resourceCanonico0);
		permissionCanonico0.getOperation();
		assertFalse(permissionCanonico0.getPermanent());
	}
}

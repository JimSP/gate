package com.github.jimsp.gate.dto.request;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PermissionRequestDto_ESTest {

	@Test
	public void test00() throws Throwable {
		Boolean boolean0 = new Boolean(false);
		OperationRequestDto operationRequestDto0 = OperationRequestDto.create((String) null, (String) null, boolean0);
		ResourceRequestDto resourceRequestDto0 = new ResourceRequestDto((String) null, boolean0, boolean0);
		PermissionRequestDto permissionRequestDto0 = new PermissionRequestDto((String) null, (String) null, boolean0,
				operationRequestDto0, resourceRequestDto0);
		ResourceRequestDto resourceRequestDto1 = permissionRequestDto0.getResource();
		assertSame(resourceRequestDto1, resourceRequestDto0);
	}

	@Test
	public void test01() throws Throwable {
		Boolean boolean0 = Boolean.valueOf(true);
		OperationRequestDto operationRequestDto0 = OperationRequestDto.create("", "", boolean0);
		ResourceRequestDto resourceRequestDto0 = new ResourceRequestDto("", boolean0, boolean0);
		PermissionRequestDto permissionRequestDto0 = PermissionRequestDto.create("", "", boolean0, operationRequestDto0,
				resourceRequestDto0);
		Boolean boolean1 = permissionRequestDto0.getPermanent();
		assertTrue(boolean1);
	}

	@Test
	public void test02() throws Throwable {
		Boolean boolean0 = Boolean.FALSE;
		ResourceRequestDto resourceRequestDto0 = new ResourceRequestDto("", boolean0, boolean0);
		PermissionRequestDto permissionRequestDto0 = new PermissionRequestDto("", "", boolean0,
				(OperationRequestDto) null, resourceRequestDto0);
		Boolean boolean1 = permissionRequestDto0.getPermanent();
		assertFalse(boolean1);
	}

	@Test
	public void test03() throws Throwable {
		OperationRequestDto operationRequestDto0 = OperationRequestDto.create((String) null, "", (Boolean) null);
		PermissionRequestDto permissionRequestDto0 = new PermissionRequestDto("", "", (Boolean) null,
				operationRequestDto0, (ResourceRequestDto) null);
		OperationRequestDto operationRequestDto1 = permissionRequestDto0.getOperation();
		assertSame(operationRequestDto1, operationRequestDto0);
	}

	@Test
	public void test04() throws Throwable {
		OperationRequestDto operationRequestDto0 = OperationRequestDto.create((String) null, "", (Boolean) null);
		PermissionRequestDto permissionRequestDto0 = new PermissionRequestDto("r", "", (Boolean) null,
				operationRequestDto0, (ResourceRequestDto) null);
		String string0 = permissionRequestDto0.getName();
		assertEquals("", permissionRequestDto0.getDescription());
		assertEquals("r", string0);
	}

	@Test
	public void test05() throws Throwable {
		Boolean boolean0 = new Boolean(false);
		OperationRequestDto operationRequestDto0 = OperationRequestDto.create("", "", boolean0);
		PermissionRequestDto permissionRequestDto0 = PermissionRequestDto.create("", "", boolean0, operationRequestDto0,
				(ResourceRequestDto) null);
		String string0 = permissionRequestDto0.getName();
		assertEquals("", string0);
	}

	@Test
	public void test06() throws Throwable {
		Boolean boolean0 = Boolean.valueOf(true);
		OperationRequestDto operationRequestDto0 = OperationRequestDto.create("", "", boolean0);
		ResourceRequestDto resourceRequestDto0 = new ResourceRequestDto("", boolean0, boolean0);
		PermissionRequestDto permissionRequestDto0 = PermissionRequestDto.create("", "A", boolean0,
				operationRequestDto0, resourceRequestDto0);
		String string0 = permissionRequestDto0.getDescription();
		assertEquals("A", string0);
		assertEquals("", permissionRequestDto0.getName());
	}

	@Test
	public void test07() throws Throwable {
		Boolean boolean0 = new Boolean("");
		OperationRequestDto operationRequestDto0 = OperationRequestDto.create("", "", boolean0);
		ResourceRequestDto resourceRequestDto0 = ResourceRequestDto.create("", boolean0, boolean0);
		PermissionRequestDto permissionRequestDto0 = PermissionRequestDto.create("", "", boolean0, operationRequestDto0,
				resourceRequestDto0);
		String string0 = permissionRequestDto0.getDescription();
		assertEquals("", string0);
	}

	@Test
	public void test08() throws Throwable {
		OperationRequestDto operationRequestDto0 = OperationRequestDto.create((String) null, "", (Boolean) null);
		PermissionRequestDto permissionRequestDto0 = new PermissionRequestDto("", "", (Boolean) null,
				operationRequestDto0, (ResourceRequestDto) null);
		Boolean boolean0 = permissionRequestDto0.getPermanent();
		assertNull(boolean0);
	}

	@Test
	public void test09() throws Throwable {
		OperationRequestDto operationRequestDto0 = OperationRequestDto.create((String) null, "", (Boolean) null);
		PermissionRequestDto permissionRequestDto0 = new PermissionRequestDto("", "", (Boolean) null,
				operationRequestDto0, (ResourceRequestDto) null);
		ResourceRequestDto resourceRequestDto0 = permissionRequestDto0.getResource();
		assertNull(resourceRequestDto0);
	}

	@Test
	public void test10() throws Throwable {
		Boolean boolean0 = Boolean.valueOf((String) null);
		OperationRequestDto operationRequestDto0 = OperationRequestDto.create((String) null, (String) null, boolean0);
		ResourceRequestDto resourceRequestDto0 = new ResourceRequestDto("", (Boolean) null, boolean0);
		PermissionRequestDto permissionRequestDto0 = new PermissionRequestDto((String) null, (String) null, boolean0,
				operationRequestDto0, resourceRequestDto0);
		String string0 = permissionRequestDto0.getName();
		assertNull(string0);
	}

	@Test
	public void test11() throws Throwable {
		Boolean boolean0 = Boolean.FALSE;
		ResourceRequestDto resourceRequestDto0 = new ResourceRequestDto("", boolean0, boolean0);
		PermissionRequestDto permissionRequestDto0 = new PermissionRequestDto("", "", boolean0,
				(OperationRequestDto) null, resourceRequestDto0);
		OperationRequestDto operationRequestDto0 = permissionRequestDto0.getOperation();
		assertNull(operationRequestDto0);
	}

	@Test
	public void test12() throws Throwable {
		Boolean boolean0 = new Boolean((String) null);
		OperationRequestDto operationRequestDto0 = OperationRequestDto.create("", (String) null, boolean0);
		ResourceRequestDto resourceRequestDto0 = ResourceRequestDto.create("", boolean0, boolean0);
		PermissionRequestDto permissionRequestDto0 = PermissionRequestDto.create("", (String) null, boolean0,
				operationRequestDto0, resourceRequestDto0);
		String string0 = permissionRequestDto0.getDescription();
		assertNull(string0);
	}
}

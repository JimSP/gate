/*
 * This file was automatically generated by EvoSuite
 * Tue Feb 13 16:48:20 BRST 2018
 */

package com.github.jimsp.gate.dto.response;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import com.github.jimsp.gate.dto.request.OperationRequestDto;

public class OperationResponseDto_ESTest {

	@Test
	public void test0() throws Throwable {
		OperationResponseDto operationResponseDto0 = new OperationResponseDto((OperationRequestDto) null);
		OperationRequestDto operationRequestDto0 = operationResponseDto0.getOperationDtoRequest();
		assertNull(operationRequestDto0);
	}

	@Test
	public void test1() throws Throwable {
		Boolean boolean0 = new Boolean("");
		OperationRequestDto operationRequestDto0 = OperationRequestDto.create("", "", boolean0);
		OperationResponseDto operationResponseDto0 = OperationResponseDto.create(operationRequestDto0);
		OperationRequestDto operationRequestDto1 = operationResponseDto0.getOperationDtoRequest();
		assertSame(operationRequestDto0, operationRequestDto1);
	}
}

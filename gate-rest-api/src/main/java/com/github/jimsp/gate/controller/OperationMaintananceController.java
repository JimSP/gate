package com.github.jimsp.gate.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.jimsp.gate.canonial.OperationCanonico;
import com.github.jimsp.gate.converter.OperationRequestDtoToOperationCanonicoConverter;
import com.github.jimsp.gate.dto.request.OperationRequestDto;
import com.github.jimsp.gate.dto.response.OperationResponseDto;
import com.github.jimsp.gate.hadle.GateRestHandle;
import com.github.jimsp.gate.interfaces.OperationMaintananceInterface;
import com.github.jimsp.gate.remote.RbacGateOperationRemote;

@RestController(GateRestHandle.OPERATION_PATH)
public class OperationMaintananceController implements OperationMaintananceInterface{

	@Autowired
	private RbacGateOperationRemote rbacOperationRemote;

	@Autowired
	private OperationRequestDtoToOperationCanonicoConverter operationRequestDtoToOperationCanonicoConverter;

	@Override
	@PostMapping(path = "/save", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody OperationResponseDto save(@Valid @RequestBody final OperationRequestDto operationRequestDto) {
		final OperationCanonico operationCanonico = operationRequestDtoToOperationCanonicoConverter.convert(operationRequestDto);
		rbacOperationRemote.save(operationCanonico);
		return OperationResponseDto.create(operationRequestDto);
	}

	@Override
	@DeleteMapping(path = "/remove", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody OperationResponseDto remove(@Valid @RequestBody final OperationRequestDto operationRequestDto) {
		final OperationCanonico operationCanonico = operationRequestDtoToOperationCanonicoConverter.convert(operationRequestDto);
		rbacOperationRemote.remove(operationCanonico);
		return OperationResponseDto.create(operationRequestDto);
	}

	@Override
	@GetMapping(path = "/", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody List<String> findAll() {
		return rbacOperationRemote //
				.findAll() //
				.parallelStream() //
				.map(operationCanonico -> operationCanonico.getName()) //
				.collect(Collectors.toList());
	}
	
	@Override
	@GetMapping(path = "/exist", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody Boolean existName(
			@RequestParam(name = "name", required = true) final String name) {
		return rbacOperationRemote.findByName(OperationCanonico.create(name, null, null)) != null;
	}
}

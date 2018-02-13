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

import com.github.jimsp.gate.canonial.PermissionCanonico;
import com.github.jimsp.gate.converter.PermissionRequestDtoToPermissionCanonicoConverter;
import com.github.jimsp.gate.dto.request.PermissionRequestDto;
import com.github.jimsp.gate.dto.response.PermissionResponseDto;
import com.github.jimsp.gate.hadle.GateRestHandle;
import com.github.jimsp.gate.interfaces.PermissionMaintananceInterface;
import com.github.jimsp.gate.remote.RbacGatePermissionRemote;

@RestController(GateRestHandle.PERMISSION_PATH)
public class PermissionMaintananceController implements PermissionMaintananceInterface {

	@Autowired
	private RbacGatePermissionRemote rbacGatePermissionRemote;

	@Autowired
	private PermissionRequestDtoToPermissionCanonicoConverter permissionRequestDtoToPermissionCanonicoConverter;

	@Override
	@PostMapping(path = "/save", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody PermissionResponseDto save(
			@Valid @RequestBody final PermissionRequestDto permissionRequestDto) {
		final PermissionCanonico permissionCanonico = permissionRequestDtoToPermissionCanonicoConverter
				.convert(permissionRequestDto);
		rbacGatePermissionRemote.save(permissionCanonico);
		return PermissionResponseDto.create(permissionRequestDto);
	}

	@Override
	@DeleteMapping(path = "/remove", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody PermissionResponseDto remove(
			@Valid @RequestBody final PermissionRequestDto permissionRequestDto) {
		final PermissionCanonico permissionCanonico = permissionRequestDtoToPermissionCanonicoConverter
				.convert(permissionRequestDto);
		rbacGatePermissionRemote.remove(permissionCanonico);
		return PermissionResponseDto.create(permissionRequestDto);
	}

	@Override
	@GetMapping(path = "/", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody List<String> findAll() {
		return rbacGatePermissionRemote //
				.findAll() //
				.parallelStream() //
				.map(permissionCanonico -> permissionCanonico.getName()) //
				.collect(Collectors.toList());
	}

	@Override
	@GetMapping(path = "/exist", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody Boolean existName(@RequestParam(name = "name", required = true) final String name) {
		return rbacGatePermissionRemote.findByName(PermissionCanonico.create(name, null, null, null)) != null;
	}
}

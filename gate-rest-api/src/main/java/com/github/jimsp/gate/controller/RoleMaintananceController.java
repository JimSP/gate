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

import com.github.jimsp.gate.canonial.RoleCanonico;
import com.github.jimsp.gate.converter.RoleRequestDtoToRoleCanonicoConverter;
import com.github.jimsp.gate.dto.request.RoleRequestDto;
import com.github.jimsp.gate.dto.response.RoleResponseDto;
import com.github.jimsp.gate.hadle.GateRestHandle;
import com.github.jimsp.gate.interfaces.RoleMaintananceInterface;
import com.github.jimsp.gate.remote.RbacGateRoleRemote;

@RestController(GateRestHandle.ROLE_PATH)
public class RoleMaintananceController implements RoleMaintananceInterface {
	
	@Autowired
	private RbacGateRoleRemote rbacGateRoleRemote;

	@Autowired
	private RoleRequestDtoToRoleCanonicoConverter roleRequestDtoToRoleCanonicoConverter;

	@Override
	@PostMapping(path = "/save", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody RoleResponseDto save(@Valid @RequestBody final RoleRequestDto roleRequestDto) {
		final RoleCanonico resourceCanonico = roleRequestDtoToRoleCanonicoConverter
				.convert(roleRequestDto);
		rbacGateRoleRemote.save(resourceCanonico);
		return RoleResponseDto.create(roleRequestDto);
	}

	@Override
	@DeleteMapping(path = "/remove", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody RoleResponseDto remove(@Valid @RequestBody final RoleRequestDto resourceRequestDto) {
		final RoleCanonico roleCanonico = roleRequestDtoToRoleCanonicoConverter
				.convert(resourceRequestDto);
		rbacGateRoleRemote.remove(roleCanonico);
		return RoleResponseDto.create(resourceRequestDto);
	}

	@Override
	@GetMapping(path = "/", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody List<String> findAll() {
		return rbacGateRoleRemote //
				.findAll() //
				.parallelStream() //
				.map(permissionCanonico -> permissionCanonico.getName()) //
				.collect(Collectors.toList());
	}

	@Override
	@GetMapping(path = "/exist", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody Boolean existName(@RequestParam(name = "name", required = true) final String name) {
		return rbacGateRoleRemote.findByName(RoleCanonico.create(name, null, null, null, null, null)) != null;
	}
}

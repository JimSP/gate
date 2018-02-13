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

import com.github.jimsp.gate.canonial.UserCanonico;
import com.github.jimsp.gate.converter.UserAuthenticationRequestDtoToUserCanonicoConverter;
import com.github.jimsp.gate.dto.request.UserOperationRequestDto;
import com.github.jimsp.gate.dto.response.UserOperationResponseDto;
import com.github.jimsp.gate.hadle.GateRestHandle;
import com.github.jimsp.gate.interfaces.UserMaintenanceInterface;
import com.github.jimsp.gate.remote.LdapGateUserRemote;

@RestController(GateRestHandle.USER_PATH)
public class UserMaintenanceController implements UserMaintenanceInterface {

	@Autowired
	private LdapGateUserRemote ldapGateUserRemote;

	@Autowired
	private UserAuthenticationRequestDtoToUserCanonicoConverter userAuthenticationRequestDtoToUserCanonicoConverter;

	@Override
	@PostMapping(path = "/save", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody UserOperationResponseDto save(
			@Valid @RequestBody final UserOperationRequestDto userOperationRequestDto) {
		final UserCanonico userCanonico = userAuthenticationRequestDtoToUserCanonicoConverter
				.convert(userOperationRequestDto);
		ldapGateUserRemote.save(userCanonico);
		return UserOperationResponseDto.create(userOperationRequestDto, null);
	}

	@Override
	@DeleteMapping(path = "/remove", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody UserOperationResponseDto remove(
			@Valid @RequestBody final UserOperationRequestDto userOperationRequestDto) {
		final UserCanonico userCanonico = userAuthenticationRequestDtoToUserCanonicoConverter
				.convert(userOperationRequestDto);
		ldapGateUserRemote.remove(userCanonico);
		return UserOperationResponseDto.create(userOperationRequestDto, null);
	}

	@Override
	@GetMapping(path = "/", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody List<String> findAll() {
		return ldapGateUserRemote //
				.findAll() //
				.parallelStream() //
				.map(userCanonico -> userCanonico.getUsername()) //
				.collect(Collectors.toList());
	}

	@Override
	@GetMapping(path = "/exist", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody Boolean existName(
			@RequestParam(name = "username", required = true) final String username) {
		return ldapGateUserRemote.findByUsername(UserCanonico.create(username, null)) != null;
	}
}

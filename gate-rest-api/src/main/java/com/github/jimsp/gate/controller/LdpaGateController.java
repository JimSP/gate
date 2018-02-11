package com.github.jimsp.gate.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.jimsp.gate.canonial.UserCanonico;
import com.github.jimsp.gate.converter.RoleCanonicoToRoleDtoConverter;
import com.github.jimsp.gate.converter.UserAuthenticationRequestDtoToUserCanonicoConverter;
import com.github.jimsp.gate.dto.RoleDto;
import com.github.jimsp.gate.dto.UserOperationRequestDto;
import com.github.jimsp.gate.dto.UserOperationResponseDto;
import com.github.jimsp.gate.dto.exception.UserNotFoundException;
import com.github.jimsp.gate.dto.exception.UserNotRemovedException;
import com.github.jimsp.gate.dto.exception.UserNotSaveException;
import com.github.jimsp.gate.remote.LdpaGateRemote;
import com.github.jimsp.gate.remote.RbacGateRemote;

@RestController("/gate")
public class LdpaGateController {

	@Autowired
	private LdpaGateRemote ldpaGateRemote;

	@Autowired
	private RbacGateRemote rbacGateRemote;

	@Autowired
	private UserAuthenticationRequestDtoToUserCanonicoConverter userAuthenticationRequestDtoToUserCanonicoConverter;

	@Autowired
	private RoleCanonicoToRoleDtoConverter roleCanonicoToRoleDtoConverter;

	@PostMapping(path = "/save", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody UserOperationResponseDto save(
			@Valid @RequestBody final UserOperationRequestDto userOperationRequestDto) {
		final UserCanonico userCanonico = userAuthenticationRequestDtoToUserCanonicoConverter
				.convert(userOperationRequestDto);
		if (ldpaGateRemote.save(userCanonico)) {
			return UserOperationResponseDto.create(userOperationRequestDto, null);
		} else {
			throw new UserNotSaveException();
		}
	}

	@DeleteMapping(path = "/remove", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody UserOperationResponseDto remove(
			@Valid @RequestBody final UserOperationRequestDto userOperationRequestDto) {
		final UserCanonico userCanonico = userAuthenticationRequestDtoToUserCanonicoConverter
				.convert(userOperationRequestDto);
		if (ldpaGateRemote.remove(userCanonico)) {
			return UserOperationResponseDto.create(userOperationRequestDto, null);
		} else {
			throw new UserNotRemovedException();
		}
	}

	@GetMapping(path = "/", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody List<String> findAll() {
		return ldpaGateRemote //
				.findAll() //
				.parallelStream() //
				.map(userCanonico -> userCanonico.getUsername()) //
				.collect(Collectors.toList());
	}

	@GetMapping(path = "/exist", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public Boolean existUsername(@RequestParam(name = "username", required = true) final String username) {
		return ldpaGateRemote.findByUsername(UserCanonico.create(username)) != null;
	}

	@PostMapping("/authenticate")
	public UserOperationResponseDto findByUsernameAndPassword(final UserOperationRequestDto userOperationRequestDto) {
		final UserCanonico userCanonico = userAuthenticationRequestDtoToUserCanonicoConverter
				.convert(userOperationRequestDto);
		final UserCanonico authenticationUser = ldpaGateRemote.findByUsernameAndPassword(userCanonico);
		if (authenticationUser != null) {
			return UserOperationResponseDto.create(userOperationRequestDto, authenticationUser.getToken().toString());
		} else {
			throw new UserNotFoundException();
		}
	}

	@GetMapping("/{token}/roles")
	public List<RoleDto> findByToken(@PathVariable(name = "token", required = true) final String token) {
		return rbacGateRemote //
				.findRolesByToken(token) //
				.parallelStream() //
				.map(roleCanonico -> roleCanonicoToRoleDtoConverter //
						.convert(roleCanonico)) //
				.collect(Collectors.toList());
	}
}

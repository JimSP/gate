package com.github.jimsp.gate.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.jimsp.gate.canonial.UserCanonico;
import com.github.jimsp.gate.converter.RoleCanonicoToRoleDtoConverter;
import com.github.jimsp.gate.converter.UserAuthenticationRequestDtoToUserCanonicoConverter;
import com.github.jimsp.gate.dto.exception.UserNotFoundException;
import com.github.jimsp.gate.dto.request.RoleRequestDto;
import com.github.jimsp.gate.dto.request.UserOperationRequestDto;
import com.github.jimsp.gate.dto.response.UserOperationResponseDto;
import com.github.jimsp.gate.hadle.GateRestHandle;
import com.github.jimsp.gate.interfaces.UserRoleAuthenticationInterface;
import com.github.jimsp.gate.remote.LdapGateUserRemote;
import com.github.jimsp.gate.remote.RbacGateUserRolesRemote;

@RestController(GateRestHandle.USER_ROLE_AUTHENTICATION_PATH)
public class UserRoleAuthenticationController implements UserRoleAuthenticationInterface {

	@Autowired
	private LdapGateUserRemote ldapGateUserRemote;

	@Autowired
	private RbacGateUserRolesRemote rbacGateUserRolesRemote;

	@Autowired
	private UserAuthenticationRequestDtoToUserCanonicoConverter userAuthenticationRequestDtoToUserCanonicoConverter;

	@Autowired
	private RoleCanonicoToRoleDtoConverter roleCanonicoToRoleDtoConverter;

	@Override
	@PostMapping(path = "/authenticate", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody UserOperationResponseDto findByUsernameAndPassword(
			@Valid @RequestBody final UserOperationRequestDto userOperationRequestDto) {
		final UserCanonico userCanonico = userAuthenticationRequestDtoToUserCanonicoConverter
				.convert(userOperationRequestDto);
		final UserCanonico authenticationUser = ldapGateUserRemote.findByUsernameAndPassword(userCanonico);
		if (authenticationUser != null) {
			return UserOperationResponseDto.create(userOperationRequestDto, authenticationUser.getToken().toString());
		} else {
			throw new UserNotFoundException();
		}
	}

	@Override
	@GetMapping(path = "/{token}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public List<RoleRequestDto> findByToken(@PathVariable(name = "token", required = true) final String token) {
		return rbacGateUserRolesRemote.findRoleByToken(token) //
				.parallelStream() //
				.map(role -> roleCanonicoToRoleDtoConverter.convert(role)) //
				.collect(Collectors.toList());
	}
}

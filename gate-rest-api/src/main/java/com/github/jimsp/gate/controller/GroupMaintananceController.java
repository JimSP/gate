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

import com.github.jimsp.gate.canonial.GroupCanonico;
import com.github.jimsp.gate.converter.GroupRequestDtoToGroupCanonicoConverter;
import com.github.jimsp.gate.dto.request.GroupOperationRequestDto;
import com.github.jimsp.gate.dto.response.GroupOperationResponseDto;
import com.github.jimsp.gate.hadle.GateRestHandle;
import com.github.jimsp.gate.interfaces.GroupMaintananceInterface;
import com.github.jimsp.gate.remote.LdapGateGroupRemote;

@RestController(GateRestHandle.GROUP_PATH)
public class GroupMaintananceController implements GroupMaintananceInterface{
	
	@Autowired
	private LdapGateGroupRemote ldapGateGroupRemote;

	@Autowired
	private GroupRequestDtoToGroupCanonicoConverter groupRequestDtoToGroupCanonicoConverter;
	
	@Override
	@PostMapping(path = "/save", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody GroupOperationResponseDto save(
			@Valid @RequestBody final GroupOperationRequestDto groupOperationRequestDto) {
		final GroupCanonico groupCanonico = groupRequestDtoToGroupCanonicoConverter
				.convert(groupOperationRequestDto);
		ldapGateGroupRemote.save(groupCanonico);
		return GroupOperationResponseDto.create(groupOperationRequestDto);
	}

	@Override
	@DeleteMapping(path = "/remove", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody GroupOperationResponseDto remove(
			@Valid @RequestBody final GroupOperationRequestDto groupOperationRequestDto) {
		final GroupCanonico groupCanonico = groupRequestDtoToGroupCanonicoConverter
				.convert(groupOperationRequestDto);
		ldapGateGroupRemote.remove(groupCanonico);
		return GroupOperationResponseDto.create(groupOperationRequestDto);
	}

	@Override
	@GetMapping(path = "/", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody List<String> findAll() {
		return ldapGateGroupRemote //
				.findAll() //
				.parallelStream() //
				.map(groupCanonico -> groupCanonico.getName()) //
				.collect(Collectors.toList());
	}

	@Override
	@GetMapping(path = "/existName", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody Boolean existName(@RequestParam(name = "groupName", required = true) final String groupName) {
		return ldapGateGroupRemote.findByName(GroupCanonico.create(groupName, null)) != null;
	}
	
	@Override
	@GetMapping(path = "/existValue", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody Boolean existValue(@RequestParam(name = "groupValue", required = true) final String groupValue) {
		return ldapGateGroupRemote.findByValue(GroupCanonico.create(null, groupValue)) != null;
	}
}

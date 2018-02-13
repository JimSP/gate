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

import com.github.jimsp.gate.canonial.ResourceCanonico;
import com.github.jimsp.gate.converter.ResourceRequestDtoToResourceCanonicoConverter;
import com.github.jimsp.gate.dto.request.ResourceRequestDto;
import com.github.jimsp.gate.dto.response.ResourceResponseDto;
import com.github.jimsp.gate.hadle.GateRestHandle;
import com.github.jimsp.gate.interfaces.ResourceMaintananceInterface;
import com.github.jimsp.gate.remote.RbacGateResourceRemote;

@RestController(GateRestHandle.RESOURCE_PATH)
public class ResourceMaintananceController implements ResourceMaintananceInterface {

	@Autowired
	private RbacGateResourceRemote rbacGateResourceRemote;

	@Autowired
	private ResourceRequestDtoToResourceCanonicoConverter resourceRequestDtoToResourceCanonicoConverter;

	@Override
	@PostMapping(path = "/save", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody ResourceResponseDto save(@Valid @RequestBody final ResourceRequestDto resourceRequestDto) {
		final ResourceCanonico resourceCanonico = resourceRequestDtoToResourceCanonicoConverter
				.convert(resourceRequestDto);
		rbacGateResourceRemote.save(resourceCanonico);
		return ResourceResponseDto.create(resourceRequestDto);
	}

	@Override
	@DeleteMapping(path = "/remove", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody ResourceResponseDto remove(@Valid @RequestBody final ResourceRequestDto resourceRequestDto) {
		final ResourceCanonico resourceCanonico = resourceRequestDtoToResourceCanonicoConverter
				.convert(resourceRequestDto);
		rbacGateResourceRemote.remove(resourceCanonico);
		return ResourceResponseDto.create(resourceRequestDto);
	}

	@Override
	@GetMapping(path = "/", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody List<String> findAll() {
		return rbacGateResourceRemote //
				.findAll() //
				.parallelStream() //
				.map(permissionCanonico -> permissionCanonico.getName()) //
				.collect(Collectors.toList());
	}

	@Override
	@GetMapping(path = "/exist", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody Boolean existName(@RequestParam(name = "name", required = true) final String name) {
		return rbacGateResourceRemote.findByName(ResourceCanonico.create(name, null, null)) != null;
	}
}

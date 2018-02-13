package com.github.jimsp.gate.dto.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jimsp.gate.dto.request.GroupOperationRequestDto;

public class GroupOperationResponseDto implements Serializable{

	private static final long serialVersionUID = -6774730352328202554L;

	public static GroupOperationResponseDto create(final GroupOperationRequestDto groupOperationRequestDto) {
		return new GroupOperationResponseDto(groupOperationRequestDto);
	}

	private final GroupOperationRequestDto groupOperationRequestDto;

	@JsonCreator
	public GroupOperationResponseDto(@JsonProperty("groupOperationRequestDto") final GroupOperationRequestDto groupOperationRequestDto) {
		super();
		this.groupOperationRequestDto = groupOperationRequestDto;
	}

	public GroupOperationRequestDto getGroupOperationRequestDto() {
		return groupOperationRequestDto;
	}

	@Override
	public String toString() {
		return "GroupOperationResponseDto [groupOperationRequestDto=" + groupOperationRequestDto + "]";
	}
}

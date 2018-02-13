package com.github.jimsp.gate.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.github.jimsp.gate.canonial.GroupCanonico;
import com.github.jimsp.gate.dto.request.GroupOperationRequestDto;

@Component("groupRequestDtoToGroupCanonicoConverter")
public class GroupRequestDtoToGroupCanonicoConverter implements Converter<GroupOperationRequestDto, GroupCanonico> {

	@Override
	public GroupCanonico convert(final GroupOperationRequestDto groupOperationRequestDto) {
		return GroupCanonico.create(groupOperationRequestDto.getName(), groupOperationRequestDto.getValue());
	}
}

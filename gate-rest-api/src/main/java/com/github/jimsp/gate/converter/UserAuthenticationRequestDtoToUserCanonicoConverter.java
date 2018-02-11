package com.github.jimsp.gate.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.github.jimsp.gate.canonial.UserCanonico;
import com.github.jimsp.gate.dto.UserOperationRequestDto;

@Component
public class UserAuthenticationRequestDtoToUserCanonicoConverter
		implements Converter<UserOperationRequestDto, UserCanonico> {

	@Override
	public UserCanonico convert(final UserOperationRequestDto userAuthenticationRequestDto) {
		return UserCanonico.create( //
				userAuthenticationRequestDto.getUsername(), //
				userAuthenticationRequestDto.getPassword());
	}
}

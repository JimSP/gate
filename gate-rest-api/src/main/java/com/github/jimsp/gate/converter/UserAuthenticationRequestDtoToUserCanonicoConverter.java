package com.github.jimsp.gate.converter;

import java.util.Collections;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.github.jimsp.gate.canonial.UserCanonico;
import com.github.jimsp.gate.dto.request.UserOperationRequestDto;

@Component("userAuthenticationRequestDtoToUserCanonicoConverter")
public class UserAuthenticationRequestDtoToUserCanonicoConverter
		implements Converter<UserOperationRequestDto, UserCanonico> {

	@Override
	public UserCanonico convert(final UserOperationRequestDto userAuthenticationRequestDto) {
		return UserCanonico.create(userAuthenticationRequestDto.getUsername(),
				userAuthenticationRequestDto.getPassword(), Collections.emptyList(),
				userAuthenticationRequestDto.getCreateDate().getTime());
	}
}

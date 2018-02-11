package com.github.jimsp.gate.dto;

import java.io.Serializable;

public class ResourceDto implements Serializable{

	private static final long serialVersionUID = -786542488741654550L;
	
	public static ResourceDto create(final String identifier, final Boolean pattern, final Boolean permanent) {
		return new ResourceDto(identifier, pattern, permanent);
	}

	private final String identifier;
	private final Boolean pattern;
	private final Boolean permanent;

	public ResourceDto(final String identifier, final Boolean pattern, final Boolean permanent) {
		super();
		this.identifier = identifier;
		this.pattern = pattern;
		this.permanent = permanent;
	}

	public String getIdentifier() {
		return identifier;
	}

	public Boolean getPattern() {
		return pattern;
	}

	public Boolean getPermanent() {
		return permanent;
	}
}

package com.github.jimsp.gate.canonial;

import java.io.Serializable;

public class ResourceCanonico implements Serializable{

	private static final long serialVersionUID = -786542488741654550L;
	
	public static ResourceCanonico create(final String identifier, final Boolean pattern, final Boolean permanent) {
		return new ResourceCanonico(identifier, pattern, permanent);
	}

	private final String identifier;
	private final Boolean pattern;
	private final Boolean permanent;

	public ResourceCanonico(final String identifier, final Boolean pattern, final Boolean permanent) {
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

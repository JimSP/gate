package com.github.jimsp.gate.canonial;

import java.io.Serializable;

public class ResourceCanonico implements Serializable{

	private static final long serialVersionUID = -786542488741654550L;
	
	public static ResourceCanonico create(final String name, final Boolean pattern, final Boolean permanent) {
		return new ResourceCanonico(name, pattern, permanent);
	}

	private final String name;
	private final Boolean pattern;
	private final Boolean permanent;

	public ResourceCanonico(final String name, final Boolean pattern, final Boolean permanent) {
		super();
		this.name = name;
		this.pattern = pattern;
		this.permanent = permanent;
	}

	public String getName() {
		return name;
	}

	public Boolean getPattern() {
		return pattern;
	}

	public Boolean getPermanent() {
		return permanent;
	}
}

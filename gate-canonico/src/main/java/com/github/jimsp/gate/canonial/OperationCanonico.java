package com.github.jimsp.gate.canonial;

import java.io.Serializable;

public class OperationCanonico implements Serializable {

	private static final long serialVersionUID = 2023353663119510489L;

	public static OperationCanonico create(final String name, final String description, final Boolean permanent) {
		return new OperationCanonico(name, description, permanent);
	}

	private final String name;

	private final String description;

	private final Boolean permanent;

	public OperationCanonico(final String name, final String description, final Boolean permanent) {
		super();
		this.name = name;
		this.description = description;
		this.permanent = permanent;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Boolean getPermanent() {
		return permanent;
	}

	@Override
	public String toString() {
		return "OperationCanonico [name=" + name + ", description=" + description + ", permanent=" + permanent + "]";
	}
}

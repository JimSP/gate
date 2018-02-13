package com.github.jimsp.gate.canonial;

import java.io.Serializable;
import java.util.Enumeration;

public class GroupCanonico implements Serializable {

	public static GroupCanonico create(final String name, final String value) {
		return new GroupCanonico(name, value);
	}
	
	public static GroupCanonico create(final Enumeration<String> enumaration) {
		final StringBuilder stringBuilder = new StringBuilder();
		int i = 0;
		String name = null;
		while (enumaration.hasMoreElements()) {
			if (i++ == 0) {
				name = enumaration.nextElement();
			} else if (i++ == 1) {
				stringBuilder.append(enumaration.nextElement());
			} else {
				stringBuilder.append(":" + enumaration.nextElement());
			}
		}
		return GroupCanonico.create( //
				name, stringBuilder.toString());
	}

	private static final long serialVersionUID = -7246056844967365286L;

	private final String name;
	private final String value;

	public GroupCanonico(final String name, final String value) {
		super();
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "GroupCanonico [name=" + name + ", value=" + value + "]";
	}
}

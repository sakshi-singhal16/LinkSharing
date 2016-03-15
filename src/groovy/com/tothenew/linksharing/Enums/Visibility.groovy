package com.tothenew.linksharing.Enums;

public enum Visibility {
	PUBLIC('Public'),
	PRIVATE('Private')

	static Visibility getVisibility(String visibility) {

		String visibilityInUpperCase = visibility.toUpperCase()

		return valueOf(visibilityInUpperCase)
	}

	final String value

	Visibility(String value) {
		this.value = value
	}

	@Override
	String toString() { value }

	String getKey() { name() }
}

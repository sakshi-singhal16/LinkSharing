package com.tothenew.linksharing.Enums;

public enum Visibility {
	PUBLIC, PRIVATE

	static Visibility convertToEnum(String s) {
		return Visibility[s.toUpperCase()];

	}
}

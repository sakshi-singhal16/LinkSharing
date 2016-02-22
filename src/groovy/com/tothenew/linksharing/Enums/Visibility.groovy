package com.tothenew.linksharing.Enums;

public enum Visibility {
	PUBLIC, PRIVATE

	Visibility convertToEnum(String s) {
		return Visibility[s];

	}
}

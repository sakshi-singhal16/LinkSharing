package com.tothenew.linksharing.Enums;

public enum Seriousness {
	SERIOUS,
	VERY_SERIOUS,
	CASUAL;

	static Seriousness convertToEnum(String s) {
		return Seriousness[s.toUpperCase()];

	}
}




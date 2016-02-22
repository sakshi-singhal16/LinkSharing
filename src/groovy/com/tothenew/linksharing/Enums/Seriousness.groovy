package com.tothenew.linksharing.Enums;

public enum Seriousness {
	SERIOUS,
	VERY_SERIOUS,
	CASUAL;

	Seriousness convertToEnum(String s) {
		return Seriousness[s];

	}
}




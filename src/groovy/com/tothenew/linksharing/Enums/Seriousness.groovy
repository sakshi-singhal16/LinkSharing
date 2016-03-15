package com.tothenew.linksharing.Enums;

public enum Seriousness {
	SERIOUS('Serious'),
	VERY_SERIOUS('Very Serious'),
	CASUAL('Casual');

//	static Seriousness convertToEnum(String s) {
//		return Seriousness[s.toUpperCase()];

	static Seriousness getSeriousness(String seriousness) {

		String seriousnessInUpperCase = seriousness.toUpperCase()

		return valueOf(seriousnessInUpperCase)
	}

	final String value

	Seriousness(String value) {
		this.value = value
	}

	@Override
	String toString() { value }

	String getKey() { name() }
}




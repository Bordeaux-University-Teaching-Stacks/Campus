package com.intuitiv.campus.enums;


public enum UserSexEnum {

	MALE("male", true),
	FEMALE("female", false);

	private String label;
	private boolean value;

	private UserSexEnum(String label, boolean value) {
		this.label = label;
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public boolean getValue() {
		return value;
	}

	public static UserSexEnum findForLabel(String label) {
		for (UserSexEnum userSexEnum : values()) {
			if (userSexEnum.getLabel().equals(label)) {
				return userSexEnum;
			}
		}
		return null;
	}

}

package com.intuitiv.campus.test.enums;

import org.junit.Assert;
import org.junit.Test;

import com.intuitiv.campus.enums.UserSexEnum;

public class UserSexEnumTest {

	@Test
	public void testFindByWrongLabel() {
		Assert.assertNull(UserSexEnum.findForLabel("test"));
	}

	@Test
	public void testFindMaleByLabel() {
		Assert.assertTrue(UserSexEnum.findForLabel("male").getValue());
	}

	@Test
	public void testFindFemaleByLabel() {
		Assert.assertFalse(UserSexEnum.findForLabel("female").getValue());
	}

}

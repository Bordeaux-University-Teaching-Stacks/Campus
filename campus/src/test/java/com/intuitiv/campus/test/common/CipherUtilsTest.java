package com.intuitiv.campus.test.common;

import junit.framework.Assert;

import org.junit.Test;

import com.intuitiv.campus.common.CipherUtils;

public class CipherUtilsTest {

	private final static CipherUtils cipher = new CipherUtils();

	@Test
	public void testCipher() {
		Assert.assertNotNull(cipher);
	}

	@Test
	public void testEncrypt() {
		Assert.assertTrue(CipherUtils.encrypt("Test13").equals("ngLzopB+RVaKg+Lx5Uuu3w=="));
	}

	@Test
	public void testDecrypt() {
		Assert.assertTrue(CipherUtils.decrypt("ngLzopB+RVaKg+Lx5Uuu3w==").equals("Test13"));
	}

	@Test
	public void testEncryptFailed() {
		Assert.assertNull(CipherUtils.encrypt(null));
	}

	@Test
	public void testDecryptFailed() {
		Assert.assertNull(CipherUtils.decrypt(null));
	}

}

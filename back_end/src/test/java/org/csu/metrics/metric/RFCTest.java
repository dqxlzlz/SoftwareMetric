package org.csu.metrics.metric;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import org.csu.metrics.CK;
import org.csu.metrics.CKNumber;
import org.csu.metrics.CKReport;

public class RFCTest extends BaseTest {

	private static CKReport report;
	
	@BeforeClass
	public static void setUp() {
		report = new CK().calculate(fixturesDir() + "/rfc");
	}

	@Test
	public void countMethodInvocations() {
		CKNumber a = report.getByClassName("rfc.GO");
		Assert.assertEquals(3, a.getRfc());
	}

	@Test
	public void countSuperInvocations() {
		CKNumber a = report.getByClassName("rfc.GO3");
		Assert.assertEquals(2, a.getRfc());
	}

	@Test
	public void notPossibleToDifferentiateTypesWithStaticAnalysis() {
		CKNumber a = report.getByClassName("rfc.RFC3");
		Assert.assertEquals(1, a.getRfc());
	}

	@Test
	public void doesNotCountConstructorInvocations() {
		CKNumber a = report.getByClassName("rfc.RFC2");
		Assert.assertEquals(0, a.getRfc());
	}
}

package de.seidfred.bam.model.enums;

import java.util.Arrays;
import java.util.List;

public enum PeriodType {
	// @formatter:off
	MONTHLY("Monthly"),
	ANNUAL("Annual"),
	SEMIANNUAL("Semiannual"),
	QUARTERLY("Quarterly");
	// @formatter:on

	private final String name;

	PeriodType(String aName) {
		name = aName;
	}

	public String getName() {
		return name;
	}

	public List<PeriodType> getAllPeriodTypes() {
		return Arrays.asList(PeriodType.values());
	}

}

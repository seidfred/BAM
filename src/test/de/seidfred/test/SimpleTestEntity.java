package de.seidfred.test;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test")
public class SimpleTestEntity {

	@Id
	private Integer id;

	// @Column(name = "int")
	// private int simpleInt;

	@Column(name = "intWrap")
	private Integer integerWrap;

	// @Column(name = "short")
	// private short simpleShort;

	@Column(name = "shortWrap")
	private Short shortWrap;

	// @Column(name = "double")
	// private double simpleDouble;

	@Column(name = "doubleWrap")
	private Double doubleWrap;

	@Column(name = "string")
	private String string;

	@Column(name = "bigDecimal")
	private BigDecimal bigDecimal;

	public SimpleTestEntity() {
		// no arg
	}

	public Integer getId() {
		return id;
	}

	public Integer getIntegerWrap() {
		return integerWrap;
	}

	public void setIntegerWrap(Integer aIntegerWrap) {
		integerWrap = aIntegerWrap;
	}

	public Short getShortWrap() {
		return shortWrap;
	}

	public void setShortWrap(Short aShortWrap) {
		shortWrap = aShortWrap;
	}

	public Double getDoubleWrap() {
		return doubleWrap;
	}

	public void setDoubleWrap(Double aDoubleWrap) {
		doubleWrap = aDoubleWrap;
	}

	public String getString() {
		return string;
	}

	public void setString(String aString) {
		string = aString;
	}

	public BigDecimal getBigDecimal() {
		return bigDecimal;
	}

	public void setBigDecimal(BigDecimal aBigDecimal) {
		bigDecimal = aBigDecimal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimpleTestEntity other = (SimpleTestEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

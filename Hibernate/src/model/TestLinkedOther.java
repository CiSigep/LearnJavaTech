package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TESTOTHER")
public class TestLinkedOther {
	
	@Id
	@GeneratedValue
	private int tlotid;
	
	@Column(name = "value")
	private String value;

	public int getTlotid() {
		return tlotid;
	}

	public void setTlotid(int tlotid) {
		this.tlotid = tlotid;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	

}

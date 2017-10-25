package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TESTLINK")
public class TestLinkedObject {
	
	@Id
	@GeneratedValue
	@Column(name="tloid")
	private int tloid;
	
	@Column(name="value")
	private String value;
	
	public int getTloid() {
		return tloid;
	}
	public void settloid(int tloid) {
		this.tloid = tloid;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	

}

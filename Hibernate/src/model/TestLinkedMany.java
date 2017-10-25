package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TESTMANY")
public class TestLinkedMany {
	
	@Id
	@GeneratedValue
	@Column(name="tlmid")
	private int tlmid;
	@Column(name="val")
	private String val;
	
	public int getTlmid() {
		return tlmid;
	}
	public void setTlmid(int tlmid) {
		this.tlmid = tlmid;
	}
	public String getVal() {
		return val;
	}
	public void setVal(String val) {
		this.val = val;
	}
	

}

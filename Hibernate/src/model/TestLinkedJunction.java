package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TESTJUNCTION")
public class TestLinkedJunction {
	
	@Id
	@GeneratedValue
	private int tljid;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tlmid")
	private TestLinkedMany tlm;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tlotid")
	private TestLinkedOther tlot;

	public int getTljid() {
		return tljid;
	}

	public void setTljid(int tljid) {
		this.tljid = tljid;
	}

	public TestLinkedMany getTlm() {
		return tlm;
	}

	public void setTlm(TestLinkedMany tlm) {
		this.tlm = tlm;
	}

	public TestLinkedOther getTlot() {
		return tlot;
	}

	public void setTlot(TestLinkedOther tlot) {
		this.tlot = tlot;
	}



}

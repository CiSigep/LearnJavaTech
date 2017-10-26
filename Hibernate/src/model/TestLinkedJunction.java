package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TESTJUNCTION")
public class TestLinkedJunction {
	
	@Id
	@GeneratedValue
	private int tljid;
	
	@OneToMany
	@JoinColumn(name = "tlm")
	private List<TestLinkedMany> tlm;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "tlot")
	private List<TestLinkedOther> tlot;

	public int getTljid() {
		return tljid;
	}

	public void setTljid(int tljid) {
		this.tljid = tljid;
	}

	public List<TestLinkedMany> getTlm() {
		return tlm;
	}

	public void setTlm(List<TestLinkedMany> tlm) {
		this.tlm = tlm;
	}

	public List<TestLinkedOther> getTlot() {
		return tlot;
	}

	public void setTlot(List<TestLinkedOther> tlot) {
		this.tlot = tlot;
	}

}

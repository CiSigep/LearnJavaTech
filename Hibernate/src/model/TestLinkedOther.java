package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TESTOTHER")
public class TestLinkedOther {
	
	@Id
	@GeneratedValue
	private int tlotid;
	
	@Column(name = "val")
	private String val;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="tlotid")
	private List<TestLinkedJunction> tlj;

	public int getTlotid() {
		return tlotid;
	}

	public void setTlotid(int tlotid) {
		this.tlotid = tlotid;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public List<TestLinkedJunction> getTlj() {
		return tlj;
	}

	public void setTlj(List<TestLinkedJunction> tlj) {
		this.tlj = tlj;
	}
	
	

}

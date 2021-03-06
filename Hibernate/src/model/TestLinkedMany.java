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
@Table(name="TESTMANY")
public class TestLinkedMany {
	
	@Id
	@GeneratedValue
	@Column(name="tlmid")
	private int tlmid;
	@Column(name="val")
	private String val;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "tlmid")
	private List<TestLinkedJunction> tlj;
	
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
	public List<TestLinkedJunction> getTlj() {
		return tlj;
	}
	public void setTlj(List<TestLinkedJunction> tlj) {
		this.tlj = tlj;
	}
	
	
	

}

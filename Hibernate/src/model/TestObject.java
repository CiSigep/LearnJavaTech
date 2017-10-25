package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TESTTABLE")
public class TestObject {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="test")
	private String test;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="tloid")
	private TestLinkedObject tlo;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id")
	private List<TestLinkedMany> many;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public TestLinkedObject getTlo() {
		return tlo;
	}
	public void setTlo(TestLinkedObject tlo) {
		this.tlo = tlo;
	}
	public List<TestLinkedMany> getMany() {
		return many;
	}
	public void setMany(List<TestLinkedMany> many) {
		this.many = many;
	}
	
	

}

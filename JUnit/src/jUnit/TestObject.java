package jUnit;

public class TestObject {
	
	private DummyService ds;
	
	public String testPhrase(){
		return "Test Phrase";
	}
	
	public int testMath (){
		return 2 + 2;
	}

	public void setDs(DummyService ds) {
		this.ds = ds;
	}
	
	public int dummyServiceMath(int a, int b) throws Exception{
		if(ds != null)
			return ds.add(a, b);
		
		throw new Exception("Dummy Service not Initialized");
	}
	
	public String dummyServiceRepeat(String s) throws Exception{
		if(ds != null)
			return ds.repeat(s);
		
		throw new Exception("Dummy Service not Initialized");
	}

}

package jUnit;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestObjectTest {

	@Test
	public void testTestPhrase() {
		TestObject t = new TestObject();
		
		assertEquals("Test Phrase", t.testPhrase());
	}
	
	@Test
	public void testTestMath(){
		TestObject t = new TestObject();
		
		assertEquals(4, t.testMath());
	}

}

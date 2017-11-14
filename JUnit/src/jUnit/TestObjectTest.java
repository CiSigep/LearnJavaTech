package jUnit;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnit44Runner;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
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
	
	@Test
	public void testDummyServiceMath(){
		TestObject t = new TestObject();
		DummyService ds = Mockito.mock(DummyService.class);
		t.setDs(ds);
		
		Mockito.when(ds.add(2, 3)).thenReturn(5);
		
		try {
			assertEquals(5, t.dummyServiceMath(2, 3));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testDummyServiceRepeat(){
		TestObject t = new TestObject();
		DummyService ds = Mockito.mock(DummyService.class);
		t.setDs(ds);
		
		Mockito.when(ds.repeat("HI")).thenReturn("HI");
		
		try{
			assertEquals("HI", t.dummyServiceRepeat("HI"));
		} catch (Exception e){
			fail();
		}
		
	}

}

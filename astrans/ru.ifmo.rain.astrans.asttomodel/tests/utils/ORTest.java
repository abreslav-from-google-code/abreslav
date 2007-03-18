package utils;

import static org.junit.Assert.assertSame;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ORTest {

	private Object a;
	private String b;
	private Date c;
	
	@Before
	public void setUp() throws Exception {
		a = new Object();
		b = "";
		c = new Date();
	}

	@Test
	public final void testCompleteOr() {
		assertSame(a, OR.get(null).or(a).getObj());
	}

	@Test
	public void testIncompleteOr() {
		assertSame(a, OR.get(a).or(b).getObj());
	}
	
	@Test
	public void testIncompleteOrWithNull() {
		assertSame(a, OR.get(a).or(null).getObj());
	}
	
	@Test
	public void testTypes() {
		assertSame(b, OR.<Object>get(b).or(c).getObj());
	}	
	
	@Test
	public void testCompleteArrayOr() {
		assertSame(c, OR.or(null, c, b, a));
	}
	
	@Test
	public void testIncompleteArrayOr() {
		assertSame(c, OR.or(c, null, b, a));
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void testArrayOrTypes() {
		assertSame(c, OR.or(c, b));
	}
}

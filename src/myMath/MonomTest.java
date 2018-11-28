package myMath;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MonomTest {
	static Monom  expected;
	static Monom actual;
	
	@BeforeEach
	void setUp() throws Exception {
		actual = new Monom();
		expected = new Monom();
	}

	@Test
	void testMonomDoubleInt() {
		actual = new Monom(3.0,0);
		expected = new Monom(3.0,0);
		assertEquals(expected.get_power(), actual.get_power());
		assertEquals(expected.get_coefficient(), actual.get_coefficient(), 0.001);
	}

	@Test
	void testMonomMonom() {
		actual = new Monom(3.0,0);
		expected = new Monom(actual);
		assertEquals(expected.get_power(), actual.get_power());
		assertEquals(expected.get_coefficient(), actual.get_coefficient(), 0.001);
	}

	@Test
	void testMonomString() {
		actual = new Monom("2x^2");
		expected = new Monom(actual);
		assertEquals(actual.get_coefficient(), expected.get_coefficient(), 0.001);
		assertEquals(actual.get_power(), expected.get_power());
		
		actual = new Monom("-12.5*x^5") ;
		expected = new Monom(actual);
		assertEquals(actual.get_coefficient(), expected.get_coefficient(), 0.001);
		assertEquals(actual.get_power(), expected.get_power());
	}

	@Test
	void testGet_coefficient() {
		actual = new Monom("2x^2");
		expected = new Monom(actual);
		assertEquals(actual.get_coefficient(), expected.get_coefficient(), 0.001);
		
		actual = new Monom("-12.5*x^5") ;
		expected = new Monom(actual);
		assertEquals(actual.get_coefficient(), expected.get_coefficient(), 0.001);
	}

	@Test
	void testGet_power() {
		actual = new Monom("2x^2");
		expected = new Monom(actual);
		assertEquals(actual.get_power(), expected.get_power());
		
		actual = new Monom("-12.5*x^5") ;
		expected = new Monom(actual);
		assertEquals(actual.get_power(), expected.get_power());
	}

	@Test
	void testSet_coefficient() {
		actual = new Monom("2x^2") ;
		actual.set_coefficient(5.5);
		expected = new Monom("5.5x^4");
		assertEquals(actual.get_coefficient(), expected.get_coefficient(), 0.001);
		
		actual = new Monom("-12.5*x^5") ;
		actual.set_coefficient(-65.5);
		expected = new Monom("-65.5x^4");
		assertEquals(actual.get_coefficient(), expected.get_coefficient(), 0.001);
	}

	@Test
	void testSet_power() {
		actual = new Monom("2x^2") ;
		actual.set_power(5);
		expected = new Monom("-65.5x^5");
		assertEquals(actual.get_power(), expected.get_power(), 0.001);
		
		actual = new Monom("-12.5*x^5") ;
		actual.set_power(340);
		expected = new Monom("-65.5x^340");
		assertEquals(actual.get_power(), expected.get_power(), 0.001);
	}

	@Test
	void testF() {
		actual = new Monom("2x^2") ;
		expected = new Monom("8x^340");
		assertEquals(actual.f(2.0), expected.get_coefficient(), 0.0001);
		
		actual = new Monom("-12.5*x^5") ;
		expected = new Monom("-3037.5x^340");
		assertEquals(actual.f(3.0), expected.get_coefficient(), 0.0001);
	}

	@Test
	void testEqual() {
		actual = new Monom("2x^2") ;
		expected = new Monom("2x^2") ;
		if(!(actual.equal(expected)))
			fail("actual and expected are not equal");	
	}

	@Test
	void testDerivative() {
		actual = new Monom("2x^2") ;
		actual.derivative();
		expected = new Monom("4x") ;
		if(!(actual.equal(expected)))
			fail("actual and expected are not equal becuase the function derivative dont work well");
	}

	@Test
	void testAdd() {
		actual = new Monom("2x^2") ;
		actual.add(actual);
		expected = new Monom("4x^2") ;
		if(!(actual.equal(expected)))
			fail("actual and expected are not equal becuase the function add dont work well");
	}

	@Test
	void testSubstract() {
		actual = new Monom("2x^2") ;
		actual.substract(actual);
		expected = new Monom("0x^0") ;
		if(!(actual.equal(expected)))
			fail("actual and expected are not equal becuase the function substract dont work well");
	}

	@Test
	void testMultiply() {
		actual = new Monom("2x^2") ;
		actual.multiply(actual);
		expected = new Monom("4x^4") ;
		if(!(actual.equal(expected)))
			fail("actual and expected are not equal becuase the function multiply dont work well");
	}

	@Test
	void testToString() {
		actual = new Monom("2x^2") ;
		String str = actual.toString();
		expected = new Monom("2.0*x^2") ;
		String str1 = expected.toString();
		
		for(int i=0 ; (i<str.length() || i<str1.length()) ; i++) {
			if(str.charAt(i) != str1.charAt(i))
				fail("actual and expected are not equal becuase the function toString dont work well");
		}
	}
}

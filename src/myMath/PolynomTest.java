package myMath;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PolynomTest {
	static Polynom actual;
	static Polynom expected;
	
	@BeforeEach
	void setUp() throws Exception {
		actual = new Polynom();
		expected = new Polynom();	
	}

	@Test
	void testPolynom() {
		actual = new Polynom();
		expected = new Polynom ("0X^0");
		if(!(actual.equals(expected)))
			fail("the defult constractor dosn't working well");	
	}

	@Test
	void testPolynomPolynom() {
		actual = new Polynom();
		expected = new Polynom (actual);
		if(!(actual.equals(expected)))
			fail("the Polynom constractor dosn't working well");
	}

	@Test
	void testPolynomString() {
		actual = new Polynom("2*X^6 + 2x^4 -3.4*x^5");
		expected = new Polynom ("2X^6 + 2*x^4 -3.4x^5");
		if(!(actual.equals(expected)))
			fail("the String constractor dosn't working well");
	}

	@Test
	void testF() {
		actual = new Polynom("2x^2 + 2x^2 + 2x^2") ;
		expected = new Polynom("8x^2 - 4x");
		assertEquals(actual.f(2.0), expected.f(2.0), 0.0001);
	}

	@Test
	void testAddPolynom_able() {
		actual = new Polynom("2x^2 + 4x^4") ;
		actual.add(actual);
		expected = new Polynom("4x^2 + 8x^4");
		if(!(actual.equals(expected)))
			fail("actual and expected are not equal becuase the function add(Polynom_able) dont work well");
	}

	@Test
	void testAddMonom() {
		Monom m1 = new Monom("2x^2") ;
		actual = new Polynom("2x^2 + 4x^4") ;
		actual.add(m1);
		expected = new Polynom("4x^2 + 4x^4");
		if(!(actual.equals(expected)))
			fail("actual and expected are not equal becuase the function add(Monom) dont work well");
	}

	@Test
	void testSubstract() {
		actual = new Polynom("2x^2 + 4x^4") ;
		actual.substract(actual);
		expected = new Polynom("0x^0");
		if(!(actual.equals(expected)))
			fail("actual and expected are not equal becuase the function substract(Polynom_able) dont work well");
	}

	@Test
	void testMultiply() {
		actual = new Polynom("2x^2 + 4x^4") ;
		actual.multiply(actual);
		expected = new Polynom("4x^4 + 16x^8 + 16x^6");
		if(!(actual.equals(expected)))
			fail("actual and expected are not equal becuase the function multiply(Polynom_able) dont work well");
	}

	@Test
	void testEqualsPolynom_able() {
		actual = new Polynom("2x^2 + 4x^4") ;
		expected = new Polynom(actual);
		if(!(actual.equals(expected)))
			fail("actual and expected are not equal becuase the function equals(Polynom_able) dont work well");
	}

	@Test
	void testIsZero() {
		actual = new Polynom("0x^0") ;
		if(!(actual.isZero()))
			fail("actual and expected are not equal becuase the function isZero() dont work well");
	}

	@Test
	void testRoot() {
		actual = new Polynom("x^2 -4") ;
		double root1 = actual.root(-5, 5, 0.000000000000000001);
		if(!(root1 == -2))
			fail("root1 dosnt equal (-2) becuase the function root(double x0, double x1, double eps) dont work well");
	}

	@Test
	void testCopy() {
		actual = new Polynom("2x^2 + 4x^4") ;
		expected = (Polynom) actual.copy();
		if(!(actual.equals(expected)))
			fail("actual and expected are not equal becuase the function copy() dont work well");
	}

	@Test
	void testDerivative() {
		actual = new Polynom("2x^2 + 4x^4") ;
		actual = (Polynom) actual.derivative();
		expected = new Polynom("4x^1 + 16x^3");
		if(!(actual.equals(expected)))
			fail("actual and expected are not equal becuase the function multiply(Polynom_able) dont work well");
	}

	@Test
	void testArea() {
		actual = new Polynom("x^1 - 1") ;
		double area1 = actual.areaUnder(0, 5, 0.00001);
		System.out.println(area1);
		if(!(area1 < 0.51 && area1 > 0.49))
			fail("area1 dosnt between -0.51 to 0.49 becuase the function area(double x0, double x1, double eps) dont work well");
	}

	@Test
	void testToString() {
		actual = new Polynom("2x^2 + 4x^1") ;
		String str = actual.toString();
		expected = new Polynom("2.0*x^2 + 4.0*x^1") ;
		String str1 = expected.toString();
		
		for(int i=0 ; (i<str.length() || i<str1.length()) ; i++) {
			if(str.charAt(i) != str1.charAt(i))
				fail("actual and expected are not equal becuase the function toString dont work well");
		}
	}

}

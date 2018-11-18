package myMath;
import java.util.*;
public class test {
	
	static Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		
		
		// test **Monom**
		//git test
		
		Monom m1 = new Monom(0.0, 0); // construct the zero monom
		System.out.println("monom m1 = " + m1); // prints the zero monom
		
		Monom m2 = new Monom(m1); // copy constructor => construct the zero monom by another monom
		System.out.println("monom m2 = " + m2); // prints the zero monom
		
		Monom m3 = new Monom("0*x^0"); // construct the zero monom by string
		System.out.println("monom m3 = " + m3); // prints the zero monom
		
		Monom m4 = new Monom("5x^2"); // construct the monom "5*x^2" by string
		System.out.println("monom m4 = " + m4); // prints the monom "5*x^2"
		
		System.out.println("monom m4 coefficient = " + m4.get_coefficient()); // get and prints the coefficient of monom m4
		System.out.println("monom m4 power = " + m4.get_power()); // get and prints the power of monom m4
		
		m4.set_coefficient(4.5); // set the coefficient of monom m4 
		m4.set_power(3); // prints the power of monom m4
		
		System.out.println("monom m4 after change coefficient to " + m4.get_coefficient() + " and power to " + m4.get_power() + " => ( monom m4 = " + m4 + ")"); // prints the monom m4
		
		double y = m4.f(3.2); // compute the value of monom m4 with the value 3.2 of x  
		System.out.println("monom m4 when (x=3.2) => f(x) = " + y ); // prints the value of y
		
		Monom m5 = new Monom("4.5*x^3"); // construct the monom "4.5*x^3" by string
		System.out.println("monom m5 = " + m5); // prints the monom "4.5*x^3"
		
		System.out.print("are " + m1 + "and " + m5 + "equal ? the answer is => ");
		System.out.println(m5.equal(m1)); // check if monom m5 equals to monom m1 and prints the result - (false)
		System.out.print("are " + m4 + "and " + m5 + "equal ? the answer is => ");
		System.out.println(m5.equal(m4)); // check if monom m5 equals to monom m4 and prints the result - (true)
		
		m5.derivative(); // compute the derivative of monom m5 
		System.out.println("monom m5 after derivative = " + m5); // prints the monom m5 (after the derivative)
		
		Monom m6 = new Monom("2*x^2");
		System.out.print("monom m5 + monom m6 = " + m5 + " " + m6 + "= ");
		m5.add(m6); // add monom m6 to monom m5
		System.out.println(m5); // prints the monom m5 (after added monom m6)	
		
		System.out.print("monom m6 - monom m5 = ( " + m6 + ") - ( " + m5 + ")= ");
		m6.substract(m5); // subtract monom m5 from m6
		System.out.println(m6); // prints the monom m6 (after subtract monom m5)
		
		System.out.print("monom m6 * monom m5 = ( " + m6 + ") * ( " + m5 + ")= ");
		m6.multiply(m5); // monom m6 multiply monom m5
		System.out.println(m6.toString()); // prints the monom m6 (after multiply monom m5)
		
		System.out.println("\n\n");
	
		
		// test **Polynom**
		
		
		Polynom p1 = new Polynom(); // construct the zero Polynom
		System.out.println("Polynom p1 = " + p1); // prints the zero Polynom
		
		Polynom p2 = new Polynom(p1); // copy constructor => construct the zero polynom by another zero polynom
		System.out.println("Polynom p2 = " + p2); // prints the zero Polynom
		
		Polynom p3 = new Polynom("0*x^0"); // construct the zero Polynom by string
		System.out.println("Polynom p3 = " + p3); // prints the zero Polynom
		
		Polynom p4 = new Polynom("5*x^2 -6.5*x^1 +0*x^1"); // construct the Polynom "5*x^2 -6.5*x^1 +0*x^0" by string
		System.out.println("Polynom p4 = " + p4); // prints the Polynom "5*x^2 -6.5*x^1 +0*x^0"
		
		double y1 = p4.f(2.4); // compute the value of Polynom p4 with the value 2.4 of x  
		System.out.println("Polynom p4 when (x=2.4) => f(x) = " + y1 ); // prints the value of y
		
		Polynom_able p5 = new Polynom("4*x^3 -2*x^2 +3*x^1"); // construct the Polynom "4*x^3 -2*x^1 +3*x^1" by string
		System.out.println("Polynom p5 = " + p5); // prints the Polynom "4*x^3 -2*x^1 +3*x^1"
		System.out.print("Polynom p4 + Polynom p5 = ( " + p4 + ") + ( " + p5 + ") = ");
		p4.add(p5); // add Polynom p4 to Polynom p5
		System.out.println(p4); // prints the Polynom m5 (after added Polynom p5)
		
		System.out.println("monom m4 that we create in the start = " + m4); // prints the monom "5*x^2"
		System.out.print("Polynom p4 + monom m4 = ( " + p4 + ") + (" + m4 + ") = ");
		p4.add(m4); // add monom m6 to Polynom p4
		System.out.println(p4); // prints the Polynom p4 (after added monom m4)
		
		System.out.print("Polynom p4 - Polynom p5 = ( " + p4 + ") - (" + p5 + ") = ");
		p4.substract(p5); // subtract Polynom p5 from Polynom p4
		System.out.println(p4); // prints the Polynom p4 (after subtract Polynom p4)
		
		System.out.print("Polynom p4 * Polynom p5 = ( " + p4 + ") * (" + p5 + ") = ");
		p4.multiply(p5); // multiply Polynom p4 with Polynom p5
		System.out.println(p4); // prints the Polynom p4 (after multiply with Polynom p5)
		
		System.out.print("are " + p4 + "and " + p5 + "equal ? the answer is => ");
		System.out.println(p4.equals(p5)); // check if Polynom p5 equals to Polynom p4 and prints the result - (false)
		Polynom_able p6 = new Polynom ("+18.0*X^6 +11.0*X^5 -22.5*X^4 -19.5*x^2 +28.0*X^3 ");
		System.out.print("are " + p4 + "and " + p6 + "equal ? the answer is => ");
		System.out.println(p4.equals(p6)); // check if Polynom p4 equals to Polynom p6 and prints the result - (true)
		
		Polynom p7 = new Polynom ("0*x^0");
		Polynom p8 = new Polynom ("0*x^0 + 0*x^0 + 0*x^0 + 0*x^0");
		System.out.print("( Polynom p7 = " + p7 + ") \\ is Polynom p7 is the zero Polynom ? the answer is => ");
		System.out.println(p7.isZero()); // check if Polynom p7 is the zero Polynom result - (true)
		System.out.print("( Polynom p8 = " + p8 + ") \\ is Polynom p8 is the zero Polynom ? the answer is => ");
		System.out.println(p8.isZero()); // check if Polynom p8 is the zero Polynom result - (true)
		System.out.print("( Polynom p6 = " + p6 + ") \\ is Polynom p6 is the zero Polynom ? the answer is => ");
		System.out.println(p6.isZero()); // check if Polynom p6 is the zero Polynom result - (false)
		
		Polynom p9 = new Polynom("2*x^4 -3*x^3 +3*x^2 -x");
		System.out.println("Polynom p9 = " + p9);
		double x2 = p9.root(0.25, 5.0, 0.001); // find the root between tow x
		System.out.println("root x = " + x2); // print the Crop with the x-axis
		
		Polynom_able p10 = p9.copy(); // create from p9 a new Polynom_able by deep copy
		System.out.println("Polynom p9 = " + p9);
		System.out.println("Polynom p10 = " + p10 + " // deep copy of polynom p9 ");
		
		System.out.println("polynom p10 after derivative = " + p10.derivative()); // prints p10 after derivative
		
		double area = p9.area(-1.0, 2.0, 0.001);
		System.out.println("possitive area of polynom p9 between (-1,2) = " + area); // prints the area value
		
		
		
		
		

	}

}

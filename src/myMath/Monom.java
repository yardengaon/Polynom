
package myMath;
/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Yarden Gaon
 *
 */
public class Monom implements function{
	
	private double _coefficient; 
	private int _power;
	
	/**
	 * this constructor create a new Monom  
	 * @param a represent the coefficient
	 * @param b represent the power // can't be smaller from zero if power smaller from zero run time exception will happen 
	 */
	
	public Monom(double a, int b){
		this.set_coefficient(a);
		this.set_power(b);
	}
	
	/**
	 * copy constructor
	 * @param m1 the Monom that required to copy 
	 */
	
	public Monom(Monom m1) {
		this(m1.get_coefficient(), m1.get_power());
	}
	
	/**
	 * A constructor who gets a string like (5*x^2) and turns it into a Monom
	 * @param s the string that becomes to a new Monom
	 */
	
	public Monom(String s) {
		s = s.toLowerCase();
		double numcoeff = 0;
		int numpow = 0;
		String coeff = "";
		String pow = "";
		if((s.indexOf("-") == 0) && (s.indexOf("x") == 1))
			this.set_coefficient(-1);
		else if((s.indexOf("+") == 0) && (s.indexOf("x") == 1))
			this.set_coefficient(1);
		else if((s.indexOf("-") == 0) && (s.indexOf("x") < 0)) {
			coeff = s;
			numcoeff = Double.parseDouble(coeff);
			this.set_coefficient(numcoeff);
		}
		else if((s.indexOf("+") == 0) && (s.indexOf("x") < 0)) {
			coeff = s;
			numcoeff = Double.parseDouble(coeff);
			this.set_coefficient(numcoeff);
		}
		else if(s.indexOf("x") == 0)   
			this.set_coefficient(1);
		else if(s.indexOf("*") >= 0 || s.indexOf("x") > 0) {
			s = s.replaceAll("\\*", "");
			s = s.replaceAll("\\.0", "");
			String[] arr2 = s.split("x");
			coeff = arr2[0];
			numcoeff = Double.parseDouble(coeff);
			this.set_coefficient(numcoeff);
		}
		else if((s.indexOf("x") < 0)) {
			coeff = s;
			try{numcoeff = Double.parseDouble(coeff);}
			catch(NumberFormatException e) {
				System.out.println("The string you entered is invalid, insert a new string from the following format a*X^b");
				throw new NumberFormatException();
			}
			this.set_coefficient(numcoeff);
			}
		else {
			System.out.println("The string you entered is invalid, insert a new string from the following format a*X^b");
			throw new RuntimeException();
		}
		if((s.indexOf("x") + 1) == s.length()) {
			this.set_power(1);
		}
		else if(s.indexOf("x") < 0) 
			this.set_power(0);
		else if(s.charAt(s.length()-2) == '^' && s.charAt(s.length()-1) == '0') 
			this.set_power(0);
		else {
			s = s.replaceAll("\\^", "");	
			s = s.replaceAll("\\.0", "");	
			String[] arr2 = s.split("x");
			pow = arr2[1];
			try{numpow = Integer.parseInt(pow);}
			catch(NumberFormatException e) {
				System.out.println("The string you entered is invalid, insert a new string from the following format a*X^b");
				throw new NumberFormatException();
			}
			this.set_power(numpow);
		}		
	}
	
	/**
	 * @return the coefficient value of this Monom
	 */
		
	public double get_coefficient(){
		return this._coefficient;
	}
	
	/**
	 * @return the power value of this Monom
	 */
	
	public int get_power(){
		return this._power;
	}
	
	/**
	 * updating the coefficient value of this Monom
	 * @param a represent the coefficient value of this Monom
	 */
	
	public void set_coefficient(double a){
		this._coefficient = a;
	}
	
	/**
	 * updating the power value of this Monom
	 * @param p represent the power value of this Monom
	 */
	public void set_power(int p) {
		if(p<0)
			throw new RuntimeException("change power // the power smaller from zero");
		this._power = p;
	}
	
	@Override
	public double f(double x) {
		return (get_coefficient() * Math.pow(x, get_power()));
	} 
	
	/**
	 * chek if tow monoms are equals
	 * @param m1 the monom that equals to this.monom 
	 * @return boolean if equals or not
	 */
	
	public boolean equal(Monom m1) {
		if (this.get_coefficient() == m1.get_coefficient() && this.get_power() == m1.get_power())
			return true;
		return false;
	}
	
	/**
	 * compute the derivative of this Monom
	 */
	
	public void derivative() {
		
		if(get_power() == 0) {
			set_power(0);
			set_coefficient(0);
		}
		else {
			int p = get_power() - 1;
			double c = get_power() * get_coefficient();
			set_power(p);
			set_coefficient(c);
		}
	}
	
	/**
	 * if the powers are equals add the coefficients of the monoms else dosen't do anything 
	 * @param m1 the monom that add to this Monom
	 */
	
	public void add(Monom m1) {
		if(get_power() == m1.get_power()) {
			double c = (get_coefficient() + m1.get_coefficient());
			set_coefficient(c);
		}
	}
	
	/**
	 * if the powers are equals Subtraction the coefficients of the monoms else dosen't do anything 
	 * @param m1 the monom that subtracts the monom this Monom
	 */
	
	public void substract(Monom m1) {
		if(get_power() == m1.get_power()) {
			double c = (get_coefficient() - m1.get_coefficient());
			set_coefficient(c);
		}
	}
	
	/**
	 * add the powerã of the monoms and multiply the coefficients 
	 * @param m1 the monom that multiply with this Monom
	 */
	
	public void multiply(Monom m1) {
		try {
			double c = this.get_coefficient() * m1.get_coefficient();
			this.set_coefficient(c);
			int p = this.get_power() + m1.get_power();
			this.set_power(p);
		}
		catch(Exception e) {
			
		}
		
	}
	
	/**
	 * print a string that displays the current monom
	 * @return string that displays the monom
	 */
	public String toString() {
		if (get_power() == 0) {
			if(get_coefficient() == 0)
				return ("+" + get_coefficient() + "*X^" + get_power() + " ");
			if(get_coefficient() > 0)
				return ("+" + get_coefficient() + "*X^"+ get_power() + " ");
			if(get_coefficient() < 0)
				return ("-" + Math.abs(get_coefficient()) + "*X^"+ get_power() + " ");
		}
		if (get_coefficient() > 0)
			return ("+" + get_coefficient() + "*X^" + get_power() + " ");
		else if(get_coefficient() < 0)
			return ("-" + Math.abs(get_coefficient()) + "*X^" + get_power() + " ");
		else
			return ("");
	}
}

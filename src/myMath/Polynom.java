package myMath;
import java.util.ArrayList;
import java.util.Iterator;

import myMath.Monom;
/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 * power can't be smaller from zero if power smaller from zero run time exception will happen 
 * 
 * @author Yrarden Gaon 312469174
 *
 */
public class Polynom implements Polynom_able{
	
	private ArrayList<Monom> monoms;
	private final Monom_Comperator cmpByPow = new Monom_Comperator();
	
	/**
	 * default constructor create a new zero Polynom
	 */
	public Polynom() {
		monoms = new ArrayList<>();
		monoms.add(new Monom(0.0,0));
	}
	
	/**
	 * copy constructor
	 * @param p1 the polynom that required to copy
	 * 
	 */
	
	public Polynom(Polynom p1) {
		monoms = new ArrayList<>();
		Iterator<Monom> itp1 = p1.iteretor();
		while(itp1.hasNext()) {
			Monom m1 = new Monom(0.0,0);
			Monom temp = itp1.next();
			double coe = temp.get_coefficient();
			int pow = temp.get_power();
			m1.set_coefficient(coe);
			m1.set_power(pow);
			monoms.add(m1);
		}	
	}
	
	/**
	 * a constructor that get a String
	 * @param s the string that becomes to a new polynom
	 */
	public Polynom(String s) {
		monoms = new ArrayList<>();
		Polynom p1 = new Polynom();
		String m1 = "" ;
		s = s.replaceAll(" ", "");
		s = s.replaceAll("-", "+-");
		s = s.replaceAll("\\^\\+-", "^-");
		String[] arr1 = s.split("\\+");
		if(s.charAt(0) == '+') {
			for(int i=1 ; i<arr1.length ; i++) {
				m1 = arr1[i];
				Monom m2 = new Monom(m1);
				p1.add(m2);
			}
		}
		else {
			for(int i=0 ; i<arr1.length ; i++) {
				m1 = arr1[i];
				Monom m2 = new Monom(m1);
				p1.add(m2);
			}
		}
		Iterator<Monom> it = p1.iteretor();
		boolean flag = false;
		
		while(it.hasNext()) {
			Iterator<Monom> it1 = monoms.iterator();
			Monom temp = it.next();
			while(it1.hasNext()) {
				Monom temp1 = it1.next();
				if(temp.get_power() == temp1.get_power()) {
					temp1.add(temp);
					flag = true;
				}
			}
			if(flag == false)
				monoms.add(new Monom (temp.get_coefficient(), temp.get_power()));
		}
	}

	@Override
	public double f(double x) {
		double y = 0.0;
		Iterator<Monom> it = monoms.iterator();
		
		while(it.hasNext()) {
			Monom m1 = it.next();
			y += (m1.get_coefficient() * Math.pow(x, m1.get_power()));
		}
		return y;
	}

	@Override
	public void add(Polynom_able p1) {
		Iterator<Monom> it = p1.iteretor();
		boolean flag = false;
		
		while(it.hasNext()) {
			Iterator<Monom> it1 = monoms.iterator();
			Monom temp = it.next();
			while(it1.hasNext()) {
				Monom temp1 = it1.next();
				if(temp.get_power() == temp1.get_power()) {
					temp1.add(temp);
					flag = true;
				}
			}
			if(flag == false)
				monoms.add(new Monom (temp.get_coefficient(), temp.get_power()));
		}
		this.monoms.sort(cmpByPow);
		
	}
		
	@Override
	public void add(Monom m1) {
		boolean flag = false;
		Iterator<Monom> it = monoms.iterator();

		while(it.hasNext()) {
			Monom temp = it.next();
			if(temp.get_power() == m1.get_power() && (m1.get_coefficient() != 0)) {
				temp.add(m1);
				flag = true;
			}
		}
		if((flag == false) && (m1.get_coefficient() != 0))
			monoms.add(new Monom (m1.get_coefficient(), m1.get_power()));
		this.monoms.sort(cmpByPow);
		
	}

	@Override
	public void substract(Polynom_able p1) {
		Iterator<Monom> it = p1.iteretor();
		boolean flag = false;
		
		while(it.hasNext()) {
			Iterator<Monom> it1 = monoms.iterator();
			Monom temp = it.next();
			while(it1.hasNext()) {
				Monom temp1 = it1.next();
				if(temp.get_power() == temp1.get_power()) {
					temp1.substract(temp);
					flag = true;
				}
			}
			if(flag == false) 
				monoms.add(new Monom (-(temp.get_coefficient()), temp.get_power()));
			flag = false ;
		}
		this.monoms.sort(cmpByPow);
		Iterator<Monom> it1 = monoms.iterator();
		if(it1.next().get_coefficient() == 0) {
			this.monoms.clear();
			Monom m1 = new Monom(); 
			this.monoms.add(m1);
		}
			
	}

	@Override
	public void multiply(Polynom_able p1) {
		Iterator<Monom> itp1 = p1.iteretor();
		Polynom p2 = new Polynom();
			
		while(itp1.hasNext()) {		
			Iterator<Monom> it = monoms.iterator();
			Monom temp1 = itp1.next();
			while(it.hasNext()) {
				Monom temp = it.next();
				p2.add(new Monom(temp.get_coefficient()*temp1.get_coefficient(),temp.get_power()+temp1.get_power()));	
			}
		}
		monoms.clear();
		this.add(p2);
		this.monoms.sort(cmpByPow);		
	}

	@Override
	public boolean equals(Polynom_able p1) {
		Iterator<Monom> itp1 = p1.iteretor();
		Iterator<Monom> it = monoms.iterator();
		while(itp1.hasNext() && it.hasNext()) {
			Monom temp1 = itp1.next();
			Monom temp = it.next();
			if((temp1.get_coefficient() != temp.get_coefficient()) || (temp1.get_power() != temp.get_power()))
				return false;
		}
		if(itp1.hasNext() || it.hasNext())
			return false;
		return true;
	}

	@Override
	public boolean isZero() {
		Iterator<Monom> it = monoms.iterator();
		while(it.hasNext()) {		
			Monom temp = it.next();
			if (temp.get_coefficient() != 0.0 || temp.get_power() != 0)
				return false;
		}
		return true;
	}

	@Override
	public double root(double x0, double x1, double eps) {
		double mid = ((x0 + x1) / 2);
		double y = f(mid);
		while((Math.abs(y)) > eps) {
			if((f(x0) * f(mid)) < 0) {
				x1 = mid;
				mid = ((mid + x0) / 2);
				y = f(mid); 
			}
			else {
				x0 = mid;
				mid = ((mid + x1) / 2);
				y = f(mid); 
			}
		}
		return mid;
	}

	@Override
	public Polynom_able copy() {
		Polynom_able p1 = new Polynom();
		Iterator<Monom> it = monoms.iterator();
		while(it.hasNext()) {
			Monom temp = it.next();
			p1.add(temp);
		}	
		return p1;
	}

	@Override
	public Polynom_able derivative() {
		Polynom_able p1 = new Polynom();
		p1 = this.copy();
		Iterator<Monom> itp1 = p1.iteretor();
		while(itp1.hasNext()) {
			Monom temp = itp1.next();
			temp.derivative();
		}
		return p1;
	}

	@Override
	public double area(double x0, double x1, double eps) {
		double length = x1 - x0;
		double loops = (length / eps); 
		double area = 0.0;
		for (int i = 0 ; i<loops ; i++) {
			if(f(x0) > 0)
				area += (eps * f(x0));
			x0 += eps;
			x1 += eps;			
		}
		return area;
	}
	
	/**
	 * Compute Riemann's Integral over this Polynom starting from x0, till x1 using eps size steps,
	 * see: https://en.wikipedia.org/wiki/Riemann_integral
	 * @return the approximated area under the x-axis below this Polynom and between the [x0,x1] range.
	 * @param x0 represent the start point to check area.
	 * @param x1 represent the end point to check area.
	 * @param eps represent the accuracy of the answer.
	 */
	
	public double areaUnder(double x0, double x1, double eps) {
		double length = x1 - x0;
		double loops = (length / eps); 
		double area = 0.0;
		for (int i = 0 ; i<loops ; i++) {
			if(f(x0) < 0)
				area += (eps * f(x0));
			x0 += eps;
			x1 += eps;			
		}
		return -area;
	}

	@Override
	public Iterator<Monom> iteretor() {	
		Iterator<Monom> it = monoms.iterator();
		return it;
	}
	
	/**
	 * print a string that displays the current polynom 
	 * @return string that displays the polynom
	 */
	public String toString() {
		String s = "" ;
		Iterator<Monom> it = monoms.iterator();
		while(it.hasNext()) {
			Monom m1 = it.next();
			s += m1.toString();
		}
		int a = s.length();
		s = s.substring(0, a);
		return s;
	}

	
	
}

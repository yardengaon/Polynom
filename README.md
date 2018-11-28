# Polynom 

## The project has 3 interfaces and 4 classes, one of which is the main.

### Interfaces are:
1. interface function 
2. interface cont_function extends function 
3. interface Polynom_able extends cont_function 

### The classes are:
1. class Monom_Comperator implements Comparator <Monom> 
2. class Monom implements function 
3. class Polynom implementments Polynom_able 
4. class test - main

### Now I'll explain what each interface and classes do: 
1. interface function - This interface represents a simple function of type y = f (x) where y and x are real numbers. 
2. interface cont_function - The interface represents a continuity function. 
3. interface Polynom_able - This interface displays a general polynomial: f (x) = a_1X ^ b_1 + a_2 * X ^ b_2 ... a_n * Xb_n, a_1, a_2 ...      a_n are real numbers and b_1 is larger then b_2..Bigger then b_n is greater than or equal to (0) There are no negative numbers              (naturals). 
4. class Monom_Comperator - implements Comparator<Monom>. 
5. class Monom - This class represents a simple "Monom" of shape a * x ^ b, where a is a real number and a is an integer (summed a none        negative) The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
6. class Polynom - This class represents a Polynom with add, multiply, substruct, derivative, area, equals, copy, functionality, it also      should support the following: Finding a numeric value between two values (currently support root only f (x) = 0). 
7. class test - Checks all functions belonging to monom and polynomial.

### Sources
Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral

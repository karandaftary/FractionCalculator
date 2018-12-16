
public class FractionCalculator {
	Fraction f1, f2;
	String operator;
	Fraction ans;
	
	public FractionCalculator(String[]  input)
	{
		// check for correct input
		if(input.length == 1)
			ans = new Fraction(input[0]);
		if(input.length % 2 == 0) // input expression is ending with an operand like + - * /
			System.out.println("incorrect expression: please provide an expression that is in the form: <operand> <operator> <operand>");
		if(!checkForAcceptableChars(input))
			System.out.println("invalid input: only valid characters like digits (0-9) and chars (* / + OR -) are allowed");
		// assume you have properly formed input
		parseExpression(input);// 1/4 + 1/2
		ans = executeExpression();// 3/4
		System.out.println(ans);
		
	}
	
	@Override
	public String toString() {
		return ans.toString();
	}
	
	private boolean checkForAcceptableChars(String[] input) {
		// loop through all characters and make sure they are either digit (0-9) or one of * / + -
		for(int k =0; k<input.length; k++)
		{ String s = input[k];
			for(int i = 0; i < s.length(); i++)
			{
				Character c = s.charAt(i);
				//if (c.equals(new Character('*')) && input[k-1].charAt(input[k-1].length()-1) != '\\') {
				//	System.out.println("It seems you are trying to multiply. Try escaping the * character by replacing it with \\* and rerun the program.");
				//	return false;
				//}
				if(!(c.isDigit(c)
						|| c.equals(new Character('*'))
						|| c.equals(new Character('+'))
						|| c.equals(new Character('-'))
						|| c.equals(new Character('/'))
						|| c.equals(new Character('_'))
						|| c.equals(new Character('\\'))
						))
					//
					return false;
			}
		}
		return true;
	}

	// assumes the expression is parsed.
	private Fraction executeExpression() {
		switch(operator){
		case "*":
			return multiply(f1,f2);
		case "/":
			return divide(f1,f2);
		case "+":
			return add(f1, f2);
		case "-":
			return subtract(f1,f2);
		default: 
			System.out.println("no operator!!!!!!");
		}
		return null; // at this point - no other condition was met.
	}

	private Fraction subtract(Fraction A, Fraction B) {
		B.numerator = -B.numerator;
		return add(A,B);
	}

	private Fraction add(Fraction A, Fraction B) {
		
		
//		check for 0 in A or 0 in B
		if(A.numerator == 0) return B;
		if(B.numerator == 0) return A;
		
		// get Least Common Multiple = a / gcd(a,d) * b
		Long gcd = Fraction.GCD(A.denominator, B.denominator);
		Long lcm = A.denominator * B.denominator / gcd;
		// multiply A and B by LCM, and add their numerators
		Fraction temp = new Fraction("1");
		
		// handle mixed case
		if(A.mixed || B.mixed) temp.mixed = true;
		
		if(A.denominator != lcm)
		{
			A.numerator *= lcm/A.denominator;
			A.denominator = lcm;			
		}
		if(B.denominator != lcm)
		{
			B.numerator *= lcm/B.denominator;
			B.denominator = lcm;			
		}

		
		assert(A.denominator == B.denominator);
		
		temp.numerator = A.numerator + B.numerator;
		temp.denominator = A.denominator;
		

		
		// simplify
		temp.simplify();
		return temp;
	}

	private Fraction divide(Fraction A, Fraction B) {
		// check div by 0, else: divide numes, denoms, 
		if(B.numerator == 0)
		{
			System.out.println("Your 2nd fraction has a 0 in it. That's not allowed unfortunately - Please rerun the program with non-zero fractions");
			System.exit(0);
		}
		Fraction temp = new Fraction("1"); 
		
		// flip B
		long tmp = B.denominator;
		B.denominator = B.numerator;
		B.numerator = tmp;
		
		// multiply A and newB
		temp = multiply(A, B);
		
		// if either was a mixed fraction to begin with - return a mixed fraction
		if(A.mixed || B.mixed) temp.mixed = true;
		return temp;
	}

	private Fraction multiply(Fraction A, Fraction B) {
		Fraction temp = new Fraction("1");
		
		
		
		
		// multiply numerators
		temp.numerator = A.numerator * B.numerator;
		// multiply denominators
		temp.denominator = A.denominator * B.denominator;
		// simplify
		temp.simplify();
		if(A.mixed | B.mixed)
			
			temp.mixed = true;
		return temp;
	}

	void parseExpression(String[] input)
	{
		f1 = new Fraction(input[0]);
		f1.simplify();
		operator = input[1];
		f2 = new Fraction(input[2]);
		f2.simplify();
	}
	
	
	
}// end FractionCalculator

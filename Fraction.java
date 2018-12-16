/**
 * Fraction class that handles all fraction operations
 * @author karan
 *
 */
public class Fraction {
	Long numerator ; 
	Long denominator ;
	Long wholePart;
	boolean mixed;

	//	Mixed numbers will be represented by whole_numerator/denominator. e.g. "3_1/4"
	//	Improper fractions and whole numbers are also allowed as operands.
	public Fraction(String number)
	{

		//case: fraction like 3/4
		if(number.contains("/"))
		{
			// mixed number like 3_1/4
			if(number.contains("_"))
			{
				int x = number.indexOf('_');
				String wholeNumString = number.substring(0, x);
				wholePart = Long.parseLong(wholeNumString);
				number = number.replace(wholeNumString+"_", "");
				mixed = true;
			}
			
			// parsing fraction part
			int a = number.indexOf('/');
			String numeStr = number.substring(0,a);
			numerator = Long.parseLong(numeStr);
			String denomStr = number.substring(a+1, number.length());
			denominator = Long.parseLong(denomStr);
			if(denominator == 0) 
			{
				System.out.println("denominator cannot be 0\n please rerurn program with a valid fraction");
				System.exit(0);
			}
			
		}
		else //assume case whole number like 1
		{
			numerator = Long.parseLong(number);
			denominator = new Long(1);
		}
		

		
	}
	
	
	
	@Override
	public String toString() {
		// returns string representation of the fraction
		if(numerator == 0) return "0";
		if(denominator == 1) return ""+numerator;
		
		StringBuilder sb = new StringBuilder();
		String str = "";
		
		if(mixed && Math.abs(numerator) > Math.abs(denominator))
		{
			wholePart = numerator / denominator;
			numerator = numerator % denominator;
			str = Math.abs(wholePart)+"_"+Math.abs(numerator)+"/"+Math.abs(denominator);
		}
		else
		{
			str = Math.abs(numerator)+"/"+Math.abs(denominator);			
		}
		

		if(numerator < 0 || denominator < 0)
			sb.insert(0, "-");
		sb.append(str);
		
		return sb.toString();
		
	}

	public void simplify() {
		// nume = whole * denom + nume 
		if(mixed) // if mixed, conver to improper fraction.
		{
			if(wholePart != null)
			{
				numerator = (wholePart * denominator) + numerator;
				wholePart = null;
			}
		}
		
		// simplify fraction to it's least terms
		Long gcd = GCD(numerator,denominator); 
		numerator = numerator / gcd;
		denominator = denominator / gcd;
	}
	
	static long GCD(Long a, Long b)
	{
		while(b != 0)
		{
			Long temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
}

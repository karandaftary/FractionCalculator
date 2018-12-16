import java.util.ArrayList;
import java.util.Arrays;

/*
 * Write a command line program in the language of your choice that will take operations on fractions as an input and produce a fractional result.
Legal operators shall be *, /, +, - (multiply, divide, add, subtract)
Operands and operators shall be separated by one or more spaces
Mixed numbers will be represented by whole_numerator/denominator. e.g. "3_1/4"
Improper fractions and whole numbers are also allowed as operands. Only expressions of the form <operand> <operator> <operand> (a single operator)
are required though you're welcome to handle more complex expressions if you like.

Example run:
? 1/2 * 3_3/4
= 1_7/8

? 2_3/8 + 9/8
= 3_1/2

Note that any conversion to a decimal (float, double) internally will disqualify the program.
 */
import java.util.Scanner;
public class Runner {

	public static void main(String[] args) {
		// check for legitimate input
		
//		// else parse and execute expression
//		Scanner in = new Scanner(System.in); 
//		System.out.println("*** Fraction Calculator ***"); 
//		System.out.println("Please enter the expression here:");
//        String s = in.nextLine(); 
//        System.out.println("You entered string "+s); 
//        String[] arr = s.split("");
		// TODO uncomment after done with all tests
		FractionCalculator fc = new FractionCalculator(args); 
		
	//	myTests();
		}
	
	private static void myTests() {
		// Test FractionCalculator with all sorts of inputs
		System.out.println("Testing Fraction Calculator");
		ArrayList<String> myList = new ArrayList<String>();
		myList.add("   1/4 +   1/5");
		myList.add("1_3/5 -   20_4/5  ");
		myList.add("-1/4 *          1/5");
		myList.add("  1/4   /       -1/5");
		myList.add("1_1/4 + 1/2");
		myList.add("1 + 1");
		myList.add("1/2 * 3_3/4");// 	1_7/8
		myList.add("2_3/8 + 9/8");//	3_1/2 
	
		// input cleaning
		for(String s : myList)
		{
			s = s.trim();
			String[] splitedOut = s.split(" ");
			// splitedOut needs to be only 3 elements
			if(splitedOut.length > 3)
			{
				ArrayList<String> cleanList = new ArrayList<String>();
				for(int i = 0; i < splitedOut.length; i++)
				{
					if(!splitedOut[i].equals(""))
						cleanList.add(splitedOut[i]);
				}// end for loop
				splitedOut = (String[]) cleanList.toArray(new String[cleanList.size()]);
			}
			FractionCalculator ans = new FractionCalculator(splitedOut);
			System.out.println(s + " = "+ ans);
		}
		
	}// end myTests()
	
	private void cleanUp(String[] strArr)
	{
		if(strArr.length < 1)
		{
			System.out.println("It seems you provided invalid input: " + Arrays.toString(strArr));
			System.out.println("please rerun the program with 2 fractions and an operator");
			System.exit(0);
		}
		
		
	}
	

	

	}



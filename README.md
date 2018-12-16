# FractionCalculator
Performs basic arithmetic calculations (* / + -) on Fractions. 

Input: taken from command line arguments. 

How to run the application: 
1) Compile: Runner.java
2) Run: Runner.java {fraction expression} eg: Runner 3/4 + 1/3 

The program accepts input of type {operand} {operator} {operand} like 1/4 + 3/4.
Progarm also accepts mixed number in the form of {wholePart}_{numerator}/{denominator} like 2_1/3

Note: "*" (multiply) needs to be escaped due to command line constraints. Hence, for multiplication - type in the expression: {operand} "\*" {operand}

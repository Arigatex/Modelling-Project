package equationsystemproject;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		ReadUserInput read = new ReadUserInput();
		SolveEquationSystem system = new SolveEquationSystem();
		AnaliticMethod method1 = new AnaliticMethod();
		read.readInput();
System.out.println(method1.calculate(read.l, read.hl,read.h0));
	}
}

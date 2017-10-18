package equationsystemproject;

public class Main {

	public static void main(String[] args) {

		// Creating the objects
		ReadUserInput read = new ReadUserInput();
		SolveEquationSystem eqsystem = new SolveEquationSystem();
		AnaliticMethod method1 = new AnaliticMethod();

		// Reading the input data and building the matrix
		read.readInput();
		System.out.println("\n" + "h(L/2)= " + method1.calculate(read.l, read.hl, read.h0) + "\n");

		// Solving the equation system
		eqsystem.sES(read.grid1, read.vector_left, read.grid3);

		// Printing the solutions
		for (int i = 0; i < eqsystem.equationsize; i++) {
			System.out.print("h" + i + ": " + eqsystem.results[i] + "\t");
		}
	}
}

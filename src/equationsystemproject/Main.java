package equationsystemproject;

public class Main {

	public static void main(String[] args) {

		// Reading the input data
		ReadUserInput read = new ReadUserInput();
		read.readInput();

		// Creating the Matrix System
		Matrix matrix = new Matrix((int) read.n, read.l, read.k, read.h0, read.hl, read.q0, read.ql, read.w0, read.wl);

		// Printing the Matrix
		matrix.MatrixPrinter();

		// Solving the analytic method
		AnaliticMethod method1 = new AnaliticMethod();
		System.out.println("Through analythic method:\t" + "h(L/2)= " + method1.calculate(read.l, read.hl, read.h0) + "\n");

		// Solving the equation system
		SolveEquationSystem eqsystem = new SolveEquationSystem();
		eqsystem.sES(matrix.getMatrix(), matrix.getVectorLeft(), matrix.getVectorRight());

		//Printing the equation system
		System.out.println("Through Finite Difference Method:");
		for (int i = 0; i < eqsystem.equationsize; i++) {
			System.out.print("h" + i + ": " + eqsystem.results[i] + "\t");
		}
	}
}

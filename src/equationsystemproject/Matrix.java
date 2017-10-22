package equationsystemproject;

import java.text.DecimalFormat;

class Matrix {

	private DecimalFormat df = new DecimalFormat("0.00");
	private boolean exceptiontop = false;
	private boolean exceptionbot = false;
	private double[][] matrix;
	private double[] vectorright;
	private double[] vectorleft;

	////////////////////////////////// Constructor/////////////////////////////////

	public Matrix(int n, double l, double k, double h0, double hl, double q0, double ql, double w0, double wl) {

		double[] vectorright = new double[n + 1];
		double[] vectorleft = new double[n + 1];
		double[][] matrix = new double[n + 1][n + 1];// <-----------initialize the general // vector

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix.length; col++) {

				if (row == col) { // <----------------------Middle diagonal
					if (row == 0) {
						matrix[row][col] = 1;
					}
					if (row == n) {
						matrix[row][col] = 1;
					}
					if (0 < row && row < n) {
						matrix[row][col] = 6 * k;
					}

				} else {

					if (row == col + 1 || row == col - 1) { // <---Secondary diagonals
						exceptiontop = false;
						exceptionbot = false;

						if (row == 0 && col == 1) { // Filling the top left element
							matrix[row][col] = 0;
							exceptiontop = true;
						} else {
						}

						if (row == n && col == n - 1) { // Filling the bottom right element
							matrix[row][col] = 0;
							exceptionbot = true;
						} else {
						}

						if (exceptiontop == false && exceptionbot == false) { // <----Filling the 2 sub-diagonals
							matrix[row][col] = -3.0 * k;
						}
					} else {
						matrix[row][col] = 0; // <----------------------------------Filling the 0s. Not necessary
					}
				}
			}
		}

		// Filling the right vector
		for (int i = 0; i < vectorright.length; i++) {
			if (i != 0 && i != n) {
				vectorright[i] = w0;
			} else {
				if (i == 0) {
					vectorright[i] = h0;
				} else {
					vectorright[i] = hl;
				}
			}
		}
		setMatrix(matrix);
		setVectorRight(vectorright);
		setVectorLeft(vectorleft);
	}

	/////////////////////////// Setters/Getters//////////////////////////////////////////

	public void setMatrix(double[][] matrix) {
		this.matrix = matrix;
	}

	public double[][] getMatrix() {
		return matrix;
	}

	public void setVectorRight(double[] vector) {
		this.vectorright = vector;
	}

	public double[] getVectorRight() {
		return vectorright;
	}

	public void setVectorLeft(double[] vector) {
		this.vectorleft = vector;
	}

	public double[] getVectorLeft() {
		return vectorleft;
	}

	//////////////////////// Matrix///////////////////////////////////////////////////////////
	//////////////////////// Printer//////////////////////////////////////////////////////////

	public void MatrixPrinter() {

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix.length; col++) {

				System.out.print(df.format(matrix[row][col]) + "\t"); // <-----------------Printing the Matrix
			}
			System.out.println("");
		}
		System.out.println();
		System.out.print("Left vector:\t");
		VectorPrinter(vectorleft);
		System.out.print("Right vector:\t");
		VectorPrinter(vectorright);
		System.out.println("");
	}

	/////////////////////////// Vector
	/////////////////////////// Printer///////////////////////////////////////////////

	public void VectorPrinter(double[] vector) {

		for (int row = 0; row < vector.length; row++) {

			System.out.print(df.format(vector[row]) + "\t"); // <-----------------Printing the Vector
		}
		System.out.println("");
	}

}

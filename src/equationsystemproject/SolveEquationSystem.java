package equationsystemproject;

public class SolveEquationSystem {

	double[] results;
	int equationsize;

	public void sES(double[][] matrix, double[] vector_left, double[] vector_right) {

		double fMaxElem;
		double fAcc;
		int nodenumber = vector_left.length;
		for (int k = 0; k < (nodenumber - 1); k++) // base row of matrix
		{
			// search of line with max element
			fMaxElem = Math.abs(matrix[k][k]);
			int m = k;
			for (int i = k + 1; i < nodenumber; i++) {
				if (Math.abs(fMaxElem) < Math.abs(matrix[i][k])) {
					fMaxElem = matrix[i][k];
					m = i;
				}
			}
			// permutation of base line (index k) and max element line(index m)
			if (m != k) {
				for (int i = k; i < nodenumber; i++) {
					fAcc = matrix[k][i];
					matrix[k][i] = matrix[m][i];
					matrix[m][i] = fAcc;
				}
				fAcc = vector_right[k];
				vector_right[k] = vector_right[m];
				vector_right[m] = (int) fAcc;
			}
			if (Math.abs(matrix[k][k]) < 1.e-10) {
				System.out.println("matrix singular " + k + " " + matrix[k][k]);// needs improvement !!!
			}
			// triangulation of matrix with coefficients
			for (int j = (k + 1); j < nodenumber; j++) // current row of matrix
			{
				fAcc = -matrix[j][k] / matrix[k][k];
				for (int i = k; i < nodenumber; i++) {
					matrix[j][i] = matrix[j][i] + fAcc * matrix[k][i];
				}
				vector_right[j] = (int) (vector_right[j] + fAcc * vector_right[k]); // free member recalculation
			}
		}
		
		for (int k = (nodenumber - 1); k >= 0; k--) {
			vector_left[k] = vector_right[k];
			for (int i = (k + 1); i < nodenumber; i++) {
				vector_left[k] -= (matrix[k][i] * vector_left[i]);
			}
			vector_left[k] = (int) (vector_left[k] / matrix[k][k]);
		}
		equationsize=vector_left.length;
		results = new double[vector_left.length];
		for (int i = 0; i < vector_left.length; i++) {
			results[i]=vector_left[i];
		}

	}

}

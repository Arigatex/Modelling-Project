package equationsystemproject;

import java.util.Scanner;

public class ReadUserInput {

	public void readInput() {
		
		Scanner input = new Scanner(System.in);

		// Length
		System.out.println("Enter the system length: ");
		double length = input.nextDouble();

		// Conductivity
		System.out.println("Enter the system conductivity: ");
		double k = input.nextDouble();

		// Number of points
		System.out.println("Enter the number of points: ");
		double n = input.nextDouble();

		// H0 - Q0
		System.out.println("H0 or Q0?: 1/2");
		double h0 = 0;
		double q0 = 0;

		int switch0;
		boolean invalid0 = true;

		while (invalid0 == true) {
			invalid0 = false;
			switch0 = input.nextInt();
			switch (switch0) {
			case (1): // H0
				System.out.println("Enter H0: ");
				h0 = input.nextDouble();
				q0 = 0;
				invalid0 = false;
				break;

			case (2): // Q0
				System.out.println("Enter Q0: ");
				q0 = input.nextDouble();
				h0 = 0;
				invalid0 = false;
				break;

			default: // Otherwise
				System.out.println("Invalid input");
				invalid0 = true;
			}
		}

		// Hl -Ql
		System.out.println("Hl or Ql?: 1/2");
		double hl = 0;
		double ql = 0;

		int switchl;
		boolean invalid1 = true;

		while (invalid1 == true) {
			invalid1 = false;
			switchl = input.nextInt();
			switch (switchl) {
			case (1): // Hl
				System.out.println("Enter Hl: ");
				hl = input.nextDouble();
				ql = 0;
				invalid1 = false;
				break;

			case (2): // Ql
				System.out.println("Enter Ql: ");
				ql = input.nextDouble();
				hl = 0;
				invalid1 = false;
				break;

			default: // Otherwise
				System.out.println("Invalid input");
				invalid1 = true;

			}
		}

		// W0
		System.out.println("Enter W0: ");
		double w0 = input.nextDouble();

		// Wl
		System.out.println("Enter Wl: ");
		double wl = input.nextDouble();

		System.out.println("Data Input Complete!");

		double[][] grid1 = new double[5][5];
		double[] vector_left = new double[5];
		double[] grid3 = new double[5];

		// Filling the matrix 1 for H0 - HL
		for (int row1 = 0; row1 < grid1.length; row1++) {
			for (int col1 = 0; col1 < grid1[row1].length; col1++) {
				if (row1==col1) {
					
					if(row1==0) { //Border condition 0
						grid1[row1][col1] = 1/k;
					}
					
					if(row1==5) { //Border condition L
						grid1[row1][col1] = 1/k;
					}
					
					else { //Middle diagonal
						grid1[row1][col1] = 6;
					}
					
				}
				else {
					
					if(col1==row1+1 | col1==row1-1) { //Filling the surrounding cells
						grid1[row1][col1] = -3;
					}
					else { //Filling the 0s. Not necessary
						grid1[row1][col1] = 0;
					}
				}
			}
		}

		// Filling the matrix 2 for H0 - HL
		double h[]=new double[5];
		for (int i = 0; i < 5; i++) {
		    h[i] = 5;
		}
		
		for (int i2 = 0; i2 < vector_left.length; i2++) {
				vector_left[i2] =h[i2+1] ;
		}

		// Filling the matrix 3 for H0 - HL
		for (int i3 = 0; i3 < grid3.length; i3++) {
			if(i3!=0&i3!=5) {
				grid3[i3] = w0;	
			}
			else {
				if(i3==0) {
					grid3[i3]=h0;
				}
				else {
					grid3[i3]=hl;
				}
			}		
		}
	}
	
}

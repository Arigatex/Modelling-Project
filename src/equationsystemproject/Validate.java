package equationsystemproject;

import java.util.Scanner;

public class Validate {

	private double newinput;
	boolean isDouble = false;
	StringBuilder sb;
	private int h0;
	private int hl;
	private int q0;
	private int ql;
	private int intinput;
	private String casedetected = new String();
	private int casenum = 0;
	int validation;

	public Validate(String read, Scanner input, String arg) {

		while (!validateDouble(read)) {
			System.out.println(arg);
			read = input.next();
		}
	}

	public boolean validateDouble(String input) {
		try {
			Double.parseDouble(input);
			this.setValue(input);
			return true;
		} catch (NumberFormatException e) {
			System.out.println("Invalid value");
			return false;
		}
	}

	/*public int validateHQ(String read, Scanner input) {

		try {
			intinput = Integer.parseInt(read);
			if (intinput == 0) {
				this.validation = 0;
				if (intinput == 1) {
					this.validation = 1;
				}

			} else {
				System.out.println("Invalid value. Try again.");
				read = input.next();
				validateHQ(read, input);
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid value");
			read = input.next();
			validateHQ(read, input);
		}
		return this.validation;
	}*/

	public int validateNumbers(String read) {

		int aux = Integer.parseInt(read);

		switch (aux) {
		case (0):
			validation = 0;
			break;
		case (1):
			validation = 1;
			break;
		default:
			validation = 2;
		}
		return validation;
	}

	////////////////////// Identifying the case/type of matrix to be
	////////////////////// used////////////////////////////////

	public String identifyCase(int x0, int xl) {
		this.h0 = x0;
		this.hl = xl;
		this.q0 = x0;
		this.ql = xl;

		if (h0 != 0 && hl != 0) {
			this.casedetected = "h0 and hl given";
			this.casenum = 1;
		} else {
			if (q0 != 0 && hl != 0) {
				this.casedetected = "q0 and hl given";
				this.casenum = 2;
			} else {
				if (h0 != 0 && ql != 0) {
					this.casedetected = "h0 and ql given";
					this.casenum = 3;
				} else {
					this.casedetected = "Unsuitable border conditions";
					this.casenum = 4;
				}
			}
		}
		return this.casedetected;
	}

	////////////////////////////////// Setters and
	////////////////////////////////// Getters/////////////////////////////////

	private void setValue(String input) {
		this.newinput = Double.parseDouble(input);
	}

	public double getValue() {
		return this.newinput;
	}

}

package ua.nure.rakova;

import java.util.Scanner;

public class XOR {

	public static int xor(int arg1, int arg2)
	{
		return arg1 & ~arg2 | ~arg1 & arg2;
	}
	public static void main(String[] args) {
		while (true) {
			System.out.println("Enter first argument for XOR operation(or print exit)");
			Scanner scan = new Scanner(System.in);
			String scaned = scan.nextLine();
			if (scaned.equals("exit"))
				break;
			try{
			int arg1 = Integer.parseInt(scaned);
			System.out.println("Enter second argument for XOR operation(or print exit)");
			scaned = scan.nextLine();
			if (scaned.equals("exit"))
				break;
			int arg2 = Integer.parseInt(scaned);

			System.out.println("first argument binary : " + Integer.toString(arg1, 2));
			System.out.println("second argument binary : " + Integer.toString(arg2, 2));
			System.out.println("xor result binary : " + Integer.toString(xor(arg1, arg2), 2));
			} catch (Exception e) {
				System.out.println("wrong arguments");
				continue;
			}
		}

	}

}

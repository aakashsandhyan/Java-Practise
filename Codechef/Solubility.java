import java.io.*;
import java.util.Scanner;

class Solubility{
	
	public static void main(String args[]){
		int t;
		Scanner scanner = new Scanner(System.in);
		t = scanner.nextInt();

		int x, a, b;
		for(int i = 0; i < t; i++){
			x = scanner.nextInt();
			a = scanner.nextInt();
			b = scanner.nextInt();

			int initSugarQuantity = 10 * a;
			int sugarAdded = 10 * b * (100 - x);
			int totalSugar = initSugarQuantity + sugarAdded;
			System.out.println(totalSugar);
		}
	}
}
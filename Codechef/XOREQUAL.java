//LKDNGOLF
import java.io.*;
import java.util.Scanner;

class XOREQUAL{

	private static int[] arr = new int[100001];
	private static final int MOD = 1000000007;

	// static Scanner scanner = new Scanner(System.in);
	public static void main(String args[]) throws IOException{

		long t;
		int n;

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = 	bf.readLine();
		generate();
		t = Long.valueOf(s);
		for(long i = 0; i < t; i++){
			s = bf.readLine();
			n = Integer.valueOf(s);
			System.out.println(arr[n]);
		}

	}

	private static void generate(){
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		for(int i = 4; i <= 100000; i++){
			arr[i] = (int) ((long)(arr[i - 1] * 2) % MOD);
		}
	}
}
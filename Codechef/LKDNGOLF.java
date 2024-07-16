//LKDNGOLF
import java.io.*;
import java.util.Scanner;

class LKDNGOLF{

	// static Scanner scanner = new Scanner(System.in);
	public static void main(String args[]) throws IOException{

		long t, n, x, k;

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = 	bf.readLine();
		t = Long.valueOf(s);
		for(long i = 0; i < t; i++){

			String str = bf.readLine();
			String arr[] = str.split(" ");
			n = Long.valueOf(arr[0]);
			x = Long.valueOf(arr[1]);
			k = Long.valueOf(arr[2]);

			String golf = "NO";

			if( x%k == 0 || (n+1-x)%k == 0){
				golf = "YES";
			}

			System.out.println(golf);
			 
		}

	}
}
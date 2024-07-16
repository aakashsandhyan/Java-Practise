import java.io.*;
import java.util.Scanner;
import java.lang.Math;

class LKDNGOLF{

	// static Scanner scanner = new Scanner(System.in);
	public static void main(String args[]) throws IOException{

		long t;

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = 	bf.readLine();
		t = Long.valueOf(str);
		for(long testCase = 0; testCase < t; testCase++){

			String s[] = new String[3];
			for(int j = 0; j < 3; j++){
				s[j] = bf.readLine();
			}

			boolean winnerO = false, winnerX = false;
			int countDiagonal = 0;
			int countWinners = 0;
			int countO = 0, countX = 0;
			int ans = 3;
			if(s[0].charAt(0) != '_' && s[0].charAt(0) == s[1].charAt(1) && s[1].charAt(1) == s[2].charAt(2))
			{
				if(s[0].charAt(0) == 'X')
					winnerX = true;
				else
					winnerO = true;
				countWinners++;
				countDiagonal++;
			}
			if(s[0].charAt(2) != '_' && s[0].charAt(2) == s[1].charAt(1) && s[1].charAt(1) == s[2].charAt(0))
			{
				if(s[0].charAt(2) == 'X')
					winnerX = true;
				else
					winnerO = true;
				countWinners++;
				countDiagonal++;
			}

			for(int  i = 0; i < 3; i++){
				if(s[i].charAt(0) != '_' && s[i].charAt(0) == s[i].charAt(1) && s[i].charAt(1) == s[i].charAt(2) ){
					if(s[i].charAt(0) == 'X'){
						winnerX = true;
					}
						
					else{
						winnerO = true;
					}
					countWinners++;
				}
				if(s[0].charAt(i) != '_' && s[0].charAt(i)== s[1].charAt(i) && s[2].charAt(i) == s[1].charAt(i)){
					if(s[0].charAt(i) == 'X'){
						winnerX = true;
					}
					else{
						winnerO = true;
					}
					countWinners++;
				}
				for(int j = 0; j < 3; j++){
					if(s[i].charAt(j) == 'X')
						countX++;
					else if(s[i].charAt(j) == 'O')
						countO++;
				}


			}

			if(Math.abs(countX - countO) <= 1){
				if(countWinners == 1){
					ans = 1;
				}
				else if(countWinners == 0){
					ans = 2;
				}
				else if(countWinners == 2 && countDiagonal == 1){
					if((winnerX & winnerO) == true){
						ans = 3;
					}
					else
						ans = 1;
				}
				else{
					ans = 3;
				}
			}
			else{
				ans = 3;
			}

			System.out.println(ans);
		}

	}
}
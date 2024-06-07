package quiz;

import java.util.Scanner;

public class PrimeNumber3 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("Number [0 : exit] : ");
			int num = sc.nextInt();
			if (num==0) break;
			PrimeNumber1 p1 = new PrimeNumber1();
			int s = (int)Math.pow(10, (double)(num-1));
			int e = (int)Math.pow(10, (double)(num))-1;
			//코드 작성
			int count = 0;
			for(int i=s; i<e; i++) {
				if(p1.isPrimeAll(i)==true) {
					System.out.print(i + " ");
					count++;
				} 
			}
			System.out.println();
		}
		System.out.println("Done!");
	}
	
	

}

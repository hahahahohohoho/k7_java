package quiz;

import java.util.Scanner;

public class PrimeNumber1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("Number[0:exit] : ");
			int num = sc.nextInt();
			if (num==0) break;
			if(isPrime(num) ==true)
				System.out.println(num + " is a Prime.");
			else
				System.out.println(num + " is not a Prime");
		}
		sc.close();
		System.out.println("Done!");
	}
	
	public static boolean isPrime(int num) {
		if(num<2) {
			return false;
		}
		for(int i = 2 ; i*i < num; i++) {
			if(num%i == 0) return false;
		} return true;

	}
	
	public static boolean isPrimeAll(int n) {
		int i =1;
		String s = String.valueOf(n);
		while(true) {
			if(!isPrime(Integer.parseInt(s.substring(0,i++))))
					return false;
			if(s.length() < i) 
				break;
		}
		return true;
	}
}

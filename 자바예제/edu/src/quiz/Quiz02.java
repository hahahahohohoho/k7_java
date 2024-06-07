package quiz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Quiz02 {
	//loadMatrix 구현
	private static int [][] loadMatrix(String fname){
		int[][] ret = null;
		List<String> list = new ArrayList<>();
		String str;
		try(BufferedReader br = new BufferedReader(new FileReader(fname))){
			while((str=br.readLine())!=null) {
				list.add(str);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}for(int i = 0; i < list.size();i++) {
			String[] arr = list.get(i).split(" ");
			if(ret == null) {
				ret = new int[list.size()][arr.length];
			}
			for(int j = 0; j<arr.length; j++) {
				ret[i][j] = Integer.parseInt(arr[j]);
			}
		}
		return ret;
	}

	
	//printMatrix 구현
	private static void printMatrix(int[][] m) {
		for(int i = 0;i<m.length;i++) {
			for(int j = 0; j<m[0].length; j++) {
				System.out.print(m[i][j] +"\t");
			}
			System.out.println();
		}
		System.out.println("-".repeat(30));
	}

	
//	printMatrix 구현
	private static int[][] calcMatrix(int[][] a, int[][] b){
		int [][] ret= new int [a.length][b[0].length];
		int sum = 0;
		for(int i=0; i<a.length; i++){
			for(int j=0; j<b[0].length; j++){
				for(int k=0; k<a[0].length; k++){
					sum += a[i][k] * b[k][j];
				}
				ret[i][j] = sum; 
				sum =0;
			}
		}
		return ret;
	} 
	
	
	
	//main
	public static void main(String[] args) {
		int[][] a = loadMatrix("m.txt");
		if(a==null)return;
		printMatrix(a);
		int[][] b = loadMatrix("m1.txt");
		if(b==null)return;
		printMatrix(b);
		int[][] c = calcMatrix(a,b);
		printMatrix(c);
	}
}

package quiz;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileReader;

public class Quiz01 {
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new FileReader("m.txt"))) {
			String str;
			while((str = br.readLine()) !=null) {
				String[] arr = str.split("");
				for(int i = 0; i<arr.length;i++) {
					System.out.print(Integer.parseInt(arr[i] + " "));
				}
				System.out.println();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
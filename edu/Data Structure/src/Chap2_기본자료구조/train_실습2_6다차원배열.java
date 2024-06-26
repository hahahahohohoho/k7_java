package Chap2_기본자료구조;

/*
 * 3번째 실습
 * 교재 83 - 배열 처리 + function parameter 전달 숙달 훈련 
 */

import java.util.Arrays;
import java.util.Random;
public class train_실습2_6다차원배열 {

	public static void main(String[] args) {
		double [][]A = new double[2][3];
		double [][]B = new double[3][4];
		double [][]C = new double[2][4];

		inputData(A);inputData(B);
		double [][]D = A.clone();//교재83 - 배열 복제
	
		showData("A[2][3] = ",A); showData("D[2][3] = ",D); showData("B[3][4] = ",B);
		
		double [][]E = addMatrix(A,D);//행렬 덧셈
		showData("E[2][3] = ",E);
		
		C = multiplyMatrix(A,B);//행렬 곱셈
		showData("C[2][4] = ",C);
		
		double [][]F = transposeMatrix(A);//전치 행렬
		showData("F[3][2] = ",F);
		
		
		boolean result = equals(A, D);//행렬 동등 비교
		System.out.println(" equals(A,D) = " + result);
//		
		System.out.println("F = " + Arrays.deepToString(F));//2차원 배열 처리 
	}
	static void inputData(double[][] A) {//double 난수 0.0 ~ 1.0 생성
		Random rnd = new Random();
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[0].length; j++) {
				A[i][j] = rnd.nextDouble();
			}
		}
	}
	static void showData(String msg, double[][] a) {//주어진 문자열을 출력하고 배열을 2차원 형태로 출력
		System.out.println(msg);
		for(int i =0; i<a.length;i++) {
			for(int j =0 ;j<a[0].length;j++) {
				System.out.print(a[i][j]+ "  ");
			}
			System.out.println();
		}
	}
	
	static boolean equals(double[][] A, double[][] B) {//두 행렬의 사이즈가 같고 값도 모두 같아야 행렬 2개는 equals을 true로 리턴
		boolean result = false;
		if(A.length == B.length & A[0].length == B[0].length) {
			for (int i = 0; i<A.length; i++) {
				for(int j=0; j<A[0].length;j++) {
					if(A[i][j]==B[i][j]) {result = true;}
					else {return false;}
				}
			}
		}
		return result;
	}
	
	static double[][] addMatrix(double[][] a, double[][] b) {//행렬 덧셈 결과를 리턴
		double[][] c = new double[a.length][a[0].length];
		for(int i=0; i< a.length ; i++) {
			for(int j =0; j<a[0].length; j++) {
				c[i][j] = a[i][j]+b[i][j];
			}
		}
		return c;
	}
	
	static double[][] multiplyMatrix(double[][] a, double[][] b) {//행렬 곱셈 결과를 리턴
		double [][] ret= new double [a.length][b[0].length];
		double sum = 0;
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
	static double[][] transposeMatrix(double[][] a) {//전치 행렬을 리턴
		double [][] ret= new double [a[0].length][a.length];
		//함수 구현
		for (int i =0; i<a[0].length;i++) {for(int j=0; j<a.length;j++) {
			ret[i][j] = a[j][i];
		}}
		return ret;
	}
}


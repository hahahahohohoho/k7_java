package Chap2_기본자료구조;

import java.util.Arrays;
//교재 67 - 실습 2-5
//2번 실습
import java.util.Random;
public class train_실습2_5정수배열정렬 {
	static int top = 0;
	static final int MAX_LENGTH = 20;
	public static void main(String[] args) {
		float []data = new float[MAX_LENGTH];// 0.0 ~ 1.0 사이의 실수를 저장
		inputData(data, 10);//10개의 난수를 입력
		showData(data);//top 개수 만큼 출력
		Random rnd = new Random();

		reverse(data);//역순으로 재배치 - 교재 67페이지 참조 - 교재는 length로 되어있는데 top으로 교체 필요
		System.out.println(Arrays.toString(data));// 교재 84페이지 코드 참조
//
		sortData(data);//교재 205 bubbleSort() 함수 코드를 사용 - 올림차순으로 정렬
//		showData(data);
		System.out.println(Arrays.toString(data));// 교재 84페이지 코드 참조

		float realData = rnd.nextFloat(); //실수 난수 생성;
		insertData(data, realData);//역순으로 재배치 - 정렬 아님
		System.out.println(realData);
//		showData(data);
		System.out.println(Arrays.toString(data));// 교재 84페이지 코드 참조

	}
	
	static void showData(float[] A) {//실수 배열을 top 갯수만 출력
		for(int i = 0 ; i<top;i++) {
			System.out.println(A[i]);
		}
	}
	static void inputData(float[] A, int count) {
		//난수 실수를 입력
		top += count;
		Random rnd = new Random();
		for(int i=0; i<count ; i++){A[i] = rnd.nextFloat();}
	}
	static void reverse(float[] data) { //역순으로 재배치
		for(int i=0; i<top/2 ; i++) {
			swap(data, i, top-i-1);
		}
	}
	static void swap(float[] a, int idx1, int idx2) {//교재 67페이지 - 맞교환
		float t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	static void sortData(float[] data) {//올림차순으로 정렬
		for(int i=0; i<top-1;i++)
			for(int j =top-1; j>i;j--) {
				if(data[j-1]>data[j]) swap(data, j-1, j);
			}
	}
	static void insertData(float[] data, float a) {//insert되는 실수 값이 insert될 위치를 찾아 보다 큰 값은 우측으로 이동 해결필요
		float tm = a;
		int num = 0;
		for(int i=0; i<top-1;i++) {
			if (tm > data[i] & tm < data[i+1]) {num = i+1;}
		}
		float k = data[top];
		for(int i=top; i>num-1;i--) {
			data[i+1] = data[i];
		}
		data[top+1] = k;
		data[num]=a;
	}


}

package Chap3_검색;
/*
* 3장 1번 실습과제: 03-3 정수배열이진검색
* 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
* 함수(메소드) 전체를 작성하는 훈련 
* 3장 - 1번 실습 과제 > 2번 실습: 스트링 객체의 정렬과 이진 탐색 > 3번 실습: 객체 정렬과 이진 탐색
*/
import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class train_실습3_4정수배열이진탐색 {

	public static void main(String[] args) {
		int []data = new int[30];
		inputData(data);// 구현 반복 숙달 훈련 - 100 이하 난수를 생성

		showList("정렬 전 배열[]:: ", data);
		Arrays.sort(data);
		showList("정렬 후 배열[]:: ", data);// 구현 반복 숙달 훈련

		int key = new Random().nextInt(100);//난수 입력
		boolean resultIndex = linearSearch(data, key);//교재 99-100:실습 3-1 참조, 교재 102: 실습 3-2
		//Arrays 클래스에 linear search는 없기 때문에 구현해야 한다
//		System.out.println("key = " + key + " result = " + resultIndex);
		System.out.println("\nlinearSearch(13): key = " + key + ", result = " + resultIndex);
//
		key = new Random().nextInt(100);//난수 입력
//		/*
//		 * 교재 109~113
//		 */
		resultIndex = binarySearch(data, key);//함수 구현이 필요
		System.out.println("\nbinarySearch(13): key = " + key + ", result = " + resultIndex);
//		key = //난수 입력;
//		/*
//		 * 교재 115 Arrays.binarySearch에 의한 검색
//		 */
		int resultIndex1 = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(10): result = " + resultIndex1);

	}
	static void inputData(int[] data) {
		for(int i=0 ; i<data.length;i++) {
			data[i] = new Random().nextInt(100);
		}
	}
	
	static void showList(String msg, int[] data){
		System.out.print(msg + " ");
		for(int i : data) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	static boolean linearSearch(int[] data, int key) {
		boolean result = false;
		for(int i =0; i<data.length; i++) {
			if(data[i]==key) result = true;		
		}
		return  result;		
	}
	static boolean  binarySearch(int[] data, int key) {
		boolean result = false;
		int left = 0; int right = data.length -1 ;
		while(left <=right) {
			int mid = (left+right)/2;
			if(data[mid]==key) {
				result = true; 
				return result;
			}
			else if (data[mid]>key) {
				right = mid - 1;
			}
			else 
				left = mid+1;
		}
		return result;
	}
}

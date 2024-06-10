package Chap3_검색;

/*
 * 3장 3번 실습과제 - 객체 배열의 정렬과 이진검색 - Comparable 구현
 * 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
 * 함수(메소드) 전체를 작성하는 훈련 
 */
import java.util.Arrays;

//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData2 implements Comparable<PhyscData2>{
	String name;
	int height;
	double vision;

	public PhyscData2(String string, int i, double d) {
		name = string;height = i;vision = d;
	}
	@Override
	public String toString() {//[홍길동,162,0.3] 형태로 리턴한다 
		String result = "["+ name + ","+ height+ "," + vision +"]" ;
		return result;
	}
//	@Override
	public int compareTo(PhyscData2 p) {
		int result = 0;
		if(name == p.name) {
			if(height == p.height) {
				result = (int) (vision*10 - p.vision*10);
			}
			else {
				result = height - p.height;
			}
		}
		else {
			result = name.compareTo(p.name);
		}
		return result;
	}

}
public class train_실습3_6_1객체배열이진탐색 {
	public static void main(String[] args) {
		PhyscData2[] data = {
				new PhyscData2("홍길동", 162, 0.3),
				new PhyscData2("나동", 164, 1.3),
				new PhyscData2("최길", 152, 0.7),
				new PhyscData2("홍길동", 162, 0.3),
				new PhyscData2("박동", 182, 0.6),
				new PhyscData2("박동", 167, 0.2),
				new PhyscData2("길동", 167, 0.5),
		};
		showData("정렬전", data);
		sortData(data);//6장 06-4 단순 삽입 정렬 InsertionSort() 함수로 구현
		showData("정렬후", data);
		
		reverse(data);
		showData("역순 재배치후", data);
		
		Arrays.sort(data);//사용된다 그 이유는? 이해가 되어야 한다  -> 내가 compareTo를 override했기 때문에 정렬의 기준이 생성되었다!
		showData("Arrays.sort() 정렬후", data);

		PhyscData2 key = new PhyscData2("길동", 167, 0.5);
		int resultIndex = linearSearch(data, key);
		System.out.println("\nlinearSearch(<길동,167,0.5>): result index = " + resultIndex);

		/* 교재 109~113 */
		key = new PhyscData2("박동", 167, 0.6);
		resultIndex = binarySearch(data, key);//comparable를 사용
		System.out.println("\nbinarySearch(<박동,167,0.6>): result index = " + resultIndex);
		
		
		/* 교재 115 Arrays.binarySearch에 의한 검색 */
		key = new PhyscData2("나동", 164, 0.6);
		resultIndex = Arrays.binarySearch(data, key);//comparable를 사용
		System.out.println("\nArrays.binarySearch(<나동,164,0.6>): result index = " + resultIndex);
	}
	
	static void showData(String msg, PhyscData2[] data) {
		System.out.print(msg + " : ");
		for( PhyscData2 p2 : data) {
			System.out.print(p2.toString()+ " ");
		}
		System.out.println();
	}
	
	static void sortData(PhyscData2[] data) {
		for(int i =0; i<data.length;i++) {
			int j;
			PhyscData2 temp=data[i];
			for(j=i; j>0 && data[j-1].compareTo(temp)>0;j--) {
				data[j]=data[j-1];
			}
			data[j]=temp;			
		}
	}
	static void reverse(PhyscData2[] data) {
		for (int i=0; i<data.length/2-1; i++) {
			int le = data.length -i-1 ;
			PhyscData2 tm = data[i];
			data[i] = data[le];
			data[le] = tm;
		}
	}
	
	static int linearSearch(PhyscData2[] data, PhyscData2 key) {
		int result = -1;
		for(int i = 0 ; i<data.length;i++) {
			if(data[i].compareTo(key)==0) {
				result = i;
			}
		}
		return result;
	}
	static int binarySearch(PhyscData2[] data, PhyscData2 key) {
		int result = -1; int left = 0 ; int right = data.length-1;
		while(left <= right) {
			int mid = (left+right)/2;
			if(data[mid].compareTo(key)==0) {
				result = mid;
				return result;
			}
			else if(data[mid].compareTo(key)>0) {
				right = mid-1;
			}
			else {
				left = mid+1;
			}
		}
		return result;		
	}
}

package Chap2_기본자료구조;

public class Test_실습2_14스트링배열정렬{
	public static void main (String[] args) {
		String []data = {"apple","grape","persimmon", "pear","blueberry", "strawberry", "melon", "oriental melon"};

		showData("정렬전", data);
		sortData(data);
		showData("정렬후", data);
		String[] newData = insertString(data, "banana");
		showData("\n삽입후", newData);
		
	}
	static void showData(String msg, String[] data) {//확장된 for 문으로 출력 
		System.out.print(msg + " : ");
		for(String str : data) System.out.print(str + " ");
		System.out.println();
	}

	static void swap(String[] data, int idx1, int idx2) {//스트링의 맞교환 함수로 sortData()에서 호출됨
		String str = data[idx1]; data[idx1] = data[idx2]; data[idx2] = str;
	}
	static void sortData(String[] data) {//올림차순으로 정렬
		for(int i=0; i<data.length-1;i++) {
			for(int j =data.length-1; j>i;j--) {
				if(data[j-1].compareTo(data[j])>0) 
					swap(data, j-1, j);
			}
		}
	}
	static String[] insertString(String[] data, String inp){//배열의 사이즈를 1개 증가시킨후 insert되는 스트링 보다 큰 값들은 우측으로 이동, 사이즈가 증가된 스트링 배열을 리턴
		String[] a = new String[data.length+1];
		for (int i = 0; i<data.length; i++) {
			a[i]=data[i];
		}
 		//함수구현
		String tm = inp;
		int num = 0;
		for(int i=0; i<data.length-1 ;i++) {
			if (tm.compareTo(data[i]) >0 & tm.compareTo(data[i+1])<0) {num = i+1;}
		}
//		System.out.println("num="+num);
		String k = data[data.length-1];
		for(int i=a.length-2; i>num-1;i--) {
			a[i+1] = a[i];
		}
		a[num]=inp;
		a[data.length] = k;
		return a;
	}
}

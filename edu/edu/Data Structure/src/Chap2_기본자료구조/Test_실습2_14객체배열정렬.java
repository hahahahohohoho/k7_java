package Chap2_기본자료구조;


//5번 실습 - 2장 실습 2-10를 수정하여 객체 배열의 정렬 구현
class PhyscData implements Comparable<PhyscData>{
	String name;
	int height;
	double vision;
	public PhyscData(String name, int height, double vision) {
		// TODO Auto-generated constructor stub
		this.name = name;this.height = height;this.vision = vision;
	}
//	@Override
	public String toString() {
		String result = name + " " + height + " " + vision; 
		return  result;
	}
	@Override
	public int compareTo(PhyscData p) {
		int result = 0;
		if(name.compareTo(p.name)==0) {
			if(height==p.height) {
				result = (int) (vision - p.vision);
			}
			else result = height - p.height;
		}
		else result =  name.compareTo(p.name);
//		System.out.println(result);
		return result;
	}
//	public int equals(PhyscData p) {
//
//	}
}
public class Test_실습2_14객체배열정렬 {
	static void swap(PhyscData[] data, int idx1, int idx2) {//스트링의 맞교환 함수로 sortData()에서 호출됨
		PhyscData str = data[idx1]; data[idx1] = data[idx2]; data[idx2] = str;
	}
	static void sortData(PhyscData[] data) {//객체 배열을 이름 순서로 정렬, 이름이 같으면 키 값을 정렬, 키 값이 같으면 시력으로 
		for (int i = 0; i<data.length;i++) {
			for(int j =data.length-1; j>i;j--) {
				if (data[j-1].compareTo(data[j])>0) {
					swap(data, j-1, j);
				}
			}
		}
	}
	public static void main(String[] args) {
		PhyscData[] data = {
				new PhyscData("홍길동", 162, 0.3),
				new PhyscData("홍동", 164, 1.3),
				new PhyscData("홍길동", 162, 0.7),
				new PhyscData("김홍길동", 172, 0.3),
				new PhyscData("이길동", 182, 0.6),
				new PhyscData("이길동", 167, 0.2),
				new PhyscData("최길동", 169, 0.5),
		};
		showData("정렬전",data);
		sortData(data);
		showData("정렬후", data);
		PhyscData[] newData= insertObject(data, new PhyscData("이기자", 179, 1.5));//배열의 사이즈를 1개 증가시킨후 insert되는 객체 보다 큰 값들은 우측으로 이동, 사이즈가 증가된 객체 배열을 리턴
		showData("삽입후", newData);
	}
	static void showData(String msg, PhyscData[] data) {
		System.out.print(msg + " : ");
		for(PhyscData k : data) System.out.print(k.toString()+" ");
		System.out.println();
	}
	static PhyscData[] insertObject(PhyscData[] data, PhyscData p){//배열의 사이즈를 1개 증가시킨후 insert되는 스트링 보다 큰 값들은 우측으로 이동, 사이즈가 증가된 스트링 배열을 리턴
		PhyscData[] result = new PhyscData[data.length+1];
		for(int i=0; i<data.length; i++) {result[i]=data[i];}
		PhyscData tm = p; int num = 0;
		for(int i=0; i<data.length-1; i++) {
			if(tm.compareTo(data[i])>0 & tm.compareTo(data[i+1])<0) {
				num= i+1;
			}
		}
		PhyscData k = data[data.length-1];
		for(int i = result.length-2; i>num-1;i--) {
			result[i+1]=result[i];
		}
		result[num] = p;
		result[data.length]=k;
		return result;
	}

}

package com.ruby.java.ch13.generic;
/*
 * 객체를 정렬하는 코드 완성 
 * 스트링 배열을 정렬
 * 객체 배열을 정렬 
 */
import java.util.Arrays;
import java.util.Comparator;
class Student{
	String sno;
	String sname;
	
	public Student(String sno, String sname) {
		this.sno = sno;
		this.sname = sname;
	}

	public String toString() {
		return sno + " " +sname;
	}

}


class SnoComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        // 학번을 기준으로 비교
    	int s11 = Integer.parseInt(s1.sno);
    	int s12 = Integer.parseInt(s2.sno);
        return s11-s12;
    }
}


public class test_객체배열정렬소스 {

	static void showData(String msg, Object[]data) {
		System.out.println(msg + " : " + Arrays.toString(data));
//		System.out.print(msg + " : ");
//		for(int i=0; i<data.length ; i++) {
//			System.out.print(data[i] + "  ");
//		}
//		System.out.println();
	}
	public static void main(String[] args) {
		String [] stringData = {"apple","grape","blueberry","banana"};
		Student [] data = {
				new Student("12", "홍길동"),
				new Student("121", "홍길순"),
				new Student("213", "홍길춘"),
				new Student("9", "홍길홍")
		};
		showData("정렬전", stringData);
		Arrays.sort(stringData);
		showData("정렬후", stringData);
		showData("정렬전", data);
		Arrays.sort(data, new SnoComparator());
		showData("정렬후", data);
	}

}

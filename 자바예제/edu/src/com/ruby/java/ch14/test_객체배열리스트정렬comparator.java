package com.ruby.java.ch14;
/*
 * 		Comparator<Student2> compSno = new Comparator<Student2>(){
			@Override
			public int compare(Student2 s1, Student2 s2) {

			}
		};
 */
import java.util.ArrayList;
/*
 * public interface Comparator<T>{
 *    int compare(T 01, T 02);
 *    }
 *    
 * public interface Comparable<T> {
 *   public int compareTo(T o);
 *   }   
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
class Student {
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
//sortStudent를 추상메서드 하나짜리 함수인터페이스 구현
interface MyInterface1{
	public void sortStudents();
}
//snoComparator
class SnoComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        // 학번을 기준으로 비교
    	int s11 = Integer.parseInt(s1.sno);
    	int s12 = Integer.parseInt(s2.sno);
        return s11-s12;
    }
}
//snameComparator
class SnameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        // 학번을 기준으로 비교
    	return o1.sname.compareTo(o2.sname);
    }
}






//main 클래스
public class test_객체배열리스트정렬comparator implements MyInterface1{
	public void sortStudents() {
	}
	static void showStudents(String msg, Object[]data) {
		System.out.println(msg + " : " + Arrays.toString(data));
	}
	static void showStudents(String msg, List<Student>data) {
		System.out.println(msg + " : " + data);
	}
	//문제5번 구현
	static void sortStudents1(Student[] data) {
		for(int i = 0; i<data.length ; i++) {
			for(int j = i+1; j<data.length ; j++) {
				Student tmp;
				if(Integer.parseInt(data[i].sno)>Integer.parseInt(data[j].sno)) {
					tmp = data[i]; data[i] = data[j]; data[j] = tmp;
				}
			}
		}
	}
	//main
	public static void main(String[] args) {
        Student[] sArray = new Student[5];        
        // Student 객체 생성 및 배열에 할당
        sArray[0] = new Student("121", "Alice");
        sArray[1] = new Student("33", "Bob");
        sArray[2] = new Student("9", "Charlie");
        sArray[3] = new Student("2", "John");
        sArray[4] = new Student("39", "Bobby");
        
        // ArrayList로 변환
        ArrayList<Student> sList = new ArrayList<>();
        for (Student student : sArray) {
            sList.add(student);
        }
        
        
        //문제1: Arrays.sort()를 사용한 sArray 정렬 - sno 사용, 익명클래스 사용
        showStudents("sno 정렬전", sArray);
        MyInterface1 s1 = new MyInterface1() {
			@Override
			public void sortStudents() {
				Arrays.sort(sArray, new SnoComparator());
			}
		};
		s1.sortStudents();
        showStudents("sno 정렬후", sArray);
        
//        //문제2: Arrays.sort()를 사용한 sArray 정렬 - sname 사용, 익명 객체 사용
        showStudents("sname 정렬전", sArray);
//        Arrays.sort(sArray, (new Comparator<Student>{
//        	
//        }));
        (new MyInterface1() {
			@Override
			public void sortStudents() {
				// TODO Auto-generated method stub
				Arrays.sort(sArray, new SnameComparator());
			}
		}).sortStudents();
        showStudents("sname 정렬후", sArray);
        
        //문제3: Collections.sort()를 사용한 sList 정렬 - sno 사용, 람다식 사용
        showStudents("sno 정렬전", sList);
        MyInterface1 m1 = ()-> Collections.sort(sList, new SnoComparator());
        m1.sortStudents();
        showStudents("sno 정렬후", sList);
        
        showStudents("sname 정렬전", sList);
        //문제4: Collections.sort()를 사용한 sList 정렬 - sname 사용
        MyInterface1 m2 = ()-> Collections.sort(sList, new SnameComparator());
        m2.sortStudents();
        showStudents("sname 정렬후", sList);
        
        showStudents("sno 정렬전", sArray);
//        //문제5: sortStudents()를 사용한 sArray 정렬 - sno 사용 sort, collection안쓰고 정렬 구현하기(버블정렬?)
        sortStudents1(sArray);
        showStudents("sname 정렬후", sArray);
	}

}

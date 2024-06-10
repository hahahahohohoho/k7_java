package Chap3_검색;
/*
 * 3장 5번 실습과제 - 스트링 리스트 정렬
 * 리스트를 배열로 변환후 중복제거후 다시 리스트 만들기 등 실습
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class train_스트링리스트정렬 {
	    public static String[] removeElement1(String[] arr, String item) {
	    	List<String> C = new ArrayList<>();
	    	for(String a : arr) {
	    		C.add(a);
	    	}
	    	C.remove(item);
//	    	System.out.println("C=" + C);
	    	String [] result = C.toArray(new String[C.size()]);
	    	return result;
	    }
	    
	    static void getList(List<String> list) {
			list.add("서울");	list.add("북경");
			list.add("상해");	list.add("서울");
			list.add("도쿄");	list.add("뉴욕");

			list.add("런던");	list.add("로마");
			list.add("방콕");	list.add("북경");
			list.add("도쿄");	list.add("서울");

			list.add(1, "LA");
	    }
	    static void showList(String topic, List<String> list) {
	    	System.out.print(topic + " : ");
	    	for(String a : list) {
	    		System.out.print(a + " ");
	    	}
	    	System.out.println();
	    }
	    static void sortList(List<String> list) { //list 정렬은 배열과 다름. 
	    	
		    
	    }
//	    서울 LA 북경 상해 도쿄 뉴욕 런던 로마 방콕
	    static String[] removeDuplicateList(List<String> list) {
		    //리스트에서 중복 제거
	    	List<String> anew = new ArrayList<>();
	    	for(String data : list) {
	    		if(!anew.contains(data)) {
	    			anew.add(data);
	    		}
	    	}
	    	String[] res = anew.toArray(new String[anew.size()]);
		    
//	    	String[] res = list.toArray(new String[list.size()]);
//	    	for (int i=0 ; i<res.length;i++) {
//	    		for (int j=i+1 ; j<res.length;j++) {
//	    			if (res[i]==res[j]) {
//	    				System.out.println("i= "+ i + " j= " + j + " res = "+res[j]);
//	    				res = removeElement1(res, res[j]);
////	    				for (String a : res) {
////	    					System.out.print(a + " ");
////	    				}
//	    			}
//	    		}
//	    	}
	    	
	    	return res;
	    }
	    
	    
		public static void main(String[] args) {
			ArrayList<String> list = new ArrayList<>();
			getList(list);
			showList("입력후", list);
			//sort - 오름차순으로 정렬, 내림차순으로 정렬, 중복 제거하는 코딩

		    Collections.sort(list);
//
//배열의 정렬
			sortList(list);
		    System.out.println();
		    showList("정렬후", list);
// 배열에서 중복제거
		    System.out.println();
//		    System.out.println("중복제거:");
		  
		    String[] cities = removeDuplicateList(list);
	        ArrayList<String> lst = new ArrayList<>(Arrays.asList(cities));
		    showList("중복제거후", lst);
		}
	}


package com.ruby.java.ch10;
//구현과제로 실습
//hashset을 arraylist로 변환하여 정렬하기 구현

/*
 * 로또 당첨 규칙:
 * 꽝: 번호 2개, 1개
 * 5등: 번호 3개 - 5000원
 * 4등: 번호 4개 - 5만원
 * 3등: 번호 5개 - 150만원 - 판매금액에 변동(판매금액의 12.5%)
 * 2등: 3등번호 + 보너스번호 - 3000만원 - 판매 금액에 변동, 당첨 확률: 1,300,000분의1
 * 1등: 6개 숫자 - 당첨 확률 8,000,000 분의 1, 10억 ~ 30억
 */
//hashset을 arraylist로 변환하여 정렬하기 구현
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
class ListComparator implements Comparator<List<Integer>>{
	@Override
	public int compare(List<Integer> l1, List<Integer> l2) {
		Iterator<Integer> ait = l1.iterator(); //iterator 반복자 : 배열이나 그와 유사한 자료구조의 내부요소를 순회하는 객체다
		Iterator<Integer> bit = l2.iterator();
		
		while (ait.hasNext()) { //hasnext 읽어올 요소가 남았는지 확인하는 메서드 -> 읽어올 요소가 남지 않을 때까지 반복
			int anum = ait.next();int bnum = bit.next(); //next 다음 데이터를 반환
			if ( anum > bnum) return 1;
			else if (anum < bnum) return -1;
		}
		return 0;
	}
}


public class Test_ch10_lotto당첨처리 {

	public static void main(String[] args) {

		lotto_generator(10);

	}

	public static void lotto_generator(int n) {
		Random number = new Random();
		HashSet<HashSet<Integer>> lot = new HashSet<>(); //Hashset 두번 건 이유는 중복을 없애기 위해
		HashSet<Integer> lotto = null; // 하나의 로또
		List<List<Integer>> al = new ArrayList<>(); //lot의 묶음(lotto)을 ArrayList로 구현
		
		
		for (int i = 0; i < n; i++) { //n이 10000, lot변수가 10000개의 복권을 가지고 있어야함
			lotto = new HashSet<Integer>();
			//구현할 부분
			for (int j = 0; lotto.size() < 6; j++) {
				lotto.add(number.nextInt(46)); //nextInt(매개변수) 매개변수 이하의 정수
			}	
			lot.add(lotto);
		}
		System.out.println(lot);
		System.out.println("\nlot hashset을 출력\n");
		for (HashSet<Integer> eachLotto : lot) {
			eachLotto.add(number.nextInt(46));
			/* 
			 * 33  1 17 22  6  8  + 보너스번호: 12
			 *  0  1 18 38  6 24  + 보너스번호: 29
			 */
			//보너스번호를 별도로 뽑아서 ArrayList 활용하여 구현할 부분 
		}
		System.out.println("복권 정렬전::lot = " + al);
		al.sort(new ListComparator());
		System.out.println("복권 정렬후::lot = " + al);
		//hashset의 리스트를 정렬하는 알고리즘 개발
		//hashset를 arrayList로 변환
		HashSet<Integer> win = new HashSet<>(); //당첨복권
		for (int j = 0; win.size() < 7; j++) {//6개 번호와 보너스 번호
			win.add(number.nextInt(46));
		}
		System.out.print("당첨번호: " + win);//6개의 당첨번호와 보너스번호
		// 6개를 맞힌 복권을 찾는다 
		System.out.println();
		winnerLotto(win, al);//1등을 찾는다
		
	}
	static void winnerLotto(HashSet<Integer> w,List<List<Integer>> al ) {
		// 당첨번호 w에 대하여 발행된 복권 리스트 al의 모든 원소 elem에 대하여 조사한다
		for (int i = 0; i < al.size(); i++) {
		//구현할 부분
			
		}
	}
	static void checkWinner(HashSet<Integer> w,List<Integer> elem) {
		// 당첨번호 w의 각 숫자를 꺼내 복권 엔트리에 포함되어 있는지를 조사
		List<Integer> L = new ArrayList<>(w);
		int count = 0;
		for (int i = 0; i < L.size()-1; i++)
		{
			/*
			 * 당첨번호 각 번호를 몇개 포함하는지를 elem에 대하여 조사
			 */
			//구현할 부분
			if(lotto[i] == myLotto[j]) {
						count++;
			}
			
	
		}
		switch (count) {
		case 0:
		case 1:
		case 2:
			System.out.println("꽝");
			break;
		case 3:
			System.out.println("5등 복권 " + elem + " 당첨번호:" + w);
			break;
		case 4:
			System.out.println("4등 복권 " + elem + " 당첨번호:" + w);
			break;
		case 5:
			if (L.get(6).equals(elem.get(6))) { //보너스 번호가 일치하는 지를 조사 
				System.out.println("2등 복권 " + elem + " 당첨번호:" + w);
				break;
			}
			else {
				System.out.println("3등 복권 " + elem + " 당첨번호:" + w);
				break;
			}
			
		case 6:
			System.out.println("1등 복권 " + elem + " 당첨번호:" + w);
			break;
		}


	}
}
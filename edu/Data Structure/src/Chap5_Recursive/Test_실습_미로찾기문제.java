package Chap5_Recursive;
/*
 * 미로 찾기 문제
 * 플라토의 미로 찾기 문제 설명 자료 학습
 * int input[12][15] 테이블에서 입구는 (0,0)이며 출구는 (11,14)임
 * 미로 테이블 (12,15)을 상하좌우 울타리를 친 maze[14][17]을 만들고 입구는 (1,1)이며 출구는(12,15)
 * stack을 사용한 backtracking 구현
 */

import java.util.ArrayList;
import java.util.List;

import Chap5_Recursive.StackList.EmptyGenericStackException;

//23.2.16 수정
//23.2.24: 객체 배열 초기화, static 사용, 내부 클래스와 외부 클래스 사용 구분을 못하는 문제 => 선행 학습 필요
class StackList {
	// --- 실행시 예외: 스택이 비어있음 ---//
	// generic class는 Throwable을 상속받을 수 없다 - 지원하지 않는다
	public class EmptyGenericStackException extends Exception {
		public EmptyGenericStackException(String message) {
			super(message);
		}
	}

	// --- 실행시 예외: 스택이 가득 참 ---//
	public class OverflowGenericStackException extends RuntimeException {
		public OverflowGenericStackException(String message) {
			super(message);
		}
	}

	private List<Items> data; // 스택용 배열
	// private List<T> data;
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

	// --- 생성자(constructor) ---//
	public StackList(int capacity) {
		top = 0;
		this.capacity = capacity;
		try {
			data = new ArrayList<>(capacity);
		}catch(OutOfMemoryError e) {
			capacity = 0;
		}
	}

	// --- 스택에 x를 푸시 ---//
	public boolean push(Items x) throws OverflowGenericStackException {
		if(top >= capacity)
			throw new OverflowGenericStackException("push : stack overflow");
		data.add(top++, x);
		return true;
	}

	// --- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public Items pop() throws EmptyGenericStackException {
		if(top <=0)
			throw new EmptyGenericStackException("stack is empty");
		return data.get(--top);
	}
	public boolean isEmpty() {
		return top <= 0;
	}
}

enum Directions {N, NE, E, SE, S, SW, W, NW}
class Items {
	int x;
	int y;
	int dir;
	public Items(int x, int y, int dir) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
}
class Offsets {
	int a;
	int b;
	public Offsets(int a, int b) {
		this.a = a;
		this.b = b;
	}

}
public class Test_실습_미로찾기문제 {

	static Offsets[] moves = new Offsets[8];//static을 선언하는 이유를 알아야 한다
//	int maze[14][17];
//	int mark[14][17];


	static void path(int maze[][], int mark[][], int m, int p) throws EmptyGenericStackException{//m = 12, p = 15
		StackList stk = new StackList(50);
		Items temp = new Items(0, 0, 0);
		temp.x = 1; temp.y=1; temp.dir=2; //출발점 (1,1), 이동 방향 dir = 2(2는 동쪽) 을 스택에 push
		stk.push(temp);

		while (!stk.isEmpty()) {   // stack is not empty
			Items tmp = stk.pop(); //	(i,j,dir) = coordinates and direction deleted from top of stack;
			int i = tmp.x;
			int j = tmp.y;
			int dir = tmp.dir;
			mark[i][j] = 1;//	현재 위치 (i,j)에 대하여 mark[][]을 1로 설정
			while (dir<8){//8가지 방향중에서 남은 방향에 대하여
		      int g = i+moves[dir].a;
		      int h = j+moves[dir].b;
//		      (g,h) = //coordinates of next move;//현재 위치 (i,j)에 대하여 이동 방향 계산
		      if ((g == m) && (h == p)) {
		    	  //success;
		    	  mark[i][j]=1; mark[g][h]=1;//(i,j)와 (g,h)에 대하여 mark 표시
		    	  return;
		      }
		      if ((maze[g][h]==0) //legal move = g,h값이 0이면
		         && (mark[g][h]==0)) //haven't been here before
		      {
		    	  mark[g][h] = 1; // g, h를 mark에 표시하고
	              stk.push(new Items(i, j, dir+1)); // add (i,j,dir) to top of stack
	              i = g; j = h;
	              dir = 0; // next direction to try
		      }
		      else {
		    	  dir++; //try next direction
		      }
			}
//		   (i,j) 현위치에 대한 mark를 취소
			if (dir >= 8) {
				mark[i][j] = 0;
			}
		}
		//	cout << "No path found" << endl;
		System.out.println("No path found.");
	}

	public static void main(String[] args) throws EmptyGenericStackException {
		int[][] maze = new int[14][17];
		int[][] mark = new int[14][17];

		int input[][] = { // 12 x 15
				{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
				{ 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 },
				{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }};
		for (int ia = 0; ia < 8; ia++)
			moves[ia] = new Offsets(0, 0);//배열에 offsets 객체를 치환해야 한다.
		moves[0].a = -1;	moves[0].b = 0;
		moves[1].a = -1;	moves[1].b = 1;
		moves[2].a = 0;		moves[2].b = 1;
		moves[3].a = 1;		moves[3].b = 1;
		moves[4].a = 1;		moves[4].b = 0;
		moves[5].a = 1;		moves[5].b = -1;
		moves[6].a = 0;		moves[6].b = -1;
		moves[7].a = -1;	moves[7].b = -1;
//		Directions d;
//		d = Directions.N;
//		d = d + 1;//java는 지원안됨
		//input[][]을 maze[][]로 복사
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 17; j++) {
				maze[i][j]=1;
			}
		}
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 15; j++) {
				maze[i+1][j+1]=input[i][j];
			}
		}

		show("maze[12,15]::", maze);
		show("\nmark[12,15]::", mark);

		path(maze, mark, 12, 15);
		System.out.println("\n==path 후 ==\n");
		show("\nmaze[12,15]::", maze);
		show("\nmark[12,15]::", mark);
	}
	private static void show(String msg, int[][] mark) {
		// TODO Auto-generated method stub
		System.out.println(msg);
		for(int[] N : mark) {
			for(int n : N) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}
}

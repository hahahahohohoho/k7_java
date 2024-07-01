package quiz;

import java.util.Scanner;

abstract class Geometry {
    int[] xArr;
    int[] yArr;
    abstract double getArea();
    abstract double getLength();
}

class Point extends Geometry{
	public Point() {
		xArr = new int[1]; 
		yArr = new int[1];
	}
	 
	double getArea() {
		return 0;
	}
	double getLength() {
		return 0;
	}			
}

class Line extends Geometry{
	public Line() {
		xArr = new int[2]; 
		yArr = new int[2]; 
	}
	double getArea() {
		return xArr[0]*xArr[1];
	}
	double getLength() {  //Line에 Length 코드를 for문 돌리는 방식으로 발전시키기
		return xArr[0]-xArr[1];
	}				
}
class Polyline extends Geometry{
	public Polyline() {
		xArr = new int[4]; //polyLine은 점이 여러개 받아져야하니 동적 array로 짜기	
		yArr = new int[4];  
	}
	double getArea() {
		return xArr[0]*xArr[1];
	}
	double getLength() {
		return xArr[0]-xArr[1];
	}				
}
class TriAngle extends Geometry{
	public TriAngle() {
		xArr = new int[3]; 
		yArr = new int[3]; 
	}
	double getArea() {
		return xArr[0]*xArr[1];
	}
	double getLength() {
		return xArr[0]-xArr[1];
	}			
}
class Rectangle extends Geometry{
	public Rectangle() {
		xArr = new int[4]; 
		yArr = new int[4]; 
	}
	double getArea() {
		return xArr[0]*xArr[1];
	}
	double getLength() {
		return xArr[0]-xArr[1];
	}			
}

public class GeometryTest {

	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in); 
		
		Geometry[] g = new Geometry[5];
		g[0] = new Point();
		g[1] = new Line();
		g[2] = new Polyline();
		g[3] = new TriAngle();
		g[4] = new Rectangle();
		
		for(Geometry p : g) {
			for (int i = 0; i < p.xArr.length; i++) {
				System.out.println("좌표를입력하세요");
				p.xArr[i] = sc.nextInt();
				p.yArr[i] = sc.nextInt();
			}
			System.out.println(p.getArea());
			System.out.println(p.getLength());			
		}
	}
}

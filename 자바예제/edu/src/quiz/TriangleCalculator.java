package quiz;
import java.util.Scanner;

public class TriangleCalculator {
    // 두 점 사이의 거리 계산하는 메소드
    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // 삼각형 넓이 계산하는 메소드
    public static double calculateArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        double a = calculateDistance(x1, y1, x2, y2);
        double b = calculateDistance(x2, y2, x3, y3);
        double c = calculateDistance(x1, y1, x3, y3);
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    // 삼각형 둘레 계산하는 메소드
    public static double calculatePerimeter(double x1, double y1, double x2, double y2, double x3, double y3) {
        double a = calculateDistance(x1, y1, x2, y2);
        double b = calculateDistance(x2, y2, x3, y3);
        double c = calculateDistance(x1, y1, x3, y3);
        return a + b + c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 세 점의 좌표 입력 받기
        System.out.println("Enter the coordinates of the first point (x1 y1):");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();

        System.out.println("Enter the coordinates of the second point (x2 y2):");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        System.out.println("Enter the coordinates of the third point (x3 y3):");
        double x3 = scanner.nextDouble();
        double y3 = scanner.nextDouble();

        // 삼각형 넓이와 둘레 계산
        double area = calculateArea(x1, y1, x2, y2, x3, y3);
        double perimeter = calculatePerimeter(x1, y1, x2, y2, x3, y3);

        // 결과 출력
        System.out.println("The area of the triangle is: " + area);
        System.out.println("The perimeter of the triangle is: " + perimeter);

        scanner.close();
    }
}


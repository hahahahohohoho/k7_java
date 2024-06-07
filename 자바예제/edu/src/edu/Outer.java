package edu;

public class Outer { //외부 클래스 선언
    static int a = 10;
    int b = 20;
    private int c = 30;

    void outerInstanceMethod(){
        System.out.println("외부 클래스의 인스턴스 메서드");
    }

    static void outerStaticMethod(){
        System.out.println("외부 클래스의 정적 메서드");
    }

    class InstanceInner{
        //static int d = 40; 인스턴스 멤버 클래스 안에서 static 사용 불가
        int e = 50;
        private int f = 60;
        
        InstanceInner(){}
        
        InstanceInner(int num1, int num2, int num3){
            a = num1; //외부 클래스의 필드를 불러오기 위해서 this.를 사용하지 않는다
            c = num2;
            this.f = num3; //내부 클래스 자신의 필드를 불러오기 위해 this.를 사용한다
        }
        
        void instanceMethod(){
            System.out.println("인스턴스 멤버 클래스의 인스턴스 메서드");
            System.out.printf("%d, %d, %d, %d, %d \n", a, b, c, e, f);
            //외부 클래스의 필드를 제한 없이 사용 가능
            outerStaticMethod();
            outerInstanceMethod();

        }
        /*
        static void staticMethod(){
            System.out.println("인스턴스 멤버 클래스 내부에 static 사용 불가");
        }
        */
    }
    
    public class Main {
        public static void main(String[] args) {
            Outer outer = new Outer();
            //외부 클래스의 객체 생성
            Outer.InstanceInner instanceInner = outer.new InstanceInner();
            //외부 클래스를 통해 내부 클래스를 불러와 내부 클래스의 객체 생성
            instanceInner.instanceMethod();
            //내부 클래스의 메서드 호출
        }
    }

}

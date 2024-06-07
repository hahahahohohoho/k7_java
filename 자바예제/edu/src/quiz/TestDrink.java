package quiz;




		abstract class Drinks {
			abstract void drink() ;
		}
		
		class Juice extends Drinks {
			void drink() {
				System.out.println("주스를 마십니다.");		
			}
		}
		
		class Coffee extends Drinks {
			void drink() {
				System.out.println("커피를 마십니다.");		
			}
		}
		
		class Beer extends Drinks{
			void drink() {
				System.out.println("맥주를 마십니다.");		
			}
		}
		
		class Water extends Drinks{
			void drink() {
				System.out.println("물을 마십니다.");		
			}
		}
		
		class Tea extends Drinks{
			void drink() {
				System.out.println("물을 마십니다.");		
			}
		}
		public class TestDrink {
			public static void main(String[] args) {
		Drinks[] dr = new Drinks[5];
		dr[0] = new Juice();
		dr[1] = new Coffee();
		dr[2] = new Beer();
		dr[3] = new Water();
		dr[4] = new Tea();
		for(Drinks p : dr) {
			p.drink();
		}
	}
}

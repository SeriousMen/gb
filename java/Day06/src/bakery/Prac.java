package bakery;

public class Prac {

	final static int stac =5;
	int a;
	int b;
	
	
	void method1(int a, int b, int stac) {
		this.a = a;
		this.b = b;
		this.stac = stac;
		
	}
	
	void method2() {
		System.out.println("a :" +a +" b :" +b+ " stac :" +stac);
		
	}
	public static void main(String[] args) {
		
		Prac p = new Prac();
		
		p.method1(5,5,5);
		p.method2();
		p.a++;
		p.b++;
		p.stac++;
		Prac p2 = new Prac();
		
		p2.a++;
		p2.b++;
		p2.stac++;
		p2.method2();
	}
}

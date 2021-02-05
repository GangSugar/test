

public class Test {
	//三个变量求最大值
	public static void main(String[] args) {
		int max,a=6,b=4,c=10;
		max=a;
		if (b>max) {
			max=b;
		}
		
		if(c>max){
				max=c;
		}
		System.out.println(max);
	}
	//交换变量a,b
	public static void main3(String[] args) {
		int a=5,b=3,c;
		c=a;
		a=b;
		b=c;

		System.out.println("a="+a);
		System.out.println("b="+b);
	}
	public static void main2(String[] args) {

		int a=10;
		{
			a=99;
			System.out.println(a);

		}
	}

	public static void main1(String[] args) {
		System.out.println("hello");
	}
}
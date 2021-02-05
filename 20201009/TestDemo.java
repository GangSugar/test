
public class TestDemo {
	public static void main(String[] args) {
		System.out.println("hello");//换行System.out.printf("aa");
		System.out.printf("bb");
		System.out.println("cc");//换行
		System.out.print("ll");//不换行
		System.out.printf("aa");//不换行

		for (int i=0;i<args.length ;i++ ) {
			System.out.println(args[i]);
		}
	}

	
	
}

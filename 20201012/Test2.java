import java.util.Scanner;
import java.util.Random; 
//程序逻辑t控制
public class Test2{
	public static void main(String[] args) {
		//输出每一位
		int m,n,p;
		int a = 785;
			m = a % 10;//个位
			n = (a / 10) % 10;//十位
			p = a / 100;//百位
			System.out.println("百位是："+p+",十位是："+n+",个位是："+m);
	}
	public static void main20(String[] args) {
		//猜数字游戏
		Random random = new Random();
		int a = random.nextInt(100)+1;
		Scanner scan = new Scanner(System.in);
		
		while(true){
			System.out.println("输入数字：");
			int num = scan.nextInt();
			if(num < a){
				System.out.println("你输入的低了！");
			}else if(num > a){
				System.out.println("你输入的高了！");
			}else{
				System.out.println("恭喜你精神小伙猜对了！");
				break;
			}
		}

	}
	public static void main19(String[] args) {
		// 写一个函数返回参数二进制中 1 的个数
		int a = 15,sum = 0;
		while(a > 0){
			if(a % 2 == 1){
				sum++;
			}
			a /= 2;
		}
		System.out.println(sum);
	}
//模拟三次密码输入
	public static void main18(String[] args) {
		int i = 0;
		for (;i < 3 ;i++ ) {
			System.out.println("请输入密码：");
			//从键盘获取数据
		Scanner scan = new Scanner(System.in);
        //读入一个整型
        String num = scan.nextLine();
        if(num.equals("123456")){
        	break;
        }
		}
	if(i < 3){
		System.out.println("登录成功！");
	}else{
		System.out.println("登录失败！");
	}
	}
	public static void main17(String[] args) {
		//求出100～999之间的所有“水仙花数”并输出
		int m,n,p,sum=0;
		for (int a = 101; a < 1000;a++){
			m = a % 10;//个位
			n = (a / 10) % 10;//十位
			p = a / 100;//百位
			sum = m*m*m+n*n*n+p*p*p;
			if(a == sum){
				System.out.println(a);
			} 
		}
	}
	public static void main16(String[] args) {
		//编写程序数一下 1到 100 的所有整数中出现多少个数字9
		int sum=0,a=0;
		for(int i =1;i <= 100;i++){
			a = i;
			while(a != 0){
				if(a % 10 == 9){
					sum++;
				}
				a=a/10;	//判断十位上面有没有9
			}
		}
		System.out.println(sum);
	}
	public static void main15(String[] args) {
		// 计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值。
		int i = 1;
		double sum = 0;
		for (i = 1;i <= 100 ; i++){
			if(i%2==1){
				sum += 1.0/i;
			}else{
				sum -= 1.0/i;
			}
		}
		System.out.println(sum);
}

	public static void main14(String[] args) {
		//俩个正整数的最大公约数(辗转相除法)
		int a = 12,b = 8,tmp;
		 while (a%b != 0){
        tmp=a%b;//取余
        a = b;//交换a，b可避免a比b小
        b = tmp;
    }
    System.out.println(b);

	}
	public static void main13(String[] args) {
		//乘法口诀表
		for (int i = 1;i <= 9 ; i++) {
			for (int j =1;j <= i ;j++ ) {
				System.out.print(i+"*"+j+"="+(i*j)+"     ");
			}
			System.out.println("\n");
		}
	}
	public static void main12(String[] args) {
		//1000-2000之间的闰年
		int year = 1000;
		while(1000 <= year&&year <= 2000){
			if (year % 4 == 0&&year % 100 != 0||year % 400 == 0) {
			System.out.println(year+"是闰年");
		}/*else{
			System.out.println(year+"不是闰年");
		}*/
		year++;
	}
	}

	public static void main11(String[] args) {
		//1-100之间的素数
		int a=2;
		while(a <= 100){
			int leap=0;
		for(int j = 2;j <= a/2;j++){
    		if(a % j == 0){
    			leap=1;
    			//System.out.println(a+"不是素数");
    			break;
    		}/*else{
    			//System.out.println(a+"是素数");
    			//break;
    		}*/
    		}
    		if(leap==0){
    			System.out.println(a);
    		}
    		a++;
    	}
    }
    public static void main10(String[] args) {
    	//判断是否为素数
    	int a=5;
    	int j = 2;
    	for(;j < a;j++){
    		if(a % j == 0){
    			System.out.println(a+"不是素数");
    			break;
    		}
    		}
    		if(j >= a){
    		System.out.println(a+"是素数");
    	}
    	}
    	
    public static void main9(String[] args) {
    	/*int sum = 0;
    	for(int i = 1;i <= 100;i++){
    		sum+=i;
    	}
    	System.out.println(sum);*/
        int a=10;
        for (int i = 1;i < 10;i++) {
        	for (int j = 1;j <= 5 ;j++ ) {
        		System.out.println(a);
        	}
        }
    }
    public static void main8(String[] args) {
    	//1-100既能被3整除也能被5整除
    	int i=0;
    	/*while(i <= 100){
    		if(i % 3 == 0 && i % 5 == 0){
    			System.out.println(i);
    		}
    		i++;
    	}
    }*/
    while(i <= 100){
    	i++;
    	if(i % 15 != 0){
    		continue;
    	}
    	System.out.println(i);
    }
}

	public static void main7(String[] args) {
		//根据年龄判断少青中老年
		Scanner scan = new Scanner(System.in);
    	int age = scan.nextInt();
		while(age>0){
		if(age<=18){
			System.out.println(age+"是少年");
		}else if(age<=28){
			System.out.println(age+"是青年");
		}else if(age<=55){
			System.out.println(age+"是中年");
		}else{
			System.out.println(age+"是老年");
		}
		break;
	    }
		}

		public static void main6(String[] args) {
    	//求1!+2!+3!+4!+5!第一种方法
    	/*int i = 1;
    	int fac = 1;
    	int result = 0;
    	while(i<=5){
    		fac*=i;
    		result+=fac;
    		i++;
    	}
    	System.out.println(result);*/
    	//第二种方法
    	int num = 5;
    	int j = 1;
    	//int fac=1;//fac应该放第一个while里面，这样才能更新fac
    	int sum=0;
    	while(j<=num){
    		int i=1;
    		int fac=1;
    		while(i<=j){
    			fac*=i;
    			i++;
    		}
    		j++;
    		sum+=fac;
    	}

        System.out.println(sum);
    }


    //循环结构while
	public static void main5(String[] args) {
		/*while(循环条件){
			循环语句;
		}*/
		/*int a = 1;
		while(a <= 10){
			System.out.println(a);
			a++;
		}*/

		//求1-100的和。1-100奇数的和，1-100偶数的和
		int a = 1;
		int sum = 0;
		int sum1 = 0;
		
		while(a<=100){
			if(a % 2 == 0){
				sum+=a;
			}else{
				sum1+=a;
			}
			a++;
		}
		System.out.println("1-100偶数和："+sum+",1-100奇数和:"+sum1+",1-100总和："+(sum+sum1));
	}
    //switch
	public static void main4(String[] args) {
		int a = 2;
        //char a = 'abc'
		switch (a) {  //不能做switch参数的数据long float double boolean
			case 2:
			System.out.println("2");
			break;
			case 3:
			System.out.println("3");
			break;
			default :
			System.out.println("有误！");
			break;
		}
	}


    public static void main3(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	int year = scan.nextInt();
        if (year % 4 == 0&&year % 100 != 0||year % 400 == 0) {
			System.out.println(year+"是闰年");
		}else{
			System.out.println(year+"不是闰年");
		}	
    }

	public static void main2(String[] args) {
		//从键盘获取数据
		Scanner scan = new Scanner(System.in);
        //读入一个整型
        int num = scan.nextInt();

		//int num=10;
		if (num % 2 == 0) {
			System.out.println(num+"是偶数");
		}else{
			System.out.println(num+"是奇数");
		}
	}

	public static void main1(String[] args) {
		System.out.println("新的一天好！");
		System.out.println("aaa");//顺序结构
		System.out.println("bbb");
		System.out.println("ccc");

		//分支结构
		//if语句
		int a=1;
		if (a==1) {          //(里面一定是布尔表达式)
			System.out.println("HELLO!");
		}else{
			System.out.println("else");
		}
	}
}
import java.util.Scanner;

public class Testdemo {
    public static void main(String[] args) {
        //买苹果，先尽量使用大袋子，直到剩余的不够，然后根据剩余的选择要不要放弃一个大袋子，从而选择俩个小袋子
        //1.输入
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
        int n = scan.nextInt();
        int k = findCount(n);
        System.out.println(k);}
    }

    public static int findCount(int n) {
        //1.奇数不行,最少也要买6个,10个也没有办法买
        if(n % 2 == 1 || n < 6 || n == 10)return -1;
        //2.整除8的
        if(n % 8 == 0)return n/8;
        //3.不能整除8的
        return n/8+1;

    }
}



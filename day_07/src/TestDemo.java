import java.util.Scanner;

public class TestDemo {
    /*public static void main(String[] args) {
        //要求最小公倍数，直接求最大公约数，然后乘积除最大公约数
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str = scan.nextLine();
            String[] s = str.split(" ");
            int A = Integer.parseInt(s[0]);
            int B = Integer.parseInt(s[1]);
            System.out.println(A*B/gys(A,B));
        }
    }
    public static int gys(int a,int b) {
        int tmp;
        //辗转相除法
        while(b != 0){
            tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }*/

    //第二种，因为是最小公倍数，那么肯定最小也是a，b之间最大的那个
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int a = scan.nextInt();
            int b = scan.nextInt();
            int max = a > b ? a : b;
            while(max % a != 0  || max % b != 0){
                max++;
             }
            System.out.println(max);
    }
}
}
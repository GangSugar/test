import java.util.Scanner;

public class TestDemo {
    public static int exchange(int k){
        //现在手里面有k个空瓶
        if(k < 2)return 0;
        if(k == 2)return 1;
        //1.首先%3，看第一次能够换几瓶
        int m = 0; int sh = 0;
        int sum = 0;
        while(k > 2) {
            m = k / 3;//m用来存储换多少瓶
            sum += m;
            sh = m + (k - 3 * m);//换了之后所剩余的空瓶子
            k = sh;
        }
        if (sh < 2) return sum;
        return sum + 1;

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
        int n = scan.nextInt();
        if(n > 0){
        int m = exchange(n);
        System.out.println(m);
        }else return;
        }
    }
}

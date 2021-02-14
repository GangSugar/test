package 乘积尾零;

import java.util.*;

/**
 * 题目内容：如下的10行数据，每行有10个整数，请你求出它们的乘积的末尾有多少个零？
 */

public class Main {
    public static void main(String[] args) {
        /**
         * 实际上面就输出乘数因子中5的个数和2的个数，他们俩的最小值
         */
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()){
            int n = 100;//因为题目已经说定了10行，每行10个
            int count2 = 0;int count5 = 0;
            while(n > 0){
                int x = scan.nextInt();
                while(x % 2 == 0){
                    x /= 2;
                    count2++;
                }
                while(x % 5 == 0){
                    x /= 5;
                    count5++;
                }
                n--;
            }
            System.out.println(Math.min(count2,count5));
        }
    }
}

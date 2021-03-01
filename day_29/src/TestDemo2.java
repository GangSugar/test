//牛客数字和为sum的方法数
//第一种方法
//public class TestDemo2 {
//    public static int n=0;
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        n=sc.nextInt();
//        int[]a=new int[n+1];
//        int sum=sc.nextInt();
//        for (int i = 1; i <=n; i++) {
//            a[i]=sc.nextInt();
//        }
//        System.out.println(calculate(a,sum));
//        sc.close();
//    }
//    public static long calculate(int[] a,int sum)
//    {
//        long dp[][]=new long[n+1][sum+1];
//        dp[0][0]=1;
//
//        for (int i = 1; i <= n; i++) {
//            for (int j = 0; j <=sum; j++) {
//                if(j>=a[i])
//                    dp[i][j]=dp[i-1][j-a[i]]+dp[i-1][j];
//                else
//                    dp[i][j]=dp[i-1][j];
//            }
//
//        }
//        return dp[n][sum];
//    }
//}
import java.util.Scanner;
//第二种方法
public class TestDemo2{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n = scan.nextInt();
            int sum = scan.nextInt();
            int[] A = new int[n+1];
            long[] d = new long[sum+1];//用来存放得到和的方案个数
            for(int i = 1;i <= n;i++){
                A[i] = scan.nextInt();
            }
            d[0] = 1;
            for(int i = 1;i <= n;i++){
                for(int j = sum;j >= A[i];j--){
                    d[j] = d[j] + d[j-A[i]];
                }
            }
            System.out.print(d[sum]);
        }
    }
}

/*
第二次测验考试
 */
import java.util.Scanner;
public class TestDemo3{
    /*public static int fiCount(int n){
        //现在有一个n,就必须要找到和他相差最近的那个斐波那契数，构造一个100以内的斐波那契数列

        int[] arr = fibon(n);//得到斐波那契数组
        //开始遍历数组，找到和n最近的那个数字
        int min = 200;
        int j =0;
        for(int i = 0;i < arr.length;i++){
            int k = Math.abs(n - arr[i]);//计算差距
            if(k < min){
                min = k;
                j = i;}
        }
        //现在计算步数
        int m = Math.abs(n-arr[j]);
        return m;
    }
    public static int[] fibon(int n){
        int[] arr = new int[30];
        arr[0] = 0;
        arr[1] = 1;
        for(int i = 2 ;arr[i-1] < 160;i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr;
    }


    public static void main(String[] args){
        //输入一个N
        Scanner scan = new Scanner(System.in);

            int N =  scan.nextInt();
            int k = fiCount(N);
            System.out.println(k);

    }*/
    /*public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

            int N =  scan.nextInt();
            int f1 = 0;
            int f2 = 1;
            int f3 = 1;
            while(f3 < N){
                f3 = f1 + f2;
                f1 = f2;
                f2 = f3;
            }
            int k = Math.min(N-f1,f2-N);
        System.out.println(k);
    }*/

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String arr = scan.nextLine();
        String[] str = arr.split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        String[][] s = new String[n][m];
        int[][] res = new int[n][m];
        int max = 0;
        int row = 0;//横坐标
        int list = 0;//纵坐标
        for(int i = 0;i < n;i++){
            s[i] = scan.nextLine().split(" ");
            for(int j = 0;j < n;j++){
                res[i][j] = Integer.parseInt(s[i][j]);
                if(res[i][j] > max){
                    max = res[i][j];
                    row = i;
                    list = j;
                }
            }
        }
        System.out.println((row+1)+" "+(list+1));
    }
}
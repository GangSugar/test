/*public class TestDemo1 {
    static int count;
    public static void beibao(int s,int n,int[] weight){
        if(s == 0){
            count++;
            return;
        }
        if(s<0||(s>0&&n<1)){
            return;
        }
        beibao(s-weight[n],n-1,weight);
        beibao(s,n-1,weight);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = sc.nextInt();
            int[] weight = new int[N+1];
            for(int i = 1;i<=N;i++){
                weight[i] = sc.nextInt();
            }
            beibao(40,N,weight);
            System.out.println(count);
        }
    }
}*/

import java.util.Scanner;

//另外一种思路：
public class TestDemo1{
    static int[] a;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new int[n];
        for(int i = 0;i < n ;i++){
            a[i] = sc.nextInt();
        }
        System.out.println(choose(n,40));//调用
    }
    public static int choose(int n,int sum){//n为选取物品的编号，sum为剩余的质量
        if(sum == 0)return 1;//找到一种够40的情况，次数就返回1；
        if(sum < 0)return 0;//证明拿出的物品超过了40，比如，你第一次拿了30，但是物品里面最少的就是20的，导致40-30-20<0;
        if(n < 1 && sum > 0)return 0;//就是还没有拿够40，然后没有物品了，那么这辈子也不可能凑够；所以直接返回0
        return choose(n-1,sum) + choose(n-1,sum-a[n-1]); //n-1为品种n对应的数组下标，即重量
        /*到着取，先取第n件也就是数组中的n-1因为数组下标是从0开始的，然后加上剩下的(比如第一次取了20，那么还有20，你还要取，
        就是类似于求5的阶乘，5*4的阶乘这样)
        */

        /*
        a.从后往前装，装上weight[n]后，若剩余物品仍然有解
          则count(s-weight[n],n-1);
         b.若装了weight[n]后，无解，则删除该包,尝试第n-1个
           count(s,n-1);
         */

    }
}
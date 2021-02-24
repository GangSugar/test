import java.util.*;
public class TestDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//表示列数
        String str = sc.next();
        char c = str.charAt(0);
        int row ;//行数是一半(四舍五入)，因此奇数要一半加1；
        //1.计算行数
        if(n%2==0){
            row = n/2;
        }else{
            row = n/2 + 1;
        }
        //2.开始打印
        for(int i = 1;i<=row;i++){
            for(int j = 1;j<=n;j++){
                if(i==1||i==row ||j==1||j==n){//第一行和最后一行要全部打印，然后是第一列和最后一列
                    System.out.print(c);
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();//打印完一行要换行
        }
    }
}

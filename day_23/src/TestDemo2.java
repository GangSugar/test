import java.util.*;
public class TestDemo2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            //1.首先得到数字的数目
            int n = scan.nextInt();
            //2.定义数组
            int[] arr = new int[n];
            for(int i = 0;i < n;i++){
                arr[i] = scan.nextInt();
            }
            //3.开始计算这五个数
            int a1 = 0,a2 = 0,a3 = 0,a4 = 0,a5 = 0,flag = 1,count = 0;
            //double a4 = 0;
            for(int i = 0;i < n;i++){
                if(arr[i] % 5 == 0 && arr[i] % 2 == 0){
                    a1 += arr[i];
                }
                if(arr[i] % 5 == 1){
                    a2 += flag*arr[i];
                    flag = -flag;
                }
                if(arr[i] % 5 == 2){
                    a3++;
                }
                if(arr[i] % 5 == 3){
                    a4 += arr[i];
                    count++;
                }
                if(arr[i] % 5 == 4){
                    a5 = Math.max(a5,arr[i]);
                }
            }
            if(a1 != 0)System.out.print(a1+" ");else System.out.print("N"+" ");
            if(a2 != 0)System.out.print(a2+" ");else System.out.print("N"+" ");
            if(a3 != 0)System.out.print(a3+" ");else System.out.print("N"+" ");
            if(a4 != 0)System.out.printf("%.1f",(float)a4/count);else System.out.print("N");
            if(a5 != 0)System.out.print(" "+a5);else System.out.print(" "+"N");
            /*System.out.print(a1+" "+a2+" "+a3+" ");
            System.out.printf("%.1f",(float)a4/count);
            System.out.print(" "+a5);*/
        }
    }
}
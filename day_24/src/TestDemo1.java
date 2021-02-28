import java.util.*;
public class TestDemo1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            int n = scan.nextInt();
            int a = scan.nextInt();
            int[] b = new int[n];
            for(int i = 0;i < n;i++){
                b[i] = scan.nextInt();
            }
            //开始比较大小
            for(int i = 0;i < n;i++){
                if(b[i] <= a){
                    a += b[i];
                }else{
                    a += gy(a,b[i]);
                }
            }
            System.out.println(a);
        }
    }
    //最大公约数
    public static int gy(int a,int b) {
        while(b != 0){
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
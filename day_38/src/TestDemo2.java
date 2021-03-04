import java.util.*;
public class TestDemo2 {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n = scan.nextInt();
            int m = scan.nextInt();
            int k = scan.nextInt();
            int[][] arr = new int[n+1][m+1];
            while(k-- > 0){
                int x = scan.nextInt();
                int y = scan.nextInt();
                arr[x][y] = 1;
            }

            long every = m1(n,m);//所有的
            long some = m2(arr,n,m);//能够到达的
            double p = (double)some/(double)every;
            System.out.printf("%.2f",p);
        }
    }
    public static long m1(int n,int m){
        long[][] arr = new long[n+1][m+1];
        for(int i = 1;i <= n;i++){
            arr[i][1] = 1;
        }
        for(int i = 1;i <= m;i++){
            arr[1][i] = 1;
        }
        for(int i = 2;i <= n;i++){
            for(int j = 2;j <= m;j++){
                arr[i][j] = arr[i-1][j]+arr[i][j-1];
            }
        }
        return arr[n][m];
    }

    public static long m2(int[][] arr,int n,int m){
        long[][] arr1 = new long[n+1][m+1];
        for(int i = 1;i <= n;i++){
            if(arr[i][1] == 0){
                arr1[i][1] = 1;
            }else{
                break;
            }
        }
        for(int i = 1;i <= m;i++){
            if(arr[1][i] == 0){
                arr1[1][i] = 1;
            }else{
                break;
            }
        }
        for(int i = 2;i <= n;i++){
            for(int j = 2;j <= m;j++){
                arr1[i][j] = arr[i][j] == 1?0:arr1[i-1][j]+arr1[i][j-1];
            }
        }
        return arr1[n][m];
    }
}
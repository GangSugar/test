import java.util.Arrays;

public class TestDemo1 {
    public static int[] arrayPrint(int[][] arr, int n) {
        // write code here
        int[] res = new int[n*n];
        int index = 0;
        int startX = 0;
        int startY = n-1;
        while(startX<n){
            int x = startX;
            int y = startY;
            while(x<n&&y<n){
                res[index++]=arr[x++][y++];
                //System.out.println("res="+res[index-1]);
            }
            if(startY>0){//小于0的时候，这里的转成X，输出剩下的对角线数据
                startY--;
                //System.out.println("y="+startY);
            }
            else{
                startX++;
                //System.out.println("x="+startX);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[] res = arrayPrint(arr,4);
        System.out.println(Arrays.toString(res));
    }
}


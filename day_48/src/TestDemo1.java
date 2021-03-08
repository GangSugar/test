public class TestDemo1 {
    public int findMaxGap(int[] A, int n) {
        // write code here
        int max = 0;
        for(int i = 0;i <= n-2;i++){
            max = Math.max(max,Math.abs(max(A,0,i)-max(A,i+1,n-1)));
        }
        return max;
    }
    public static int max(int[] arr,int start,int end){
        int max = arr[end];
        for(int i = start;i < end;i++){
            max = Math.max(max,arr[i]);
        }
        return max;
    }
}
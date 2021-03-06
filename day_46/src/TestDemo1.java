public class TestDemo1 {
    public int MoreThanHalfNum_Solution(int [] array) {
        //计数
        int[] arr = new int[10];//0-9总共10个数字
        int n = array.length;
        for(int i = 0;i < n;i++){
            arr[array[i]]++;
        }
        for(int i = 0;i < 10;i++){
            if(arr[i] > n/2){
                return i;
            }
        }
        return 0;
    }
}
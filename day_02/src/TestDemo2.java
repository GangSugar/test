
/*public class TestDemo2 {
    public static int count(int[] A, int n) {
        if(n == 0)return 0;
        int count = 0;
        for(int i = 0;i < n;i++){
            for(int j = i;j < n;j++){
                if(A[i] > A[j]){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,0};
        int k = count(a,a.length);
        System.out.println(k);
    }
}*/


public class TestDemo2 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,0};
        int[] b = {7,5,6,4};
        int k = count(a,a.length);
        System.out.println(k);
        System.out.println(count(b,b.length));
    }
    public static int count(int[] A, int n) {
        if(n == 0)return 0;
        return mergesort(A,0,n-1);
    }
    //先分
    public static int mergesort(int[] arr,int low,int high){
        if(low == high)return 0;
        int mid = (low+high)/2;
        return mergesort(arr,low,mid)+mergesort(arr,mid+1,high)+merge(arr,low,high,mid);
    }
    public static int merge(int[] arr,int low,int high,int mid){
        int[] tmp = new int[high-low+1];//临时存放合并后的数组
        int k = 0;
        int count = 0;//统计次数
        int s1 = low;
        int s2 = mid+1;
        while(s1 <= mid && s2 <= high){
            if(arr[s1] <= arr[s2]){
                tmp[k++] = arr[s1++];
            }else {
                tmp[k++] = arr[s2++];
                count += (mid-s1+1);
            }
        }
        //有一个还没有装完
        while (s1 <= mid){
            tmp[k++] = arr[s1++];
        }
        while (s2 <= high){
            tmp[k++] = arr[s2++];
        }
        for(int i = 0;i < tmp.length;i++){
            arr[low+i] = tmp[i];
        }
        return count;
    }
}

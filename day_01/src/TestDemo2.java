import java.util.Arrays;

//快速排序，挖坑法
public class TestDemo2 {
    /*public static int findKth(int[] a, int n, int K) {
        a = quick(a,0,n-1);//已经排好序了
        //直接返回
        return a[n-K];
    }
    //进行递归排序
    public static int[] quick(int[] arr,int low,int high){
        if(low > high){
            return arr;
        }
        //找基准
        int par = parttion(arr,low,high);
        quick(arr,low,par-1);//左半部分
        quick(arr,par+1,high);//右半部分
        return arr;
    }
    //确定基准的函数
    public static int parttion(int[] arr,int start,int end){
        //挖坑
        int tmp = arr[start];
        while(start < end){
            while(start < end && arr[end] >= tmp){
                end--;
            }
            if(start > end){
                break;
            }else{
                arr[start] = arr[end];
            }


            while(start < end && arr[start] <= tmp){
                start++;
            }
            if(start > end){
                break;
            }else{
                arr[end] = arr[start];
            }
        }
        arr[start] = tmp;
        return start;
    }
    public static void main(String[] args) {
        int[] a={1,3,5,2,2};
        int k = findKth(a,a.length,3);
        System.out.println(k);

    }*/
    //第二种方法，边快排，边找数字;
    /*public static int findKth(int[] a, int n, int K) {
        return quick(a, 0, n-1, K);
    }
    public static int quick(int[] a, int low,int high,int k) {
        //利用快速排序思想，如果第一次确定基准位置后，判断如果基准右边有k-1，那么这个基准就是要得到的数字
        int par = parration(a,low,high);

        if(par-low+1 == k)return a[par];
        if(par-low+1  < k)return quick(a,par+1,high,k-par+low-1);
        return quick(a,low,par-1,k);
    }
    public static int parration(int[] arr,int start,int end){
        int tmp = arr[start];//挖坑,从打小排(如果从小到大上面会出现数字越界的情况)
        while(start < end){
            while(start < end && arr[end] <= tmp){
                end--;
            }
            if(start >= end){
                break;
            }else{
                arr[start] = arr[end];
            }

            while(start < end && arr[start] >= tmp){
                start++;
            }
            if(start >= end){
                break;
            }else{
                arr[end] = arr[start];
            }
        }
        //入坑
        arr[start] = tmp;
        return start;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        System.out.println(findKth(a,5,3));
    }*/
    //快排（从大到小排序）
    public static void quicksort(int[] arr){
        quick(arr,0,arr.length-1);
    }
    public static void quick(int[] arr,int low,int high){
        if (low > high)return;
        int par = parration(arr,low,high);

        //开始递归
        quick(arr,low,par-1);
        quick(arr,par+1,high);
    }
    public static int parration(int[] arr,int low,int high){
        //1.首先挖坑
        int tmp = arr[low];
        //2.开始从另外一个方向填坑
        while(low < high){
            while (low < high && arr[high] < tmp){
                high--;
            }
            if(low >= high){
                break;
            }else{
                arr[low] = arr[high];
            }

            //3.右边有坑了，现在从左边找数字开始给右边填坑
            while(low < high && arr[low] > tmp){
                low++;
            }
            if(low >= high){
                break;
            }else{
                arr[high] = arr[low];
            }
        }
        //4.将最后面一个坑补上
        arr[low] = tmp;
        return low;
    }

    public static void main(String[] args) {
        int[] arr = {15,598,33,5,6,3,156,2456,21,66,99,55,30};
        System.out.println(Arrays.toString(arr));
        quicksort(arr);
        System.out.println(Arrays.toString(arr));

    }
}

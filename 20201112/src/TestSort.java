import java.util.Comparator;
import java.util.Stack;

public class TestSort {
    //直接插入排序(是稳定的排序)
    /*
    稳定性：
    1.一个稳定的排序可以变成不稳定的排序；
    2.一个本身就不稳定的是不可能变成稳定的；
    空间复杂度：O(1)
    时间复杂度：最好情况O(n)数组有序的时候,最坏情况O(n2)数组无序的时候
     */
    public static void insertsort(int[] arr){
        for(int i = 1;i < arr.length;i++) {
            int tmp = arr[i];
            int j = i-1;
            for (;j >= 0;j--){
                if (arr[j] > tmp) {
                    arr[j+1] = arr[j];
                }else{
                    break;
                }
            }
            arr[j+1] = tmp;
        }
    }

    //希尔排序(优化直接插入排序)将数组进行分组
    public static void shellsort(int[] arr){
        //1.首先获取组数gqp
        int[] drr = {5,3,1};//定义一个增量数组
        for (int i = 0;i < drr.length;i++){
            shell(arr,drr[i]);
        }
    }
    //直接插入排序
    public static void shell(int[] arr,int gap) {
        for(int i = gap;i < arr.length;i++) {
            int tmp = arr[i];
            int j = i-gap;
            for (;j >= 0;j -= gap){
                if (arr[j] > tmp) {
                    arr[j+gap] = arr[j];
                }else{
                    break;
                }
            }
            arr[j+gap] = tmp;
        }
    }
    //选择排序：把后面的依次和i比较，遍历完一次，i下标放的就是最小的
    /*
    时间o(n^2)
    空间o（1）
     */
    public static void selectsort(int[] arr){
        for (int i =0;i < arr.length;i++){
            for (int j = i+1;j < arr.length;j++){
                if(arr[i] > arr[j]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    //堆排序（不稳定）
    /*
    时间复杂度O(n*log2n)
    空间复杂度：o（1）
     */
    public static void heapsort(int[] arr){
        //首先将数组元素放入一个堆
        createheap(arr);

        int end = arr.length-1;//因为后面要将堆头和最后一个元素交换位置
        while(end > 0){
            int tmp = arr[0];
            arr[0] = arr[end];
            arr[end] = tmp;
            adjustDown(arr,0,end);//调用向下调整方法重新构造大根堆
            end--;//构造完之后，将最后一个元素去掉
        }
    }
    //构造一个堆
    public static void createheap(int[] arr){
        for(int i =(arr.length-1-1)/2;i >= 0;i--){
            adjustDown(arr,i,arr.length);
        }
    }
    //向下调整方法
    public static void adjustDown(int[] arr,int parent,int len){
        //计算左孩子节点下标
        int child = 2*parent+1;
        while(child < len){
            //左右孩子选择最大的
            if(child+1 < len && arr[child] < arr[child+1]){
                child++;
            }
            //到了这一步，已经找到最大的孩子，和双亲进行比较
            if (arr[child] > arr[parent]){
                int tmp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = tmp;
                parent = child;
                child = 2*parent+1;
            }else{
                break;
            }
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] arr){
        for (int i = 0;i < arr.length-1;i++){//控制冒泡次数
            for(int j = 0;j < arr.length-1-i;j++){
                if (arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    //快速排序(采用分治思想)(找一个基准)分而治之
    /*不稳定
    时间n*log2n
    空间 log2n
     */
    public static void quicksort(int[] arr){
        quick(arr,0,arr.length-1);

    }
    //
    public static void quick(int[] arr,int low,int high){
        if(low > high){
            return;
        }
        //第一个优化：当low,high之间的数据个数少于某一个范围，可以调用直接插入排序
        if(high-low+1 < 100){
            insertsort2(arr,low,high);
            return;
        }
        //第二次优化，取三个数中位数,这样的基准就不会出现极端情况
        mid(arr,low,high);
        //par是基准
        int par = parttion(arr,low,high);
        quick(arr,low,par-1);
        quick(arr,par+1,high);
    }
    //用来优化的的直接插入排序
    public static void insertsort2(int[] arr,int low,int high){
        for(int i = low+1;i <= high;i++) {
            int tmp = arr[i];
            int j = i-1;
            for (;j >= low;j--){
                if (arr[j] > tmp) {
                    arr[j+1] = arr[j];
                }else{
                    break;
                }
            }
            arr[j+1] = tmp;
        }
    }
    //优化的取三个数字的中位数
    public static void mid(int[] arr,int low,int high){
        /*int mid = (high+low)/2;
        if (arr[low] < arr[mid] && arr[mid] < arr[high]){
            int tmp = arr[low];
            arr[low] = arr[mid];
            arr[mid] =tmp;
            System.out.println(low);
        }else if(arr[high] > arr[low] && arr[high] < arr[mid]) {
            int tmp = arr[high];
            arr[high] = arr[low];
            arr[low] =tmp;
            System.out.println(low);
        }else{
            System.out.println(low);
            return;
        }*/
        int mid = (low+high)/2;
        //array[mid] < array[low] < array[high]
        if(arr[low] >= arr[high]) {
            swap(arr,low,high);
        }
        if(arr[low] <= arr[mid]) {
            swap(arr,low,mid);
        }
        if(arr[mid] >= arr[high]) {
            swap(arr,low,mid);
        }
    }
    public static void swap(int[] arr,int low,int high){
        int tmp = arr[low];
        arr[low] = arr[high];
        arr[high] = tmp;
    }
    //划分函数
    public static int parttion(int[] arr,int start,int end){
        //申请一个tmp空间用来放基准的值(基准一般选择的是边上的值)
        int tmp = arr[start];//这里取的是最左边的值，那么一会就先从最右边开始找[end]位置
        while(start < end){
            while(start < end && arr[end] >= tmp){
                end--;
            }
            //到了这里，从while出来有俩种情况，不满足start < end或者不满足arr[end] >= tmp
            if (start >= end){
                //arr[start] = tmp;
                break;//直接退出，因为已经遍历完毕
            }else{//else就是arr[end] < tmp
                arr[start] = arr[end];
            }
            while(start < end && arr[start] <= tmp){
                start++;
            }
            //到了这里，同样从while出来有俩种情况，不满足start < end或者不满足arr[start] <= tmp
            if (start > end){
                //arr[end] = tmp;
                break;
            }else{
                arr[end] = arr[start];
            }
        }
        arr[start] = tmp;
        return start;//返回基准移动到位置，这样基准的左边全小于它，右边全都大于它
    }


    //非递归实现快速排序(需要一个栈)
    public static void quicksort1(int[] arr){
        Norquick(arr,0,arr.length-1);

    }
    //非递归实现快速排序
    public static void Norquick(int[] arr,int low,int high){
        Stack<Integer> stack = new Stack<>();
        int par = parttion(arr,low,high);
        if (par > low+1){
            stack.push(low);
            stack.push(par-1);
        }
        if (par < high-1){
            stack.push(par+1);
            stack.push(high);
        }
        while(!stack.empty()){
            int end = stack.pop();
            int start = stack.pop();
            par = parttion(arr,start,end);
            if (par > start+1){
                stack.push(start);
                stack.push(par-1);
            }
            if (par < end-1){
                stack.push(par+1);
                stack.push(end);
            }
        }
    }
    //归并排序
    public static void mergesort(int[] arr){
        mergeSortInternal(arr,0,arr.length-1);
    }
    //分割
    public static void mergeSortInternal(int[] arr,int low,int high){
        if(low >= high){
            return;
        }
        int mid = (low + high)/2;
        mergeSortInternal(arr,low,mid);
        mergeSortInternal(arr,mid+1,high);
        //分割完成，就开始合并

        merge(arr,low,high,mid);
    }
    //合并方法
    public static void merge(int[] arr,int low,int high,int mid){
        int s1 = low;
        int s2 = mid+1;
        int[] tmp = new int[high-low+1];//临时存放合并后的数据
        //开始合并
        int k = 0;//tmp开始下标
        while(s1 <= mid && s2 <= high){//俩个段都有数据
            if (arr[s1] <= arr[s2]){
                tmp[k++] = arr[s1++];

            }else{
                tmp[k++] = arr[s2++];
            }
        }
        //第一个归并段还有很多数据
        while(s1 <= mid){//第一个还有若干个数据
            tmp[k++] = arr[s1++];
        }
        while(s2 <= high){//第二个还有若干个数据
            tmp[k++] = arr[s2++];
        }
        //此时就有序了
        for (int i = 0;i < tmp.length;i++){
            arr[low+i] = tmp[i];//将临时存放好的数据给人家放回去；
        }
    }

    //归并非递归排序
    public static void mergeNorsort(int[] arr){
        for (int i = 1;i < arr.length;i *= 2 ){
            mergeNor(arr,i);
        }
    }
    public static void mergeNor(int[] arr,int gap){
        int len  = arr.length;
        int s1 = 0;
        int e1 = s1+gap-1;
        int s2 = e1+1;
        int e2 = s2+gap-1 < len ? s2+gap-1 : len-1;
        /*if (s2+gap-1 < len){
            e2 = s2+gap-1;
        }else{
            e2 =  len-1;
        }*/
        int[] tmp = new int[len];
        int k = 0;
        while(s2 < len){
            while(s1 <= e1 && s2 <= e2){
                if (arr[s1] < arr[s2]){
                    tmp[k++] = arr[s1++];
                }else {
                    tmp[k++] = arr[s2++];
                }
            }
            while(s1 <= e1){
                tmp[k++] = arr[s1++];
            }
            while(s2 <= e2){
                tmp[k++] = arr[s2++];
            }
            //一组比较完毕
            s1 = e2+1;
            e1 = s1+gap-1;
            s2 = e1+1;
            e2 = s2+gap-1 < len ? s2+gap-1 : len-1;
        }
        //到了这步，有可能只有一个段s1，那么直接将s1移动下来就可以了;
        while(s1 <= len-1){
            tmp[k++] = arr[s1++];
        }
        for (int i =0;i < arr.length;i++){
            arr[i] = tmp[i];
        }
    }
    public static void main(String[] args) {
        //直接插入排序
        int[] arr = {2,3,5,1,6,4};
        insertsort(arr);
        System.out.print("直接插入排序结果: ");
        for (int i = 0;i < arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        //希尔排序
        int[] arr1 = {7,4,9,34,0,8,5,22,55,6,12,33,56,89,77};
        shellsort(arr1);
        System.out.print("希尔排序结果: ");
        for (int i = 0;i < arr1.length;i++){
            System.out.print(arr1[i]+" ");
        }
        System.out.println();
        //选择排序
        int[] arr2 = {7,4,9,34,0,8,5,22,55,6,12,33,56,89,77};
        selectsort(arr2);
        System.out.print("选择排序结果: ");
        for (int i = 0;i < arr2.length;i++){
            System.out.print(arr2[i]+" ");
        }
        System.out.println();
        //冒泡排序
        int[] arr3 = {7,4,9,34,0,8,5,22,55,6,12,33,56,89,77};
        bubbleSort(arr3);
        System.out.print("冒泡排序结果: ");
        for (int i = 0;i < arr3.length;i++){
            System.out.print(arr3[i]+" ");
        }
        System.out.println();
        //堆排序
        int[] arr4 = {7,4,9,34,0,8,5,22,55,6,12,33,56,89,77};
        heapsort(arr4);
        System.out.print("堆排序结果: ");
        for (int i = 0;i < arr4.length;i++){
            System.out.print(arr4[i]+" ");
        }
        System.out.println();
        //快速排序
        int[] arr5 = {7,4,9,34,0,8,5,22,55,6,12,33,56,89,77};
        quicksort(arr5);
        System.out.print("快速排序结果: ");
        for (int i = 0;i < arr5.length;i++){
            System.out.print(arr5[i]+" ");
        }
        System.out.println();
        //非递归快速排序
        int[] arr6 = {7,4,9,34,0,8,5,22,55,6,12,33,56,89,77};
        quicksort1(arr6);
        System.out.print("非递归快速排序结果: ");
        for (int i = 0;i < arr6.length;i++){
            System.out.print(arr6[i]+" ");
        }
        System.out.println();
        //归并排序
        int[] arr7 = {7,4,9,34,0,8,5,22,55,6,12,33,56,89,77};
        mergesort(arr7);
        System.out.print("归并排序结果: ");
        for (int i = 0;i < arr7.length;i++){
            System.out.print(arr7[i]+" ");
        }
        System.out.println();
        //非递归归并排序
        int[] arr8 = {7,4,9,34,0,8,5,22,55,6,12,33,56,89,77};
        mergesort(arr8);
        System.out.print("非递归归并排序结果: ");
        for (int i = 0;i < arr8.length;i++) {
            System.out.print(arr8[i] + " ");
        }
    }
}



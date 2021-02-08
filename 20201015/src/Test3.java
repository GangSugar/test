import java.util.Arrays;

public class Test3 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] arr1 = {3,5,6,7,9};
        System.out.println("交换前arr:"+Arrays.toString(arr));
        System.out.println("交换前arr1:"+Arrays.toString(arr1));
        exchange(arr,arr1);
        System.out.println("交换后arr:"+Arrays.toString(arr));
        System.out.println("交换后arr1:"+Arrays.toString(arr1));
    }

    public static void main1(String[] args) {
        //拷贝第一种，自己设计（浅拷贝：改变拷贝后面的值，拷贝前的值也跟着改变）
        int[] arr = {1,2,3,4,5};
        int[] copy = cop(arr);
        System.out.println(Arrays.toString(copy));

        //拷贝第二种，利用库函数拷贝（浅拷贝）
        /*Arrays.copyOf(int[] original, int newLength)
        original:你要拷贝的数组
        newLength：需要拷贝的长度*/
        int[] copy1 = Arrays.copyOf(arr,arr.length);
        System.out.println(Arrays.toString(copy1));
        //拷贝第三种（浅拷贝）
        int[] copy3 = arr.clone();//克隆，产生当前对象的一个副本,改变副本不会改变原来数组的值
        System.out.println(Arrays.toString(copy3));
        copy3[0] = 888;
        System.out.println(Arrays.toString(copy3));
        System.out.println(Arrays.toString(arr));
        //拷贝第四种
        /*public static native void arraycopy(Object src,  int  srcPos, Object dest, int destPos, int length);
        native:底层是由C/C++代码实现
                src:你要拷贝的数组：源数组
                srcPos：源数组的位置
                dest：目的地数组
                destPos：目的数组的位置
                length：拷贝的长度*/
        int[] copy4 = new int[arr.length];
        System.arraycopy(arr,0,copy4,0,arr.length);
        System.out.println(Arrays.toString(copy4));

        //找数组最大值
        int max = maxArray(arr);
        System.out.println("数组最大值为:"+max);
        //平均值
        double avg = avgArray(arr);
        System.out.println(avg);
        //二分查找
        int[] arr1 = {1,5,2,6,4};
        Arrays.sort(arr1);//数组排序
        System.out.println(Arrays.toString(arr1));
        int k= find(arr1,1);
        System.out.println("下标是:"+k);
        //冒泡排序
        int[] arr2 = new int[1000];
        for (int i = 0;i < arr2.length;i++){
            arr2[i] = i;
        }
        bubbleSSort(arr2);
        System.out.println("冒泡后的数组顺序是:"+Arrays.toString(arr2));
        /*bubbleSSort1(arr2);
        System.out.println("优化冒泡后的数组顺序是:"+Arrays.toString(arr2));*/
        //逆序数组
        reverse(arr2);
        System.out.println("逆序数组:"+Arrays.toString(arr2));
        //数组数字排列
        int[] arr3 ={1,2,4,8,5,6,7};
        transform(arr3);
        System.out.println("数组数字排列"+Arrays.toString(arr3));
    }
    //自己设计的拷贝函数
    public static int[] cop(int[] array){
        int[] copy = new int[array.length];
        for (int i = 0;i < array.length;i++){
            copy[i] = array[i];
        }
        return copy;
    }
    //找数组最大值
    public static int maxArray(int[] array){
        int max = array[0];
        for (int i = 1;i < array.length;i++){
            if (array[i] >max){
                max = array[i];
            }
        }
        return max;
    }
    public static double avgArray(int[] array){
        double avg = 0;
        int sum = 0;
        for (int i = 0;i < array.length;i++){
             sum = sum + array[i];
        }
        avg = sum*1.0/array.length;
        return avg;
    }
    //判断数组是否有序
    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i] > arr[i+1]) {
                return false;
            }
        }
        return true;
    }
    //二分查找(前提数组要先排序)
    public static int find(int[] array,int key){
        int left = 0;
        int right = array.length-1;
        while (left <= right){
            int mid = (left+right)/2;
            if (key < array[mid]){  // 数组左侧查找
                right = mid - 1;
            }else if (key > array[mid]){  // 数组右侧查找
                left = mid + 1;
            }else
                return mid;
        }
        return -1;//循环结束说明没有找到；
    }
    //排序
    public static void sort1(int[] arr){
        for (int i = 0;i < arr.length;i++){
            for (int j = i+1;j < arr.length;j++){
                if (arr[i] > arr[j]){
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
    }
    //冒泡排序
    public static void bubbleSSort(int[] arr){
        int count = 0;
        for (int i = 0;i < arr.length-1;i++){//i表示趟数
            count++;
            for (int j = 0;j < arr.length-1-i;j++){
                if (arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        System.out.println("趟数:"+count);
    }
    //优化后的冒泡排序（因为提前已经排好序，所有应该想办法让他提前停止，
    // 这样就没有必要进行后面无用的趟数）
    public static void bubbleSSort1(int[] arr){
        int count = 0;
        for (int i = 0;i < arr.length-1;i++){//i表示躺数
            boolean flag = false;
            count++;
            for (int j = 0;j < arr.length-1-i;j++){
                if (arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = true;
                }
            }
            if (flag == false){
                break;
            }
        }
        System.out.println("优化趟数:"+count);
    }
    //数组逆序
    public static void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
                right--;
        }
    }
    //数组数字排列（奇数放在偶数的后面）
    public static void transform(int[] arr){
        int left = 0;
        int right = arr.length-1;
        while(left < right){
            // 该循环结束, left 就指向了一个奇数
            while(left < right && arr[left] % 2 == 0){
                left++;
            }
            //left遇到奇数了
            while(left < right && arr[right] % 2 != 0){
                // 该循环结束, right 就指向了一个偶数
                right--;
            }
            //right遇到偶数了

                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
        }
    }
    //奇数放在数组后面
    public static void transform1(int[] arr){
        int left = 0;
        int right = arr.length-1;
        while(left < right){
            // 该循环结束, left 就指向了一个偶数
            while(left < right && arr[left] % 2 != 0){
                left++;
            }
            //left遇到偶数了
            while(left < right && arr[right] % 2 == 0){
                // 该循环结束, right 就指向了一个奇数
                right--;
            }
            //right遇到奇数了

            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
        }
    }

    //交换俩个数组
    public static void exchange(int[] arr,int[] arr1){
        int[] tmp = new int[arr.length];
        for (int i = 0;i < arr.length;i++){
            tmp[i] = arr[i];
            arr[i] = arr1[i];
            arr1[i] = tmp[i];
        }
    }
    /*public static int sum (int[] arr){//(int... arr)可以变参数
        int ret = 0;
        for (int i = 0;i < arr.length;i++){
            ret += arr[i];
        }
    }*/

};
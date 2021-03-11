/*
排序
* */

import java.util.Arrays;
import java.util.LinkedList;

public class TestDemo {
    //直接插入排序
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = tmp;
        }
    }

    //希尔排序
    public static void shellsort(int[] arr) {
        int[] gap = {5, 3, 1};//定义分组的个数
        for (int i = 0; i < gap.length; i++) {
            //调用直接插入排序
            shell(arr, gap[i]);
        }
    }

    public static void shell(int[] arr, int gap) {
        for (int i = gap; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i - gap;
            for (; j >= 0; j -= gap) {
                if (arr[j] > tmp) {
                    arr[j + gap] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + gap] = tmp;
        }
    }

    //选择排序
    public static void selectsort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    //堆排序
    public static void heapsort(int[] arr) {
        initheap(arr);//数组入堆
        //开始排序
        int end = arr.length - 1;
        while (end > 0) {
            int tmp = arr[0];
            arr[0] = arr[end];
            arr[end] = tmp;
            //重新排序
            adjustDown(0, arr, end);
            end--;
        }

    }

    //人堆
    public static void initheap(int[] arr) {
        for (int i = (arr.length - 1 - 1) / 2; i >= 0; i--) {
            adjustDown(i, arr, arr.length);
        }
    }

    //构造大根堆（向下调整）
    public static void adjustDown(int partent, int[] arr, int len) {
        int child = 2 * partent + 1;
        while (child < len) {
            if (child+1 < len && arr[child] < arr[child+1]) {
                child++;
            }
            //到了这里和双亲进行比较
            if (arr[child] > arr[partent]) {
                int tmp = arr[child];
                arr[child] = arr[partent];
                arr[partent] = tmp;
                partent = child;
                child = 2 * partent + 1;
            } else {
                break;
            }
        }
    }

    //冒泡排序
    public static void bobullsort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    //快速排序
    public static void quicksort(int[] arr) {
        quick(arr, 0, arr.length - 1);

    }

    //
    public static void quick(int[] arr, int low, int high) {
        if (low > high) {
            return;
        }
        int par = parttion(arr, low, high);
        quick(arr, low, par - 1);
        quick(arr, par + 1, high);
    }

    //划分函数
    public static int parttion(int[] arr, int start, int end) {
        //填坑法，首先挖坑,坑里面挖出来作为基准备
        int tmp = arr[start];
        while (start < end) {
            while (start < end && arr[end] > tmp) {
                end--;
            }
            if (start >= end) {
                break;
            } else {
                arr[start] = arr[end];
            }
            while (start < end && arr[start] < tmp) {
                start++;
            }
            if (start >= end) {
                break;
            } else {
                arr[end] = arr[start];
            }
        }
        arr[start] = tmp;
        return start;
    }

//归并排序
    //合并
    public static void merge(int[] array,
                             int low,int high,int mid) {
        int s1 = low;
        int s2 = mid+1;
        int[] tmpArr = new int[high-low+1];//用来存放合并后的数字
        int k = 0;//就是tmpArr的下标

        //代表2个段都有数据
        while (s1 <= mid && s2 <= high) {
            if(array[s1] <= array[s2]) {
                tmpArr[k] = array[s1];
                k++;
                s1++;
            }else {
                tmpArr[k] = array[s2];
                k++;
                s2++;
            }
        }
        //第一个归并段 还有 若干数据
        while (s1 <= mid) {
            tmpArr[k++] = array[s1++];
        }
        while (s2 <= high) {
            tmpArr[k++] = array[s2++];
        }
        //也就是说 tmpArr 当中存放的 就是这次归并的有序之后 的 结果
        for (int i = 0; i < tmpArr.length; i++) {
            array[low+i] = tmpArr[i];
        }
    }

    /**
     * 时间复杂度：nlogn
     * 空间复杂度：O(n)
     * 稳定性：稳定的排序
     * @param array
     * @param low
     * @param high
     */

    //分解
    public static void mergeSortInternal(int[] array,
                                         int low,int high) {
        if(low >= high) {
            return;
        }
        int mid = (low+high)/2;
        mergeSortInternal(array,low,mid);
        mergeSortInternal(array,mid+1,high);
        //开始合并
        merge(array,low,high,mid);
    }
//归并排序
    public static void mergeSort(int[] array) {
        mergeSortInternal(array,0,array.length-1);
    }


    public static void main(String[] args) {
        int[] arr = {7,4,9,34,0,8,5,22,55,6,12,33,56,89,77};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

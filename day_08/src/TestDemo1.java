/*import java.util.Scanner;
public class TestDemo1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n = scan.nextInt();
            int[] arr = new int[n];
            //数组初值都是0，将删除掉的数字变为1；每次开始数到第三个就删除掉，一直到删够n-1个数字，剩下那个就是
            int index = index(arr,n-1);
            System.out.println(index);
        }
    }
    public static int index(int[] arr,int n){
        int count = 0;//计数的，每次删除掉第三个，然后重新计数
        int k = 0;//数组下标
        int res = 0;//用来放结果的
        //循环条件一直删除够n-1个数字
        while(n > 0){
            if(arr[k] == 0){
                count++;
            }
            if(count == 3){
                count = 0;
                n--;
                arr[k % arr.length] = 1;
            }
            k++;
            if(k == arr.length) k = k%arr.length;
        }
        for (int i = 0;i < arr.length ;i++){
            if (arr[i] == 0){
                res = i;//得到最后剩下的那个的数字，那么他就是最后一个需要删除的数字;
                break;
            }
        }
        return res;
    }
}*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 每次隔俩个删除俩个
 */
public class TestDemo1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n = scan.nextInt();
            List<Integer> arr = new ArrayList<>();
            for(int i = 0;i < n;i++){
                arr.add(i);
            }
            int i = 0;
            while (arr.size() > 1){
                i = (i+2)%arr.size();
                arr.remove(i);
            }
            System.out.println(arr.get(0));
        }
    }
}




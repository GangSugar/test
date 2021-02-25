/**
 * 每次读取一个数之后，算出他经过k次洗牌后的位置，只用一个长度为2n数组用来输出
 * 根据当前数的位置，可以算出经过一次洗牌后的位置
 * 如果当前数小于等于n（即在左手），则他下次出现的位置是 2*当前位置-1
 * 如果当前位置大于n（即在右手）,则他下次出现的位置是 2*（当前位置 - n）
 * 个人建议在线面试题的时候如果5分钟内没想到好方法建议就使用暴力方法，
 * 毕竟测试用例不通过什么都没用
 * Created by lizo on 2016/8/20.
 */

import java.util.*;
public class TestDemo1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int num = scan.nextInt();//有几组数据
            while(num > 0){
                int n = scan.nextInt();//n是牌数的一半，总共2*n张
                int k = scan.nextInt();//k是交换的次数
                int[] arr = new int[2*n];
                for (int i = 0;i < 2*n;i++){
                    int tmp = i+1;
                    for (int j = 0;j < k;j++){//每张牌交换的次数
                        //如果小于等于n消除就在2*现在的位置减1；
                        if(tmp <= n){
                            tmp = 2*tmp-1;
                        }else{
                            tmp = 2*(tmp-n);
                        }
                    }
                    arr[tmp-1] = scan.nextInt();
                }

                //开始输出
                if(arr.length > 0) System.out.print(arr[0]);
                for(int i = 1;i < 2*n;i++){
                    System.out.print(" "+arr[i]);
                }
                System.out.println();
                num--;
            }
        }
    }
}

/*
1.左边的牌下一次的位置是2*当前下标；
2.右边的牌下一次位置等于2*(当前下标-n+1)-1；
*/
//import java.util.*;
//public class Main {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        while(scan.hasNext()){
//            //1.开始输入
//            int num = scan.nextInt();// num组数据
//            //2.单独处理每一组数据
//            while(num > 0){
//                //3.首先把n和k拿出来
//                int n = scan.nextInt();
//                int k =  scan.nextInt();
//                //4.设置一个数组，用来放2*n张牌
//                int[] arr = new int[2*n];
//                for(int i = 0;i < 2*n;i++){
//                    int tmp = i;//用tmp先标记牌的首次位置，然后最后表示k次之后的位置
//                    for(int j = 0;j < k;j++){//每一张牌都是有规律的变k次
//                        if(tmp < n){
//                            tmp = 2*tmp;
//                        }else{
//                            tmp = 2*(tmp-n+1)-1;
//                        }
//                    }
//                    arr[tmp] = scan.nextInt();
//                }
//                //5.经过循环之后一组数据就已经放好了，现在要输出，输出的时候有空格
//                System.out.print(arr[0]);
//                for(int i = 1;i < 2*n;i++){
//                    System.out.print(" "+arr[i]);
//                }
//                //6.一组数据输完要进行换行
//                System.out.println();
//                //7.开始进行下一组数据的处理，num代表的是组数，那么就num--;
//                num--;
//            }
//        }
//    }
//}
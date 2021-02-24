import java.util.Arrays;
import java.util.Scanner;

/*import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
public class TestDemo2 {
    public static void main(String[] args) {
        //TOPK问题，建立最小堆，优先级队列
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str = scan.nextLine();
            String[] s = str.split(" ");
            int[] arr = new int[s.length-1];
            int k = Integer.parseInt(s[s.length-1]);
            for(int i = 0;i < s.length-1;i++){
                arr[i] = Integer.parseInt(s[i]);
            }
            topk(arr,k);
        }
    }
    public static void topk(int[] arr,int k){
        int[] res = new int[k];
        //1.先建立k个数的大根堆
       PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        //2.遍历数组，放够k个数据，
        for (int i = 0;i < arr.length;i++){
            if (maxHeap.size() < k){//刚开始不够k个先放进去k个
                maxHeap.add(arr[i]);
            }else{
                //现在够k个,如果比根小就放进去
                if(arr[i] < maxHeap.peek()){
                    maxHeap.poll();
                    maxHeap.offer(arr[i]);
                }
            }
        }
        //3.然后排序
        for(int i = 0;i < k;i++){
            res[i] = maxHeap.poll();
        }
        Arrays.sort(res);
        StringBuffer str = new StringBuffer();
        for(int i = 0;i < k;i++){
            str.append(res[i]);
            str.append(" ");
        }
        System.out.println(str.toString());
    }
}*/
//第二种方法去，利用快排的思想
public class TestDemo2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str = scan.nextLine();
            String[] s = str.split(" ");//用空格将字符串放在字符串数组中
            int[] num = new int[s.length-1];//用来放这些数字的数组，这样好用来排序
            for(int i = 0;i < s.length-1;i++){
                num[i] = Integer.parseInt(s[i]);//将字符串变为数字好放在数字数组中
            }
            int k = Integer.parseInt(s[s.length-1]);//得到是k的值，因为k在最后一个
            //1.开始进行快速排序，首先进行递归，然后进行确定几准的位置
            int start = 0;
            int end = num.length-1;
            int index = qSort(num,start,end);//现在已经确定了位置，则判断左边够不够k个
            while(index != k){
                if(index > k){
                    end = index-1;
                    index = qSort(num,start,end);//开始只排前半部分
                }else{
                    start = index+1;
                    index = qSort(num,start,end);
                }
            }
            //到这里之后index == k，然后将这k个元素排序就好
            Arrays.sort(num,0,k);
            for (int i = 0;i < k;i++){
                System.out.print(i == k-1?num[i]:num[i]+" ");//这样就是最后一个不需要空格
            }
        }
    }

    //确定基准的位置
    public static int qSort(int[] num,int start,int end){
        //1.首先挖坑
        int tmp = num[start];
        //2.开始遍历
        while(start < end){
            //3.开始填坑
            while(start < end && num[end] > tmp){
                end--;
            }
            //4.循环出来之后，可能有俩种情况
            if(start >= end){
                break;//直接跳出
            }else{
                num[start] = num[end];//先暂时用这个合适的坑填上前面的
            }

            //5.现在又要挖这边的坑去填另外一边的坑，和上面一样
            while(start < end && num[start] < tmp){
                start++;
            }
            if (start >= end){
                break;
            }else{
                num[end] = num[start];
            }
        }
        //6.到了这里，把最后一个坑补上去
        num[start] = tmp;
        return start;
    }
}
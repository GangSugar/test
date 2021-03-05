//import java.util.*;
//public class TestDemo1 {
//    public static void main (String[] args) {
//        Scanner scan = new Scanner(System.in);
//        while(scan.hasNext()){
//            int n = scan.nextInt();
//            int[] arr = new int[n];
//            for(int i = 0;i < n;i++){
//                arr[i] = scan.nextInt();
//            }
//            int max = Integer.MIN_VALUE;
//            for(int i = 0;i < n;i++){
//                ArrayList<Integer> list = new ArrayList<>();
//                for(int j = i;j < n;j++){
//                    list.add(arr[i]);
//                    int sum = sum(list);//求和
//                    if(sum > max){
//                        max = sum;
//                    }
//                }
//            }
//            System.out.println(max);
//        }
//    }
//    public static int sum(ArrayList<Integer> list) {
//        int sum = 0;
//        for(int i = 0;i < list.size();i++){
//            sum += list.get(i);
//        }
//        return sum;
//    }
//}


//第二种方法
import java.util.*;
public class TestDemo1 {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n = scan.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i < n;i++){
                arr[i] = scan.nextInt();
            }
            int max = Integer.MIN_VALUE;
            int sum = 0;
            for(int i = 0;i < n;i++){
                if(sum > 0){
                    sum += arr[i];
                }else{
                    sum = arr[i];
                }
                if(sum > max){
                    max = sum;
                }
            }
            System.out.println(max);
        }
    }
}
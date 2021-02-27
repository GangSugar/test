import java.util.Arrays;

public class TestDemo1 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,2,2};
//        Map<Integer,Integer> map = new HashMap<>();
//        for (int i = 0;i < 5;i++){
//            if (!map.containsKey(arr[i])){
//                map.put(arr[i],1);
//            }else {
//                map.put(arr[i],map.get(arr[i])+1);
//            }
//        }
//        for (int i = 0;i < 5;i++){
//            if (map.get(arr[i]) > 5/2) System.out.println(arr[i]);
//        }
//        System.out.println(0);

        //第二种方法，那个数如果存在一定在排序后的数组中间位置
        Arrays.sort(arr);
        int res = arr[5/2];
        int count = 0;
        for (int i = 0;i < 5;i++){
            if (arr[i] == res){
                count++;
            }
        }
        System.out.println((count > 5 / 2) ? res : 0);

    }
}

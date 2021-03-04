import java.util.*;

/**
 * 多边形
 */
public class TestDemo1 {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while(scan.hasNext()){
            int n = scan.nextInt();
            //i = 1添加，2是删除
            for(int i = 0;i < n;i++){
                int op = scan.nextInt();
                int l = scan.nextInt();
                if(op == 1){
                    list.add(l);
                }else{
                    //如果存在该长度的就去掉
                    //list.remove(i),移除下标为i的元素的值。
                    //转化为list.remove((Object)i)表示要移除该值;
                    if(list.contains(l)){
                        list.remove((Object)l);
                    }
                }
                //判断是不是能够成为多边形
                is(list);
            }
        }
    }
    public static void is(List<Integer> list){
        //由三角形定理等价过来，任意俩边之和大于第三边，则可以，极端情况，只要最小的边之和大于最大的那条边就可以
        Collections.sort(list);
        int max = list.get(list.size()-1);
        int sum = 0;
        for(int i = 0;i < list.size()-1;i++){
            sum += list.get(i);
        }
        if(sum > max){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
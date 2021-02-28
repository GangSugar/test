import java.util.*;
public class TestDemo2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n = scan.nextInt();//学生数目
            int m = scan.nextInt();//操作的数目
            int[] arr = new int[n+1];//n个学生的初始成绩
            for(int i = 1;i < n+1;i++){
                arr[i] = scan.nextInt();
            }
            //Q为询问操作，U是更新操作
            List<Integer> res = new ArrayList<>();
            while(m > 0){
                char ch = scan.next().charAt(0);
                int a = scan.nextInt();
                int b = scan.nextInt();
                if(ch == 'Q'){
                    //求最大值
                    res.add(max(arr,a,b));
                }else{
                    arr[a] = b;
                }
                m--;
            }
            for (int i = 0;i < res.size();i++){
                System.out.println(res.get(i));
            }
        }
    }
    //最大值
    public static int max(int[] arr,int left,int right) {
        int max = arr[left];
        for(int i = left;i <= right;i++){
            max = Math.max(max,arr[i]);
        }
        return max;
    }
}
import java.util.*;
public class TestDemo1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            //越靠近左边的使用最小的
            String str = scan.nextLine();
            String[] st = str.split(" ");
            int min = 10;
            int[] arr = new int[10];//直接用长度为10的放0-9的数字
            for(int i = 0;i < st.length;i++) {
                arr[i] = Integer.parseInt(st[i]);
            }
            //2.将数字放好，只要第一个数字放除0之外最小的一个数字，然后按照顺序输出就ok
            StringBuffer res = new StringBuffer();//结果
            for (int i = 1;i < 10;i++){
                if(arr[i] != 0){
                    res.append(i);
                    arr[i] -= 1;
                    break;
                }
            }
            //将剩下的按照顺序添加进去
            for (int i = 0;i < 10;i++){
                while(arr[i] != 0){
                    res.append(i);
                    arr[i] -= 1;
                }
            }
            System.out.println(res.toString());
        }
    }
}

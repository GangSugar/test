
import java.util.Scanner;
public class TestDemo2{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int pop = scan.nextInt();
            //俩种做法都相当于由元组(2*x+1)组成
            int nums = Min(pop);
            System.out.println(nums);
        }
    }
    public static int Min(int x){
        int count = 0 ;
        //因为最多100000次神秘力量，那就是100000次8*x+7，也就是300000次2*x+1；
        while(x != 0 && count <= 300000){
            x = ((x << 1)+1) % 1000000007;
            count++;
        }
        //count相当于走一次2*x+1，在加上俩次就是三次的2*x+1也就是8*x+7;
        int res = (count + 2) / 3;
        return res > 100000 ? -1 : res;
    }
}
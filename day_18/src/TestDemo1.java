import java.util.Scanner;
public class TestDemo1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.nextLine();
            int n = scan.nextInt();
            //开始for循环
            int max = 0;
            int index = 0;//记录最大子序列开始下标
            for(int i = 0;i <= str.length()-n;i++){
                int count = 0;//统计子序列的长度
                for(int j = i;j < i+n;j++){
                    if(str.charAt(j) == 'G' || str.charAt(j) == 'C'){
                        count++;
                    }
                }
                if(count > max){
                    index = i;
                    max = count;
                }
            }
            //进行输出
            StringBuffer s = new StringBuffer();
            for(int i = 0;i < n;i++){
                s.append(str.charAt(index));
                index++;
            }
            System.out.println(s.toString());

        }
    }
}
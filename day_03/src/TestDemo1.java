/*public class TestDemo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String ressult = "";
        int count = 0;
        char [] arr = string.toCharArray();
        for (int i= 0 ;i<arr.length;i++){
            if('0'<=arr[i] && '9'>= arr[i]){//当前的是数字
                count = 1;//初始化计算器
                int index = i;//在后面的循环存储截至索引
                for(int j=i+1;j<arr.length;j++){
                    if('0'<=arr[j] && '9'>= arr[j]){
                        count++;
                        index =j;
                    }else {
                        break;
                    }
                }if(count>ressult.length()){
                    ressult = string.substring(i,index+1);
                }
            }else {
                continue;
            }

        }
        System.out.println(ressult);
    }
}*/
/*abcd12345ed125ss123456789fb*/

//第二种方法
import java.util.Scanner;
public class TestDemo1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str = scan.nextLine();//得到字符串
            int max = 0,count = 0,end = 0;
            for(int i = 0;i < str.length();i++){
                if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                    count++;
                    if(count > max){
                        max = count;
                        end = i;
                    }
                }else{
                    count = 0;
                }
            }
            //输出
            System.out.println(str.substring(end-max+1,end+1));

        }
    }
}
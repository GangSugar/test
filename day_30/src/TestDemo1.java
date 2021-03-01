import java.util.Scanner;

//牛客奇校验
public class TestDemo1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()){
            String str  = scan.nextLine();
            //进行奇校验，最后的结果是1的个数奇数个
            //3的ASCII码为51，二进制为：0011 0011 奇校验为：1011 0011
            for (int i = 0;i < str.length();i++){
                char ch = str.charAt(i);
                int a = ch - 0;
                //得到二进制字符串
                StringBuilder binary = new StringBuilder(Integer.toBinaryString(a));
                if (binary.length() < 8){
                    int len = 8 - binary.length();
                    for (int j = 0;j < len;j++){
                        binary.insert(0,"0");//将不够8位的二进制补充为8位
                    }
                }
                //现在开始统计二进制字符串当中1的个数
                int count = 0;
                for (int j = 0;j < binary.length();j++){
                    if (binary.charAt(j) == '1')count++;
                }
                //统计完成后看1的个数是奇数个还是偶数个
                if (count % 2 == 0){//如果是偶数个
                    System.out.println("1"+binary.substring(1));//将最高位补充为1因此要从第二个截取一下
                }else{
                    System.out.println(binary.toString());//直接输出二进制
                }
            }
        }
    }
}

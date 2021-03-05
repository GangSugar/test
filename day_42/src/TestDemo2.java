import java.util.Scanner;

public class TestDemo2{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String s1 = scan.nextLine();
            String s2 = scan.nextLine();
            System.out.println(add(s1));
            System.out.println(sub(s2));
        }
    }
    //加密
    public static String add(String str){
        char[] chs = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < chs.length; i++){
            if(chs[i] >= 'a' && chs[i] <= 'z'){
                chs[i] = (char)((str.charAt(i)+1-32-'A')%26+'A');
            }
            else if(chs[i] >= 'A' && chs[i] <= 'Z'){
                chs[i] = (char)((str.charAt(i)+1+32-'a')%26+'a');
            }
            else if(chs[i] >= '0' && chs[i] <= '9'){
                chs[i] = (char)((str.charAt(i)+1-'0')%10+'0');
            }
            sb.append(chs[i]);
        }
        return sb.toString();
    }
    //解密
    public static String sub(String str){
        char[] chs = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < chs.length; i++){
            if(chs[i] >= 'a' && chs[i] <= 'z'){
                chs[i] = (char)((str.charAt(i)-1-32-'A'+26)%26+'A');
            }
            else if(chs[i] >= 'A' && chs[i] <= 'Z'){
                chs[i] = (char)((str.charAt(i)-1+32-'a'+26)%26+'a');
            }
            else if(chs[i] >= '0' && chs[i] <= '9'){
                chs[i] = (char)((str.charAt(i)-1-'0'+10)%10+'0');
            }
            sb.append(chs[i]);
        }
        return sb.toString();
    }
}

//第二种方法
//import java.util.Scanner;
//
//public class Main {
//
//    public static final String str1 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//    public static final String str2 = "BCDEFGHIJKLMNOPQRSTUVWXYZAbcdefghijklmnopqrstuvwxyza1234567890";
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {
//            String strEncrypt = in.nextLine();// 待加密字符串
//            String strUnEncrypt = in.nextLine();// 待解密字符串
//
//            char[] aucPassword = strEncrypt.toCharArray();
//            char[] password = strUnEncrypt.toCharArray();
//
//            Encrypt(aucPassword);
//            unEncrypt(password);
//        }
//    }
//
//    /**
//     * 字符串加密
//     *
//     * @param aucPassword
//     */
//    public static void Encrypt(char aucPassword[]) {
//        StringBuffer sb = new StringBuffer();
//        for (int j = 0; j < aucPassword.length; j++) {
//            for (int i = 0; i < str1.length(); i++) {
//                char c = str1.charAt(i);
//                if (c == aucPassword[j])
//                    sb.append(str2.charAt(i));
//            }
//        }
//        System.out.println(sb.toString());
//    }
//
//    /**
//     * 字符串解密
//     *
//     * @param password
//     */
//    public static void unEncrypt(char password[]) {
//        StringBuffer sb = new StringBuffer();
//        for (int j = 0; j < password.length; j++) {
//            for (int i = 0; i < str2.length(); i++) {
//                char c = str2.charAt(i);
//                if (c == password[j])
//                    sb.append(str1.charAt(i));
//            }
//        }
//        System.out.println(sb.toString());
//    }
//
//}
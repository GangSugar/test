public class TestDemo1{
    /**
     * 第一种：自己写的，利用String
     * @param str1
     * @param str2
     * @return
     */
    /*public static int find(String str1,String str2){
        //寻找回文串
        //1.首先遍历str1,判断方法，双指针
        int count = 0;
        if(find1(str2+str1)){//直接加在头
            count++;
        }
        if(find1(str1+str2)){//直接加在尾巴
            count++;
        }
        for(int i = 0;i < str1.length()-1 ;i++){//中间部分
            String str3 = str1.substring(0,i+1);//左闭右开
            String str4 = str1.substring(i+1, str1.length());
            String str5 = str3+str2+str4;
            if(find1(str5)){
                count++;
            }
        }
        return count;
    }
    //用来合并字符串，并且判断是否为回文
    public static boolean find1(String str1){
        int start =0;int end = str1.length()-1;
        for (;start < str1.length();){
            if(str1.charAt(start) == str1.charAt(end)){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            String str1 = scan.nextLine();
            String str2 = scan.nextLine();
            int k = find(str1,str2);
            System.out.println(k);}

    }*/


    /**
     * 第二种：答案当中的利用StringBuilder或者StringBuffer
     */
    /*public static void main(String[] args) {
        //1.首先输入俩个字符串str1和str2
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();//nextLine可以输入空格
        String str2 = scan.nextLine();
        int count = 0;//用来统计
        //开始循环，从不同的位置添加进去str2
        for(int i =0;i <= str1.length();i++){
            //这里采用StringBuilder(单线程String，非线程安全)
            StringBuilder sb = new StringBuilder(str1);
            sb.insert(i,str2);//将str2插入到sb、的i位置上面
            //这里单独写一个判断是否为回文的方法
            if(isHuiWen(sb.toString())){
                count++;//如果是就加加
            }
        }
        System.out.println(count);
    }
    public static boolean isHuiWen(String s) {
        int start = 0;int end = s.length()-1;
        while(start < end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }*/

    /**
     * 第三种：用StringBuffer
     */
    /*public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();//nextLine可以输入空格
        String str2 = scan.nextLine();
        int count = 0;//用来统计
        //开始循环，从不同的位置添加进去str2
        for(int i =0;i <= str1.length();i++){
            //这里采用StringBuffer(多线程String，线程安全)
            StringBuffer sb = new StringBuffer(str1);
            sb.insert(i,str2);//将str2插入到sb、的i位置上面
            //这里单独写一个判断是否为回文的方法
            if(isHuiWen(sb.toString())){
                count++;//如果是就加加
            }
        }
        System.out.println(count);
    }
    public static boolean isHuiWen(String s) {
        int start = 0;int end = s.length()-1;
        while(start < end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }*/

}


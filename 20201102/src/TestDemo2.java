//包装类

/*
装箱   简单到-》包装类类型
1.自动装箱
2.显示装箱

拆箱     包装类型到-》简单类型
1.自动拆箱
2.显示拆箱
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TestDemo2 {



    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.add(3,4);
        System.out.println(list);

        List<Integer> list2 = new ArrayList<>();
        list2.add(88);
        list2.addAll(list);
        System.out.println(list2);

        System.out.println("size = "+list2.size());
        System.out.println(list2.remove(2));
        System.out.println("size = "+list2.size());

        int a = list2.get(0);
        System.out.println(a);

        List<Integer> ret = list2.subList(0,2);
        System.out.println(ret);
        System.out.println(list2);
        ret.set(0,1);
        System.out.println(list2);



        List<Integer> list3 = new ArrayList<>();
        list3.add(73);
        list3.add(50);
        list3.add(100);
        Collections.sort(list3);
        System.out.println(list3);

        List<String> list4 = new ArrayList<>();
        String str1 = "welcome to bit";
        String str2 = "come";
        list4 = fun(str1,str2);
        //System.out.println(list4);
        for (String str :list4) {
            System.out.print(str);
        }
        /* Integer i = 10;//自动装箱，
        Integer i1 = new Integer(10);//显示装箱
        Integer i2 = 10;//如果值在-128 -- 127之间，则i和i1相同

        int b = i;//拆箱
        double d = i.doubleValue();
        */
    }
    public static List<String> fun(String str1,String str2){
        List<String> list4 = new ArrayList<>();
        for (int i = 0;i < str1.length();i++){
            char ch = str1.charAt(i);
            if(!str2.contains(ch+"")){
                list4.add(ch+"");
            }
        }
        return list4;
    }

}

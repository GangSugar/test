package 哈希map;

import java.util.*;

public class TestDemo {
    /*
    旧键盘：https://www.nowcoder.com/questionTerminal/f88dafac00c8431fa363cd85a37c2d5e
     */
    //strMust是本来输入的字符串，strAct是最后实际输出的字符串
    /*public static void fun(String strMust,String strAct){
        //1.首先把实际输出的字符串放到集合里面
        HashSet<Character> setAct = new HashSet<>();
        for (char ch:strAct.toUpperCase().toCharArray()){//toUpperCase()把值变为大写字母
            setAct.add(ch);
        }

        //此时setAct中存放的就是实际输出的字符
        //2.遍历本来要输入的字符串strMust
        HashSet<Character> setMust = new HashSet<>();//用来存放坏了的键盘键

        char[] strMusts = strMust.toUpperCase().toCharArray();//将本来输入的放到字符数组里面
        for(char ch2 : strMusts){
            //如果实际输入没有ch2，那么说明ch2就是坏键盘，后面那个条件是判断之前有没有把这个坏键盘记录下来
            if (!setAct.contains(ch2) && !setMust.contains(ch2)){
                setMust.add(ch2);//ch2里面放的就是坏键盘
                System.out.println(ch2);
            }
        }
    }

    public static void main4(String[] args) {
        fun("7_This_is_a_test","_hs_s_a_es");
    }*/
    public static void main3(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random ran = new Random();
        for (int i = 0;i < 100000;i++){
            list.add(ran.nextInt(100000));
        }
        Set<Integer> set = new HashSet<>();
        //第一题：找到100000个数字中第一次重复的那个数据
        for (int i =0;i < 100000;i++){
            if (set.contains((list.get(i)))){
                System.out.println(list.get(i));
                break;
            }else{
                set.add(list.get(i));
            }
        }
        //第二题：去掉重复数据
        for (int i =0;i < 100000;i++){
            set.add(list.get(i));
        }
        //第三题：统计数据出现次数
        Map<Integer,Integer> map = new HashMap<>();
        //1.遍历list
        for (Integer key:list){
            if (map.get(key) == null){
                map.put(key,1);
            }else{
                map.put(key,map.get(key)+1);
            }
        }
        for (Map.Entry<Integer,Integer> i: map.entrySet()){
            if (i.getValue() > 1){
                System.out.println("重复数字："+i.getKey()+"次数："+i.getValue());
            }
        }

    }

    public static void main2(String[] args) {
        Set<String> set = new HashSet<>();//set中不放重复的值(是个集合)，只存放key键值
        set.add("avsd");
        set.add("sfsdvc");
        System.out.println(set);

        Iterator<String> it = set.iterator();//迭代器
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println(set.size());
        it.remove();
        System.out.println(set.size());

    }

    public static void main(String[] args) {
        String[] str  = {" "};
        Arrays.toString(str).split("\\ ");
    }
    public static void main1(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("及时雨","宋江");
        System.out.println(map.get("及时雨"));

        for (Map.Entry<String,String> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}

import java.util.*;

public class TestDemo {
    public static void main(String[] args) {
        //Map是键值对应值  key-》value，因此<>里面有俩种类型，例如<String,String>
        Map<String,String> map= new HashMap<>();
        map.put("悟能","八戒");
        map.put("齐天大圣","孙悟空");//map存放的顺序不一定是打印的顺序
        System.out.println(map);
        map.put("齐天大圣","孙悟空2");//键值可以重复，但是对应的值就被更新了
        System.out.println(map);

        System.out.println(map.get("齐天大圣"));//根据键值拿值

        System.out.println(map.getOrDefault("齐天大圣", "唐僧"));
        System.out.println(map.getOrDefault("悟净", "唐僧"));

        Set<Map.Entry<String,String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
                   System.out.println(entry.getKey());
                   System.out.println(entry.getValue());
         }
    }

    public static void main1(String[] args) {
        Collection<Integer> coll1 = new ArrayList<>();;
        coll1.add(1);
        System.out.println(coll1.isEmpty());//判断是否为空
        System.out.println(coll1);
        coll1.add(2);
        coll1.add(3);
        System.out.println(coll1);
        System.out.println(coll1.remove(3));//删除
        System.out.println(coll1);


        Collection<String> coll2 = new ArrayList<>();
        coll2.add("abc");

    }
}

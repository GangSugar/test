import java.util.*;

public class TestDemo2 {
    public List<String> topKFrequent(String[] words, int k) {
        //在输入进来了一串单词，取出其中出现频率最高的k个单词
        //1.首先将单词和它对应的数据一起存放在哈希表中，通过 键值(String单词)——值(Integer频率) 的形式
        Map<String,Integer> map = new HashMap<>();
        String[] s = new String[words.length];
        for (int i = 0; i < words.length;i++){
            s[i] = words[i];
            if (map.get(s[i]) == null){
                map.put(s[i],1);
            }else{
                map.put(s[i],map.get(s[i])+1);

            }
        }
        //2.开始构造小根堆(根据优先级队列)
        PriorityQueue<Map.Entry<String,Integer>> minHeap = new PriorityQueue<>(
                k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue()){//如果俩个单词的频率相同
                    return o2.getKey().compareTo(o1.getKey());//俩个单词按照降序排序
                }
                return o1.getValue()-o2.getValue();//否则按照频率升序排列
            }
        }
        );
        //3.开始往优先级队列中添加元素，类似于TOPK问题
        for(Map.Entry<String,Integer> i : map.entrySet()){
            if (minHeap.size() < k){
                minHeap.offer(i);
            }else{
                Map.Entry<String,Integer> top = minHeap.peek();
                if (top.getValue() == i.getValue() ){
                    //词的频率相等，字母顺序小的入栈
                    if (top.getKey().compareTo(i.getKey()) > 0){
                        minHeap.poll();
                        minHeap.offer(i);
                    }
                }else{
                    if(top.getValue() < i.getValue()) {
                        minHeap.poll();
                        minHeap.add(i);
                    }
                }
            }
        }
        //4.因为输出顺序和需要堆顺序相反，所以倒换一下顺序
        LinkedList<String>  res = new LinkedList<>();
        for(int i = 0; i< k; ++i){
            String temp = minHeap.peek().getKey();
            res.add(0,temp);//头插法
            minHeap.poll();
        }
        return res;

    }
}

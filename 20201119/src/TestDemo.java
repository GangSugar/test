//哈希表
//哈希桶
class HashBuck{

    static class Node{
        int data;//map.put(key,value)，data就是键key
        int value;
        Node next;
        public Node(int data,int value){
            this.data = data;
            this.value = value;
        }
    }
    Node[] array;//数组里面放的是Node节点
    int usedSize;
    public HashBuck(){
        this.array =new Node[10];
        usedSize = 0;
    }
    //放入哈希表
    public void put(int key,int value){
        int index = key % array.length;//拿到位置
        //遍历这个位置下的链表
        for (Node cur = array[index];cur != null;cur = cur.next){
            if (cur.data == key){//判断一下之前有没有插入进去过value这个值，如果之前已经有了直接替换掉
                cur.value = value;
                return;
            }
        }
        //到了这里说明没有和当前key值一样的元素，进行头插法
        //头插法：首先先跟后面的联系起来；
        Node node = new Node(key,value);//待插入节点
        node.next = array[index];//数组里面放的就是第一个节点的地址
        array[index] = node;//然后把新插入的地址放到数组里面
        usedSize++;//插入进去之后，链表的数量加一
        //判断是否需要扩容，当负载因子大于0.75，就需要扩容
        if (loadFactor() > 0.75){
            //需要扩容
            resize();//调用扩容函数
        }
    }
    //计算负载因子
    public float loadFactor(){
        return usedSize*1.0f / array.length;
    }
    //扩容(扩容的时候必须重新哈希)
    public void resize(){
        Node[] newArray = new Node[2*array.length];//扩为原来的二倍
        for (int i = 0;i < array.length;i++){//遍历，进行重新哈希
            Node curNext = null;//用来标记下一个，防止重新哈希cur的时候，后面的节点丢失；
            for (Node cur = array[i];cur != null;cur = curNext){//对每一个数组下标下的链表都要进行遍历；
                curNext = cur.next;
                //array[i]下标是一个链表
                //cur是头节点
                int index = cur.data % newArray.length;//计算新的位置
                cur.next = newArray[index];//然后进行头插
                newArray[index] = cur;
            }
        }
        this.array = newArray;//最后赋值得到新的扩容之后的哈希；
    }
    //根据键去获取值value
    public int getvalue(int key){
        int index = key % array.length;//拿到位置
        for(Node cur = array[index];cur != null;cur = cur.next){
            if (cur.data == key){
                return cur.value;
            }
        }
        return -1;
    }

    //根据键key删除掉这个值
    public void remove(int key){
        //1.首先找到位置
        int index = key % array.length;//拿到位置
        if(index >= array.length)return;//不在表中，位置不合理
        //然后开始遍历，如果是头节点，直接删除掉
        if(array[index] != null){
        if(array[index].data == key){
            array[index] = array[index].next;
        }}
        //2.接下来，不是头节点，直接删除
        Node cur = null;
        Node prev = null;
        if( array[index] != null && array[index].next != null)
        {cur  = array[index].next;
        prev = array[index];}
        while(cur != null){
            if(cur.data == key){
                prev.next = cur.next;
                cur = prev.next;
            }else{
                prev = cur;
                cur = cur.next;
            }
        }
    }
}


public class TestDemo {
    public static void main(String[] args) {
        HashBuck hashBuck = new HashBuck();
        hashBuck.put(1,1);
        hashBuck.put(2,2);
        hashBuck.put(3,3);
        hashBuck.put(4,4);
        hashBuck.put(5,5);
        hashBuck.put(6,6);
        hashBuck.put(7,7);
        System.out.println("abcd");
        hashBuck.remove(4);
        System.out.println("12345");


    }
}

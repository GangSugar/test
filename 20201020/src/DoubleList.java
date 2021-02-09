//节点类
class Node2{
    public int val;//数据
    Node2 next;//后继
    Node2 prev;//前驱
    //构造方法
    public Node2(int val){
        this.val = val;
    }
}


//带傀儡节点双向链表
public class DoubleList {
    public Node2 head;//双向链表的头
    public Node2 last;//双向链表的尾巴
    //傀儡节点
    public DoubleList() {
        this.head = new Node2(-1);
    }


    //头插法
    public void addFirst(int val) {
        Node2 node = new Node2(val);

        //第一次插入，只有傀儡节点
        if (head.next == null){
        head.next = node;
        node.prev = head;
        last = node;
        return;
        }
        //不是第一次插入
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }
    //尾插法
    public void addLast(int val) {
        Node2 node = new Node2(val);
        //第一次插入
        if (head == null) {
            head.next = node;
            node.prev = head;
            last = node;
            return;
        }
        last.next = node;
        node.prev = last;
        last = node;
    }

    //打印带傀儡节点的双向链表
    public void display(){
        Node2 tmp = head.next;
        while (tmp != null){
            System.out.print(tmp.val+" ");
            tmp = tmp.next;
        }
        System.out.println();
    }
    //长度
    public int size() {
        int count = 0;
        Node2 tmp = head.next;
        while (tmp != null) {
            tmp = tmp.next;
            count++;
        }
        return count;
    }
    //查找关键字key是否在链表中
    public boolean contains(int key) {
        if (head.next == null) {
            return false;
        }
        Node2 tmp = head.next;
        while (tmp != null) {
            if (tmp.val == key) {
                return true;
            } else {
                tmp = tmp.next;
            }
        }
        return false;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data) {
        Node2 node = new Node2(data);
        if (index == 0){
            addFirst(data);
            return;
        }
        if (index == size()){
            addLast(data);
            return;
        }
        Node2 cur = this.head.next;
        int a = index;
        while(a > 0){
            cur = cur.next;
            a--;
        }
        node.next = cur;
        cur.prev.next = node;
        node.prev = cur.prev;
        cur.prev = node;
    }
    //删除第一次出现关键字key节点
    public void remove(int key){
        if (head.next == null){
            System.out.println("没有!");
        }
        Node2 cur = head.next;
        while(cur != null) {
            if (cur.val == key){
                if (cur == head.next){
                    head.next = cur.next;
                    cur.next.prev = head;
                }else{
                    cur.next.prev = cur.next;
                     if (cur.next != null){
                        cur.next.prev = cur.prev;
                     }else{
                       last = last.prev;
                     }
                }
                return;
            }else{
                cur = cur.next;
            }
        }

    }
    //删除所有出现关键字key的节点
    public void removeAll(int key){
        if (head.next == null){
            System.out.println("没有!");
        }
        Node2 cur = head.next;
        while(cur != null) {
            if (cur.val == key){
                if (cur == head.next){
                    head.next = cur.next;
                    cur.next.prev = head;
                }else{
                    cur.prev.next = cur.next;
                    if (cur.next != null){
                        cur.next.prev = cur.prev;
                    }else{
                        last = last.prev;
                    }
                }
            }else{
                cur = cur.next;
            }
        }

    }
    //清除
    public void clear() {
        this.head = null;
        this.last = null;
    }
}

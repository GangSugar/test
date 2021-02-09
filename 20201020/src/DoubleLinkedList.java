//节点类
class Node1{
    public int val;//数据
    Node1 next;//后继
    Node1 prev;//前驱
    //构造方法
    public Node1(int val){
        this.val = val;
    }
}

//双向链表
public class DoubleLinkedList {
    public Node1 head;//双向链表的头
    public Node1 last;//双向链表的尾巴

    //头插法
    public void addFirst(int val) {
        Node1 node = new Node1(val);
        //第一次插入
        if (head == null) {
            head = node;
            last = node;
        }
        //不是第一次插入
        node.next = head;
        head.prev = node;
        head = node;
    }

    //尾插法
    public void addLast(int val) {
        Node1 node = new Node1(val);
        //第一次插入
        if (head == null) {
            head = node;
            last = node;
            return;
        }
        last.next = node;
        node.prev = last;
        last = node;
    }

    //长度
    public int size() {
        int count = 0;
        Node1 tmp = this.head;
        while (tmp != null) {
            tmp = tmp.next;
            count++;
        }
        return count;
    }

    //查找关键字key是否在链表中
    public boolean contains(int key) {
        if (head == null) {
            return false;
        }
        Node1 tmp = head;
        while (tmp != null) {
            if (tmp.val == key) {
                return true;
            } else {
                tmp = tmp.next;
            }
        }
        return false;
    }
    //打印双向链表
    public void display(){
        Node1 tmp = head;
        while (tmp != null){
            System.out.print(tmp.val+" ");
            tmp = tmp.next;
        }
        System.out.println();
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data) {
        Node1 node = new Node1(data);
        if (index == 0){
            addFirst(data);
            return;
        }
        if (index == size()){
            addLast(data);
            return;
        }
        Node1 cur = this.head;
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
    //删除第一次出现关键字key的节点
    public void remove(int key){
        if (head == null){
            System.out.println("没有!");
        }
        Node1 cur = head;
        while(cur != null) {
            if (cur.val == key){
                if (head.val ==key){
                head = head.next;
                this.head.prev = null;
                }else{
                    cur.prev.next = cur.next;
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
        if (head == null){
            System.out.println("没有!");
        }
        Node1 cur = head;
        while(cur != null) {
            if (cur.val == key){
                if (head.val ==key){
                    if (head.next == null){
                        head = null;
                        return;
                    }
                    head = head.next;
                    this.head.prev = null;
                }else{
                    cur.prev.next = cur.next;
                    if (cur.next != null){
                        cur.next.prev = cur.prev;
                    }else{
                        last = last.prev;
                    }
                }
            }
                cur = cur.next;
        }
    }
    //清除
    public void clear() {
        this.head = null;
        this.last = null;
    }
}

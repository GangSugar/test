//定义节点类
class Node1{
    //一个数据域，俩个地址域（引用）
    public int data;
    public Node1 next;//后继
    public Node1 prev;//前驱

    //构造方法
    public Node1(){

    }
    public Node1(int data){
        this.data = data;
    }
}

//无傀儡节点的双向链表
class DoubleLinkedList{
    public Node1 head;//双向链表的头
    public Node1 last;//双向链表的尾巴

    //头插法
    public void addFirst(int data){
        Node1 node = new Node1(data);
        //1.第一次插入
        if(head == null){
            head = node;
            last = node;
            return;
        }
        //其他情况
        node.next = head;//先和链表绑定起来
        head.prev = node;
        head = node;//换头，新插入的节点做头
    }
    //尾插法
    public void addLast(int data){
        Node1 node = new Node1(data);
        //1.先考虑是不是第一次插入
        if (head == null){
            head = node;
            last = node;
            return;
        }
        //2.其他情况，用一个cur来标记尾巴，进行尾插法
        //Node1 cur = this.head;
        while(last.next !=null){
            last = last.next;
        }
        node.prev = last;
        last.next = node;

    }
    //找插入位置index
    public Node1 searchIndex(int index){
        Node1 cur = this.head;
        int count = 0;
        while(count <index){
            cur = cur.next;
            count++;
        }
        return cur;
    }
    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index,int data){
        //1.一般对于在指定位置插入，要先考虑插入位置是否合理
        //2.然后考虑会不会插入的位置的是不是头或者尾巴
        //3.剩下的其他情况，
        Node1 node = new Node1(data);
        if (index < 0 || index > size()){
            System.out.println("插入位置不合法!");
            return false;
        }
        if(index == 0){
            addFirst(data);
            return true;
        }
        if (index == size()){
            addLast(data);
            return true;
        }
        //其他情况,找插入位置
        Node1 cur = searchIndex(index);
        node.next = cur;
        node.prev = cur.prev;
        cur.prev.next = node;
        cur.prev = node;

        return true;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        //1.直接遍历链表，进行比较，找到就true
        Node1 cur = this.head;
        while(cur != null){
            if (cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        //1.利用contains判断是否存在关键字，不存在直接跳出
        if (!contains(key)){
            return;
        }
        //2.存在进行遍历,特殊情况，头节点没有前驱
        Node1 cur = this.head;
        while(cur != null){
            if (cur.data == key){
                if(head.data == key){
                    head = head.next;
                    head.prev = null;
                }else{
                    cur.prev.next = cur.next;
                    if (cur.next != null){
                        cur.next.prev = cur.prev;
                    }else{
                        last = last.prev;
                    }
                }
                return;
            }
            cur = cur.next;
        }
    }
    //删除所有值为key的节点
    //第一种，遍历俩次
    /*public void removeAllKey(int key){
        //1.遍历一次，确定关键字的个数
        //2.然后调用remove
        Node1 cur = this.head;
        int count = 0
        while(cur != null){
            count++;
            cur = cur.next;
        }
        while(count > 0){
            remove(key);
            count--;
        }
    }*/
    //第二种，只遍历一次
    public void removeAllKey(int key){
        Node1 cur = this.head;
        while(cur != null){
            if (cur.data == key){
                if(head.data == key){
                    if (head.next == null){
                        head = null;
                        return;
                    }
                    head = head.next;
                    head.prev = null;
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
    //得到单链表的长度
    public int size(){
        Node1 cur = this.head;
        int count = 0;
        while(cur != null){
            cur = cur.next;
            count++;
        }
        return count;
    }
    //打印双向链表
    public void display(){
        Node1 cur = this.head;
        while(cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;//遍历整个链表
        }
        System.out.println();
    }
    //清除双向链表
    public void clear(){
        head = null;
    }
}

public class TestDemo2 {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addFirst(1);
        doubleLinkedList.addFirst(1);
        doubleLinkedList.addFirst(2);
        doubleLinkedList.addFirst(3);
        doubleLinkedList.addFirst(1);
        doubleLinkedList.display();
        doubleLinkedList.addLast(4);
        doubleLinkedList.addLast(5);
        doubleLinkedList.addFirst(1);
        doubleLinkedList.addLast(6);
        doubleLinkedList.addFirst(1);
        doubleLinkedList.addFirst(99);
        doubleLinkedList.addFirst(1);
        doubleLinkedList.addLast(6);
        doubleLinkedList.display();
        /*doubleLinkedList.remove(1);
        doubleLinkedList.display();*/
        doubleLinkedList.removeAllKey(1);
        doubleLinkedList.display();

    }
}

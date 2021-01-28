//先设置一个节点类
class Node{
    //1.一个数据域，一个地址域
    public int data;
    public Node next;//存放下一个节点的引用（地址）
    public Node(){

    }

    public Node(int val){
        this.data = val;
        //这里没有初始化的原因:不知道next当前指向谁
    }

}
//单链表（不带傀儡节点的）(每一个节点都是一个对象)
class LinkedList{
    public Node head;//定义一个节点（Node）

    //头插法
    public void addFirst(int data){
        Node node = new Node(data);
        //1.是不是第一次插入
        if (head == null){
            head = node;
        }else{
        node.next = head;
        head = node;//node作新的头
        }
    }
    //尾插法
    public void addLast(int data){
        Node node = new Node(data);
        //1.是不是第一次插入
        if (head == null){
            head = node;
            return;
        }
        //找到尾巴节点
        Node cur = this.head;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = node;
    }
    //找到index位置的前驱index-1位置的节点
    public Node searchPrev(int index){
        Node cur = this.head;
        int count = 0;
        while (count < index-1){
            cur = cur.next;
            count++;
        }
        return cur;
    }
    //任意位置插入,第一个数据节点为0号下标,index是位置
    public boolean addIndex(int index , int data){
        Node node = new Node(data);
        //1.首先判断位置是否合理并且链表是否为空
        if (index < 0 || index > size()){
            System.out.println("位置不合法!");
            return false;
        }
        //2.插入为0号位置，就相当于头插法
        if (index == 0){
            addFirst(data);
        }
        //3.其他情况，要先找到插入位置的前驱
        Node cur = searchPrev(index);//调用seachPrev找到index-1位置的节点（就是index的前驱）
        node.next = cur.next;
        cur.next = node;

        return true;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        //遍历
        Node cur = this.head;
        while(cur != null){
            if (cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //找到关键字的前驱节点
    public Node searchPrev1(int key){
        Node cur = this.head;
        while (cur.next != null){
            if (cur.next.data == key){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        //1.判断是否有关键字
        if(!contains(key)){
            return;
        }
        //2.如果有，要考虑关键字是否为头结点
        if (head.data == key){
            head = head.next;
            return;
        }
        //其他情况，找到关键字的前驱，直接前驱prev.next = prev.next.next
        Node cur = searchPrev1(key);//找关键字节点的前驱
        if (cur != null){
            cur.next = cur.next.next;
        }else{
            return;
        }
    }
    //删除所有值为key的节点
    //第一种，遍历了很多次
    /*public void removeAll(int key){
        int count = 0;
        Node node = new Node(key);
        Node cur = this.head;
        while(cur != null){
            if (cur.data == key){
                count++;
            }
            cur = cur.next;
        }
        while(count > 0){
            remove(key);
            count--;
        }
    }*/
    //第二种，只遍历一次就删除
    public void removeAll(int key){
        /*1.定义俩个引用
        head ，prev(要删除节点的前驱)
        2.定义一个cur：当前要删除的节点
         */
        Node prev = this.head;
        Node cur = head.next;
        while(cur != null){
            if (cur.data == key){
                prev.next = cur.next;
            }else{
                prev = cur;
            }
            cur = cur.next;
        }
        //因为刚才没有考虑头节点，因此直接判断头节点
        if (head.data == key){
            //调用remove
            //remove(key);
            head = head.next;
        }

    }
    //打印单链表
    public void display(){
        Node cur = head;
        while (cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    //单链表长度
    public int size(){
        //遍历，进行count++
        int count = 0;
        Node cur = head;
        while (cur != null){
            cur = cur.next;
            count++;
        }
        return count;
    }
    //清空单链表
    public void clear(){
        head = null;
    }
}

public class TestDemo1 {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.display();
        linkedList.addLast(4);
        linkedList.addLast(5);
        linkedList.addLast(6);
        linkedList.addFirst(99);
        linkedList.display();
        linkedList.addIndex(2,100);
        linkedList.addIndex(2,100);
        linkedList.addIndex(2,100);
        linkedList.addLast(100);
        linkedList.display();
        linkedList.remove(1);
        linkedList.removeAll(100);
        linkedList.display();
    }
}

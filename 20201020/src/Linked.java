//节点类
class Nod{
    //包含俩个成员变量数据域和地址（引用）
    public int data;
    public Nod next;
//构造方法
    public Nod(int data) {
        this.data = data;
    }
}


//单向链表
public class Linked {
    //1.首先定义头节点
    public Nod head;

    //头插法
    public void addFirst(int data){
        //1.先考虑特殊情况，第一次插入并且之前没有任何节点
        //2.接着普遍情况
        //定义插入的节点
        Nod node  = new Nod(data);
        if (head == null){
            head = node;
            return;
        }else{
            //1.首先把head给node，将node和之前的链表联系起来
            node.next = head;
            head = node;//2.把node变为新的头head
        }
    }
    //尾插法
    public void addLast(int data){
        Nod node = new Nod(data);//建立起来插入节点
        //1.特殊情况考虑链表是否有节点
        //2.一般情况，要找到最后一个节点，才能插入，因此需要进行遍历
        if(head == null){
            head = node;
            return;
        }
        Nod cur = this.head;//从头节点开始
        while(cur.next != null){
            cur = cur.next;//一直找到尾巴
        }
        //上面已经找到尾巴，开始插入
        cur.next = node;
        node.next = null;
    }

    //找到index-1的节点
    public Nod searchPrev(int index){
        int count = 0;
        Nod cur = this.head;
        while (count < index-1){
            cur = cur.next;
            count++;
        }
        return cur;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data) {
        Nod node = new Nod(data);
        //1.首先判断是否有节点，没有的话直接头插法
        if(head == null){
            head =node;
        }
        //2.要先知道插入的位置是否合理，是否超出链表的长度，因此先知道长度
        if(index < 0||index > size()){
            System.out.println("插入位置不合理!");
            return;
        }
        //1.要找到index-1位置的节点
        if (index == 0){
            addFirst(data);
        }

        if (index == size()+1){
            addLast(data);
        }
        if(index <= size()){
            Nod cur = searchPrev(index);
            node.next = cur.next;
            cur.next = node;
        }

    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        Nod cur = this.head;
        while(cur != null){
            if(cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){

    }
    //删除所有值为key的节点
    public void removeAllKey(int key) {

    }
    //得到单链表的长度
    public int size() {
        int count = 0;//用来计数
        Nod node = this.head;
        while(node != null){
            count++;
            node = node.next;
        }
        return count;
    }
    public void display() {
        Nod cur = this.head;//把头节点给新引用，这样进行从头到尾巴遍历
        while(cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();

    }
    public void clear() {
        this.head = null;
    }

    /**
     *  删除链表中等于给定值 **val** 的所有节点。 [OJ题]
     Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    /*class Solution {
        public ListNode removeElements( int val) {
            if(head == null) {
                return null;
            }
            Node prev = head;
            Node cur = head.next;//用来遍历
            while (cur != null) {
                if(cur.val == val) {
                    prev.next = cur.next;
                }else {
                    prev = cur;
                }
                cur = cur.next;
            }
            if(head.val == val) {
                head = head.next;
            }
            return head;
        }
    }*/
    //输入两个链表，找出它们的第一个公共结点；
    public Nod getIntersectionNode(Nod headA, Nod headB) {
        if (headA != null|| headB != null){
            return null;
        }
        Nod pl = headA;
        Nod ps = headB;
        //1.算单链表长度
        int lenA = 0;
        int lenB = 0;
        while(pl != null){
            lenA++;
            pl = pl.next;
        }
        while(ps != null){
            lenB++;
            ps = ps.next;
        }
        //2.长的给pl，短的给ps
        if (lenA < lenB){
            pl = headB;
            ps = headA;
        }else{
            ps = headB;
            pl = headA;
        }
        //3.pl走差值步,a为差值
        int a = 0;
        if(lenA -lenB > 0){
            a = (lenA-lenB);
        }else{
            a = (lenB-lenA);
        }
        while(a > 0){
            pl = pl.next;
        }
        //4.一起走，直到相遇
        while(pl != ps && pl != null && ps != null){
            pl = pl.next;
            ps = ps.next;
        }
        if (pl == ps && pl != null){
        return pl;
        }
        return null;
    }
}

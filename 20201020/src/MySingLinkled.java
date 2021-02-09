//节点类
class Node{
    public int data;//数据
    public Node next;//相当于对象，存放引用
    //构造方法
    public Node(int data){
        this.data = data;
        //这里没有初始化next的原因，是因为不知道next指向哪个节点；
    }
}
//单向链表
public class MySingLinkled {
    public Node head;//定位头节点

    //头插法
    public void addFirst(int data){
        //1.通过data构造一个Node对象
        //node.next= head，（其中node是插入的数据）
        //head = node；
        Node node = new Node(data);
        if (this.head == null){
            //第一次插入
            this.head = node;
        }else{
            node.next = this.head;//先建立插入节点与原先链表的联系
            this.head = node;//把插入进来的node设置为新的头节点
        }
    }
    //尾插法
    public void addLast(int data){
        Node node = new Node(data);
        if (this.head == null){
            this.head = node;
            return;
        }
        Node cur = this.head;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = node;
        node.next = null;
    }

    //找到index-1的节点
    public Node searchPrev(int index){
        int count = 0;
        Node cur = this.head;
        while (count < index-1){
            cur = cur.next;
            count++;
        }
        return cur;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data) {
        Node node = new Node(data);
        if(index < 0||index >size()){
            System.out.println("不合法!");
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
            Node cur = searchPrev(index);
            node.next = cur.next;
            cur.next = node;
        }
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        Node cur = this.head;
        while(cur != null){
            if(cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    /**
     * 找到关键字Key的前驱
     * @param key
     * @return
     */
    public Node searchPrevNode(int key) {
        Node cur = this.head;
        while (cur.next != null) {
            if(cur.next.data == key) {
                return cur;
            }
            cur = cur.next;
        }
        //退出循环，cur已经走到了链表的尾部
        return null;//没有key的前驱
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        //1、头节点
        if(this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        //2、找需要删除节点的前驱
        Node prev = searchPrevNode(key);
        if(prev == null) {
            return;
        }
        Node del = prev.next;//就是要删除的节点的引用
        prev.next = del.next;
    }

    /*//删除第一次出现关键字为key的节点
    public void remove(int key){
        //1.找删除函数的前驱
        //2.特殊情况删除头节点
        if(contains(key) != true){
            System.out.println("关键字不存在");
            return;
        }

        Node cur = this.head;
        //假设删除的是头节点
        if (this.head.data == key){
            this.head =  this.head.next;
        }
        //删除的不是头节点
        while(cur.next != null) {
            if (cur.next.data == key){
                Node del = cur.next;
                cur.next = del.next;
            }
            cur = cur.next;
        }
    }*/
    //删除所有值为key的节点(第一种方法)
    public void removeAllKey(int key) {
        int count = 0;
        Node cur = this.head;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        while (count > 0){
            remove(key);
            count--;
        }
    }
    //删除所有值为key的节点(第二种方法)
    public void removeAllKey1(int key) {
        Node prev = this.head;//当前删除节点的前驱
        Node cur = this.head.next;//cur为当前需要删除的节点
        while(cur != null) {
            if (cur.data == key) {
                prev.next = cur.next;
                //cur = cur.next;
            } else {
                prev = cur;
                //cur = cur.next;
            }
            cur = cur.next;
        }
        if(this.head.data == key){
            this.head = this.head.next;
        }
    }
    //得到单链表的长度
    public int size() {
        int count = 0;
        Node tmp = this.head;
        while(tmp != null){
            tmp = tmp.next;
            count++;
        }
        return count;
    }
    //打印单链表
    public void display() {
        Node cur = this.head;
        while(cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    //从指定节点开始打印
    public void display1(Node newHead) {
        Node cur = newHead;
        while(cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    //删除链表
    public void clear() {
        this.head = null;
    }
    //反转链表
        public Node reverseList() {
            //第一种想法：拿头节点后面的一个一个进行头插
            //第二种想法：一个一个改变next值（head,prev,cur,curNext）head要置空
            Node cur = this.head;
            Node newHead = null;//反转后新的头节点
            Node prev = null;//用来标记每次要改变那个节点
            while (cur != null) {
                Node curNext = cur.next;
                if(curNext == null) {
                    newHead = cur;
                }
                cur.next = prev;
                prev = cur;
                cur = curNext;
            }
            return newHead;
        }
        // 返回链表中间节点
        public Node middleNode(){
            //1.定义俩个引用，一个是一个的速度的二倍，快的（fast）一次走俩步
            //2.对偶数情况发fast为空，奇数fast。next为空
            Node slow = this.head;slow = slow.next;
        Node fast = this.head;
        while(fast !=null && fast.next != null){
             fast = fast.next.next;
         }
        return slow;
    }
    //输出链表倒数第k个节点
    public Node findNode(int k){
        if (head == null || k <= 0||k >size()){
            return null;
        }
        Node slow = this.head;
        //其中一个先走k-1步
        Node fast = this.head;
        int m = k-1;
        while(m != 0 ){
            if (fast.next != null){
            fast = fast.next;
            m--;
            }else{
                System.out.println("没有这个k!");
                return null;
            }
        }
        while(fast.next !=null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    //给定一个链表，给定一个x，左边放比x小的，右边放大于等于x的；
    public Node partition(int x){
        Node bs = null;
        Node be = null;
        Node as = null;
        Node ae = null;
        Node cur = this.head;

        while (cur != null) {
            if(cur.data < x) {
                if(bs == null) {
                    bs = cur;
                    be = cur;
                }else {
                    bs.next = cur;
                    be = bs.next;
                }
            }else {
                if(as == null) {
                    as = cur;
                    ae = cur;
                }else {
                    as.next = cur;
                    ae = as.next;
                }
            }
            cur = cur.next;
        }
        /*
        把新的链表串起来
        1、两个段内 可能有一个是空的
        2、如果两个段都有数据,最后一定要置空，ae.next = null;
           be.next = as;
         */
        if (bs == null){
            return as;
        }
        if (as == null){
            return bs;
        }
        be.next = as;
        ae.next = null;
        return bs;
    }
    //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点
    public Node deleteDuplicatiuon(){
        Node newHead = new Node(-1);
        Node cur = this.head;
        Node tmp = newHead;

        while (cur != null){
            if (cur.next != null && cur.data == cur.next.data){
                while(cur.next != null && cur.data == cur.next.data){
                    cur = cur.next;
                }
                    cur = cur.next;
            }else{
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        tmp.next = null;
        return newHead.next;
    }
    //给定一个链表,判断是否有环
    public boolean hasCycle() {
        Node fast = this.head;
        Node slow = this.head; //给定一个链表;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }
        if(fast == null || fast.next == null) {
            return false;
        }
        return true;
    }
    //给定一个链表，返回链表开始入环的第一个节点
    public Node hasCycle1(){
        //1.先判断有环
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }
        if(fast == null || fast.next == null) {
            return null;
        }

        slow = this.head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    //回文
    public boolean chkPalindrome() {
        if(this.head == null) {
            return false;
        }
        //只有1个节点的时候，也是回文
        if(this.head.next == null) {
            return true;
        }
            //1.找中间位置
            Node fast = this.head;
            Node slow = this.head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            //2.slow就是中间位置，开始反转
            Node cur = slow.next;
            while(cur != null){
                Node curNext = cur.next;
                cur.next = slow;
                slow = cur;
                cur = curNext;
            }
            //3.开始判断
            while(this.head != slow){
                if (this.head.data != slow.data){
                    return false;
                }
                //偶数情况
                if (this.head.next == slow){
                    return true;
                }
                this.head = this.head.next;
                slow = slow.next;

            }
            return true;
        }

    //俩个有序链表，变为新的有序链表
    public Node mergeList(Node headA,Node headB){
        Node newHead = new Node(-1);
        Node tmp = newHead;
        while(headA != null && headB != null ){
         if (headA.data < headB.data){
             tmp.next = headA;
             tmp = tmp.next;
             headA = headA.next;
         }else{
             tmp.next = headB;
             tmp = tmp.next;
             headB = headB.next;
         }
        }
        if (headA == null){
            tmp.next = headB;
        }else{
            tmp.next = headA;
        }
        return newHead.next;
    }
    //输入两个链表，找出它们的第一个公共结点
    public Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null) return null;
        Node pA = headA, pB = headB;
        while (headA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class TestDDemo2 {
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        //1.直接准备俩个链表，一个大，一个小，最后把大的放小的后面
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode smallHead = small;
        ListNode largeHead = large;
        while(pHead != null){
            if(pHead.val < x){
                small.next = pHead;
                small = small.next;
            }else{
                large.next = pHead;
                large = large.next;
            }
            pHead = pHead.next;
        }
        //将大尾节点弄为空
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}

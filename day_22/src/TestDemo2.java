class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class TestDemo2 {
    public static void main(String[] args) {
        ListNode a = new ListNode(0);
        ListNode a1 = a;
        a.next = new ListNode(1);
        a = a.next;
        a.next = new ListNode(2);

        ListNode b = new ListNode(0);
        ListNode b1 = a;
        b.next = new ListNode(1);
        b = b.next;
        b.next = new ListNode(2);
        plusAB(a1,b1);
    }
    public static void plusAB(ListNode a, ListNode b) {
        // write code here
        //首先遍历俩个链表得到这俩个整数
        ListNode aHead = a;
        ListNode bHead = b;
        StringBuffer astr = new StringBuffer();
        StringBuffer bstr = new StringBuffer();
        while(aHead != null){
            astr.append(aHead.val);
            aHead = aHead.next;
        }
        System.out.println(astr.toString());
        while(bHead != null){
            bstr.append(bHead.val);
            bHead = bHead.next;
        }
        //System.out.println(bstr.toString());
        int aNum = Integer.parseInt(astr.reverse().toString());
        System.out.println(astr.toString());
        int bNum = Integer.parseInt(bstr.reverse().toString());
        //System.out.println(bstr.toString());
        int num = aNum + bNum;
        //将num的值从个位放到链表中
        String s = String.valueOf(num);
        StringBuffer str = new StringBuffer(s);
        str.reverse();//逆序
        //开始遍历，放入链表
        ListNode res = new ListNode(0);
        ListNode head = res;
        for (int i = 0;i < str.length();i++){
            res.next = new ListNode((str.charAt(i)-'0'));
            res = res.next;
            //System.out.println("hao"+(str.charAt(i)-'0'));
        }
       // return head.next;


        //第二种方法
//        ListNode list = new ListNode(-1);
//        ListNode head = list;
//        ListNode p = a;
//        ListNode q = b;
//        int sum = 0;
//        while(p != null || q != null || sum !=0){
//            if(p!=null){
//                sum += p.val;
//                p = p.next;
//            }
//            if(q!=null){
//                sum += q.val;
//                q = q.next;
//            }
//            head.next = new ListNode(sum%10);
//            sum /= 10;//保留进位
//            head = head.next;
//        }
//        ListNode res = list.next;
//        StringBuffer s = new StringBuffer();
//        while (res != null){
//            s.append(res.val);
//            res = res.next;
//        }
//        System.out.println(s.toString());
//        //return list.next;

    }
}

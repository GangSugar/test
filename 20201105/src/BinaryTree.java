
import java.lang.Math;
import java.util.*;

/*
孩子表示法
 */
class Node {
    char val;
    Node left;
    Node right;
    //构造方法
    public Node(char val) {
        this.val = val;
    }
}
public class BinaryTree {
    //构造一颗树
    public  Node createTree(){
          Node A = new Node('A');
          Node B = new Node('B');
          Node C = new Node('C');
          Node D = new Node('D');
          Node E = new Node('E');
          Node F = new Node('F');
          Node G = new Node('G');
          Node H = new Node('H');
          A.left = B;
          A.right = C;
          B.left = D;
          B.right = E;
          E.right = H;
          C.left = F;
          C.right = G;
          return A;
      /* Node A = new Node('1');
        Node B = new Node('2');
        Node C = new Node('3');
        Node D = new Node('4');
        Node E = new Node('5');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        return A;*/
      }
    public  Node createTree1(){
        Node B = new Node('2');
        Node D = new Node('4');
        Node E = new Node('5');
        B.left = D;
        B.right = E;
        return B;
    }
    //前序遍历
    void preOrderTraversal(Node root){
        if (root == null)return;
        System.out.print(root.val+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    //中序遍历
    void inOrderTraversal(Node root){
        if (root == null)return;
        inOrderTraversal(root.left);
        System.out.print(root.val+" ");
        inOrderTraversal(root.right);
    }
    //后序遍历
    void postOrderTraversal(Node root){
        if (root == null)return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val+" ");
    }


    static int size = 0;
    //子问题思想，求节点个数（先算左边，在算右边，最后加起来在加根节点的一）
    int getSize2(Node root){
        if (root == null)return 0;
        int left = getSize2(root.left);
        int right = getSize2(root.right);
        return left+right+1;
    }

    //遍历思路求节点个数
    void getSize1(Node root){
        if (root == null)return;
        size++;
        getSize1(root.left);
        getSize1(root.right);

    }


    //子问题思路--求叶子节点的个数
    public int getLeafSize2(Node root){
        if (root == null)return 0;
        if (root.left == null && root.right == null)
            return 1;
        return getLeafSize2(root.left)+getLeafSize2(root.right);
    }

    //遍历思路
    static int leafsize = 0;
    public void getLeafSize1(Node root){
        if (root == null) return;
        if (root.left == null && root.right == null)
            leafsize++;
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }

    //子问题思路--求第k层的节点个数
    int getLevelSize (Node root,int k){
        if (root == null)return 0;
        if (k == 1)return 1;
        return getLevelSize(root.left,k-1)+getLevelSize(root.right,k-1);
    }

    //子问题思路--求树的深度
    int getHeight(Node root){
        if (root == null)return 0;
        /*int left = getHeight(root.left;
        int right = getHeight(root.right);
        return Math.max(left,right)+1
        */
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }
    /*查找 val 所在结点，没有找到返回 null
     按照 根 -> 左子树 -> 右子树的顺序进行查找
     一旦找到，立即返回，不需要继续在其他位置查找*/
    Node find(Node root, int val){
        if (root == null)return null;
        if (root.val == val)return root;
        Node newroot =find(root.left,val);
        if (newroot != null){
        return newroot;}
        Node newroot1 = find(root.right,val);
        if (newroot1 != null){
            return newroot1;
        }
        return null;
    }
    //俩颗相同的树
    public boolean isSameTree(Node p,Node q) {
        //1.如果一颗为空，一个不空，则false
        //2.如果都为空，直接true
        //3.其他情况
        if (p == null && q != null){
            return false;
        }else if (q == null && p != null){
            return false;
        }else if (q == null && p == null){
            return true;
        }else{
            if (p.val == q.val){
                return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
            }else{
                return false;
            }
        }
    }
    //另外一颗树的子树（前序遍历）https://leetcode-cn.com/problems/subtree-of-another-tree/submissions/
    public boolean isSubtree(Node s, Node t) {
        if (s == null || t == null)return false;
        //1.相同的树也是互为子树
        if (isSameTree(s,t)){
            return true;
        }
        //2.s的左边树是否等于t，是就true，不是就判断右边树
        if(isSubtree(s.left,t)){
            return true;
        }
        if(isSubtree(s.right,t)){
            return true;
        }
        return false;
    }
    //层次遍历（加入一个队列）
    void levelOrderTraversal(Node root) {
        if(root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();//队列对象
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print(cur.val);
            if (cur.left != null){
                queue.offer(cur.left);
            }
            if (cur.right != null){
                queue.offer(cur.right);
            }
        }

    }
    //二叉树的层次遍历（输出是按照一层一层输出的）https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
    public List<List<Character>> levelOrder(Node root) {
        List<List<Character>> ret = new ArrayList<>();//相当于二维数组，里面放的是字符型数据(Character)
        if(root == null) {
            return ret;
        }
        //队列用来保证遍历当前顺序性
        Queue<Node> queue = new LinkedList<>();//队列
        queue.offer(root);
        int max = 0;//用来实现另外一个功能，求出哪层所拥有的节点最多少；
        while (!queue.isEmpty()){
            //用来存放每一层的数据
            List<Character> rowlist = new ArrayList<>();
            int count = queue.size();
            while(count != 0){
                //出栈，cur存放出栈的节点，并且判断后续是否有其他树节点需要进队列
                Node cur = queue.poll();//出栈
                rowlist.add(cur.val);
                if (cur.left != null){
                    queue.offer(cur.left);
                }
                if (cur.right != null){
                    queue.offer(cur.right);
                }
                count--;//用来分层，当一层弹出完毕，count就变为0
            }
            ret.add(rowlist);
            if (rowlist.size() > max){
                max = rowlist.size();
            }
        }
        System.out.println("层的最多节点数目: "+max);
        return ret;
    }

    // 判断一棵树是不是完全二叉树
    boolean isCompleteTree(Node root) {
        if(root == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();//队列
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if(cur != null){
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else{
                break;
            }
        }
        //判断队列剩下的元素  是否有非空的元素
        while(!queue.isEmpty()){
            Node cur = queue.peek();
            if(cur != null) {
                return false;
            }else {
                queue.poll();
            }
        }
            return true;
    }
//ABC##DE#G##F### 其中“#”表示的是空格，空格字符代表空树。建立起此二叉树以后，再对二叉树进行中序遍历，输出遍历结果。
    /*
    int i = 0;
    Node createTreeByString(String str){
        Node root;
        if (str.charAt(i) != '#'){
            root = new Node(str.charAt(i));
            i++;
            root.left = createTreeByString(str);
            root.right = createTreeByString(str);
        }else{
            i++;
        }
        return root;
    }*/

    //二叉搜索树转为双向链表(中序遍历)
    Node prev = null;//设为全局变量，因为它一直要保持上次的结果
    public void ConvetChild(Node root){
        if (root == null) return;
        ConvetChild(root.left);
        root.left = prev;
        if (prev != null){
            prev.right = root;
        }
        prev = root;
        ConvetChild(root.right);
    }
    public Node Convet(Node root) {
        //首先判断树是否为空
        if (root == null) return null;
        ConvetChild(root);
        Node head = root;
        while (head.left != null) {
            head = head.left;
        }
        return head;
    }

    //递增顺序查找树
    Node cur;
    public Node increasingBST(Node root){
        //采用顺序表的存储
        if (root == null)return null;
        List<Character> list = new ArrayList<>();
        increasingBSTChild(root,list);
        Node ans = new Node('0');//先定义一个ans节点,相当于head
        cur = ans;
        //开始遍历list表
        for(int i = 0;i < list.size();i++){
            cur.right = new Node(list.get(i));
            cur = cur.right;
        }
        return ans.right;//因为ans、刚开始的值是自己定义的，不能打印；
    }
    public void increasingBSTChild(Node root,List<Character> list){
        if (root == null)return;
        //中序遍历
        increasingBSTChild(root.left,list);
        list.add(root.val);
        increasingBSTChild(root.right,list);

    }

    // 二叉树前序非递归遍历实现，（采用栈）
    /*
    思路：
    1.用一个栈
     */
    void preOrderTraversal1(Node root){
        if (root == null)return;

        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while(cur != null || !stack.empty()){
            while(cur != null){
                System.out.print(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.pop();
            cur = top.right;
        }
    }

    //中序非递归遍历
    void inOrderTraversal1(Node root){
        if (root == null)return;
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while(cur != null || !stack.empty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.pop();
            System.out.print(top.val);
            cur = top.right;
        }
    }

    //后序非递归遍历
    void postOrderTraversal1(Node root){
        if (root == null)return;
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node prev=null;
        while(cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right == null || cur.right == prev) {
                stack.pop();
                System.out.print(cur.val);
                prev = cur;
                cur = null;
            } else {
                cur = cur.right;

            }
        }
    }
/*
    //根据前序遍历和中序遍历确定二叉树pre前序，inorder前序
    public int preIndex = 0;//用来标记前序的下标，全局遍历，可以一直往后遍历，一直遍历完；
    public Node buildTree(char[] preorder, char[] inorder) {
        //如果传进来的有一个为空，则没有办法确定一棵二叉树
        if(preorder == null || inorder == null) {
            return null;
        }
        //如果数组长度为0，同样没办法构造
        if(preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        //其他情况，开始调用构造一棵一棵子树，最后就构造成为一棵完整的二叉树
        return buildTreeChild(preorder,inorder,
                0,inorder.length-1);
    }*/
    //将前序遍历和中序遍历传递过来，inbegin代表中序遍历的第一个节点下标，inend代表中序遍历的最后的一个节点下标
    /*
    思路：1.从前序遍历第一个数据开始依次往后面遍历，然后在中序遍历中确定新的子树根
     */
    /*public Node buildTreeChild(char[] preorder,
                               char[] inorder,int inbegin,int inend) {
        //在遍历过程中防止下标越界
        if(inbegin > inend) {
            return null;
        }
        Node root = new Node(preorder[preIndex]);//建立一棵树的根节点
        //通过调用findInoderIndexOfRoot 在中序遍历中遍历找到和前序遍历对应节点的下标
        int inorderIndex = findInoderIndexOfRoot(inorder,
                inbegin,inend,preorder[preIndex]);
        preIndex++;//前序的下标接着向后遍历
        //开始构造左子树
        root.left = buildTreeChild(preorder,inorder,inbegin,preIndex-1);
        //接着是右子树
        root.right = buildTreeChild(preorder,
                inorder,inorderIndex+1,inend);
        return root;
    }
    public int findInoderIndexOfRoot(char[] inorder,
                                     int inbegin,int inend,char val) {
        for (int i = inbegin;i <= inend;i++){
            if (inorder[i] == val){
                return i;
            }
        }
        return -1;

    }*/

    /*
    //根据后序遍历和中序遍历确定一棵二叉树
    public int postIndex = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //首先判断数组是否为空或者长度为0
        if(inorder == null || postorder == null || postorder.length == 0 || inorder.length == 0){
            return null;
        }
        postIndex = postorder.length-1;
        //其他情况，写一个专门构造子树的方法
        return buildTreeChild(postorder,inorder,0,inorder.length-1);

        }
        //构造子树

        public TreeNode buildTreeChild(int[] postorder, int[] inorder,int Inbegin ,int Inend) {
            if(Inbegin > Inend){return null;}
            TreeNode root = new TreeNode(postorder[postIndex]);

            //开始遍历中序遍历，找到中序遍历中和前序遍历下标所对应元素一致的元素的下标
           int ioderIndex = findfindInoderIndexOfRoot(inorder,
                Inbegin,Inend,postorder[postIndex]);
                postIndex--;
                //同样遍历构造左子树和右子树
                root.right = buildTreeChild(postorder,inorder,ioderIndex+1,Inend);
                 root.left = buildTreeChild(postorder,inorder,Inbegin,ioderIndex-1);
                 return root;
        }
        public int findfindInoderIndexOfRoot(int[] inorder,int Inbegin,int Inend,int val){
            for(int i = 0;i < inorder.length;i++){
                if(inorder[i] == val){
                    return i;
                }
            }
            return -1;
        }   
     */
}



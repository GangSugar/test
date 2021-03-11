import java.util.Map;
import java.util.PriorityQueue;
/*
二叉搜索树
 */
class BinarySearchTree{
    static class  Node{
        int data;
        Node left;
        Node right;
        public Node(int data ){
            this.data = data;
        }
    }
    Node root = null;
    //入二叉搜索树
    public void put(int key){
        Node node = new Node(key);
        if (root == null){
            root = node;
            return;
        }
        Node par = null;
        Node cur = root;

        while(cur != null){
            if (cur.data < key){
                par = cur;
                cur = cur.right;
            }else if(cur.data > key){
                par = cur;
                cur = cur.left;
            }else{
                break;
            }
        }
        //这个时候cur为空,确定把值放在par的左边还是右边
        if (par.data < key){
            par.right = node;
        }else{
            par.left = node;
        }
    }
    //遍历二叉搜索树（中序遍历）
    public void inorder(Node root){
        if (root == null)return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    //遍历二叉搜索树（前序遍历）
    public void preorder(Node root){
        if (root == null)return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    //在二叉搜索树中找到给定的val值
    public Node findVal(int val) {
        if(root == null) return null;
        Node cur = root;
        while (cur != null) {
            if(cur.data == val) {
                return cur;
            }else if(cur.data < val){
                cur = cur.right;
            }else {
                cur = cur.left;
            }
        }
        return null;
    }

    /*
    二叉搜素树删除给定节点：
    思路：
    1. 若删除的节点没有孩子的时候，直接删除此节点，然后将父节点NULL；
    2.若删除的节点有一个孩子的时候，直接将父节点连接到其孩子节点，然后删除此节点。
    3.若有两个节点的时候，这时候就要找个节点代替它了，因为二叉搜索树具有左子树比此节点的值都小，右子树比此节点的值大，所以
    （1）可以找左子树中节点最大的元素，也就是左子树中最右端的元素，
    （2）也可以找右子树中节点最小的元素，也就是右子树中最左端的节点。
        让此节点的值等于子树中选出的值，然后删除子树中的节点，
        因为被删除的节点不是在最右端就是在最左端，所以可知此节点只有一个孩子。。。。然后转到第二种情况。。。
   可以看出，这三种情况都需要记住父节点的地址
     */
    public void remove(int key){
        if (root == null){
            return;
        }
        Node cur = root;//用cur表示待删除节点
        Node par = null;
        while(cur != null){
        if (cur.data > key){
            par = cur;
            cur = cur.left;
        }else if(cur.data < key){
            par = cur;
            cur = cur.right;
        }else{
            removeNode(par,cur);
            return;
        }
        }
    }
    public void removeNode(Node par,Node cur){
        if (cur.left == null){
            if(cur == root){
                root = cur.right;
            }else if(par.left == cur){
                par.left = cur.right;
            }else{
                par.right = cur.right;
            }
        }else if(cur.right == null){
            if(cur == root){
                root = cur.left;
            }else if(par.left == cur){
                par.left = cur.left;
            }else{
                par.right = cur.left;
            }
        }else{
            //替换法，左树找最大值或者右树找最小值
            Node targetPareat = cur;
            Node target = targetPareat.right;
            while(target.left != null){
                targetPareat = target;
                target = target.left;
            }
            cur.data = target.data;
            if (targetPareat.left == target){
                targetPareat.left = target.right;
            }else{
                targetPareat.right = target.right;
            }
        }
    }
}

public class TestDemo {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] arr = {15,23,19,67,4,10};
        for (int i = 0; i < arr.length; i++) {
            bst.put(arr[i]);
        }
        bst.inorder(bst.root);
        System.out.println();
        bst.preorder(bst.root);
        System.out.println();
        try {
            System.out.println(bst.findVal(67).data);
        }catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("没有这个节点");
        }
        System.out.println("删除节点后面，再次进行中序遍历和前序遍历：");
        bst.remove(19);
        bst.inorder(bst.root);
        System.out.println();
        bst.preorder(bst.root);
        System.out.println();
    }
}

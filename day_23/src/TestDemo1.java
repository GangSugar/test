class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class TestDemo1 {
    public static boolean isBalance(TreeNode root) {
        // write code here
        if(root == null)return true;
        //1.开始遍历左边子树和右边子树，计算出高度
        int leftHeight =  height(root.left);
        int rightHeight =  height(root.right);

        //2.进行比较
        if(Math.abs(leftHeight-rightHeight) > 1){
            return false;
        }
        //3.分别判断左右子树的高度差是不是也小于等于1
        return isBalance(root.left) && isBalance(root.right);
    }
    //计算树的高度
    public static int height(TreeNode root){
        if(root == null)return 0;

        return Math.max(height(root.left),height(root.right))+1;
    }

    public static void main(String[] args) {
        //isBalance(TreeNode root);
    }
}
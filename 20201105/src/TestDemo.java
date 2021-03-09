

class TestDemo{
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();//创建对象
        Node root = binaryTree.createTree();//构造一棵树，通过调用BinaryTree类里面的createTree()方法
        System.out.print("前序遍历:");
        binaryTree.preOrderTraversal(root);
        System.out.println();
        binaryTree.preOrderTraversal1(root);
        System.out.println();
        System.out.print("中序遍历:");
        binaryTree.inOrderTraversal(root);
        System.out.println();
        binaryTree.inOrderTraversal1(root);
        System.out.println();
        System.out.print("后序遍历:");
        binaryTree.postOrderTraversal(root);
        System.out.println();
        binaryTree.postOrderTraversal1(root);
        System.out.println();

        /*binaryTree.getSize1(root);
        System.out.println("树的节点个数:"+binaryTree.size);
        System.out.println("树的节点个数:"+binaryTree.getSize2(root));
        System.out.println();
        binaryTree.getLeafSize1(root);
        System.out.println("叶子节点个数:"+binaryTree.leafsize);
        System.out.println("叶子节点个数:"+binaryTree.getLeafSize2(root));
        System.out.println();
        System.out.println("第k层的节点个数:"+binaryTree.getLevelSize(root, 3));
        System.out.println();

        System.out.println("树的深度:"+binaryTree.getHeight(root));
        System.out.println();
        Node root1 = binaryTree.find(root, 'A');
        System.out.println(root1.val);
        Node root2 = binaryTree.find(root, 'H');
        System.out.println(root2.val);
        Node root3 = binaryTree.find(root, 'l');
        if (root3 == null){
            System.out.println(root3);
        }else{
            System.out.println(root.val);
        }*/

        /*Node root4 = binaryTree.createTree1();
        System.out.println("true为相同的树,false为不相同的树: "+binaryTree.isSameTree(root, root4));
        System.out.println("true代表是子树,false不是子树: "+binaryTree.isSubtree(root, root4));
        binaryTree.levelOrderTraversal(root);*/
        binaryTree.levelOrder(root);
        //System.out.println("是否是完全二叉树: "+binaryTree.isCompleteTree(root));
    }
}
